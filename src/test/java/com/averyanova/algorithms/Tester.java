package com.averyanova.algorithms;

import com.maveryanova.algorithms.tasks.Task;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tester {
    private static String RESOURCES_PATH = "src/test/resources/";

    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    public void runTests(Task task) {
        logger.info(String.format("Start testing task: %s", task.getClass().getSimpleName()));
        String path = task.getPath();
        Integer i = 0;

        while (true) {
            Path inFile = Paths.get(RESOURCES_PATH + String.format("%s/test.%d.in", path, i));
            Path outFile = Paths.get(RESOURCES_PATH + String.format("%s/test.%d.out", path, i));

            if (!Files.exists(inFile) || !Files.exists(outFile)) {
                logger.info("File doesn't exist or tests completed");
                break;
            }

            Instant startTime = Instant.now();
            boolean testResult = runTest(inFile, outFile, task);
            Instant endTime = Instant.now();

            long durationMillis = endTime.toEpochMilli() - startTime.toEpochMilli();
            long durationSeconds = durationMillis / 1000;
            String duration = durationSeconds + "s" +
                (durationMillis >= 1000 ? durationMillis - 1000 * durationSeconds : durationMillis) + "ms";

            logger.info(String.format("Test #%d result is - %s; duration=%s", i, testResult, duration));
            assertTrue(testResult);

            i++;
        }
    }

    private boolean runTest(Path inFile, Path outFile, Task task) {
        try {
            List<String> data = Files.readAllLines(inFile);
            String expected = Files.readAllLines(outFile).get(0);
            String actual = task.run(data);

            return expected.equals(actual);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warning(String.format("Error: %s", e));
            return false;
        }

    }
}
