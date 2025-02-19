/*
package org.example.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dao.ConsultantDAO;
import org.example.models.Consultant;
import org.example.models.Manager;
import org.example.models.Project;
import org.example.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ConsultantDAOImpl implements ConsultantDAO {
    private static final Logger logger = LogManager.getLogger(ConsultantDAOImpl.class);
    private final Connection connection;

    public ConsultantDAOImpl() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    // 1. Insert operation
    @Override
    public void insert(Consultant consultant) {
        String sql = "INSERT INTO consultants (first_name, last_name, salary, industry, managers_id) " +
                "VALUES (?, ?, ?, ?, ?) ";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, consultant.getFirstName());
            stmt.setString(2, consultant.getLastName());
            stmt.setDouble(3, consultant.getSalary());
            stmt.setString(4, consultant.getIndustry());
            stmt.setLong(5, consultant.getManager());
            stmt.setLong(6, consultant.getId());
            stmt.executeUpdate();
            logger.info("Consultant inserted successfully.");
        } catch (SQLException e) {
            logger.error("Error inserting consultant", e);
        }
    }

    // 2. Select with two join statements
    @Override
    public List<Consultant> getByProjectAndManager(Long projectId, Long managerId) {
        List<Consultant> consultants = new ArrayList<>();
        String sql = "SELECT c.* FROM consultants c " +
                "JOIN consultant_projects cp ON c.id = cp.consultants_id " +
                "JOIN managers m ON c.managers_id = m.id " +
                "WHERE cp.projects_id = ? AND m.id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, projectId);
            stmt.setLong(2, managerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                consultants.add(mapToConsultant(rs));
            }
            logger.info("Consultants retrieved successfully by project and manager.");
        } catch (SQLException e) {
            logger.error("Error fetching consultants by project and manager", e);
        }
        return consultants;
    }

    // 3. Five select operations
    @Override
    public Optional<Consultant> getById(Long id) {
        String sql = "SELECT * FROM consultants WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(mapToConsultant(rs));
            }
        } catch (SQLException e) {
            logger.error("Error fetching consultant by id", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Consultant> getAll() {
        List<Consultant> consultants = new ArrayList<>();
        String sql = "SELECT * FROM consultants";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                consultants.add(mapToConsultant(rs));
            }
            logger.info("All consultants retrieved successfully.");
        } catch (SQLException e) {
            logger.error("Error fetching all consultants", e);
        }
        return consultants;
    }

    @Override
    public List<Consultant> getByIndustry(String industry) {
        List<Consultant> consultants = new ArrayList<>();
        String sql = "SELECT * FROM consultants WHERE industry = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, industry);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                consultants.add(mapToConsultant(rs));
            }
        } catch (SQLException e) {
            logger.error("Error fetching consultants by industry", e);
        }
        return consultants;
    }

    @Override
    public List<Consultant> getBySalaryRange(double minSalary, double maxSalary) {
        List<Consultant> consultants = new ArrayList<>();
        String sql = "SELECT * FROM consultants WHERE salary BETWEEN ? AND ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, minSalary);
            stmt.setDouble(2, maxSalary);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                consultants.add(mapToConsultant(rs));
            }
        } catch (SQLException e) {
            logger.error("Error fetching consultants by salary range", e);
        }
        return consultants;
    }

    @Override
    public List<Consultant> getByManagerId(Long managerId) {
        List<Consultant> consultants = new ArrayList<>();
        String sql = "SELECT * FROM consultants WHERE managers_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, managerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                consultants.add(mapToConsultant(rs));
            }
        } catch (SQLException e) {
            logger.error("Error fetching consultants by manager id", e);
        }
        return consultants;
    }

    // 4. Three Update operations
    @Override
    public void update(Consultant consultant) {
        String sql = "UPDATE clients SET name = ?, contact_info = ?, first_name = ?, last_name = ?, projects_id = ? " +
                "WHERE id = ? ";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, consultant.getFirstName());
            stmt.setString(2, consultant.getLastName());
            stmt.setDouble(3, consultant.getSalary());
            stmt.setString(4, consultant.getIndustry());
            stmt.setLong(5, consultant.getManager());
            stmt.executeUpdate();
            logger.info("Consultant updated successfully: {}", consultant.getId());
        } catch (SQLException e) {
            logger.error("Error updating consultant", e);
        }
    }

    @Override
    public void updateSalary(Long id, double newSalary) {
        String sql = "UPDATE consultants SET salary = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, newSalary);
            stmt.setLong(2, id);
            stmt.executeUpdate();
            logger.info("Consultant salary updated successfully.");
        } catch (SQLException e) {
            logger.error("Error updating consultant salary", e);
        }
    }

    @Override
    public void updateIndustry(Long id, String newIndustry) {
        String sql = "UPDATE consultants SET industry = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, newIndustry);
            stmt.setLong(2, id);
            stmt.executeUpdate();
            logger.info("Consultant industry updated successfully.");
        } catch (SQLException e) {
            logger.error("Error updating consultant industry", e);
        }
    }

    // 5. Two Delete operations
    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM consultants WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
            logger.info("Consultant deleted successfully.");
        } catch (SQLException e) {
            logger.error("Error deleting consultant", e);
        }
    }

    @Override
    public void deleteByManagerId(Long managerId) {
        String sql = "DELETE FROM consultants WHERE managers_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, managerId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("Consultants with manager ID {} deleted successfully.", managerId);
            } else {
                logger.info("No consultants found with manager ID {}", managerId);
            }
        } catch (SQLException e) {
            logger.error("Error deleting consultants by manager id", e);
        }
    }

    private Consultant mapToConsultant(ResultSet rs) throws SQLException {
        long managerId = rs.getLong("manager_id"); // Fetch manager ID from the result set
        Manager manager = (Manager) getByManagerId(managerId);  // Replace with actual manager retrieval logic

        List<Project> projects = List.of(new Project()); // Replace with actual project list

        return new Consultant(
                rs.getLong("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getDouble("salary"),
                rs.getString("industry"),
                manager, // Pass the actual Manager object
                projects // Pass the list of projects
        );
    }
}
*/
