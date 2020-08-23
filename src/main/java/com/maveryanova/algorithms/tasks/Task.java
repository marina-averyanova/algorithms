package com.maveryanova.algorithms.tasks;

import java.util.List;

public interface Task {
    String getPath();

    String run(List<String> data);
}
