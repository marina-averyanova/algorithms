package com.averyanova.algorithms;

import com.maveryanova.algoritmms.tasks.StringsLength;
import com.maveryanova.algoritmms.tasks.Task;
import com.maveryanova.algoritmms.tasks.Tickets;
import com.maveryanova.algoritmms.tasks.TicketsDynamic;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MainTest {
    private static Tester tester;

    @BeforeAll
    static void setUp() {
        tester = new Tester();
    }


    @Test
    public void stringsLengthTest() {
        Task stringsLengthTask = new StringsLength();
        tester.runTests(stringsLengthTask);
    }

    @Test
    public void ticketsTest() {
        Task ticketsTask = new Tickets();
        tester.runTests(ticketsTask);
    }

    @Test
    public void ticketsTestDynamic() {
        Task ticketsTask = new TicketsDynamic();
        tester.runTests(ticketsTask);
    }
}
