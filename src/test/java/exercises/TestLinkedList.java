package exercises;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;

public class TestLinkedList {
    @Test
    public void testGetOnEmptyList() {
        LinkedList list = new LinkedList();
        boolean success = false;
        try {
            list.get(0);
            fail("should have thrown an exception");
        } catch (IndexOutOfBoundsException e) {
            success = true;
        }
        assertEquals(true, success);
    }
    @Test
    public void testGetOnNonEmptyList() {
        LinkedList list  = new LinkedList();
        list.add(10);
        list.add(12);
        list.add(14);
        list.add(16);
        assertEquals(14,list.get(2));
    }
    @Test
    public void testAddInEmptyList() {
        LinkedList list  = new LinkedList();
        list.add(10);
        assertEquals(false, list.isEmpty());

    }
}
