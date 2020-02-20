package Models.Map;

import Models.Artifacts;
import Models.Stats;

public class Villain {
    public int id;
    public static int idCounter;
    public String villainClass;
    public int level;
    public Coordinates coordinates;
    public Stats stats;
    public   Artifacts artifacts;



    public Villain(String villainClass, int level, Coordinates coordinates, Stats stats, Artifacts artifacts) {
        this.id = idCounter;
        this.villainClass = villainClass;
        this.level = level;
        this.coordinates = coordinates;
        this.artifacts = artifacts;
        this.stats = stats;

        nextId();
    }

    private int nextId(){
        if(idCounter == 0) {
            return (idCounter++);
        }
        idCounter += 1;
        return idCounter;
    }
}
