package Controllers;

import Menu.Console;
import Models.Hero;
import Models.Map.Villain;

import java.util.Map;

@SuppressWarnings("Duplicates")
public class PlayerNavigation {

    public static int moveNorth(char[][] map, Hero hero, Map<String, Villain> villains){

        map[hero.coordinates.getY()][hero.coordinates.getX()] = '.';
        hero.coordinates.setY(hero.coordinates.getY() - 1);
        int battleResult;
        if(map[hero.coordinates.getY()][hero.coordinates.getX()] == 'X'){
            Console.displayVillainInfo(Battle.getVillain(villains,hero.coordinates.getX(), hero.coordinates.getY()),hero);
            battleResult = Console.fightOrFlight(Battle.getVillain(villains,hero.coordinates.getX(), hero.coordinates.getY()), hero, map);
            if (battleResult == 0){
                hero.coordinates.setY(hero.coordinates.getY() + 1);
                map[hero.coordinates.getY()][hero.coordinates.getX()] = '#';
                return (1);
            } else if (battleResult == -1){
                return (0);
            }
        }
        map[hero.coordinates.getY()][hero.coordinates.getX()] = '#';
        return (1);
    }

    public static int moveSouth(char[][] map, Hero hero, Map<String, Villain> villains){
        map[hero.coordinates.getY()][hero.coordinates.getX()] = '.';
        hero.coordinates.setY(hero.coordinates.getY() + 1);
        int battleResult;
        if(map[hero.coordinates.getY()][hero.coordinates.getX()] == 'X'){
            Console.displayVillainInfo(Battle.getVillain(villains,hero.coordinates.getX(), hero.coordinates.getY()), hero);
            battleResult = Console.fightOrFlight(Battle.getVillain(villains,hero.coordinates.getX(), hero.coordinates.getY()), hero, map);
            if (battleResult == 0){
                hero.coordinates.setY(hero.coordinates.getY() - 1);
                map[hero.coordinates.getY()][hero.coordinates.getX()] = '#';
                return(1);
            } else if (battleResult == -1){
                return(0);
            }
        }
        map[hero.coordinates.getY()][hero.coordinates.getX()] = '#';
        return (1);
    }

    public static int moveEast(char[][] map, Hero hero, Map<String, Villain> villains){
        map[hero.coordinates.getY()][hero.coordinates.getX()] = '.';
        hero.coordinates.setX(hero.coordinates.getX() + 1);
        int battleResult;

        if(map[hero.coordinates.getY()][hero.coordinates.getX()] == 'X'){
            Console.displayVillainInfo(Battle.getVillain(villains,hero.coordinates.getX(), hero.coordinates.getY()), hero);
            battleResult = Console.fightOrFlight(Battle.getVillain(villains,hero.coordinates.getX(), hero.coordinates.getY()), hero, map);
            if (battleResult == 0){
                hero.coordinates.setX(hero.coordinates.getX() - 1);
                map[hero.coordinates.getY()][hero.coordinates.getX()] = '#';
                return (1);
            } else if(battleResult == -1){
                return (0);
            }
        }
        map[hero.coordinates.getY()][hero.coordinates.getX()] = '#';
        return (1);
    }

    public static int moveWest(char[][] map, Hero hero, Map<String, Villain> villains){
        map[hero.coordinates.getY()][hero.coordinates.getX()] = '.';
        hero.coordinates.setX(hero.coordinates.getX() - 1);
        int battleResult;
        if(map[hero.coordinates.getY()][hero.coordinates.getX()] == 'X'){
            Console.displayVillainInfo(Battle.getVillain(villains,hero.coordinates.getX(), hero.coordinates.getY()), hero);
            battleResult = Console.fightOrFlight(Battle.getVillain(villains,hero.coordinates.getX(), hero.coordinates.getY()), hero, map);
            if (battleResult == 0){
                hero.coordinates.setX(hero.coordinates.getX() + 1);
                map[hero.coordinates.getY()][hero.coordinates.getX()] = '#';
                return(1);
            } else if (battleResult == -1){
                return (0);
            }
        }
        map[hero.coordinates.getY()][hero.coordinates.getX()] = '#';
        return(1);
    }
}
