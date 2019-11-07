package com.landscape.service.impl;

import static org.junit.Assert.assertEquals;

import com.landscape.service.WaterService;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class WaterServiceImplTest {

    private static WaterService waterService;

    @Before
    public void initWaterService() {
        waterService = new WaterServiceImpl();
    }

    @Test
    @Parameters(method = "parametersToTestAmountWater")
    public void whenWithNamedMethod_thenCalculateWaterAmount(int[] array, int expectedValue) {
        assertEquals(expectedValue, waterService.calculateWaterAmount(array));
    }

    private Object[] parametersToTestAmountWater() {
        return new Object[]{
                new Object[]{getIntArray(), 2},
                new Object[]{getIntArray1(), 9},
                new Object[]{getIntArray2(), 27},
                new Object[]{getIntArray3(), 0}
        };
    }

    private int[] getIntArray() {
        return new int[]{3, 0, 0, 1};
    }

    private int[] getIntArray1() {
        return new int[]{5, 2, 3, 4, 5, 4, 0, 3, 1};
    }

    private int[] getIntArray2() {
        return new int[]{9, 2, 6, 3, 7, 0, 9};
    }

    private int[] getIntArray3() {
        return new int[]{3, 0, 0};
    }

}

