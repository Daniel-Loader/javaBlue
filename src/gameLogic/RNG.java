package gameLogic;

import java.util.Random;

public class RNG {
    private final Random random;

    public RNG(long seed){
        this.random = new Random(seed);
    }
    public Double GenerateNumber() {
        return random.nextDouble();
    }
}