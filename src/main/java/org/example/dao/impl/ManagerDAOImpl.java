/*
package org.example.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dao.ManagerDAO;
import org.example.models.Manager;
import org.example.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ManagerDAOImpl implements ManagerDAO {
    private static final Logger logger = LogManager.getLogger(ManagerDAOImpl.class);
    private final Connection connection;

    public ManagerDAOImpl() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    // 1. Insert operation
    @Override
    public void insert(Manager manager) {
        String sql = "INSERT INTO managers (first_name, last_name, salary, industry, skills) " +
                "VALUES (?, ?, ?, ?, ?) ";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, manager.getFirstName());
            stmt.setString(2, manager.getLastName());
            stmt.setDouble(3, manager.getSalary());
            stmt.setString(4, manager.getIndustry());
            stmt.setString(5, manager.getSkills());
            stmt.executeUpdate();
            logger.info("Manager inserted: {}", manager);
        } catch (SQLException e) {
            logger.error("Error inserting manager", e);
        }
    }

    // 2. Select with two join statements
    @Override
    public List<Manager> getManagersByProjectId(Long projectId) {
        List<Manager> managers = new ArrayList<>();
        String sql = "SELECT m.* FROM managers m " +
                "JOIN consultants c ON m.id = c.managers_id " +
                "JOIN consultant_projects cp ON c.id = cp.consultants_id " +
                "WHERE cp.projects_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, projectId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                managers.add(mapToManager(rs));
            }
        } catch (SQLException e) {
            logger.error("Error fetching managers by project ID", e);
        }
        return managers;
    }

    // 3. Five select operations
    @Override
    public Optional<Manager> getById(Long id) {
        String sql = "SELECT * FROM managers WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(mapToManager(rs));
            }
        } catch (SQLException e) {
            logger.error("Error fetching manager by ID", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Manager> getByIndustry(String industry) {
        List<Manager> managers = new ArrayList<>();
        String sql = "SELECT * FROM managers WHERE industry = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, industry);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                managers.add(mapToManager(rs));
            }
        } catch (SQLException e) {
            logger.error("Error fetching managers by industry", e);
        }
        return managers;
    }

    @Override
    public List<Manager> getAll() {
        List<Manager> managers = new ArrayList<>();
        String sql = "SELECT * FROM managers";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                managers.add(mapToManager(rs));
            }
        } catch (SQLException e) {
            logger.error("Error fetching all managers", e);
        }
        return managers;
    }

    @Override
    public List<Manager> getBySalaryRange(double minSalary, double maxSalary) {
        List<Manager> managers = new ArrayList<>();
        String sql = "SELECT * FROM managers WHERE salary BETWEEN ? AND ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, minSalary);
            stmt.setDouble(2, maxSalary);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                managers.add(mapToManager(rs));
            }
        } catch (SQLException e) {
            logger.error("Error fetching managers by salary range", e);
        }
        return managers;
    }

    @Override
    public List<Manager> getBySkills(String skills) {
        List<Manager> managers = new ArrayList<>();
        String sql = "SELECT * FROM managers WHERE skills LIKE ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + skills + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                managers.add(mapToManager(rs));
            }
        } catch (SQLException e) {
            logger.error("Error fetching managers by skills", e);
        }
        return managers;
    }

    // 4. Two Update operations
    @Override
    public void update(Manager manager) {
        String sql = "UPDATE managers SET first_name = ?, last_name = ?, salary = ?, industry = ?, skills = ? " +
                "WHERE id = ? ";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, manager.getFirstName());
            stmt.setString(2, manager.getLastName());
            stmt.setDouble(3, manager.getSalary());
            stmt.setString(4, manager.getIndustry());
            stmt.setString(5, manager.getSkills());
            stmt.setLong(6, manager.getId());
            stmt.executeUpdate();
            logger.info("Manager updated: {}", manager);
        } catch (SQLException e) {
            logger.error("Error updating manager", e);
        }
    }

    @Override
    public void updateManagerSalary(Long id, double newSalary) {
        String sql = "UPDATE managers SET salary = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, newSalary);
            stmt.setLong(2, id);
            stmt.executeUpdate();
            logger.info("Manager salary updated for ID: {}", id);
        } catch (SQLException e) {
            logger.error("Error updating manager salary", e);
        }
    }

    // 5. Two Delete operations
    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM managers WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
            logger.info("Manager deleted with ID: {}", id);
        } catch (SQLException e) {
            logger.error("Error deleting manager", e);
        }
    }

    @Override
    public void deleteByIndustry(String industry) {
        String sql = "DELETE FROM managers WHERE industry = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, industry);
            stmt.executeUpdate();
            logger.info("Managers deleted with industry: {}", industry);
        } catch (SQLException e) {
            logger.error("Error deleting managers by industry", e);
        }
    }

    private Manager mapToManager(ResultSet rs) throws SQLException {
        Manager manager = new Manager();
        manager.setId(rs.getLong("id"));
        manager.setFirstName(rs.getString("first_name"));
        manager.setLastName(rs.getString("last_name"));
        manager.setSalary(rs.getDouble("salary"));
        manager.setIndustry(rs.getString("industry"));
        manager.setSkills(rs.getString("skills"));
        return manager;
    }
}
*/
