import ExtraClasses.Logger;
import Menu.Console;
import Models.Arena;
import Models.Hero;
import Models.Heroes.*;
import Models.Map.Map;
import Models.Map.VillainFactory;
import Views.MainFrame;


import javax.swing.*;
import java.io.*;
import java.util.ArrayList;


public class Main extends JFrame {
    public static void main(String[] args){
            try{
                BufferedReader reader;
                Hero currentHero;
//                Villain villain;
                String line;
                int playAgain = 1;
                int battleResults;

                File file = new File("Heroes.txt");
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();



                Arena arena = new Arena();
                if(args.length == 1 && ((args[0].compareToIgnoreCase("gui") == 0) || (args[0].compareToIgnoreCase("console") == 0))){


                if(args[0].compareToIgnoreCase("gui") == 0) {
                        new MainFrame();
                    return;
                }

                while(true) {
                    Logger.appendHeroesFile(file.getName());
                    reader  = new BufferedReader(new FileReader(file));
                    arena.heroes = new ArrayList<Hero>();
                    while ((line = reader.readLine()) != null) {
                        String[] heroValues = line.split(" ");
                        Hero hero = HeroFactory.newHero(heroValues[0], heroValues[1], Integer.parseInt(heroValues[2]), Integer.parseInt(heroValues[3]), 0, 0, Integer.parseInt(heroValues[4]), Integer.parseInt(heroValues[5]), Integer.parseInt(heroValues[6]), Integer.parseInt(heroValues[7]), Integer.parseInt(heroValues[8]), Integer.parseInt(heroValues[9]));
                        arena.loadHeroes(hero);
                    }
                    if(Console.characterSelect() == 0){
                        if(arena.heroes.size() != 0){
                            arena.showHeroes();
                            currentHero = Console.heroSelect(arena, null);
                            arena.heroes.remove(currentHero);
                        }  else {
                            System.out.println("No players found in database. Please create one.");
                            currentHero = Console.createHero(arena, null, null);
                        }
                    } else {
                        currentHero = Console.createHero(arena, null, null);
                    }
                    Map map = new Map(currentHero.level);
                    map.generateMap(map.x, map.y, map.map);
                    currentHero.coordinates.setY(map.x / 2);
                    currentHero.coordinates.setX(map.y / 2);
                    map.map[currentHero.coordinates.getX()][currentHero.coordinates.getY()] = '#';
                    int i = 0;
                    while (i < (map.x * map.y) / 2) {
                        arena.loadVillains(VillainFactory.newVillain(map, currentHero.level));
                        i++;
                    }
                    int k = 0;
                    while (k < map.y) {
                        System.out.println(map.map[k]);
                        k++;
                    }
                    System.out.println('\n');
                    while (true) {
                        battleResults = Console.navDirectionCheck(map, currentHero, arena.villains);
                        if(battleResults == 1){
                            k = 0;
                            while (k < map.y) {
                                System.out.println(map.map[k]);
                                k++;
                            }
                            System.out.println('\n');
                        } else if (battleResults == 2)
                        {
                            currentHero.xp += 2 * (50 * currentHero.level);
                            currentHero.level = Console.updateLevel(currentHero.xp, currentHero.level);
                            arena.loadHeroes(currentHero);
                            Logger.createHeroesFile(file.getName());
                            arena.saveHeroesToDB();
                            if(Console.again(playAgain) == 0)
                                return;
                            else
                                break ;
                        } else if (battleResults == 0) {
                            arena.loadHeroes(currentHero);
                            Logger.createHeroesFile(file.getName());
                            arena.saveHeroesToDB();
                            if (Console.again(playAgain) == 0)
                                return;
                            else
                                break;
                        }
                    }
                }
                } else
                    System.out.println("Usage:  java -jar swingy.jar console for Console version or java -jar swingy.jar gui for Gui verion");
            }
            catch (FileNotFoundException e){
                System.out.println("Error could not find file : " + args[0]);
            } catch (IOException e) {
                System.out.println("There was an error reading file : " + args[0]);
            }
            catch (NumberFormatException e){
                System.out.println("Error reading file");
            }
    }
}
