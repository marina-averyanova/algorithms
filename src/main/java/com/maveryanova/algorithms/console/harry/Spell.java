package com.maveryanova.algorithms.console.harry;

public interface Spell {
    boolean doMagic(int x, int y);
}

class Alohomora implements Spell {

    @Override
    public boolean doMagic(int x, int y) {
        return x <= y;
    }
}

class Imperio implements Spell {

    @Override
    public boolean doMagic(int x, int y) {
        return x == y;
    }
}

class Reducto implements Spell {

    @Override
    public boolean doMagic(int x, int y) {
        return x + y == 24;
    }
}

class Confundo implements Spell {

    @Override
    public boolean doMagic(int x, int y) {
        return x <= 5 || y <= 5 || x + y < 30;
    }
}

class Expelliarmus implements Spell {
    @Override
    public boolean doMagic(int x, int y) {
        return 2 * x == y || 2 * x + 1 == y;
    }
}

class Levicorpus implements Spell {
    @Override
    public boolean doMagic(int x, int y) {
        return x <= 10 || y <= 10;
    }
}

class Morsmordre implements Spell {
    @Override
    public boolean doMagic(int x, int y) {
        return x > 15 && y > 15;
    }
}

class Sonorus implements Spell {
    @Override
    public boolean doMagic(int x, int y) {
        return x == 0 || y == 0;

    }
}

class AvadaKedavra implements Spell {
    @Override
    public boolean doMagic(int x, int y) {
        return x > y + 10 || x < y - 10;
    }
}

class ExpectoPatronum implements Spell {
    @Override
    public boolean doMagic(int x, int y) {
        return x + 1 <= y && 2 * x + 1 >= y;
    }
}

class Legilimens implements Spell {
    @Override
    public boolean doMagic(int x, int y) {
        return (isEven(x) && isEven(y)) || (!isEven(x) && !isEven(y));
    }

    private boolean isEven(int value) { return value % 2 == 0; }
}

class Obliviate implements Spell {
    @Override
    public boolean doMagic(int x, int y) {
        return x == y || x + y == 24;
    }
}
