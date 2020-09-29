package Server.utility;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTesting {
    @Test
    public void addedElementIsInList(){
        //Arrange
        ListADT<String> q = new ArrayList<>();
        //Act
        q.add("A");
        //Assert
        assertTrue(q.contains("A"));
    }

    @Test
    public void addedElementIsNotInList(){
        ListADT<String> q = new ArrayList<>();
        q.add("A");
        assertFalse(q.contains("B"));
    }

    @Test
    public void addMultipleElementsToInList(){
        ListADT<String> q = new ArrayList<>();
        q.add("A");
        q.add("B");
        q.add("C");
        q.add("D");
        q.add("E");
        assertTrue(q.contains("A"));
        assertTrue(q.contains("B"));
        assertTrue(q.contains("C"));
        assertTrue(q.contains("D"));
        assertTrue(q.contains("E"));
    }

}