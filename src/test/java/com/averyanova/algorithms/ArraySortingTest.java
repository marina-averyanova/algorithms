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
    private final HeapSort heapSort = new HeapSort();

    @Test
    public void randomTest() {
        Map<Integer, Pair<int[], String>> testData = reader.read("sorting-tests/0.random");

        /*logger.info("Selection sort");
        sortData(testData, selectionSortClass, 6);

        logger.info("Insertion sort");
        sortData(testData, insertionSortClass, 6);

        logger.info("Shell sort ('Shell' type)");
        sortData(testData, shellSortClass, "shell", null);

        logger.info("Shell sort ('Knut' type)");
        sortData(testData, shellSortClass, "knut", null);

        logger.info("Shell sort ('Sedgewick' type)");
        sortData(testData, shellSortClass, "sedgewick", null);*/

        logger.info("Heap sort");
        sortData(testData, heapSort, 6);
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
    *            | Sel sort | Ins sort |Sh. 'Shell'|Sh. 'Knut'| Sh. 'Sedgewick'|
    -----------------------------------------------------------------------------
    | 1          | 0        | 0        | 0         | 0        | 0              |
    | 10         | 0        | 0        | 0         | 0        | 0              |
    | 100        | 0        | 0        | 0         | 0        | 0              |
    | 1000       | 1        | 2        | 1         | 1        | 1              |
    | 10_000     | 61       | 12       | 5         | 2        | 1              |
    | 100_000    | 3505     | 948      | 16        | 18       | 14             |
    | 1_000_000  | ~        | ~        | 181       | 209      | 144            |
    | 10_000_000 | ~        | ~        | 3751      | 3016     | 1841           |

    */

    /* *
    * comparison table
    *
    * digitsTest
    *
    *            | Sel sort | Ins sort |Sh. 'Shell'|Sh. 'Knut'| Sh. 'Sedgewick'|
    -----------------------------------------------------------------------------
    | 1          | 0        | 0        | 0         | 0        | 0              |
    | 10         | 0        | 0        | 0         | 0        | 0              |
    | 100        | 0        | 0        | 0         | 0        | 0              |
    | 1000       | 6        | 3        | 4         | 1        | 1              |
    | 10_000     | 75       | 14       | 15        | 8        | 7              |
    | 100_000    | 3572     | 1112     | 888       | 727      | 691            |
    | 1_000_000  | ~        | ~        | ~         | ~        | ~              |
    | 10_000_000 | ~        | ~        | ~         | ~        | ~              |

    */

    /* *
    * comparison table
    *
    * sortedTest
    *
    *            | Sel sort | Ins sort |Sh. 'Shell'|Sh. 'Knut'| Sh. 'Sedgewick'|
    -----------------------------------------------------------------------------
    | 1          | 0        | 0        | 0         | 0        | 0              |
    | 10         | 0        | 0        | 0         | 0        | 0              |
    | 100        | 0        | 0        | 0         | 0        | 0              |
    | 1000       | 3        | 0        | 1         | 0        | 0              |
    | 10_000     | 62       | 4        | 4         | 0        | 1              |
    | 100_000    | 3639     | 26       | 12        | 9        | 11             |
    | 1_000_000  | ~        | 2741     | 137       | 119      | 144            |
    | 10_000_000 | ~        | ~        | 1981      | 1679     | 1439           |

    */

    /* *
    * comparison table
    *
    * reversTest
    *
    *            | Sel sort | Ins sort |Sh. 'Shell'|Sh. 'Knut'| Sh. 'Sedgewick'|
    -----------------------------------------------------------------------------
    | 1          | 0        | 0        | 0         | 0        | 0              |
    | 10         | 0        | 0        | 0         | 0        | 0              |
    | 100        | 0        | 0        | 0         | 0        | 0              |
    | 1000       | 4        | 3        | 1         | 0        | 0              |
    | 10_000     | 43       | 19       | 4         | 0        | 0              |
    | 100_000    | 8990     | 1980     | 6         | 3        | 3              |
    | 1_000_000  | ~        | ~        | 50        | 35       | 32             |
    | 10_000_000 | ~        | ~        | 643       | 422      | 415            |

    */
}