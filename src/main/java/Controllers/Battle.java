package Controllers;

import Models.Hero;
import Models.Map.Villain;

import java.util.Map;

public class Battle {
    public  static Villain getVillain(Map<String, Villain> villains, int mapX, int mapY){
        String key = "" + mapY + " " + mapX;
        return villains.get(key);
    }

    public static void simulateBattle(Villain villain, Hero hero){

    }
}
