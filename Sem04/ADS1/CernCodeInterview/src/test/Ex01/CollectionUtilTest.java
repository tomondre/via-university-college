package Ex01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.*;

public class CollectionUtilTest {

    @Test
    public void getDuplicatesFromEmptyList() {

        //Arrange
        List<String> list = new ArrayList<String>();
        List<String> result;

        //Act
        result = CollectionUtil.getDuplicates(list);

        //Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void getDuplicatesFromOneItemList() {

        //Arrange
        List<String> list = new ArrayList<String>(Arrays.asList("A"));
        List<String> result;

        //Act
        result = CollectionUtil.getDuplicates(list);

        //Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void getDuplicatesFromListWithMultipleItems() {

        //Arrange
        List<String> list = new ArrayList<String>(Arrays.asList("A", "B", "C"));
        List<String> result;

        //Act
        result = CollectionUtil.getDuplicates(list);

        //Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void getDuplicatesFromListWithOneDuplicate() {

        //Arrange
        List<String> list = new ArrayList<String>(Arrays.asList("A", "B", "C", "A"));
        List<String> result;

        //Act
        result = CollectionUtil.getDuplicates(list);

        //Assert
        assertEquals(1, result.size());
    }

    @Test
    public void getDuplicatesFromListWithMultipleDuplicate() {

        //Arrange
        List<String> list = new ArrayList<String>(Arrays.asList("A", "B", "B", "C", "C", "A"));
        List<String> result;

        //Act
        result = CollectionUtil.getDuplicates(list);

        //Assert
        assertEquals(3, result.size());
    }

    @Test
    public void getDuplicatesIsResultListInOrder() {

        //Arrange
        List<String> list = new ArrayList<String>(Arrays.asList("b", "a", "c", "c", "e", "a", "c", "d", "c", "d"));
        List<String> result;
        List<String> expectedResult = new ArrayList<String>(Arrays.asList("a", "c", "d"));

        //Act
        result = CollectionUtil.getDuplicates(list);

        //Assert
        assertEquals(expectedResult, result);
    }
}
