package org.example.business;

import org.example.data.api.TodoService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockTest {

    @Test
    public void test() {
        TodoService todoServiceMock = Mockito.mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, filteredTodos.size());
    }

    @Test
    public void test_withEmptyList() {
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList();
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(0, filteredTodos.size());
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_usingBDD() {

        //given
        TodoService todoServiceMock = Mockito.mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertThat(filteredTodos.size(),is(2) );
    }
    @Test
    public void testDeleteNotTodosRelatedToSpring_usingBDD() {

        //given
        TodoService todoServiceMock = Mockito.mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
        //verify(todoServiceMock,times(1)).deleteTodo("Learn to Dance");
        //verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");
        then(todoServiceMock).should(never()).deleteTodo("Learn to Dance");
        then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
        then(todoServiceMock).should(never()).deleteTodo("Learn Spring");

        //verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");

    }
    @Test
    public void testDeleteNotTodosRelatedToSpring_usingBDD_argument() {

        //declare argument captor
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        //define argument captor on specific method call
        //capture the argument

        //given
        TodoService todoServiceMock = Mockito.mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        //when
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
        //verify(todoServiceMock,times(1)).deleteTodo("Learn to Dance");
        //verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");
        // then: capture what was deleted
        then(todoServiceMock).should(times(1)).deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));

        // and: verify spring-related ones were not deleted
        then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
        then(todoServiceMock).should(never()).deleteTodo("Learn Spring");
    }

    @Test
    public void testDeleteNotTodosRelatedToSpring_usingBDD_multipleArguments() {

        //declare argument captor
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        //define argument captor on specific method call
        //capture the argument

        //given
        TodoService todoServiceMock = Mockito.mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn to Rock and Roll", "Learn Spring", "Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        //when
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
        then(todoServiceMock).should(never()).deleteTodo(contains("Spring"));
        then(todoServiceMock).should(times(2)).deleteTodo(argThat(s -> !s.contains("Spring")));

        assertThat(stringArgumentCaptor.getAllValues().size(), is(0));

    }
}
