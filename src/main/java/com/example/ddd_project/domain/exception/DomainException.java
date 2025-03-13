package com.example.ddd_project.domain.exception;

import com.example.ddd_project.domain.service.Notification;

public class DomainException extends RuntimeException {
    private final Notification notification;

    public DomainException(Notification notification) {
        this.notification = notification;
    }

    public Notification getNotification() {
        return notification;
    }
}
