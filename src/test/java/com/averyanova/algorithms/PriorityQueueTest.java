package com.averyanova.algorithms;

import com.maveryanova.algorithms.datastructure.PriorityQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PriorityQueueTest {

    @Test
    public void priorityQueueTest() throws Exception {
        PriorityQueue<String> queue = new PriorityQueue<>();
        boolean isEmpty = queue.isEmpty();
        assertTrue(isEmpty);

        queue.enqueue("Battle", 3);
        queue.enqueue("York", 2);
        queue.enqueue("Richard", 1);
        queue.enqueue("Vain", 50);
        queue.enqueue("Gave", 2);
        queue.enqueue("Of", 1);
        queue.enqueue("In", 40);


        StringBuilder rainbow = new StringBuilder();

        while (!queue.isEmpty()) {
            String out = queue.dequeue();
            rainbow.append(out);
            rainbow.append(queue.isEmpty() ? "" : " ");
        }

        assertEquals("Richard Of York Gave Battle In Vain", rainbow.toString());
    }
}
