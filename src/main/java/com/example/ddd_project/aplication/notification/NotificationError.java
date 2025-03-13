package com.example.ddd_project.aplication.notification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.example.ddd_project.domain.service.ErrorResponse;
import com.example.ddd_project.domain.service.Notification;

@RequestScope
@Component
public class NotificationError implements Notification {

    private int status = 400;
    private List<String> errors = new ArrayList<>();

    @Override
    public void addError(String message) {
        this.errors.add(message);
    }

    @Override
    public Boolean hasErrors() {
        return !this.errors.isEmpty();
    }

    @Override
    public List<String> getErrors() {
        return this.errors;
    }

    @Override
    public ErrorResponse getErrorResponse() {
        ErrorResponse response = new ErrorResponse(this.status, this.errors);
        return response;
    }

}
