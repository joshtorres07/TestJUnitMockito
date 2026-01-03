package org.example.data.api;

import java.util.Arrays;
import java.util.List;

public class ToDoServiceStub implements  TodoService{

    public List<String> retrieveTodos(String user) {
        return Arrays.asList("1", "2", "3", "4", "5");
    }
}
