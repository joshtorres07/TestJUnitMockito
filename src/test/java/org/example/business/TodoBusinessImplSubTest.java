package org.example.business;

import org.example.data.api.ToDoServiceStub;
import org.example.data.api.TodoService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TodoBusinessImplSubTest {

    @Test
    public void test() {
        TodoService toDoServiceStub = new ToDoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(toDoServiceStub);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("1");
        assertEquals(0, filteredTodos.size());
    }

    @Test
    public void test2() {
        TodoService toDoServiceStub = new ToDoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(toDoServiceStub);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("1");
        assertEquals(0, filteredTodos.size());
    }
}
