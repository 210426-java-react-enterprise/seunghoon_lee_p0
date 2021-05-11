package com.revature.seunghoon_lee_p0.util;

import com.revature.seunghoon_lee_p0.util.LinkedList;
import org.junit.*;

public class LinkedListTest {

    private LinkedList<String> sut;

    @Before
    public void setUpTest() {
        sut = new LinkedList<>();
    }

    @After
    public void tearDownTest() {
        sut = null;
    }

    @Test(expected = Exception.class)
    public void test_addWithNullValue() {
        //Arrange

        //Act
        sut.add(null);

        //Assert
    }

    @Test
    public void test_addWithNonNullValue() {
        //Arrange

        //Act
        sut.add("test");
        //Assert
        Assert.assertEquals(1, sut.size());
    }

    @Test
    public void test_containsWithEmptyList() {
        //Arrange
        //Act
        boolean no = sut.contains("test_1");
        //Asset
        Assert.assertFalse(no);
    }

    @Test
    public void test_containsWithPopulatedList() {
        //Arrange
        sut.add("test_1");
        sut.add("test_2");
        //Act
        boolean yes = sut.contains("test_1");
        boolean no  = sut.contains("test_3");
        //Asset
        Assert.assertTrue(yes);
        Assert.assertFalse(no);
    }

    @Test
    public void test_removeMatchingValue() {
        //Arrange
        sut.add("test_1");
        sut.add("test_2");
        sut.add("test_3");
        //Act
        String data = sut.remove("test_2");
        //Assert
        Assert.assertEquals("test_2", data);
        Assert.assertEquals(2, sut.size());
    }

    @Test
    public void test_removeNonMatchingValue() {
        //Arrange
        sut.add("test_1");
        sut.add("test_2");
        //Act
        String data = sut.remove("test_3");
        //Assert
        Assert.assertEquals(null, data);
        Assert.assertEquals(2, sut.size());
    }

    @Test
    public void test_getWithIndexInBounds() {
        //Arrange
        sut.add("test_1");
        sut.add("test_2");
        sut.add("test_3");
        //Act
        String data = sut.get(1);
        //Assert
        Assert.assertEquals("test_2", data);
    }

    @Test(expected = Exception.class)
    public void test_getWithIndexOutOfBounds() {
        //Arrange
        sut.add("test_1");
        sut.add("test_2");
        sut.add("test_3");
        //Act
        String data = sut.get(5);
        //Assert
    }

    @Test
    public void test_peekWithEmptyList() {
        //Arrange
        //Act
        String data = sut.peek();
        //Assert
        Assert.assertNull(data);
    }

    @Test
    public void test_peekWithPopulatedList() {
        //Arrange
        sut.add("test_1");
        sut.add("test_2");
        sut.add("test_3");
        //Act
        String data = sut.peek();
        //Assert
        Assert.assertEquals("test_1", data);
    }

    @Test
    public void test_pollWithEmptyList() {
        //Arrange

        //Act
        String data = sut.poll();
        //Aseert
        Assert.assertNull(data);
    }

    @Test
    public void test_pollWithPopulatedList() {
        //Arrange
        sut.add("test_1");
        sut.add("test_2");
        //Act
        String data = sut.poll();
        //Aseert
        Assert.assertEquals("test_1", data);
        Assert.assertEquals(1, sut.size());
    }

}
