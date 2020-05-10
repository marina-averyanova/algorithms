/* *
 * Watch the "Harry Potter Square" video tutorial and unravel a dozen spells
 * https://www.youtube.com/watch?v=KmV3aBHfo5w
 */
package com.maveryanova.algoritmms.console.harry;

import java.io.Console;
import java.io.PrintWriter;

public class HarryPotter {
    private static PrintWriter writer;

    public static void main(String[] args) {
        try {
            Console console = System.console();

            if (console != null) {

                writer = console.writer();

                for (int x = 0; x < 25; x++) {
                    for (int y = 0; y < 25; y++) {
                        if (args.length > 0) {
                            callSpell(args[0], x, y);
                        } else {
                            throw new Exception("Number of spell required");
                        }
                    }
                    writer.println("");
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void callSpell(String spellNumber, int x, int y) throws Exception {
        Spell spell;
        switch (Integer.parseInt(spellNumber)) {
            case 1:
                spell = new Alohomora();
                break;
            case 2:
                spell = new Imperio();
                break;
            case 3:
                spell = new Reducto();
                break;
            case 4:
                spell = new Confundo();
                break;
            case 5:
                spell = new Expelliarmus();
                break;
            case 6:
                spell = new Levicorpus();
                break;
            case 7:
                spell = new Morsmordre();
                break;
            case 8:
                spell = new Sonorus();
                break;
            case 9:
                spell = new AvadaKedavra();
                break;
            case 10:
                spell = new ExpectoPatronum();
                break;
            case 20:
                spell = new Legilimens();
                break;
            case 24:
                spell = new Obliviate();
                break;
            default: throw new Exception("I'm just learning, I don't know all the spells");
        }

        writer.print(spell.doMagic(x, y) ? "# " : ". ");
    }
}
