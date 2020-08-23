package com.averyanova.algorithms;

import com.maveryanova.algorithms.tasks.FiboIteration;
import com.maveryanova.algorithms.tasks.FiboMatrix;
import com.maveryanova.algorithms.tasks.FiboRecursion;
import com.maveryanova.algorithms.tasks.Power2Power;
import com.maveryanova.algorithms.tasks.PowerBinary;
import com.maveryanova.algorithms.tasks.PowerIterate;
import com.maveryanova.algorithms.tasks.Task;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AlgebraicTest {
    private static Tester tester;

    @BeforeAll
    static void setUp() {
        tester = new Tester();
    }

    @Test
    public void fiboRecursionTest() {
        Task ticketsTask = new FiboRecursion();
        tester.runTests(ticketsTask);
    }

    @Test
    public void fiboIterationTest() {
        Task ticketsTask = new FiboIteration();
        tester.runTests(ticketsTask);
    }

    @Test
    public void fiboMatrixTest() {
        Task ticketsTask = new FiboMatrix();
        tester.runTests(ticketsTask);
    }

    /* *
    * Fibo timelines
    *
    *          | recursion | iteration | matrix  |
    -----------------------------------------------
    | Test #0  | 0s12ms    | 0s12ms    | 0s10ms  |
    | Test #1  | 0s0ms     | 0s1ms     | 0s3ms   |
    | Test #2  | 0s1ms     | 0s1ms     | 0s2ms   |
    | Test #3  | 0s6ms     | 0s1ms     | 0s0ms   |
    | Test #4  | 0s63ms    | 0s1ms     | 0s0ms   |
    | Test #5  | 2s146ms   | 0s1ms     | 0s0ms   |
    | Test #6  | 0s26ms    | 0s1ms     | 0s1ms   |
    | Test #7  | 237s394ms | 0s1ms     | 0s1ms   |
    | Test #8  | undefined | 0s1ms     | 0s2ms   |
    | Test #9  | undefined | 0s2ms     | 0s1ms   |
    | Test #10 | undefined | 0s4ms     | 0s1ms   |
    | Test #11 | undefined | 16s497ms  | 1s81ms  |
    | Test #12 | undefined | undefined | 6s901ms |

    * */

    @Test
    public void powerIterateTest() {
        Task ticketsTask = new PowerIterate();
        tester.runTests(ticketsTask);
    }

    @Test
    public void power2PowerTest() {
        Task ticketsTask = new Power2Power();
        tester.runTests(ticketsTask);
    }

    @Test
    public void powerBinaryTest() {
        Task ticketsTask = new PowerBinary();
        tester.runTests(ticketsTask);
    }

    /* *
    * Power of number timelines
    *
    *          | iterate   | power2power | binary |
    -----------------------------------------------
    | Test #0  | 0s12ms    | 0s12ms      | 0s11ms |
    | Test #1  | 0s1ms     | 0s0ms       | 0s0ms  |
    | Test #2  | 0s1ms     | 0s0ms       | 0s0ms  |
    | Test #3  | 0s1ms     | 0s0ms       | 0s0ms  |
    | Test #4  | 0s2ms     | 0s3ms       | 0s0ms  |
    | Test #5  | 0s2ms     | 0s16ms      | 0s0ms  |
    | Test #6  | 0s26ms    | 0s24ms      | 0s0ms  |
    | Test #7  | 0s108ms   | 0s200ms     | 0s0ms  |
    | Test #8  | 1s148ms   | 2s20ms      | 0s0ms  |
    | Test #9  | undefined | 4s345ms     | 0s0ms  |

    * */

}
