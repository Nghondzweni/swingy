package Models;

import ExtraClasses.Logger;
import Models.Heroes.Character;
import Models.Map.Villain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Arena {
    public List<Hero> heroes;
    public Map<String, Villain> villains = new HashMap<String, Villain>();



    public void loadHeroes(Hero hero) {
        if (heroes != null) {
            if (heroes.contains(hero)) {
                return;
            }
            heroes.add(hero);
        }
    }


    public void loadVillains(Villain villain) {
        String key = "" + villain.coordinates.getX() + " " + villain.coordinates.getY();
        if (villains.containsKey(key)) {
            return;
        }
        villains.put(key, villain);
    }




    public void unregister(Character character) {
        heroes.remove(character);
    }

    public void showHeroes(){
        Hero hero;
        for(int i = 0; i < heroes.size(); i++){
            hero = heroes.get(i);
            System.out.println("| Name : " + hero.heroName + " | Class : " + hero.heroClass + " | Level : " + hero.level + " | Attack : " + hero.stats.getAttack() + " | Defence : " + hero.stats.getDefence() + " | Hit Points : " + hero.stats.getHitPoints()  + "\n");
        }
    }

    public void saveHeroesToDB() {
        Hero hero;
        for(int i = 0; i < heroes.size(); i++){
            hero = heroes.get(i);
            Logger.log(hero.heroClass + " "+ hero.heroName + " " + hero.level + " " + hero.xp + " " + hero.stats.getAttack() + " " + hero.stats.getDefence() + " " + hero.stats.getHitPoints() + " " + hero.artifacts.getWeapon() + " " + hero.artifacts.getArmor() + " " + hero.artifacts.getHelm());
        }
    }
}
