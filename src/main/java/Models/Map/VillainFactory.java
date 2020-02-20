package Models.Map;

import Models.Artifacts;
import Models.Stats;

import java.util.Random;

public class VillainFactory {
    public static Villain newVillain(Map map, int heroLevel){
        int x;
        int y;
        int villainLevel;
        Random random = new Random();
        String[] villainClass = {"Assassin", "Barbarian", "Knight", "Warrior", "Wizard"};


        if (heroLevel >= 0 && heroLevel < 4)
            villainLevel = (int )(Math.random() * 5);
        else if (heroLevel > 3 && heroLevel < 7)
            villainLevel = (int )(Math.random() * 8);
        else if (heroLevel > 6 && heroLevel < 11)
            villainLevel = (int )(Math.random() * (12 - 5) + 5);
        else
            villainLevel = (int )(Math.random() * (15 - 12) + 12);

        while(true){
        x = (int )(Math.random() * map.x - 1);
        y = (int )(Math.random() * map.y - 1);
        if(x == 0)
            x++;
        if(y == 0)
            y++;
            if(map.map[x][y] == '0'){
            map.map[x][y] = 'X';
            return  new Villain(villainClass[random.nextInt(5)], villainLevel, new Coordinates(x, y), generateStats(villainLevel), generateArtifacts(villainLevel));
        }
        }
    }

    public static Stats generateStats(int level) {
        if (level >= 0 && level < 4)
            return new Stats((int) (Math.random() * 30)* 100/2, (int) (Math.random() * 30)* 100/2, (int) (Math.random() * 30)* 100/2);
        else if (level > 3 && level < 7)
            return new Stats((int) (Math.random() * (60 - 30) + 30) * 100/2, (int) (Math.random() * (60 - 30) + 30) * 100/2, (int) (Math.random() * (60 - 30) + 30) * 100/2);
        else if (level > 6 && level < 11)
            return new Stats((int) (Math.random() * (100 - 60) + 60)* 100/2, (int) (Math.random() * (100 - 60) + 60)* 100/2, (int) (Math.random() * (100 - 60) + 60)* 100/2);
        else
            return null;
    }

    public static Artifacts generateArtifacts(int level){
        if(level >= 0 && level < 4)
            return new Artifacts((int ) (Math.random() * 30), (int ) (Math.random()* 30), (int ) (Math.random()* 30));
        else if(level > 3 && level < 7)
            return new Artifacts((int ) (Math.random() * (60-30) + 30), (int ) (Math.random()* (60-30) + 30), (int ) (Math.random()* (60-30) + 30));
        else if(level > 6 && level < 11)
            return new Artifacts((int ) (Math.random() * (100-60) + 60), (int ) (Math.random()* (100-60) + 60), (int ) (Math.random()* (100-60) + 60));
        else
            return null;
    }

}
