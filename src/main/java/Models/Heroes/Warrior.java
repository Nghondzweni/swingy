package Models.Heroes;

import Models.Artifacts;
import Models.Hero;
import Models.Map.Coordinates;
import Models.Stats;

public class Warrior extends Hero {
    Warrior(String heroType, String heroName, int level, int xp, Coordinates coordinates, Stats stats, Artifacts artifacts){
        super(heroType, heroName, level, xp, coordinates, stats, artifacts);
    }

    public void updateStats() {
        System.out.println("Update stats for Warrior\n");
    }

    public void updateArtifacts() {

    }

}
