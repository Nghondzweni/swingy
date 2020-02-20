package Menu;

import Controllers.PlayerNavigation;
import ExtraClasses.Logger;
import ExtraClasses.Scanner;
import Models.Arena;
import Models.Hero;
import Models.Heroes.*;
import Models.Map.Map;
import Models.Map.Villain;

import java.util.Random;

@SuppressWarnings("ALL")
public class Console {

    public static Hero heroSelect(Arena arena, String HeroName) {
        String name = "";

        while (name.compareToIgnoreCase("") == 0) {

            if(HeroName != null)
                name = HeroName;
            if(name.compareToIgnoreCase("") == 0){
                System.out.println("ENTER HERO NAME TO SELECT A CHARACTER ");
                name = Scanner.readLine();
            }
            for (int i = 0; i < arena.heroes.size(); i++) {
                if (arena.heroes.get(i).heroName.compareToIgnoreCase(name) == 0) {
                    return arena.heroes.get(i);
                }
            }
            System.out.println("Hero not found. Please try again.");
        }
        return null;
    }


    public static Hero createHero(Arena arena, String HeroType, String HeroName) {

        String heroClass = "";;
        String name = "";

        while (heroClass.compareToIgnoreCase("") == 0) {
            if(HeroType != null && HeroName != null){
                heroClass = HeroType;
                name = HeroName;
            }
            if(heroClass.compareToIgnoreCase("") == 0) {
                System.out.println("SELECT HERO CLASS: | ASSASSIN | BARBARIAN | KNIGHT | WARRIOR | WIZARD |");
                heroClass = Scanner.readLine();
            }

            if (heroClass.compareToIgnoreCase("Warrior") == 0) {
                return saveHero(createWarrior(name, arena));
            } else if (heroClass.compareToIgnoreCase("Knight") == 0) {
                return saveHero(createKnight(name, arena));
            } else if (heroClass.compareToIgnoreCase("barbarian") == 0) {
                return saveHero(createBarbarian(name, arena));
            } else if (heroClass.compareToIgnoreCase("wizard") == 0) {
                return saveHero(createWizard(name, arena));
            } else if (heroClass.compareToIgnoreCase("assassin") == 0) {
                return saveHero(createAssassin(name, arena));
            } else {
                heroClass = "";
                System.out.println("Error, Hero class not found. Please try again : ");
            }

        }
        return null;
    }

    private static Hero createAssassin(String heroName, Arena arena) {
        String tmp[];
        int weapon = 37;
        int armor = 28;
        int helm = 35;

        while (heroName.compareToIgnoreCase("") == 0) {
            System.out.println("ENTER HERO NAME: ");
            heroName = Scanner.readLine();
            tmp = heroName.split(" ");
            if (tmp.length > 1){
                System.out.println("Error, Hero name cannot contain spaces. Use '_' for  separation. Please try again");
                heroName = "";
            }
            if (heroName.compareToIgnoreCase("") != 0) {
                for (int i = 0; i < arena.heroes.size(); i++) {
                    if (arena.heroes.get(i).heroName.compareToIgnoreCase(heroName) == 0) {
                        System.out.println("A hero with that name already exists. Please choose another name.");
                        heroName = "";
                    }
                }
            }
        }
        return HeroFactory.newHero("Assassin", heroName, 0, 0, 0, 0, (weapon * 100)/2, (armor * 100)/2, (helm * 100)/2, weapon, armor, helm);
    }

    private static Hero createBarbarian(String heroName, Arena arena) {
        String tmp[];
        String name = "";
        int weapon = 29;
        int armor = 39;
        int helm = 32;

        while (name.compareToIgnoreCase("") == 0) {
            if(heroName != null){
                name = heroName;
            }
            if(name.compareToIgnoreCase("") == 0){
                System.out.println("ENTER HERO NAME: ");
                heroName = Scanner.readLine();
            }

            tmp = heroName.split(" ");
            if (tmp.length > 1){
                System.out.println("Error, Hero name cannot contain spaces. Use '_' for  separation. Please try again");
                heroName = "";
            }
            if (heroName.compareToIgnoreCase("") != 0) {
                for (int i = 0; i < arena.heroes.size(); i++) {
                    if (arena.heroes.get(i).heroName.compareToIgnoreCase(heroName) == 0) {
                        System.out.println("A hero with that name already exists. Please choose another name.");
                        heroName = "";
                    }
                }
            }
        }
        return HeroFactory.newHero("Barbarian", heroName, 0, 0, 0, 0, (weapon * 100)/2, (armor * 100)/2, (helm * 100)/2, weapon, armor, helm);
    }

