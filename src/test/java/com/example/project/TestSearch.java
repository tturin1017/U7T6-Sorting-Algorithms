package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import com.example.project.Linear_Search.Search;
import static org.junit.jupiter.api.Assertions.*;


public class TestSearch {

    int[] elementsArray = {3, 7, 2, 7, 5, 7};
    ArrayList<Integer> elementsList = new ArrayList<>(Arrays.asList(3, 7, 2, 7, 5, 7));

    int[] emptyArray = {};
    ArrayList<Integer> emptyList = new ArrayList<>();

    int[] singleElementArray = {10};
    ArrayList<Integer> singleElementList = new ArrayList<>(Arrays.asList(10));

    int[] noMatchArray = {1, 2, 3, 4, 5};
    ArrayList<Integer> noMatchList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

    int[] allMatchArray = {8, 8, 8, 8};
    ArrayList<Integer> allMatchList = new ArrayList<>(Arrays.asList(8, 8, 8, 8));


    @Test
    public void testLinearSearchFirstArray() {
        assertEquals(1, Search.linearSearchFirst(elementsArray, 7));
        assertEquals(-1, Search.linearSearchFirst(elementsArray, 10));

        // New test cases
        assertEquals(-1, Search.linearSearchFirst(emptyArray, 7));
        assertEquals(0, Search.linearSearchFirst(singleElementArray, 10));
        assertEquals(-1, Search.linearSearchFirst(noMatchArray, 7));
        assertEquals(0, Search.linearSearchFirst(allMatchArray, 8));
    }

    @Test
    public void testLinearSearchLastArray() {
        assertEquals(5, Search.linearSearchLast(elementsArray, 7));
        assertEquals(-1, Search.linearSearchLast(elementsArray, 10));
        assertEquals(-1, Search.linearSearchLast(emptyArray, 7));
        assertEquals(0, Search.linearSearchLast(singleElementArray, 10));
        assertEquals(-1, Search.linearSearchLast(noMatchArray, 7));
        assertEquals(3, Search.linearSearchLast(allMatchArray, 8));
    }


    @Test
    public void testLinearSearchFoundArray() {
        assertTrue(Search.linearSearchFound(elementsArray, 7));
        assertFalse(Search.linearSearchFound(elementsArray, 10));
        assertFalse(Search.linearSearchFound(emptyArray, 7));
        assertTrue(Search.linearSearchFound(singleElementArray, 10));
        assertFalse(Search.linearSearchFound(noMatchArray, 7));
        assertTrue(Search.linearSearchFound(allMatchArray, 8));
    }

    @Test
    public void testLinearSearchCountArray() {
        assertEquals(3, Search.linearSearchCount(elementsArray, 7));
        assertEquals(0, Search.linearSearchCount(elementsArray, 10));
        assertEquals(0, Search.linearSearchCount(emptyArray, 7));
        assertEquals(1, Search.linearSearchCount(singleElementArray, 10));
        assertEquals(0, Search.linearSearchCount(noMatchArray, 7));
        assertEquals(4, Search.linearSearchCount(allMatchArray, 8));
    }


    @Test
    public void testLinearSearchFirstArrayList() {
        assertEquals(1, Search.linearSearchFirst(elementsList, 7));
        assertEquals(-1, Search.linearSearchFirst(elementsList, 10));
        assertEquals(-1, Search.linearSearchFirst(emptyList, 7));
        assertEquals(0, Search.linearSearchFirst(singleElementList, 10));
        assertEquals(-1, Search.linearSearchFirst(noMatchList, 7));
        assertEquals(0, Search.linearSearchFirst(allMatchList, 8));
    }


    @Test
    public void testLinearSearchLastList() {
        assertEquals(5, Search.linearSearchLast(elementsList, 7));
        assertEquals(-1, Search.linearSearchLast(elementsList, 10));
        assertEquals(-1, Search.linearSearchLast(emptyList, 7));
        assertEquals(0, Search.linearSearchLast(singleElementList, 10));
        assertEquals(-1, Search.linearSearchLast(noMatchList, 7));
        assertEquals(3, Search.linearSearchLast(allMatchList, 8));
    }

    @Test
    public void testLinearSearchFoundList() {
        assertTrue(Search.linearSearchFound(elementsList, 7));
        assertFalse(Search.linearSearchFound(elementsList, 10));
        assertFalse(Search.linearSearchFound(emptyList, 7));
        assertTrue(Search.linearSearchFound(singleElementList, 10));
        assertFalse(Search.linearSearchFound(noMatchList, 7));
        assertTrue(Search.linearSearchFound(allMatchList, 8));
    }

    @Test
    public void testLinearSearchCountList() {
        assertEquals(3, Search.linearSearchCount(elementsList, 7));
        assertEquals(0, Search.linearSearchCount(elementsList, 10));
        assertEquals(0, Search.linearSearchCount(emptyList, 7));
        assertEquals(1, Search.linearSearchCount(singleElementList, 10));
        assertEquals(0, Search.linearSearchCount(noMatchList, 7));
        assertEquals(4, Search.linearSearchCount(allMatchList, 8));
    }
}