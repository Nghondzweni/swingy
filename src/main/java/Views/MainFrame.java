package Views;

import ExtraClasses.Logger;
import Menu.Console;
import Models.Arena;
import Models.Hero;
import Models.Heroes.HeroFactory;
import Models.Map.Map;
import Models.Map.VillainFactory;
import Views.old.RootWindow;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class MainFrame {

    public static Arena arena;
    public static Hero currentHero;
    public static JFrame frame;
//    public static PlayerSelect playerSelect = new PlayerSelect(arena);
    public static String line;
    public static int playAgain = 1;
    public static int battleResults;
    public static File file = new File("Heroes.txt");
    public static int gui = 0;
    public static Map map;

    public static BufferedReader reader;

    static {
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public MainFrame() {
        try {
            gui = 1;
            //noinspection ResultOfMethodCallIgnored
            file.createNewFile();
            arena = new Arena();

            while (true) {
                iLoadHeroes();
                Logger.appendHeroesFile(file.getName());

                frame = getFrame();
//                frame.setVisible(false);
                new Splash();
                //All Heroes added to arena


                return ;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JFrame getFrame(){
        if(frame == null){
            frame = new JFrame();
            frame.setTitle("SWINGY");
            frame.setSize(700, 500);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
        return frame;
    }

    public static void showFrame() {
        if (frame != null)
            frame.setVisible(true);
    }

    public static void iLoadHeroes() throws IOException {
        arena.heroes = new ArrayList<Hero>();
        while ((line = reader.readLine()) != null) {
            String[] heroValues = line.split(" ");
            Hero hero = HeroFactory.newHero(heroValues[0], heroValues[1], Integer.parseInt(heroValues[2]), Integer.parseInt(heroValues[3]), 0, 0, Integer.parseInt(heroValues[4]), Integer.parseInt(heroValues[5]), Integer.parseInt(heroValues[6]), Integer.parseInt(heroValues[7]), Integer.parseInt(heroValues[8]), Integer.parseInt(heroValues[9]));
            arena.loadHeroes(hero);
        }
    }

    public static void iCurrentHero(int option, String HeroType, String HeroName){
        if(option == 0){
            if(arena.heroes.size() != 0){
                currentHero = Menu.Console.heroSelect(arena, HeroName);
                arena.heroes.remove(currentHero);
            }  else {
                currentHero = Menu.Console.createHero(arena, HeroType, HeroName);
            }
        } else {
            currentHero = Console.createHero(arena, HeroType, HeroName);
        }
    }

    public static void iCreateMap(){
        map = new Map(currentHero.level);
        map.generateMap(map.x, map.y, map.map);
        currentHero.coordinates.setY(map.x / 2);
        currentHero.coordinates.setX(map.y / 2);
        map.map[currentHero.coordinates.getX()][currentHero.coordinates.getY()] = '#';
        int i = 0;
        while (i < (map.x * map.y) / 2) {
            arena.loadVillains(VillainFactory.newVillain(map, currentHero.level));
            i++;
        }
    }

    public static int iBattle() throws IOException {
        int k;

        while (true) {
            battleResults = Console.navDirectionCheck(map, currentHero, arena.villains);
            if(battleResults == 1){
                return 1;
            } else if (battleResults == 2)
            {
                currentHero.xp += 2 * (50 * currentHero.level);
                currentHero.level = Console.updateLevel(currentHero.xp, currentHero.level);
                arena.loadHeroes(currentHero);
                Logger.createHeroesFile(file.getName());
                arena.saveHeroesToDB();
                if(Console.again(playAgain) == 0)
                    return 2;
                else
                    return 3;
            } else if (battleResults == 0) {
                arena.loadHeroes(currentHero);
                Logger.createHeroesFile(file.getName());
                arena.saveHeroesToDB();
                if (Console.again(playAgain) == 0)
                    return 2;
                else
                    return 3;
            }
        }
    }
}