    private static Hero createKnight(String heroName, Arena arena) {
        String tmp[];
        int weapon = 41;
        int armor = 24;
        int helm = 35;
        while (heroName.compareToIgnoreCase("") == 0) {
            System.out.println("ENTER HERO NAME: ");
            heroName = Scanner.readLine();
            tmp = heroName.split(" ");
            if (tmp.length > 1){
                System.out.println("Error, Hero name cannot contain spaces. Use '_' for  separation. Please try again");
                heroName = "";
            }
            if (heroName.compareToIgnoreCase("") != 0) {
                for (int i = 0; i < arena.heroes.size(); i++) {
                    if (arena.heroes.get(i).heroName.compareToIgnoreCase(heroName) == 0) {
                        System.out.println("A hero with that name already exists. Please choose another name.");
                        heroName = "";
                    }
                }
            }
        }
        return HeroFactory.newHero("Knight", heroName, 0, 0, 0, 0, (weapon * 100)/2, (armor * 100)/2, (helm * 100)/2, weapon, armor, helm);
    }

    private static Hero createWarrior(String heroName, Arena arena) {
        String tmp[];
        int weapon = 36;
        int armor = 42;
        int helm = 22;
        while (heroName.compareToIgnoreCase("") == 0) {
            System.out.println("ENTER HERO NAME: ");
            heroName = Scanner.readLine();
            tmp = heroName.split(" ");
            if (tmp.length > 1){
                System.out.println("Error, Hero name cannot contain spaces. Use '_' for  separation. Please try again");
                heroName = "";
            }
            if (heroName.compareToIgnoreCase("") != 0) {
                for (int i = 0; i < arena.heroes.size(); i++) {
                    if (arena.heroes.get(i).heroName.compareToIgnoreCase(heroName) == 0) {
                        System.out.println("A hero with that name already exists. Please choose another name.");
                        heroName = "";
                    }
                }
            }
        }
        return HeroFactory.newHero("Warrior", heroName, 0, 0, 0, 0, (weapon * 100)/2, (armor * 100)/2, (helm * 100)/2, weapon, armor, helm);
    }

    private static Hero createWizard(String heroName, Arena arena) {
        String tmp[];
        int weapon = 45;
        int armor = 29;
        int helm = 26;
        while (heroName.compareToIgnoreCase("") == 0) {
            System.out.println("ENTER HERO NAME: ");
            heroName = Scanner.readLine();
            tmp = heroName.split(" ");
            if (tmp.length > 1){
                System.out.println("Error, Hero name cannot contain spaces. Use '_' for  separation. Please try again");
                heroName = "";
            }
            if (heroName.compareToIgnoreCase("") != 0) {
                for (int i = 0; i < arena.heroes.size(); i++) {
                    if (arena.heroes.get(i).heroName.compareToIgnoreCase(heroName) == 0) {
                        System.out.println("A hero with that name already exists. Please choose another name.");
                        heroName = "";
                    }
                }
            }
        }
        return HeroFactory.newHero("Wizard", heroName, 0, 0, 0, 0, (weapon * 100)/2, (armor * 100)/2, (helm * 100)/2, weapon, armor, helm);
    }

    public static Hero saveHero(Hero hero) {
        Logger.log(hero.heroClass + " " + hero.heroName + " " + hero.level + " " + hero.xp + " " + hero.stats.getAttack() + " " + hero.stats.getDefence() + " " + hero.stats.getHitPoints() + " " + hero.artifacts.getWeapon() + " " + hero.artifacts.getArmor() + " " + hero.artifacts.getHelm());
        return hero;
    }

    public static int navDirectionCheck(Map map, Hero hero, java.util.Map<String, Villain> villains) {
        int x;
        int y;
        while (true) {
            x = hero.coordinates.getX();
            y = hero.coordinates.getY();

            if (x == 0 || y == 0 || y == (map.y - 1) || x == (map.x - 1)) {
                System.out.println("Well Done. You have reached the edge of the board. Mission Complete!!");
                return 2;
            }

            System.out.println("ENTER A DIRECTION TO MOVE: | NORTH (N) | SOUTH (S) | WEST (W) | EAST (E) |");
            String direction = Scanner.readLine();
            if (direction.compareToIgnoreCase("North") == 0 || direction.compareToIgnoreCase("N") == 0) {
               if(PlayerNavigation.moveNorth(map.map, hero, villains) == 0)
                   return 0;
            } else if (direction.compareToIgnoreCase("South") == 0 || direction.compareToIgnoreCase("S") == 0) {
                if(PlayerNavigation.moveSouth(map.map, hero, villains) == 0)
                    return 0;
            } else if (direction.compareToIgnoreCase("West") == 0 || direction.compareToIgnoreCase("W") == 0) {
               if(PlayerNavigation.moveWest(map.map, hero, villains) == 0)
                   return 0;
            } else if (direction.compareToIgnoreCase("East") == 0 || direction.compareToIgnoreCase("E") == 0) {
                if (PlayerNavigation.moveEast(map.map, hero, villains) == 0)
                    return 0;
            } else
                System.out.println("Error, direction not found");
            return 1;
        }
    }

