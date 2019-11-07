package com.landscape.service.impl;

import com.landscape.service.WaterService;

public class WaterServiceImpl implements WaterService {

    /**
     * Algorithm count water between hills.
     *
     * @param landscape array with height values.
     * @return count of possible water.
     */
    public long calculateWaterAmount(int[] landscape) {
        int result = 0, maxLeft = 0, maxRight = 0;
        int startIndex = 0, endIndex = landscape.length - 1;

        while (startIndex <= endIndex) {
            if (landscape[startIndex] < landscape[endIndex]) {
                if (landscape[startIndex] > maxLeft)
                    maxLeft = landscape[startIndex];
                else
                    result += maxLeft - landscape[startIndex];

                startIndex++;
            } else {
                if (landscape[endIndex] > maxRight)
                    maxRight = landscape[endIndex];
                else
                    result += maxRight - landscape[endIndex];
                endIndex--;
            }
        }

        return result;
    }

}
