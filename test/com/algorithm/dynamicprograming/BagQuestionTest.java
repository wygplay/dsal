package com.algorithm.dynamicprograming;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/6/13 16:30
 */
public class BagQuestionTest {

    public BagQuestion bagQuestion;

    @Before
    public void init() {
        int[] bagWeight = {1, 2, 3, 4};
        int[] selectionWeight = {1, 4, 3, 1};
        int[] selectionValue = {1500, 3000, 2000, 3000};
        bagQuestion = new BagQuestion(bagWeight, selectionWeight, selectionValue);
    }

    @Test
    public void getMaxInterest() {
        assertEquals(5000, bagQuestion.getMaxInterest());
    }
}