    public static void displayVillainInfo(Villain villain, Hero hero) {
        System.out.println("YOU HAVE ENCOUNTERED AN ENEMEY!!!");
        System.out.println("VILLAIN TYPE: " + villain.villainClass);
        System.out.println("VILLAIN LEVEL: " + villain.level);
        System.out.println("VILLAIN ATTACK: " + villain.stats.getAttack());
        System.out.println("VILLAIN DEFENCE: " + villain.stats.getDefence());
        System.out.println("VILLAIN HIT POINTS: " + villain.stats.getHitPoints());
        System.out.println("\n");
        System.out.println("YOUR STATS : " + hero.heroName);
        System.out.println("HERO TYPE: " + hero.heroClass);
        System.out.println("HERO LEVEL: " + hero.level);
        System.out.println("HERO XP: " + hero.xp);
        System.out.println("HERO ATTACK: " + hero.stats.getAttack());
        System.out.println("HERO DEFENCE: " + hero.stats.getDefence());
        System.out.println("HERO HIT POINTS: " + hero.stats.getHitPoints());
        System.out.println("\n");
    }

    public static int fightOrFlight(Villain villain, Hero hero, char[][] map) {
        String action;
        Random random = new Random();
        int rand = random.nextInt(42);
        while (true) {
            System.out.println("WOULD YOU LIKE TO FIGHT OR RUN LIKE A LIL' BITCH?  : | RUN (R) | FIGHT (F)");
            System.out.println("If you choose to run, You have a 50% chance of returning to your previous position.");
            System.out.println("Warning!!! If the odds are against you, you will have to fight your enemy regardless of your power");
            action = Scanner.readLine();
            if(action.compareToIgnoreCase("run") == 0 || action.compareToIgnoreCase("r") == 0){
                if (rand%2 == 0){
                    System.out.println("You ran like a lil bitch");
                    return (0);
                }
                else {
                    System.out.println("You chose to run like a lil' bitch but the odds were against you. Now fight your enemy!!");
                    return(fight(villain, hero));
                }
            }
            if(action.compareToIgnoreCase("fight") == 0 || action.compareToIgnoreCase("f") == 0)
            {
                System.out.println("You chose to fight like a real nigga!!");
                return(fight(villain, hero));
            }
        }
    }

    public static int fight(Villain villain, Hero hero){
        int heroPoints = 0;
        int villainPoints = 0;

        System.out.println("Fight simulation taking place...");

        Random random = new Random();
        int luck = random.nextInt(10);

        if(hero.level > villain.level)
            heroPoints += 5;
        else if(hero.level < villain.level)
            villainPoints += 5;
        if(hero.stats.getAttack() > villain.stats.getAttack())
            heroPoints += 4;
        else if(hero.stats.getAttack() < villain.stats.getAttack())
            villainPoints += 4;
        if(hero.stats.getDefence() > villain.stats.getDefence())
            heroPoints += 3;
        else if (hero.stats.getDefence() < villain.stats.getDefence())
            villainPoints += 3;
        if(hero.stats.getHitPoints() > villain.stats.getHitPoints())
            heroPoints += 2;
        else if (hero.stats.getHitPoints() < villain.stats.getHitPoints())
            villainPoints += 2;

        if(heroPoints >= villainPoints){
            System.out.println("You kicked your enemy's ass!!!");
            win(villain.level, hero);
            return (1);
        }
        else if (villainPoints > heroPoints && luck == 5){
            System.out.println("Your enemy was way stronger than you. But you got lucky");
            win(villain.level, hero);
            return (1);
        }
        else{
            System.out.println("Your enemy was way stronger than you. He kicked your ass!!!");
            return (-1);
        }

    }

