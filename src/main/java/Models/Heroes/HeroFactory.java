package Models.Heroes;

import Models.Artifacts;
import Models.Hero;
import Models.Map.Coordinates;
import Models.Stats;

public class HeroFactory {
    public static Hero newHero(String heroType, String heroName, int level, int xp, int x, int y, int attack, int defence, int hitPoints, int weapon, int armor, int helm){

        Artifacts artifacts = new Artifacts(weapon,armor, helm);
        Stats stats = new Stats(attack, defence, hitPoints);
        Coordinates coordinates = new Coordinates(x, y);

        if(heroType.compareToIgnoreCase("Warrior") == 0 ){
            return new Warrior(heroType, heroName,level,xp,coordinates, stats,artifacts);

        } else if(heroType.compareToIgnoreCase("Knight") == 0 ){
            return new Knight(heroType, heroName,level,xp, coordinates ,stats,artifacts);

        } else if(heroType.compareToIgnoreCase("barbarian") == 0 ){
            return new Barbarian(heroType, heroName,level,xp, coordinates ,stats,artifacts);

        } else if(heroType.compareToIgnoreCase("wizard") == 0 ){
            return new Wizard(heroType, heroName,level,xp, coordinates,stats,artifacts);
        } else if(heroType.compareToIgnoreCase("assassin") == 0 ){
            return new Assassin(heroType, heroName,level,xp, coordinates, stats,artifacts);
        } else
            return null;
    }


}
