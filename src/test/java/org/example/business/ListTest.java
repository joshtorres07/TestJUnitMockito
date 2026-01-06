package org.example.business;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class ListTest {

    @Test
    public void letsMockListSizeMethod() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2, listMock.size());
    }

    @Test
    public void letsMockListSize_returnMultipleValues() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }

    @Test
    public void letsMockListGet() {
        List listMock = mock(List.class);

        //when(listMock.get(0)).thenReturn("josh");
        when(listMock.get(anyInt())).thenReturn("josh");
        assertEquals("josh", listMock.get(0));

    }
    @Test(expected = RuntimeException.class)
    public void letsMockLis_throwException() {
        List listMock = mock(List.class);

        //when(listMock.get(0)).thenReturn("josh");
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something went wrong"));
        listMock.get(0);
    }

    @Test(expected = RuntimeException.class)
    public void letsMockList_mixingUp() {
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something went wrong"));
    }

    @Test
    public void letsMockListGet_usingBDD() {
        //Given
        List<String> listMock = mock(List.class);
        //when(listMock.get(0)).thenReturn("josh");
        given(listMock.get(anyInt())).willReturn("josh");

        //when
        String first = listMock.get(0);

        //then
        assertThat(first, is("josh"));
        //assertEquals("josh", listMock.get(0));

    }
}