    public static void win(int villainLevel, Hero hero) {
        Random random = new Random();
        int artifact = random.nextInt(5);
        int artifactPoints;
        String line = "";

        if(villainLevel < 4)
            artifactPoints = random.nextInt(3);
        else if (villainLevel > 3 && villainLevel < 8)
            artifactPoints = (int) (Math.random() * (4 - 3) + 3);
        else
            artifactPoints = 5;

        if (artifactPoints == 0)
            artifactPoints++;

        while (line.compareToIgnoreCase("") == 0) {
            if(artifact == 0)
                System.out.println("Your enemy has dropped a Weapon with ("+ artifactPoints + ") points. Would you like to take or leave it? | TAKE (T) | LEAVE (L) |");
            else if(artifact == 1)
                System.out.println("Your enemy has dropped a Armor with ("+ artifactPoints + ") points. Would you like to take or leave it? | TAKE (T) | LEAVE (L) |");
            else if(artifact == 2)
                System.out.println("Your enemy has dropped Helm with ("+ artifactPoints + ") points. Would you like to take or leave it? | TAKE (T) | LEAVE (L) |");
            if(artifact != 3 && artifact != 4) {
                line = Scanner.readLine();
                if (line.compareToIgnoreCase("take") == 0 || line.compareToIgnoreCase("t") == 0) {
                    if (artifact == 0) {
                        hero.artifacts.setWeapon(hero.artifacts.getWeapon() + artifactPoints);
                        hero.stats.setAttack(hero.artifacts.getWeapon() * 100 / 2);
                    } else if (artifact == 1) {
                        hero.artifacts.setArmor(hero.artifacts.getArmor() + artifactPoints);
                        hero.stats.setDefence(hero.artifacts.getArmor() * 100 / 2);
                    } else if (artifact == 2) {
                        hero.artifacts.setHelm(hero.artifacts.getHelm() + artifactPoints);
                        hero.stats.setHitPoints(hero.artifacts.getHelm() * 100 / 2);
                    }
                    if (villainLevel == 0)
                        hero.xp += 2 * (1 * 25);
                    else
                        hero.xp += 2 * (villainLevel * 25);
                    hero.level = updateLevel(hero.xp, hero.level);
                    return;
                } else if (line.compareToIgnoreCase("leave") == 0 || line.compareToIgnoreCase("l") == 0) {
                    System.out.println("You chose to leave artifact");
                    if (villainLevel == 0)
                        hero.xp += 2 * (1 * 25);
                    else
                        hero.xp += 2 * (villainLevel * 25);
                    hero.level = updateLevel(hero.xp, hero.level);
                    return;
                } else
                    System.out.println("Error, Command not found");
                line = "";
            } else{
                if (villainLevel == 0)
                    hero.xp += 2 * (1 * 25);
                else
                    hero.xp += 2 * (villainLevel * 25);
                hero.level = updateLevel(hero.xp, hero.level);
                System.out.println("Your enemy did not drop any artifact");
                line = " ";
            }
        }
    }

    public static int updateLevel(int xp, int level){
        if (level == 0) {
            if (xp > 999)
                return ++level;
            else
                return level;
        } else {
            if (xp > ((level + 1) * 1000) + (((level + 1) - 1) * ((level + 1) - 1)) * 450)
                return ++level;
            else
                return level;
        }
    }

    public static int again(int playAgain){
        String result = "";
        while (result.compareToIgnoreCase("") == 0) {
            System.out.println("Would you like to play again? | YES (Y) | NO (N) |");
            result = Scanner.readLine();

            if (result.compareToIgnoreCase("yes") == 0 || result.compareToIgnoreCase("y") == 0)
                return 1;
            else if (result.compareToIgnoreCase("no") == 0 || result.compareToIgnoreCase("n") == 0) {
                System.out.println("GoodBye!!");
                return 0;
            } else
                result = "";
        }
        return (0);
    }

    public static int characterSelect(){
        String result = "";
        while (result.compareToIgnoreCase("") == 0) {
            System.out.println("WOULD YOU LIKE TO SELECT A PREVIOUSLY CREATED HERO OR SELECT A NEW ONE? | CREATE (C) | SELECT (S) |");
            result = Scanner.readLine();

            if (result.compareToIgnoreCase("create") == 0 || result.compareToIgnoreCase("c") == 0)
                return 1;
            else if (result.compareToIgnoreCase("select") == 0 || result.compareToIgnoreCase("s") == 0) {
                return 0;
            }
            else
                System.out.println("Error, command not found!!");
            result = "";
        }
        return (0);
    }
}