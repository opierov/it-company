package org.example.services;

import org.example.models.Manager;

import java.util.List;
import java.util.Optional;

public interface ManagerService {
    void addManager(Manager manager);
    Optional<Manager> getManagerById(Long id);
    List<Manager> getAllManagers();
    void updateManager(Manager manager);
    void deleteManager(Long id);
    List<Manager> getManagersByIndustry(String industry);

}
