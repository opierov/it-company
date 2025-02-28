package org.example.listeners;

import java.util.List;

import org.example.models.Employee;

public interface EmployeeListener {
    static void notifyListeners(List<EmployeeListener> LISTENERS, String event, Employee employee, Long employeeId) {
        for (EmployeeListener listener : LISTENERS) {
            switch (event) {
                case "insert":
                    listener.onInsert(employee);
                    break;
                case "update":
                    listener.onUpdate(employee);
                    break;
                case "delete":
                    listener.onDelete(employeeId);
                    break;
            }
        }
    }
    void onInsert(Employee employee);
    void onUpdate(Employee employee);
    void onDelete(Long employeeId);
}
