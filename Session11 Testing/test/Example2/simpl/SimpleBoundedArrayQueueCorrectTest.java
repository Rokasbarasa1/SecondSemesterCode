package Example2.simpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleBoundedArrayQueueCorrectTest {

    SimpleBoundedArrayQueueCorrect q;

    @Before
    public void setUp() throws Exception {
        q = new SimpleBoundedArrayQueueCorrect(5);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
        public void testEnqueue(){
            q.enqueue("A");
            q.enqueue("B");
            q.enqueue("C");
            assertEquals(3, q.size());
            q.enqueue("D");
            q.enqueue("E");
            assertTrue(q.contains("E"));
            assertEquals(5, q.size());
            q.enqueue("F");

        fail("Should not be able to push 6 elemts with 5 capaciy");
    }

    @Test //(expected = IllegalStateException.class)
    public void testDequeue(){
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        assertEquals(3, q.size());
        q.dequeue();
        assertEquals(2, q.size());
        assertTrue(!(q.contains("A")));

        //fail("The thing was not deleted");
    }

    @Test (expected = IllegalStateException.class)
    public void testFirst(){
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        assertEquals(3, q.size());
        assertEquals("A", q.first());
        q.dequeue();
        assertEquals("B", q.first());
        q.dequeue();
        assertEquals("C", q.first());
        q.dequeue();
        q.first();
    }

    @Test //(expected = IllegalStateException.class)
    public void testSize(){
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        assertEquals(3, q.size());
        q.dequeue();
        assertEquals(2, q.size());
        q.dequeue();
        assertEquals(1, q.size());
        q.dequeue();
        assertEquals(0, q.size());
    }

    @Test //(expected = IllegalStateException.class)
    public void testIsEmpty(){
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.isEmpty();

    }

    @Test //(expected = IllegalStateException.class)
    public void testIndexOf(){
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");



    }
}