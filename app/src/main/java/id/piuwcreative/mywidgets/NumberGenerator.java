package id.piuwcreative.mywidgets;

import java.util.Random;

public class NumberGenerator {
    public static int generate(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }
}
