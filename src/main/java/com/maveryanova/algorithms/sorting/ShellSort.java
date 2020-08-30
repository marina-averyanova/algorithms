package com.maveryanova.algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;

public class ShellSort implements Sort {
    private Rule rule;

    public ShellSort() {
        this.rule = new Shell();
    }

    public ShellSort(String rule) {
        if (rule.equals("K")) {
            this.rule = new Knut();
        } else if (rule.equals("S")) {
            this.rule = new Sedgewick();
        }
    }

    @Override
    public int[] sort(int[] arrayToSort) {
        int[] array = SortUtils.copyArray(arrayToSort);
        int length = array.length;

        for (int step = rule.getStartStep(length); step > 0; step = rule.getNextStep(step)) {
            for (int outerCounter = step; outerCounter < length; outerCounter++) {
                for (int innerCounter = outerCounter - step; innerCounter >= 0 && array[innerCounter] > array[innerCounter + step] ; innerCounter -= step) {
                    SortUtils.swap(array, innerCounter, innerCounter + step);
                }
            }
        }

        return array;
    }

    private abstract class Rule {
        public abstract int getStartStep(int length);
        public abstract int getNextStep(int current);
    }

    private class Shell extends Rule {
        // NOTE O(N^2)
        public int getStartStep(int length) {
            return length / 2;
        }

        public int getNextStep(int current) {
            return current / 2;
        }
    }
    private class Knut extends Rule {
        // NOTE O(N^3/2)
        public int getStartStep(int length) {
            int h = 1;
            while( h < length / 3) {
                h = 3 * h + 1;
            }
            return h;
        }

        public int getNextStep(int current) {
            return (current - 1) / 3;
        }
    }
    private class Sedgewick extends Rule {
        // { 1, 8, 23, 77, 281, 1073, 4193, 16577, 65921, 262913, 1050113, 4197377, 16783361 }
        private ArrayList<Integer> intervals;
        private int curIndex;

        public int getStartStep(int length) {
            intervals = new ArrayList<>();
            int h = 1; int i = 1;
            while (h == 1 || h < length) {
                intervals.add(h);
                h = (int) (Math.pow(4, i) + 3 * Math.pow(2, i - 1) + 1);
                i++;
            };
            Collections.reverse(intervals);
            curIndex = 0;
            return intervals.get(curIndex);
        }

        public int getNextStep(int current) {
            curIndex++;
            if (curIndex < intervals.size()) {
                return intervals.get(curIndex);
            } else return -1;
        }
    }
}
