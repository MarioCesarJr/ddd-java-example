package com.example.ddd_project.domain.service;

import java.util.List;

public interface Notification {

    public void addError(String message);

    public Boolean hasErrors();

    public List<String> getErrors();

    public ErrorResponse getErrorResponse();
}
