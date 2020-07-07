package com.averyanova.algorithms;

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

    @Test
    public void randomTest() {
        Map<Integer, Pair<int[], String>> testData = reader.read("sorting-tests/0.random");

        logger.info("Selection sort");
        for (Map.Entry<Integer, Pair<int[], String>> entry : testData.entrySet()) {
            selectionSortClass.setArray(entry.getValue().fst);
            testSort(selectionSortClass, entry.getValue().snd, entry.getKey());
            if (entry.getKey() == 5) {
                break;
            }
        }

        logger.info("Insertion sort");
        for (Map.Entry<Integer, Pair<int[], String>> entry : testData.entrySet()) {
            insertionSortClass.setArray(entry.getValue().fst);
            testSort(insertionSortClass, entry.getValue().snd, entry.getKey());
            if (entry.getKey() == 5) {
                break;
            }
        }

        logger.info("Shell sort ('Shell' type)");
        for (Map.Entry<Integer, Pair<int[], String>> entry : testData.entrySet()) {
            shellSortClass.setArray(entry.getValue().fst);
            shellSortClass.setRule("shell");
            testSort(shellSortClass, entry.getValue().snd, entry.getKey());
        }

        logger.info("Shell sort ('Knut' type)");
        for (Map.Entry<Integer, Pair<int[], String>> entry : testData.entrySet()) {
            shellSortClass.setArray(entry.getValue().fst);
            shellSortClass.setRule("knut");
            testSort(shellSortClass, entry.getValue().snd, entry.getKey());
        }

        logger.info("Shell sort ('Sedgewick' type)");
        for (Map.Entry<Integer, Pair<int[], String>> entry : testData.entrySet()) {
            shellSortClass.setArray(entry.getValue().fst);
            shellSortClass.setRule("sedgewick");
            testSort(shellSortClass, entry.getValue().snd, entry.getKey());
        }
    }

    @Test
    public void digitsTest() {
        Map<Integer, Pair<int[], String>> testData = reader.read("sorting-tests/1.digits");

        logger.info("Selection sort");
        for (Map.Entry<Integer, Pair<int[], String>> entry : testData.entrySet()) {
            selectionSortClass.setArray(entry.getValue().fst);
            testSort(selectionSortClass, entry.getValue().snd, entry.getKey());
            if (entry.getKey() == 5) {
                break;
            }
        }

        logger.info("Insertion sort");
        for (Map.Entry<Integer, Pair<int[], String>> entry : testData.entrySet()) {
            insertionSortClass.setArray(entry.getValue().fst);
            testSort(insertionSortClass, entry.getValue().snd, entry.getKey());
            if (entry.getKey() == 5) {
                break;
            }
        }

        logger.info("Shell sort ('Shell' type)");
        for (Map.Entry<Integer, Pair<int[], String>> entry : testData.entrySet()) {
            shellSortClass.setArray(entry.getValue().fst);
            shellSortClass.setRule("shell");
            testSort(shellSortClass, entry.getValue().snd, entry.getKey());
            if (entry.getKey() == 5) {
                break;
            }
        }

        logger.info("Shell sort ('Knut' type)");
        for (Map.Entry<Integer, Pair<int[], String>> entry : testData.entrySet()) {
            shellSortClass.setArray(entry.getValue().fst);
            shellSortClass.setRule("knut");
            testSort(shellSortClass, entry.getValue().snd, entry.getKey());
            if (entry.getKey() == 5) {
                break;
            }
        }

        logger.info("Shell sort ('Sedgewick' type)");
        for (Map.Entry<Integer, Pair<int[], String>> entry : testData.entrySet()) {
            shellSortClass.setArray(entry.getValue().fst);
            shellSortClass.setRule("sedgewick");
            testSort(shellSortClass, entry.getValue().snd, entry.getKey());
            if (entry.getKey() == 5) {
                break;
            }
        }
    }

    @Test
    public void sortedTest() {
        Map<Integer, Pair<int[], String>> testData = reader.read("sorting-tests/2.sorted");

        logger.info("Selection sort");
        for (Map.Entry<Integer, Pair<int[], String>> entry : testData.entrySet()) {
            selectionSortClass.setArray(entry.getValue().fst);
            testSort(selectionSortClass, entry.getValue().snd, entry.getKey());
            if (entry.getKey() == 5) {
                break;
            };
        }

        logger.info("Insertion sort");
        for (Map.Entry<Integer, Pair<int[], String>> entry : testData.entrySet()) {
            insertionSortClass.setArray(entry.getValue().fst);
            testSort(insertionSortClass, entry.getValue().snd, entry.getKey());
            if (entry.getKey() == 6) {
                break;
            }
        }

        logger.info("Shell sort ('Shell' type)");
        for (Map.Entry<Integer, Pair<int[], String>> entry : testData.entrySet()) {
            shellSortClass.setArray(entry.getValue().fst);
            shellSortClass.setRule("shell");
            testSort(shellSortClass, entry.getValue().snd, entry.getKey());
        }

        logger.info("Shell sort ('Knut' type)");
        for (Map.Entry<Integer, Pair<int[], String>> entry : testData.entrySet()) {
            shellSortClass.setArray(entry.getValue().fst);
            shellSortClass.setRule("knut");
            testSort(shellSortClass, entry.getValue().snd, entry.getKey());
        }

        logger.info("Shell sort ('Sedgewick' type)");
        for (Map.Entry<Integer, Pair<int[], String>> entry : testData.entrySet()) {
            shellSortClass.setArray(entry.getValue().fst);
            shellSortClass.setRule("sedgewick");
            testSort(shellSortClass, entry.getValue().snd, entry.getKey());
        }
    }

    @Test
    public void reversTest() {
        Map<Integer, Pair<int[], String>> testData = reader.read("sorting-tests/3.revers");

        logger.info("Selection sort");
        for (Map.Entry<Integer, Pair<int[], String>> entry : testData.entrySet()) {
            selectionSortClass.setArray(entry.getValue().fst);
            testSort(selectionSortClass, entry.getValue().snd, entry.getKey());
            if (entry.getKey() == 5) {
                break;
            }
        }

        logger.info("Insertion sort");
        for (Map.Entry<Integer, Pair<int[], String>> entry : testData.entrySet()) {
            insertionSortClass.setArray(entry.getValue().fst);
            testSort(insertionSortClass, entry.getValue().snd, entry.getKey());
            if (entry.getKey() == 5) {
                break;
            }
        }

        logger.info("Shell sort ('Shell' type)");
        for (Map.Entry<Integer, Pair<int[], String>> entry : testData.entrySet()) {
            shellSortClass.setArray(entry.getValue().fst);
            shellSortClass.setRule("shell");
            testSort(shellSortClass, entry.getValue().snd, entry.getKey());
        }

        logger.info("Shell sort ('Knut' type)");
        for (Map.Entry<Integer, Pair<int[], String>> entry : testData.entrySet()) {
            shellSortClass.setArray(entry.getValue().fst);
            shellSortClass.setRule("knut");
            testSort(shellSortClass, entry.getValue().snd, entry.getKey());
        }

        logger.info("Shell sort ('Sedgewick' type)");
        for (Map.Entry<Integer, Pair<int[], String>> entry : testData.entrySet()) {
            shellSortClass.setArray(entry.getValue().fst);
            shellSortClass.setRule("sedgewick");
            testSort(shellSortClass, entry.getValue().snd, entry.getKey());
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
    *            | Sel sort | Ins sort |Sh. 'Shell'|Sh. 'Knut'| Sh. 'Sedgewick'|
    -----------------------------------------------------------------------------
    | 1          | 0        | 0        | 0         | 0        | 0              |
    | 10         | 0        | 0        | 0         | 0        | 0              |
    | 100        | 0        | 0        | 0         | 0        | 0              |
    | 1000       | 1        | 0        | 0         | 1        | 1              |
    | 10_000     | 83       | 14       | 1         | 1        | 1              |
    | 100_000    | 7007     | 1714     | 19        | 19       | 15             |
    | 1_000_000  | ~        | ~        | 383       | 292      | 256            |
    | 10_000_000 | ~        | ~        | 5419      | 5031     | 3349           |

    */
}