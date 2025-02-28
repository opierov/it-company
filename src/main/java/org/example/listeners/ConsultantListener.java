package org.example.listeners;

import java.util.List;

import org.example.models.Consultant;

public interface ConsultantListener {
    static void notifyListeners(List<ConsultantListener> LISTENERS, String event, Consultant consultant, Long consultantId) {
        for (ConsultantListener listener : LISTENERS) {
            switch (event) {
                case "insert":
                    listener.onInsert(consultant);
                    break;
                case "update":
                    listener.onUpdate(consultant);
                    break;
                case "delete":
                    listener.onDelete(consultantId);
                    break;
            }
        }
    }
    void onInsert(Consultant consultant);
    void onUpdate(Consultant consultant);
    void onDelete(Long consultantId);
}