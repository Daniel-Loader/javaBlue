package Enviroment;


public class WorldState {
    /* TODO
    *   random seed
    *   Difficulty (easy, normal, hard)
    *   Money
    *   experience / score
    *   Player name
    *   day initialization / days remaining
    *   maybe day class should go here?
    *   available interaction options / current menu window
    *   win state / fail state
    *   save / load (wish list)
    *
    * */

    private int difficulty; // 0: easy, 1: normal, 2: hard
    private int currentDay;
    private int maxDays;
    private final RNG rand;


    public WorldState(long seed) {
        this.difficulty = 1;
        this.currentDay = 0;
        rand = new RNG(seed);
    }




    // Getters and Setters
    public Double getRandomNumber() {
        return rand.GenerateNumber();
    }

    /* Difficulty control functions */
    public int getDifficulty() {return difficulty;}
    public void setDifficulty(int difficulty) {this.difficulty = difficulty;}
    public String getDiffStr() {
        switch (this.difficulty){
            case 0 -> {return "Easy";}
            case 1 -> {return "Normal";}
            case 2 -> {return "Hard";}
            default -> {return "???";}
        }
    }

    /* Day Control Functions */
    public int getDay() {return currentDay;}
    public void setDay(int day) {this.currentDay = day;} // for testing
    public void incrementDay() {this.currentDay++;}
    public int getMaxDays() {return maxDays;}
    public void setMaxDays(int maxDays) {this.maxDays = maxDays;}


    @Override
    public String toString() {
        return "WorldState{" +
                "difficulty=" + difficulty +
                ", day=" + currentDay +
                '}';
    }
}