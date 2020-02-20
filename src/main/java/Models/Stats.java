package Models;

public class Stats {

    private int attack;
    private int defence;
    private int hitPoints;

    public Stats(int attack, int defence, int hitPoints){
        setAttack(attack);
        setDefence(defence);
        setHitPoints(hitPoints);
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
}
