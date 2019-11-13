package com.practice;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ArrayIncreasingSequenceTest {

    private static ArrayIncreasingSequence increasingSequence;

    @Before
    public void initArrayIncreasingSequence() {
        increasingSequence = new ArrayIncreasingSequence();
    }

    @Test
    @Parameters(method = "parametersToTestPosAndMaxSeq")
    public void posAndMaxSeq(int[] array,  ArrayIncreasingSequence.PosLength expectedValue) {
        assertEquals(expectedValue, increasingSequence.posAndMaxSeq(array));
    }


    private Object[] parametersToTestPosAndMaxSeq() {
        return new Object[]{
                new Object[]{getIntArray1(), new ArrayIncreasingSequence.PosLength(0,8)},
                new Object[]{getIntArray4(), new ArrayIncreasingSequence.PosLength(3,1)},
                new Object[]{getIntArray2(), new ArrayIncreasingSequence.PosLength(3,4)},
                new Object[]{getIntArray(), new ArrayIncreasingSequence.PosLength(0,0)},
                new Object[]{getIntArray5(), new ArrayIncreasingSequence.PosLength(0,2)},
                new Object[]{getIntArray6(), new ArrayIncreasingSequence.PosLength(3,1)},
                new Object[]{getIntArray7(), new ArrayIncreasingSequence.PosLength(6,7)}
        };
    }

    private int[] getIntArray1() {
        return new int[]{1, 2, 3, 4, 5, 7, 8, 9};
    }

    private int[] getIntArray2() {
        return new int[]{9, 2, 6, 3, 7, 8, 9, 0, 0};
    }

    private int[] getIntArray() {
        return new int[]{};
    }

    private int[] getIntArray4() {
        return new int[]{4, 3, 2, 1};
    }

    private int[] getIntArray5() {
        return new int[]{-4, 3, -2, 1};
    }

    private int[] getIntArray6() {
        return new int[]{0, 0, 0, 0};
    }

    private int[] getIntArray7() {
        return new int[]{4, 8, 1, 2, 3, 0, -1, 5, 6, 7, 8, 9, 10, 0, 1, 0, -2};
    }

}