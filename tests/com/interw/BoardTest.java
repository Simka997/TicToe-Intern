package com.interw;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BoardTest {
    private static final String ALREADY_TAKEN = "1 1";
    private static final String WITHOUT_SPACE = "11";
    private static final String TEXT_INPUT = "ss sada sad";
    private static final String SPECIAL_CHAR = "** //";
    private static final String NUMERIC_INPUT = "44 55";
    private static final String INVALID_MOVE_AREA = "1 5";
    private static final String VALID_MOVE_AREA = "1 3";

    Board board = new Board();


    @Before
    public void before() {
        board.isValidMove(ALREADY_TAKEN);
        board.add('X');
    }

    @Test
    public void isAlreadyTaken() {

        Assert.assertFalse(board.isValidMove(ALREADY_TAKEN));
    }

    @Test
    public void isWithoutSpace() {

        Assert.assertFalse(board.isValidMove(WITHOUT_SPACE));
    }

    @Test
    public void isValidTextInput() {

        Assert.assertFalse(board.isSpaceBetweenXandY(TEXT_INPUT));
    }

    @Test
    public void isValidSpecialCharInput() {

        Assert.assertFalse(board.isValidMove(SPECIAL_CHAR));
    }

    @Test
    public void isValidNumericInput() {

        Assert.assertFalse(board.isSpaceBetweenXandY(NUMERIC_INPUT));
    }

    @Test
    public void isValidMoveArea() {

        Assert.assertFalse(board.isValidMove(INVALID_MOVE_AREA));
    }

    @Test
    public void isValidMoveArea1() {

        Assert.assertTrue(board
                .isValidMove(VALID_MOVE_AREA));
    }
}