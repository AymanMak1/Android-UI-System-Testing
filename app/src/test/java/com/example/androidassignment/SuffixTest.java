package com.example.androidassignment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;


public class SuffixTest {
    Suffix suff;

    @Before
    public void setup() {
        try {
            suff = new Suffix("Ayman", 2);
        } catch (IllegalArgumentException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void getSTest() {
        assertEquals("Ayman", suff.getS());
    }

    @Test
    public void getIndexTest() {
        assertEquals(2, suff.getIndex(),0);
    }

    @Test
    public void setIndexTest() {
        suff.setIndex(3);
        assertEquals(3, suff.getIndex(), 0);
    }

    @Test
    public void setSTest() {
        suff.setS("Ashraf");
        assertEquals("Ashraf", suff.getS());
    }

    @Test
    public void secondParameterGreaterThanTheLengthOfTheFirstParameter() {
        try {
            suff.setIndex(6);
        } catch(IllegalArgumentException e){
            String expectedMessage = "The index parameter has to be less than the length of the string.";
            String actualMessage = e.getMessage();
            if (actualMessage != null) {
                assertTrue(actualMessage.equals(expectedMessage));
            }
        }
    }

    @Test
    public void throwExceptionWhenSecondParameterisNegative(){
        try {
            suff.setIndex(-1);
        } catch (IllegalArgumentException e) {
            String expectedMessage = "The index can't be smaller than 0";
            String actualMessage = e.getMessage();
            if (actualMessage != null) {
                assertTrue(actualMessage.equals(expectedMessage));
            }
        }
    }
}