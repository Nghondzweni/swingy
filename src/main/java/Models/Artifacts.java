package Models;

public class Artifacts {
    private int weapon;
    private int armor;
    private int helm;

    public Artifacts(int weapon, int  armor, int helm){
        setArmor(armor);
        setHelm(helm);
        setWeapon(weapon);

    }

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getHelm() {
        return helm;
    }

    public void setHelm(int helm) {
        this.helm = helm;
    }
}
