package com.interw;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BoardTest {
    Board b = new Board();


    @Before
    public void before() {
        b.isValidMove("1 1");
        b.add('X');
    }
    @Test
    public void isValidMove3() {

        Assert.assertFalse(b.isValidMove("1 1"));
    }
    @Test
    public void isValidMove() {

        Assert.assertFalse(b.isValidMove("11"));
    }
    @Test
    public void isValidInput() {

        Assert.assertFalse(b.isSpaceBetweenXandY("ss sada sad"));
    }
    @Test
    public void isValidInput1() {

        Assert.assertFalse(b.isSpaceBetweenXandY("**** ****"));
    }
    @Test
    public void isValidInput2() {

        Assert.assertFalse(b.isSpaceBetweenXandY("44 55"));
    }
    @Test
    public void isValidMove1() {

        Assert.assertFalse(b.isValidMove("1 5"));
    }
    @Test
    public void isValidMove2() {

        Assert.assertTrue(b.isValidMove("1 3"));
    }
}