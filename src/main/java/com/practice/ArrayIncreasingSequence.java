package com.practice;

import java.util.Objects;

public class ArrayIncreasingSequence {

    private static int[] array = new int[]{4, 3, 2, 1};


    public static void main(String[] args) {
        ArrayIncreasingSequence arrayIncreasingSequence = new ArrayIncreasingSequence();
        PosLength method = arrayIncreasingSequence.posAndMaxSeq(array);
        System.out.println("Position array[i]: i = " + method.getPosition() + " Length: " + method.getLength());
    }

    public PosLength posAndMaxSeq(int[] arr) {
        PosLength posLength = new PosLength();
        int length = 0;
        int prevSequence = 0;

        if (arr.length == 0) {
            return posLength;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                length += 1;
            } else if (prevSequence <= length) {
                posLength.setLength(length + 1);
                posLength.setPosition(i - length - 1);
                prevSequence = length + 1;
                length = 0;
            }
        }

        // rare case when sequence increase from start to end
        if (length + 1 == arr.length) {
            posLength.setPosition(0);
            posLength.setLength(length + 1);
        }

        // rare case when sequence decrease from end to start
        if (length == 0 && prevSequence == 1) {
            posLength.setPosition(arr.length - 1);
            posLength.setLength(length + 1);
        }

        return posLength;
    }

    static class PosLength {
        private int position;
        private int length;

        public PosLength() {
        }

        public PosLength(int position, int length) {
            this.position = position;
            this.length = length;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PosLength posLength = (PosLength) o;
            return position == posLength.position &&
                    length == posLength.length;
        }

        @Override
        public int hashCode() {
            return Objects.hash(position, length);
        }
    }
}
