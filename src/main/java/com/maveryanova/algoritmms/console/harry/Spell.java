package com.maveryanova.algoritmms.console.harry;

import java.io.PrintWriter;

public interface Spell {
    void call(PrintWriter PrintWriter, int x, int y);
}

class Alohomora implements Spell {

    @Override
    public void call(PrintWriter writer, int x, int y) {
        writer.print(x <= y ? "# " : ". ");
    }
}

class Imperio implements Spell {

    @Override
    public void call(PrintWriter writer, int x, int y) {
        writer.print(x == y ? "# " : ". ");
    }
}

class Reducto implements Spell {

    @Override
    public void call(PrintWriter writer, int x, int y) {
        writer.print(x + y == 24 ? "# " : ". ");
    }
}

class Confundo implements Spell {

    @Override
    public void call(PrintWriter writer, int x, int y) {
        writer.print((x <= 5 || y <= 5 || x + y < 30) ? "# " : ". ");
    }
}

class Expelliarmus implements Spell {
    @Override
    public void call(PrintWriter writer, int x, int y) {
        writer.print(
            2 * x == y || 2 * x + 1 == y
                ? "# " : ". ");
    }
}

class Levicorpus implements Spell {
    @Override
    public void call(PrintWriter writer, int x, int y) {
        writer.print((x <= 10 || y <= 10) ? "# " : ". ");
    }
}


class Morsmordre implements Spell {
    @Override
    public void call(PrintWriter writer, int x, int y) {
        writer.print((x > 15 && y > 15) ? "# " : ". ");
    }
}


class Sonorus implements Spell {
    @Override
    public void call(PrintWriter writer, int x, int y) {
        writer.print((x == 0 || y == 0) ? "# " : ". ");

    }
}


class ExpectoPatronum implements Spell {
    @Override
    public void call(PrintWriter writer, int x, int y) {
        writer.print((x + 1 <= y && 2 * x + 1 >= y) ? "# " : ". ");
    }
}


class Legilimens implements Spell {
    @Override
    public void call(PrintWriter writer, int x, int y) {
        writer.print(
            (isEven(x) && isEven(y)) || (!isEven(x) && !isEven(y))
                ? "# " : ". "
        );
    }

    private boolean isEven(int value) { return value % 2 == 0; }
}


class Obliviate implements Spell {
    @Override
    public void call(PrintWriter writer, int x, int y) {
        writer.print(x == y || x + y == 24 ? "# " : ". ");
    }
}

