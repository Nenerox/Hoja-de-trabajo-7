import org.junit.Test;
import static org.junit.Assert.*;

public class BSTTest {

    @Test
    public void testInsertAndSearchMultiple() {
        BST<Integer> bst = new BST<>();

        int[] values = {5, 3, 7, 2, 4, 6, 8};

        for (int v : values) {
            bst.insert(v);
        }

        for (int v : values) {
            assertNotNull(bst.search(v));
            assertEquals(v, (int) bst.search(v).value());
        }

        // valores que no están
        assertNull(bst.search(0));
        assertNull(bst.search(9));
    }
}
