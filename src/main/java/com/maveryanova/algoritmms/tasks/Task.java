package com.maveryanova.algoritmms.tasks;

import java.util.List;

public interface Task {
    String getPath();

    String run(List<String> data);
}
