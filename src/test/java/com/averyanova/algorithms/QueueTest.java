package com.averyanova.algorithms;

import com.maveryanova.algorithms.datastructure.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueTest {

    @Test
    public void queueTest() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("Richard");
        queue.enqueue("Of");
        queue.enqueue("York");
        queue.enqueue("Gave");
        queue.enqueue("Battle");
        queue.enqueue("In");
        queue.enqueue("Vain");

        StringBuilder rainbow = new StringBuilder();

        while (!queue.isEmpty()) {
            String out = queue.dequeue();
            rainbow.append(out);
            rainbow.append(queue.isEmpty() ? "" : " ");
        }

        assertEquals("Richard Of York Gave Battle In Vain", rainbow.toString());
    }
}
