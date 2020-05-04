package com.maveryanova.algoritmms.tasks;

import java.util.List;

public class StringsLength implements Task {
    @Override
    public String getPath() {
        return "0.String";
    }

    @Override
    public String run(List<String> data) {
        return String.valueOf(data.get(0).length());
    }
}
