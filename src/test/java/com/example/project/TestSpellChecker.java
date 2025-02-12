package com.example.project;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.example.project.Spell_Checker.SpellChecker;

public class TestSpellChecker {
    private SpellChecker checker = new SpellChecker();

    @Test
    public void testLinearSearchInList(){
        boolean result = checker.linearSpellCheck("frost");
        int loopCount = checker.getLoopCounter();
        assertTrue(result, "Frost is found in the list");
        assertEquals(44357,loopCount);
    }

    @Test
    public void testLinearSearchNotInList(){
        boolean result = checker.linearSpellCheck("catdog");
        int loopCount = checker.getLoopCounter();
        assertFalse(result, "catdog is not found in the list");
        assertEquals(127143,loopCount);
    }

    @Test
    public void testBinarySearchInList(){
        boolean result = checker.binarySpellCheck("frost");
        int loopCount = checker.getLoopCounter();
        assertTrue(result, "Frost is found in the list");
        assertEquals(16,loopCount);
    }

    @Test
    public void testBinarySearchInList2(){
        boolean result = checker.binarySpellCheck("lightered");
        int loopCount = checker.getLoopCounter();
        assertTrue(result, "lightered is found in the list");
        assertEquals(1,loopCount);
    }

    @Test
    public void testBinarySearchNotInList(){
        boolean result = checker.binarySpellCheck("catdog");
        int loopCount = checker.getLoopCounter();
        assertFalse(result, "catdog is not found in the list");
        assertEquals(17,loopCount);
    }
}
