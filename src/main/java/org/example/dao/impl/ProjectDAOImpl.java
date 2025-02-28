package org.example.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dao.ProjectDAO;
import org.example.models.*;
import org.example.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectDAOImpl implements ProjectDAO {
    private static final Logger logger = LogManager.getLogger(ProjectDAOImpl.class);
    private final Connection connection;

    public ProjectDAOImpl() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    // 1. Insert operation
    @Override
    public void insert(Project project) {
        String sql = "INSERT INTO projects (name, deadline, budget, technology) " +
                "VALUES (?, ?, ?, ?, ) ";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, project.getName());
            stmt.setString(2, project.getDeadline());
            stmt.setDouble(3, project.getBudget());
            stmt.setString(4, project.getTechnology());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error inserting project: {}", project, e);
        }
    }

    // 2. Select with two join statements
    @Override
    public List<Project> getProjectWithClientAndManager(Long projectId) {
        List<Project> projects = new ArrayList<>();
        String sql = "SELECT p.*, c.*, m.* FROM projects p " +
                "JOIN clients c ON p.id = c.projects_id " +
                "JOIN managers m ON p.id = m.id " +
                "WHERE p.id = ? ";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, projectId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Project project = mapToProject(rs);
                projects.add(project);
            }
        }
        catch (SQLException e) {
            logger.error("Error fetching project with client and manager", e);
        }
        return projects;
    }

    // 3. Six select operations
    @Override
    public List<Project> getAll() {
        List<Project> projects = new ArrayList<>();
        String sql = "SELECT * FROM projects";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                projects.add(mapToProject(rs));
            }
        } catch (SQLException e) {
            logger.error("Error fetching all projects: ", e);
        }
        return projects;
    }

    @Override
    public Optional<Project> getById(Long id) {
        String sql = "SELECT * FROM projects WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(mapToProject(rs));
            }
        } catch (SQLException e) {
            logger.error("Error fetching project by id", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Project> getByTechnology(String technology) {
        List<Project> projects = new ArrayList<>();
        String sql = "SELECT * FROM projects WHERE technology LIKE ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + technology + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                projects.add(mapToProject(rs));
            }
        } catch (SQLException e) {
            logger.error("Error fetching projects by technology: ", e);
        }
        return projects;
    }

    @Override
    public List<Project> getByBudgetRange(double minBudget, double maxBudget) {
        List<Project> projects = new ArrayList<>();
        String sql = "SELECT * FROM projects WHERE budget BETWEEN ? AND ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, minBudget);
            stmt.setDouble(2, maxBudget);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                projects.add(mapToProject(rs));
            }
        } catch (SQLException e) {
            logger.error("Error fetching projects by budget range: ", e);
        }
        return projects;
    }

    @Override
    public List<Project> getByDeadline(String deadline) {
        List<Project> projects = new ArrayList<>();
        String sql = "SELECT * FROM projects WHERE deadline = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, deadline);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                projects.add(mapToProject(rs));
            }
        } catch (SQLException e) {
            logger.error("Error fetching projects by deadline: ", e);
        }
        return projects;
    }

    @Override
    public List<Project> getByName(String name) {
        List<Project> projects = new ArrayList<>();
        String sql = "SELECT * FROM projects WHERE name LIKE ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                projects.add(mapToProject(rs));
            }
        } catch (SQLException e) {
            logger.error("Error fetching projects by name: ", e);
        }
        return projects;
    }

    // 4. Three Update operations
    @Override
    public void update(Project project) {
        String sql = "UPDATE projects SET name = ?, deadline = ?, budget = ?, technology = ? " +
                "WHERE id = ? ";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, project.getName());
            stmt.setString(2, project.getDeadline());
            stmt.setDouble(3, project.getBudget());
            stmt.setString(4, project.getTechnology());
            stmt.setLong(5, project.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error updating project with ID {}", project.getId(), e);
        }
    }

    @Override
    public void updateProjectName(Long id, String newName) {
        String sql = "UPDATE projects SET name = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, newName);
            stmt.setLong(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error updating project name: ", e);
        }
    }

    @Override
    public void updateProjectTechnology(Long id, String newTechnology) {
        String sql = "UPDATE projects SET technology = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, newTechnology);
            stmt.setLong(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error updating project technology: ", e);
        }
    }

    // 5. Two Delete operations
    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM projects WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error deleting project: ", e);
        }
    }

    @Override
    public void deleteByTechnology(String technology) {
        String sql = "DELETE FROM projects WHERE technology = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, technology);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error deleting projects by technology: ", e);
        }
    }

    private Project mapToProject(ResultSet rs) throws SQLException {
        return new Project.ProjectBuilder()
                .setId(rs.getLong("id"))
                .setName(rs.getString("name"))
                .setDeadline(rs.getString("deadline"))
                .setBudget(rs.getDouble("budget"))
                .setTechnology(rs.getString("technology"))
                .setManager(new Manager.ManagerBuilder()
                        .setId(rs.getLong("manager_id"))
                        .build())
                .build();
    }

}