package com.averyanova.algorithms;

import com.maveryanova.algorithms.tasks.Task;
import com.maveryanova.algorithms.tasks.Tickets;
import com.maveryanova.algorithms.tasks.TicketsDynamic;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TicketsTest {
    private static Tester tester;

    @BeforeAll
    static void setUp() {
        tester = new Tester();
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
