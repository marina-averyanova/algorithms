package com.maveryanova.algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ShellSort extends Sort {
    private ArrayList<Integer> intervals;
    private final Map<Integer, ArrayList<Integer>> shellIntervals = new HashMap<>();
    private final Map<Integer, ArrayList<Integer>> knutIntervals = new HashMap<>();
    private final Map<Integer, ArrayList<Integer>> sedgewickIntervals = new HashMap<>();

    public ShellSort() {
        super();
        this.intervals = new ArrayList<>();
    }

    @Override
    public int[] sort() {
        int[] array = copyArray();

        int innerCounter,  outerCounter;
        int temp;
        for (Integer h : intervals) {
            for (outerCounter = h; outerCounter < getLength(); outerCounter++) {
                temp = array[outerCounter];
                innerCounter = outerCounter;

                while (innerCounter > h - 1 && array[innerCounter - h] >= temp) {
                    array[innerCounter] = array[innerCounter - h];
                    innerCounter -= h;
                }
                array[innerCounter] = temp;
            }
        }

        return array;
    }

    public void setRule(String rule) {
        setIntervals(rule);
    }

    private void setIntervals(String intervalsRule) {
        int length = getLength();
        if (intervalsRule.equals("shell")) {
            // NOTE O(N^2)
            if (shellIntervals.containsKey(length)) {
                this.intervals = shellIntervals.get(length);
            } else {
                ArrayList<Integer> intervals = getShellIntervals(length);
                this.intervals = intervals;
                shellIntervals.put(length, intervals);
            }
        }
        if (intervalsRule.equals("knut")) {
            // NOTE O(N^3/2)
            if (knutIntervals.containsKey(length)) {
                this.intervals = knutIntervals.get(length);
            } else {
                ArrayList<Integer> intervals = getKnutIntervals(length);
                this.intervals = intervals;
                knutIntervals.put(length, intervals);
            }
        }
        if (intervalsRule.equals("sedgewick")) {
            // NOTE O(N^4/3)
            if (sedgewickIntervals.containsKey(length)) {
                this.intervals = sedgewickIntervals.get(length);
            } else {
                ArrayList<Integer> intervals = getSedgewickIntervals(length);
                this.intervals = intervals;
                sedgewickIntervals.put(length, intervals);
            }
        }
    }

    private ArrayList<Integer> getShellIntervals(int length) {
        ArrayList<Integer> intervals = new ArrayList<>();
        for (int h = length / 2; h > 0; h /= 2) {
            intervals.add(h);
        }
        return intervals;
    }

    private ArrayList<Integer> getKnutIntervals(int length) {
        ArrayList<Integer> intervals = new ArrayList<>();
        int h = 1;
        intervals.add(h);
        while (h <= length / 3) {
            h = h * 3 + 1;
            intervals.add(h);
        }
        Collections.reverse(intervals);
        return intervals;
    }

    private ArrayList<Integer> getSedgewickIntervals(int length) {
        ArrayList<Integer> intervals = new ArrayList<>();
        int h = 1; int i = 1;
        while (h == 1 || h < length) {
            intervals.add(h);
            h = new Double(Math.pow(4, i) + 3 * Math.pow(2, i - 1) + 1).intValue();
            i++;
        };
        /*int[] sequence = new int[] { 1, 8, 23, 77, 281, 1073, 4193, 16577, 65921, 262913, 1050113, 4197377, 16783361 };
        int h = 1; int i = 0;
        while (h < getLength()) {
            h = sequence[i];
            this.intervals.add(h);
            i++;
        };*/
        Collections.reverse(intervals);
        return intervals;
    }
}
