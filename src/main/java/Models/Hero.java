package Models;

import Models.Map.Coordinates;

public abstract class Hero {

    public int id;
    public static int idCounter;
    public String heroClass;
    public String heroName;
    public int level;
    public int xp;
    public Coordinates coordinates;
    public Artifacts artifacts;
    public Stats stats;


    public Hero(String heroClass, String heroName, int level, int xp, Coordinates coordinates, Stats stats, Artifacts artifacts) {
        this.id = idCounter;
        this.heroClass = heroClass;
        this.heroName = heroName;
        this.level = level;
        this.xp = xp;
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

    public abstract void updateStats();
    public abstract void updateArtifacts();
}
