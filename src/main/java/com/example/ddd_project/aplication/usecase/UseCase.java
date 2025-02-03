package com.example.ddd_project.aplication.usecase;

public interface UseCase<Input, Output> {

    Output execute(Input input);

}
