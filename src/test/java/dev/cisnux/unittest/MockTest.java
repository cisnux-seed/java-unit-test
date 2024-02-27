package dev.cisnux.unittest;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class MockTest {
    @Test
    void testMock() {
        final List<String> list = Mockito.mock(List.class);
        Mockito.when(list.getFirst()).thenReturn("Fajra");
        Mockito.when(list.get(100)).thenReturn("Risqulla");

        System.out.println(list.getFirst());
        System.out.println(list.get(100));

        Mockito.verify(list, Mockito.times(1)).getFirst();
    }
}
