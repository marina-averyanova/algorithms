package com.averyanova.algorithms;

import com.maveryanova.algorithms.sorting.HeapSort;
import com.maveryanova.algorithms.sorting.InsertionSort;
import com.maveryanova.algorithms.sorting.SelectionSort;
import com.maveryanova.algorithms.sorting.ShellSort;
import com.maveryanova.algorithms.sorting.Sort;
import com.sun.tools.javac.util.Pair;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArraySortingTest {
    private static final FileReader reader = new FileReader();
    private final Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    private final SelectionSort selectionSortClass = new SelectionSort();
    private final InsertionSort insertionSortClass = new InsertionSort();
    private final ShellSort shellSortClass = new ShellSort();
    private final HeapSort heapSortClass = new HeapSort();

    @Test
    public void randomTest() {
        Map<Integer, Pair<int[], String>> testData = reader.read("sorting-tests/0.random");

        logger.info("Selection sort");
        sortData(testData, selectionSortClass, 6);

        logger.info("Insertion sort");
        sortData(testData, insertionSortClass, 6);

        logger.info("Shell sort ('Shell' type)");
        sortData(testData, shellSortClass, "shell", null);

        logger.info("Shell sort ('Knut' type)");
        sortData(testData, shellSortClass, "knut", null);

        logger.info("Shell sort ('Sedgewick' type)");
        sortData(testData, shellSortClass, "sedgewick", null);

        logger.info("Heap sort");
        sortData(testData, heapSortClass, null);
    }

    @Test
    public void digitsTest() {
        Map<Integer, Pair<int[], String>> testData = reader.read("sorting-tests/1.digits");

        logger.info("Selection sort");
        sortData(testData, selectionSortClass, 6);

        logger.info("Insertion sort");
        sortData(testData, insertionSortClass, 6);

        logger.info("Shell sort ('Shell' type)");
        sortData(testData, shellSortClass, "shell", 6);

        logger.info("Shell sort ('Knut' type)");
        sortData(testData, shellSortClass, "knut", 6);

        logger.info("Shell sort ('Sedgewick' type)");
        sortData(testData, shellSortClass, "sedgewick", 6);

        logger.info("Heap sort");
        sortData(testData, heapSortClass, null);
    }

    @Test
    public void sortedTest() {
        Map<Integer, Pair<int[], String>> testData = reader.read("sorting-tests/2.sorted");

        logger.info("Selection sort");
        sortData(testData, selectionSortClass, 6);

        logger.info("Insertion sort");
        sortData(testData, insertionSortClass, 7);

        logger.info("Shell sort ('Shell' type)");
        sortData(testData, shellSortClass, "shell", null);

        logger.info("Shell sort ('Knut' type)");
        sortData(testData, shellSortClass, "knut", null);

        logger.info("Shell sort ('Sedgewick' type)");
        sortData(testData, shellSortClass, "sedgewick", null);

        logger.info("Heap sort");
        sortData(testData, heapSortClass, null);
    }

    @Test
    public void reversTest() {
        Map<Integer, Pair<int[], String>> testData = reader.read("sorting-tests/3.revers");

        logger.info("Selection sort");
        sortData(testData, selectionSortClass, 6);

        logger.info("Insertion sort");
        sortData(testData, insertionSortClass, 6);

        logger.info("Shell sort ('Shell' type)");
        sortData(testData, shellSortClass, "shell", null);

        logger.info("Shell sort ('Knut' type)");
        sortData(testData, shellSortClass, "knut", null);

        logger.info("Shell sort ('Sedgewick' type)");
        sortData(testData, shellSortClass, "sedgewick", null);

        logger.info("Heap sort");
        sortData(testData, heapSortClass, null);
    }

    private void sortData(Map<Integer, Pair<int[], String>> testData, Sort sort, Integer stopPoint) {
        for (Map.Entry<Integer, Pair<int[], String>> entry : testData.entrySet()) {
            if (stopPoint != null) {
                if (entry.getKey().equals(stopPoint)) {
                    logger.info("Stopped at case: " + stopPoint);
                    break;
                }
            }

            sort.setArray(entry.getValue().fst);
            testSort(sort, entry.getValue().snd, entry.getKey());
        }
    }

    private void sortData(Map<Integer, Pair<int[], String>> testData, ShellSort sort, String rule, Integer stopPoint) {
        for (Map.Entry<Integer, Pair<int[], String>> entry : testData.entrySet()) {
            if (stopPoint != null) {
                if (entry.getKey().equals(stopPoint)) {
                    logger.info("Stopped at case: " + stopPoint);
                    break;
                }
            }

            sort.setArray(entry.getValue().fst);
            sort.setRule(rule);
            testSort(sort, entry.getValue().snd, entry.getKey());
        }
    }

    private void testSort(Sort sortClass, String expected, int testCase) {
        Instant startTime = Instant.now();
        int[] testResult = sortClass.sort();
        Instant endTime = Instant.now();

        long durationMillis = endTime.toEpochMilli() - startTime.toEpochMilli();

        logger.info(String.format("Test #%d; duration=%d", testCase, durationMillis));
        assertEquals(expected, arrayToString(testResult));
    }

    private String arrayToString(int[] array) {
        return Arrays.stream(array)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(" "));
    }


    /* *
    * comparison table
    *
    * randomTest
    *
    *                 | Sel sort | Ins sort |Sh. 'Shell'|Sh. 'Knut'| Sh. 'Sedgewick'| Heap sort
    --------------------------------------------------------------------------------------------
    | #0   1          | 0        | 0        | 0         | 0        | 0              | 0
    | #1   10         | 0        | 0        | 0         | 0        | 0              | 0
    | #2   100        | 0        | 0        | 0         | 0        | 0              | 0
    | #3   1000       | 1        | 2        | 1         | 1        | 1              | 0
    | #4   10_000     | 61       | 12       | 5         | 2        | 1              | 2
    | #5   100_000    | 3505     | 948      | 16        | 18       | 14             | 14
    | #6   1_000_000  | ~        | ~        | 181       | 209      | 144            | 172
    | #7   10_000_000 | ~        | ~        | 3751      | 3016     | 1841           | 2812

    */

    /* *
    * comparison table
    *
    * digitsTest
    *
    *                 | Sel sort | Ins sort |Sh. 'Shell'|Sh. 'Knut'| Sh. 'Sedgewick'| Heap sort
    --------------------------------------------------------------------------------------------
    | #0   1          | 0        | 0        | 0         | 0        | 0              | 0
    | #1   10         | 0        | 0        | 0         | 0        | 0              | 0
    | #2   100        | 0        | 0        | 0         | 0        | 0              | 0
    | #3   1000       | 6        | 3        | 4         | 1        | 1              | 1
    | #4   10_000     | 75       | 14       | 15        | 8        | 7              | 2
    | #5   100_000    | 3572     | 1112     | 888       | 727      | 691            | 10
    | #6   1_000_000  | ~        | ~        | ~         | ~        | ~              | 86
    | #7   10_000_000 | ~        | ~        | ~         | ~        | ~              | 936

    */

    /* *
    * comparison table
    *
    * sortedTest
    *
    *                 | Sel sort | Ins sort |Sh. 'Shell'|Sh. 'Knut'| Sh. 'Sedgewick'| Heap sort
    --------------------------------------------------------------------------------------------
    | #0   1          | 0        | 0        | 0         | 0        | 0              | 0
    | #1   10         | 0        | 0        | 0         | 0        | 0              | 0
    | #2   100        | 0        | 0        | 0         | 0        | 0              | 0
    | #3   1000       | 3        | 0        | 1         | 0        | 0              | 0
    | #4   10_000     | 62       | 4        | 4         | 0        | 1              | 2
    | #5   100_000    | 3639     | 26       | 12        | 9        | 11             | 11
    | #6   1_000_000  | ~        | 2741     | 137       | 119      | 144            | 94
    | #7   10_000_000 | ~        | ~        | 1981      | 1679     | 1439           | 1074

    */

    /* *
    * comparison table
    *
    * reversTest
    *
    *                 | Sel sort | Ins sort |Sh. 'Shell'|Sh. 'Knut'| Sh. 'Sedgewick'| Heap sort
    --------------------------------------------------------------------------------------------
    | #0   1          | 0        | 0        | 0         | 0        | 0              | 0
    | #0   10         | 0        | 0        | 0         | 0        | 0              | 0
    | #0   100        | 0        | 0        | 0         | 0        | 0              | 0
    | #0   1000       | 4        | 3        | 1         | 0        | 0              | 0
    | #0   10_000     | 43       | 19       | 4         | 0        | 0              | 2
    | #0   100_000    | 8990     | 1980     | 6         | 3        | 3              | 10
    | #0   1_000_000  | ~        | ~        | 50        | 35       | 32             | 84
    | #0   10_000_000 | ~        | ~        | 643       | 422      | 415            | 994

    */

    /* *
    *
    * Selection sort
    *
    *                 | random   | digits   | sorted    | reversed
    ---------------------------------------------------------------
    | #0   1          | 0        | 0        | 0         | 0
    | #1   10         | 0        | 0        | 0         | 0
    | #2   100        | 0        | 0        | 0         | 0
    | #3   1000       | 1        | 6        | 3         | 4
    | #4   10_000     | 61       | 75       | 62        | 43
    | #5   100_000    | 3505     | 3572     | 3639      | 8990
    | #6   1_000_000  | ~        | ~        | ~         | ~
    | #7   10_000_000 | ~        | ~        | ~         | ~

    */

    /* *
    *
    * Insertion sort
    *
    *                 | random   | digits   | sorted    | reversed
    ---------------------------------------------------------------
    | #0   1          | 0        | 0        | 0         | 0
    | #1   10         | 0        | 0        | 0         | 0
    | #2   100        | 0        | 0        | 0         | 0
    | #3   1000       | 2        | 3        | 0         | 3
    | #4   10_000     | 12       | 14       | 4         | 19
    | #5   100_000    | 948      | 1112     | 26        | 1980
    | #6   1_000_000  | ~        | ~        | 2741      | ~
    | #7   10_000_000 | ~        | ~        | ~         | ~

    */

    /* *
    *
    * Shell sort ('Sedgewick')
    *
    *                 | random   | digits   | sorted    | reversed
    ---------------------------------------------------------------
    | #0   1          | 0        | 0        | 0         | 0
    | #1   10         | 0        | 0        | 0         | 0
    | #2   100        | 0        | 0        | 0         | 0
    | #3   1000       | 1        | 1        | 0         | 0
    | #4   10_000     | 1        | 7        | 1         | 0
    | #5   100_000    | 14       | 691      | 11        | 3
    | #6   1_000_000  | 144      | ~        | 144       | 32
    | #7   10_000_000 | 1841     | ~        | 1439      | 415

    */

    /* *
    *
    * Heap sort
    *
    *                 | random   | digits   | sorted    | reversed
    ---------------------------------------------------------------
    | #0   1          | 0        | 0        | 0         | 0
    | #1   10         | 0        | 0        | 0         | 0
    | #2   100        | 0        | 0        | 0         | 0
    | #3   1000       | 0        | 1        | 0         | 0
    | #4   10_000     | 2        | 2        | 2         | 2
    | #5   100_000    | 14       | 10       | 11        | 10
    | #6   1_000_000  | 172      | 86       | 94        | 84
    | #7   10_000_000 | 2812     | 936      | 1074      | 994

    */

    /* *

      Selection sort more slower with reversed array probably due to more assignment operations in each iteration.
      Selection sort is not reactive to few-variative or pre-sorted arrays.

      Insertion sort quickly than selection sort.
      Insertion sort reacts on pre-sorted data due to fewer swaps.

      Shell?

      Heap sort quickly than other n^2 algorithms.
      Heap sort is not reactive to pre-sorted or reversed arrays.
      Heap sort quickly with digits array probably due to a lot of equal values ​​and fewer swaps.
      Сomparison for random sorted/reversed arrays is irrelevant due to different order of numbers.

    */


}