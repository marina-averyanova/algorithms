package com.averyanova.algorithms;

import com.maveryanova.algorithms.datastructure.FactorArray;
import com.maveryanova.algorithms.datastructure.IArray;
import com.maveryanova.algorithms.datastructure.JavaListArray;
import com.maveryanova.algorithms.datastructure.MatrixArray;
import com.maveryanova.algorithms.datastructure.SingleArray;
import com.maveryanova.algorithms.datastructure.VectorArray;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ArraysTest {

    @Test
    public void singleArrayAddTest() {
        testAddArray(new SingleArray<>(), 100);          // 2
        testAddArray(new SingleArray<>(), 10_000);       // 72
        testAddArray(new SingleArray<>(), 100_000);      // 2599
        //testAddArray(new SingleArray<>(), 10_000_000);       // undefined
    }

    @Test
    public void vectorArrayAddTest() {
        testAddArray(new VectorArray<>(), 100);          // 1
        testAddArray(new VectorArray<>(), 10_000);       // 15
        testAddArray(new VectorArray<>(), 100_000);      // 534
        //testAddArray(new VectorArray<>(), 10_000_000);       // undefined

        testAddArray(new VectorArray<>(1000), 100);          // 0
        testAddArray(new VectorArray<>(1000), 10_000);       // 1
        testAddArray(new VectorArray<>(1000), 100_000);      // 10
        testAddArray(new VectorArray<>(1000), 10_000_000);   // 42259
    }

    @Test
    public void factorArrayAddTest() {
        testAddArray(new FactorArray<>(), 100);          // 1
        testAddArray(new FactorArray<>(), 10_000);       // 3
        testAddArray(new FactorArray<>(), 100_000);      // 10
        testAddArray(new FactorArray<>(), 10_000_000);   // 2115

        testAddArray(new FactorArray<>(1000), 100);          // 0
        testAddArray(new FactorArray<>(1000), 10_000);       // 1
        testAddArray(new FactorArray<>(1000), 100_000);      // 3
        testAddArray(new FactorArray<>(1000), 10_000_000);   // 1955
    }

    @Test
    public void matrixArrayAddTest() {
        testAddArray(new MatrixArray<>(), 100);          // 1
        testAddArray(new MatrixArray<>(), 10_000);       // 12
        testAddArray(new MatrixArray<>(), 100_000);      // 10
        testAddArray(new MatrixArray<>(), 10_000_000);   // 2251

        testAddArray(new MatrixArray<>(1000), 100);          // 0
        testAddArray(new MatrixArray<>(1000), 10_000);       // 1
        testAddArray(new MatrixArray<>(1000), 100_000);      // 5
        testAddArray(new MatrixArray<>(1000), 10_000_000);   // 1542
    }

    @Test
    public void javaListArrayAddTest() {
        testAddArray(new JavaListArray<>(), 100);          // 1
        testAddArray(new JavaListArray<>(), 10_000);       // 12
        testAddArray(new JavaListArray<>(), 100_000);      // 10
        testAddArray(new JavaListArray<>(), 10_000_000);   // 2251
    }

    /* *
    * Add tests
    *
    *            | single    | vector    | vector1000 | factor | factor1000 | matrix | matrix1000 | javaArray
    ----------------------------------------------------------------------------------------------------------
    | 100        | 2         | 2         | 0          | 1      | 0          | 1      | 0          | 0
    | 10_000     | 72        | 15        | 1          | 3      | 1          | 12     | 1          | 5
    | 100_000    | 2599      | 534       | 10         | 10     | 3          | 10     | 5          | 11
    | 10_000_000 | undefined | undefined | 42259      | 2115   | 1955       | 2251   | 1542       | 3133
    *
    *
    * Реализация single работает медленнее всего, потому что выполняет копирование всего внутреннего массива
    * при вставке каждого элемента. При вставке 100_000 элементов копирование выполнится 100_000 раз.
    * Реализация vector работает быстрее, тк копирование будет выполняться в vector меньше раз:
    * - по умолчанию vector=10, 100_000/10 = 10000 операций копирования;
    * - при заданном vector=1000, 100_000/1000 = 100 операций копирования.
    * Реализация factor позволяет сделать вставку еще большего числа элементов, тк копирует внутренний массив
    * еще меньше, причем тем меньше, чем больше стартовое значение factor.
    * Реализация matrix работает быстее factor на больших данных лучше при большем стартовом размере внутреннего
    * массива, тк это приводит к меньшему числу вызовов копирования у внутреннего массива.
    * Реализация java работает примерно как factor, тк инкрементирует свой capacity на 1.
    * На удаление все реализации работают примерно одинаково, за исключением matrix и factor.
    * И если matrix выполняет сложную операцию сдвига всех элементов внутренних массивов, то почему
    * тупит factor, использующий тот же System.arraycopy, что и javaList - не удалось разобраться.
    *
    * The Single implementation is slowest because it makes copy of the internal array for each item inserting.
    * When you paste 100_000 elements, it will make copy 100_000 times.
    * The Vector implementation is faster, because it makes copying "vector" times less:
    * - by default, vector = 10, 100_000 / 10 = 10000 copying operations;
    * - for a given vector = 1000, 100_000 / 1000 = 100 copying operations.
    * The Factor implementation allows to insert even more elements, because it copies the internal array
    * less times and it depends of the start value of factor.
    * The Matrix implementation is faster than the Factor with big data if the start size of the internal
    * array is bigger (we have less copy calls of the internal array).
    * On deletion, all implementations work approximately the same, except for Matrix and Factor.
    * And if Matrix performs a complex operation of shifting all elements of internal arrays, then why
    * Factor is so slow ( using the same System.arraycopy as JavaList ) - I failed to figure out.
    *
    * */

    @Test
    public void singleArrayRemoveTest() {
        testRemoveArray(new SingleArray<>(), 100);          // 0
        testRemoveArray(new SingleArray<>(), 10_000);       // 0
        testRemoveArray(new SingleArray<>(), 100_000);      // 0
        //testRemoveArray(new SingleArray<>(), 10_000_000);       // undefined
    }

    @Test
    public void vectorArrayRemoveTest() {
        testRemoveArray(new VectorArray<>(1000), 100);          // 0
        testRemoveArray(new VectorArray<>(1000), 10_000);       // 0
        testRemoveArray(new VectorArray<>(1000), 100_000);      // 1
        testRemoveArray(new VectorArray<>(1000), 10_000_000);   // 8
    }

    @Test
    public void factorArrayRemoveTest() {
        testRemoveArray(new FactorArray<>(1000), 100);          // 0
        testRemoveArray(new FactorArray<>(1000), 10_000);       // 0
        testRemoveArray(new FactorArray<>(1000), 100_000);      // 0
        testRemoveArray(new FactorArray<>(1000), 10_000_000);   // 132
    }

    @Test
    public void matrixArrayRemoveTest() {
        testRemoveArray(new MatrixArray<>(), 100);          // 0
        testRemoveArray(new MatrixArray<>(), 10_000);       // 2
        testRemoveArray(new MatrixArray<>(), 100_000);      // 3
        testRemoveArray(new MatrixArray<>(), 10_000_000);   // 77

        testRemoveArray(new MatrixArray<>(1000), 100);          // 0
        testRemoveArray(new MatrixArray<>(1000), 10_000);       // 0
        testRemoveArray(new MatrixArray<>(1000), 100_000);      // 0
        testRemoveArray(new MatrixArray<>(1000), 10_000_000);   // 5
    }

    @Test
    public void javaArrayRemoveTest() {
        testRemoveArray(new JavaListArray<>(), 100);          // 0
        testRemoveArray(new JavaListArray<>(), 10_000);       // 0
        testRemoveArray(new JavaListArray<>(), 100_000);      // 0
        testRemoveArray(new JavaListArray<>(), 10_000_000);   // 2
    }

    @Test
    public void arraysGetTest() {
        IArray<Date> single = new SingleArray<>();
        testGetArray(single);

        IArray<Date> vector = new VectorArray<>();
        testGetArray(vector);

        IArray<Date> factor = new FactorArray<>();
        testGetArray(factor);

        IArray<Date> matrix = new MatrixArray<>();
        testGetArray(matrix);

        IArray<Date> javaList = new JavaListArray<>();
        testGetArray(javaList);
    }

    private static void testAddArray(IArray<Date> array, int total) {
        long start = System.currentTimeMillis();

        for (int j = 0; j < total; j ++)
            array.add(new Date());

        System.out.println(array + " testAddArray: " +
            (System.currentTimeMillis() - start));

        assertEquals(array.size(), total);
    }

    private static void testRemoveArray(IArray<Integer> array, int total) {
        assertNull(array.remove(0));
        for (int i = 0; i < total; i ++) {
            array.add(i);
        }
        int removeIndex = array.size() / 2;

        long start = System.currentTimeMillis();
        Integer removed = array.remove(removeIndex);

        System.out.println(array + " testRemoveArray: " +
            (System.currentTimeMillis() - start));

        assertEquals(removeIndex, removed);

        // check size
        assertEquals(total - 1, array.size());

        // check out of bounds
        assertNull(array.remove(array.size() + 1));
        assertNull(array.remove(-100500));

        // remove first
        assertEquals(0, array.remove(0));
        assertEquals(total - 2, array.size());

        // remove last
        assertEquals(total - 1, array.remove(total - 3));
        assertEquals(total - 3, array.size());
    }

    private void testGetArray(IArray<Date> array) {
        assertEquals(0, array.size());
        assertNull(array.get(0));
        array.add(new Date());
        assertEquals(1, array.size());
        assertNotNull(array.get(0));
        assertNull(array.get(1));
        assertNull(array.get(-100500));
    }
}
