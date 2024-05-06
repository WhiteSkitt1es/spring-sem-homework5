package ru.app.hw5.model;

public enum TaskStatus {

    NOT_STARTED, IN_PROGRESS, COMPLETED;

    public static TaskStatus statusUpdate(String  status){

        return switch (status) {
            case "start" -> IN_PROGRESS;
            case "done" -> COMPLETED;
            default -> NOT_STARTED;
        };


    }
}
