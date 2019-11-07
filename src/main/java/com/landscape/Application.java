package com.landscape;

import com.landscape.service.WaterService;
import com.landscape.service.impl.WaterServiceImpl;

import java.util.Arrays;
import java.util.Random;

public class Application {

    private final static int MAX_VALUE = 32000;

    public static void main(String[] args) {
        int[] taskLandscape = {5, 2, 3, 4, 5, 4, 0, 3, 1};
        printLandscape(taskLandscape);
        WaterService waterService = new WaterServiceImpl();
        System.out.println(String.format("Example landscape.\n Water cubes count: %s ", waterService.calculateWaterAmount(taskLandscape)));

        int[] landscape = generateBigArray();
        System.out.println(String.format("Big landscape.\n Water cubes count: %s ", waterService.calculateWaterAmount(landscape)));
    }

    /**
     * Draw landscape.
     *
     * @param landscape init array.
     */
    private static void printLandscape(int[] landscape) {
        int row = findLargestElement(landscape);

        for (int i = 0; i < row; i++) {
            for (int weight : landscape) {
                if (row - weight - i > 0) {
                    System.out.print("[ ] ");
                } else {
                    System.out.print("[X] ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Search largest element in array.
     *
     * @param array integers.
     * @return max value.
     */
    private static int findLargestElement(int[] array) {
        return Arrays.stream(array).max().getAsInt();
    }

    private static int[] generateBigArray() {
        int[] array = new int[MAX_VALUE];

        for (int i = 0; i < array.length; i++) {
            array[i] = getRandomNumberInRange(0, MAX_VALUE);
        }

        return array;
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("Max value must be greater than min value");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
