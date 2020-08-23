package com.averyanova.algorithms;

import com.sun.tools.javac.util.Pair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class FileReader {
    private static final String RESOURCES_PATH = "src/test/resources/";

    private final Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    public Map<Integer, Pair<int[], String>> read(String path) {
        Map<Integer, Pair<int[], String>> data = new HashMap<>();
        Integer i = 0;

        try {
            while (true) {
                Path inFile = Paths.get(RESOURCES_PATH + String.format("%s/test.%d.in", path, i));
                Path outFile = Paths.get(RESOURCES_PATH + String.format("%s/test.%d.out", path, i));

                if (!Files.exists(inFile) || !Files.exists(outFile)) {
                    logger.info("File doesn't exist or reading complete");
                    break;
                }
                data.put(i, readFiles(inFile, outFile));
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.warning(String.format("Error: %s", e));
        }
        return data;
    }

    private Pair<int[], String> readFiles(Path inFile, Path outFile) throws IOException {
        int[] inArray = formatDataToIntArray(Files.readAllLines(inFile));
        String outString = Files.readAllLines(outFile).get(0);
        return new Pair<>(inArray, outString);
    }

    private int[] formatDataToIntArray(List<String> inData) {
        int size = Integer.parseInt(inData.get(0));
        String[] digits = inData.get(1).split(" ");
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(digits[i]);
        }
        return array;
    }
}
