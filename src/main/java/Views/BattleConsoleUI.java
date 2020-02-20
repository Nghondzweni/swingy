package Views;


import Controllers.Battle;
import ExtraClasses.Logger;
import ExtraClasses.Scanner;
import Models.Hero;
import Models.Map.Villain;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Random;

import static Menu.Console.updateLevel;
import static javax.swing.BoxLayout.Y_AXIS;



public class BattleConsoleUI {
    private JPanel mainPanel = new JPanel();
    private JLabel swingyLogo = new JLabel();
    private JPanel logoContainer = new JPanel();
    private JPanel mapContainer = new JPanel();
    private JPanel buttonsContainer = new JPanel();
    private JPanel battleInfoContainer = new JPanel();
    private JLabel battleInfo = new JLabel("<html>New Game!!!");
    private JLabel heroInfo = new JLabel();
    private JButton moveUp = new JButton("");
    private JButton moveDown = new JButton("");
    private JButton moveLeft = new JButton("");
    private JButton moveRight = new JButton("");
//    private JButton fight = new JButton("Fight");
//    private JButton flight = new JButton("Flight");
    Border border = BorderFactory.createLineBorder(Color.black, 1);

    private JPanel mapCC = new JPanel();
    private JLabel grass;

    private JPanel container;
    private JScrollPane scrollPane;
    private JScrollPane textScroll;
    private GridBagConstraints constraints;




    public BattleConsoleUI(){


        moveUp.setIcon(new ImageIcon("./src/main/resources/up.png"));
        moveDown.setIcon(new ImageIcon("./src/main/resources/down.png"));
        moveLeft.setIcon(new ImageIcon("./src/main/resources/left.png"));
        moveRight.setIcon(new ImageIcon("./src/main/resources/right.png"));

        mainPanel.setLayout(new GridBagLayout());

        container = new JPanel();

        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;


        scrollPane = new JScrollPane(container);

        textScroll = new JScrollPane(battleInfo);

        battleInfoContainer.setLayout(new BoxLayout(battleInfoContainer, Y_AXIS));
        buttonsContainer.setLayout(new GridLayout(2,2));
        textScroll.setPreferredSize(new Dimension(292,500));
        textScroll.setMinimumSize(new Dimension(292, 500));
        textScroll.setPreferredSize(new Dimension(292, 500));
        textScroll.setMaximumSize(new Dimension(292, 500));


        battleInfoContainer.add(heroInfo);
        battleInfoContainer.add(textScroll);


        battleInfo.setBorder(border);
//        battleInfoContainer.add(fight);
//        battleInfoContainer.add(flight);
        buttonsContainer.add(moveUp);
        buttonsContainer.add(moveDown);
        buttonsContainer.add(moveLeft);
        buttonsContainer.add(moveRight);

        container.setLayout(new GridLayout(MainFrame.map.y, MainFrame.map.y, 0, 0));
        if(MainFrame.currentHero.level > 3)
            scrollPane.setPreferredSize(new Dimension(800, 700));
        else
            scrollPane.setPreferredSize(new Dimension(35 * MainFrame.map.y, 35 * MainFrame.map.y));






        mainPanel.setLayout(new BoxLayout(mainPanel, Y_AXIS));
        swingyLogo.setIcon(new ImageIcon("./src/main/resources/swingy.png"));
        logoContainer.add(swingyLogo);
        mapContainer.setLayout(new GridLayout(1,3));
        mapContainer.setPreferredSize(new Dimension(1500,1100));
        mapContainer.setBackground(Color.black);


        mapContainer.setLayout(new GridLayout(MainFrame.map.y,MainFrame.map.x));
        for(int i = 0; i < MainFrame.map.y; i++){
            for(int j = 0; j < MainFrame.map.x; j++){
                border = BorderFactory.createLineBorder(Color.black, 1);
                grass = new JLabel();
                if(MainFrame.map.map[i][j] == 'X'){
                    showVillain(Battle.getVillain(MainFrame.arena.villains, j, i), grass);
                }
                else if (i == MainFrame.currentHero.coordinates.getY() && j == MainFrame.currentHero.coordinates.getX()){
                    grass.setIcon(new ImageIcon("./src/main/resources/hero2.png"));
                    border = BorderFactory.createLineBorder(Color.RED, 1);

                }
                else {
                    if(i == 0 || j == 0 || (i == MainFrame.map.y - 1) || (j == MainFrame.map.x - 1))
                        grass.setIcon(new ImageIcon("./src/main/resources/wall.png"));
                    else
                        grass.setIcon(new ImageIcon("./src/main/resources/grass.png"));
                }
                grass.setBorder(border);
                container.add(grass);
            }
        }

        Dimension size = scrollPane.getViewport().getViewSize();
        int x = (size.width) / 3;
        int y = (size.height) / 3;
        scrollPane.getViewport().setViewPosition(new Point(x, y));

        heroInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        updateHeroStats();



        mapCC.add(battleInfoContainer);
        mapCC.add(scrollPane, constraints);
        mapCC.add(buttonsContainer);
        mainPanel.add(logoContainer);
        mainPanel.add(mapCC);

        moveUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Border border;
                container.removeAll();
                for(int i = 0; i < MainFrame.map.y; i++){
                    for(int j = 0; j < MainFrame.map.x; j++){
                        border = BorderFactory.createLineBorder(Color.black, 1);
                        grass = new JLabel();
                        if(MainFrame.map.map[i][j] == 'X' && i == (MainFrame.currentHero.coordinates.getY() - 1) && j == (MainFrame.currentHero.coordinates.getX())){
                            grass.setIcon(new ImageIcon("./src/main/resources/swords.png"));

                        }
                        else if(MainFrame.map.map[i][j] == 'X'){
                            showVillain(Battle.getVillain(MainFrame.arena.villains, j, i), grass);
                        }
                        else if (i == (MainFrame.currentHero.coordinates.getY() - 1) && j == MainFrame.currentHero.coordinates.getX()){
                            grass.setIcon(new ImageIcon("./src/main/resources/hero2.png"));
                            border = BorderFactory.createLineBorder(Color.RED, 1);
                        }
                        else if(MainFrame.map.map[i][j] == '.'){
                            grass.setIcon(new ImageIcon("./src/main/resources/dead_enemy.png"));
                        }
                        else {
                            if(i == 0 || j == 0 || (i == MainFrame.map.y - 1) || (j == MainFrame.map.x - 1))
                                grass.setIcon(new ImageIcon("./src/main/resources/wall.png"));
                            else
                                grass.setIcon(new ImageIcon("./src/main/resources/grass.png"));
                        }
                        grass.setBorder(border);
                        container.add(grass);
                    }
                }
                MainFrame.currentHero.coordinates.setY(MainFrame.currentHero.coordinates.getY() - 1);
                if(checkMapEdge(MainFrame.currentHero.coordinates.getX(),MainFrame.currentHero.coordinates.getY(), MainFrame.map.x, MainFrame.map.y) == 1)
                    playAgain();

                if(MainFrame.map.map[MainFrame.currentHero.coordinates.getY()][MainFrame.currentHero.coordinates.getX()] == 'X') {
                    try {
                        iFightOrFlight(Battle.getVillain(MainFrame.arena.villains, MainFrame.currentHero.coordinates.getX(), MainFrame.currentHero.coordinates.getY()));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                scrollPane.validate();
                scrollPane.repaint();
            }
        });

        moveDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Border border;
                container.removeAll();
                for(int i = 0; i < MainFrame.map.y; i++){
                    for(int j = 0; j < MainFrame.map.x; j++){
                        border = BorderFactory.createLineBorder(Color.black, 1);
                        grass = new JLabel();
                        if(MainFrame.map.map[i][j] == 'X' && i == (MainFrame.currentHero.coordinates.getY() + 1) && j == (MainFrame.currentHero.coordinates.getX())){
                            grass.setIcon(new ImageIcon("./src/main/resources/swords.png"));

                        }
                        else if(MainFrame.map.map[i][j] == 'X'){
                            showVillain(Battle.getVillain(MainFrame.arena.villains, j, i), grass);
                        }
                        else if (i == (MainFrame.currentHero.coordinates.getY() + 1) && j == MainFrame.currentHero.coordinates.getX()){
                            grass.setIcon(new ImageIcon("./src/main/resources/hero2.png"));
                            border = BorderFactory.createLineBorder(Color.RED, 1);
                        }
                        else if(MainFrame.map.map[i][j] == '.'){
                            grass.setIcon(new ImageIcon("./src/main/resources/dead_enemy.png"));
                        }
                        else {
                            if(i == 0 || j == 0 || (i == MainFrame.map.y - 1) || (j == MainFrame.map.x - 1))
                                grass.setIcon(new ImageIcon("./src/main/resources/wall.png"));
                            else
                                grass.setIcon(new ImageIcon("./src/main/resources/grass.png"));
                        }
                        grass.setBorder(border);
                        container.add(grass);
                    }
                }

                MainFrame.currentHero.coordinates.setY(MainFrame.currentHero.coordinates.getY() + 1);

                if(checkMapEdge(MainFrame.currentHero.coordinates.getX(),MainFrame.currentHero.coordinates.getY(), MainFrame.map.x, MainFrame.map.y) == 1)
                    playAgain();

                if(MainFrame.map.map[MainFrame.currentHero.coordinates.getY()][MainFrame.currentHero.coordinates.getX()] == 'X') {
                    try {
                        iFightOrFlight(Battle.getVillain(MainFrame.arena.villains, MainFrame.currentHero.coordinates.getX(), MainFrame.currentHero.coordinates.getY()));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                scrollPane.validate();
                scrollPane.repaint();
            }
        });

        moveLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Border border;
                container.removeAll();
                for(int i = 0; i < MainFrame.map.y; i++){
                    for(int j = 0; j < MainFrame.map.x; j++){
                        border = BorderFactory.createLineBorder(Color.black, 1);

                        grass = new JLabel();
                        if(MainFrame.map.map[i][j] == 'X' && i == (MainFrame.currentHero.coordinates.getY()) && j == (MainFrame.currentHero.coordinates.getX() - 1)){
                            grass.setIcon(new ImageIcon("./src/main/resources/swords.png"));

                        }
                        else if(MainFrame.map.map[i][j] == 'X'){
                            showVillain(Battle.getVillain(MainFrame.arena.villains, j, i), grass);
                        }
                        else if (i == MainFrame.currentHero.coordinates.getY() && j == (MainFrame.currentHero.coordinates.getX() - 1)){
                            grass.setIcon(new ImageIcon("./src/main/resources/hero2.png"));
                            border = BorderFactory.createLineBorder(Color.RED, 1);
                        }
                        else if(MainFrame.map.map[i][j] == '.'){
                            grass.setIcon(new ImageIcon("./src/main/resources/dead_enemy.png"));
                        }
                        else {
                            if(i == 0 || j == 0 || (i == MainFrame.map.y - 1) || (j == MainFrame.map.x - 1))
                                grass.setIcon(new ImageIcon("./src/main/resources/wall.png"));
                            else
                                grass.setIcon(new ImageIcon("./src/main/resources/grass.png"));
                        }
                        grass.setBorder(border);
                        container.add(grass);
                    }
                }
                MainFrame.currentHero.coordinates.setX(MainFrame.currentHero.coordinates.getX() - 1);

                if(checkMapEdge(MainFrame.currentHero.coordinates.getX(),MainFrame.currentHero.coordinates.getY(), MainFrame.map.x, MainFrame.map.y) == 1)
                    playAgain();

                if(MainFrame.map.map[MainFrame.currentHero.coordinates.getY()][MainFrame.currentHero.coordinates.getX()] == 'X') {
                    try {
                        iFightOrFlight(Battle.getVillain(MainFrame.arena.villains, MainFrame.currentHero.coordinates.getX(), MainFrame.currentHero.coordinates.getY()));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                scrollPane.validate();
                scrollPane.repaint();
            }
        });

        moveRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Border border;
                container.removeAll();
                for(int i = 0; i < MainFrame.map.y; i++){
                    for(int j = 0; j < MainFrame.map.x; j++){
                        border = BorderFactory.createLineBorder(Color.black, 1);
                        grass = new JLabel();
                        if(MainFrame.map.map[i][j] == 'X' && i == (MainFrame.currentHero.coordinates.getY()) && j == (MainFrame.currentHero.coordinates.getX() + 1)){
                            grass.setIcon(new ImageIcon("./src/main/resources/swords.png"));

                        }
                        else if(MainFrame.map.map[i][j] == 'X'){
                            showVillain(Battle.getVillain(MainFrame.arena.villains, j, i), grass);
                        }
                        else if (i == (MainFrame.currentHero.coordinates.getY()) && j == (MainFrame.currentHero.coordinates.getX() + 1)){
                            grass.setIcon(new ImageIcon("./src/main/resources/hero2.png"));
                            border = BorderFactory.createLineBorder(Color.RED, 1);
                        }
                        else if(MainFrame.map.map[i][j] == '.'){
                            grass.setIcon(new ImageIcon("./src/main/resources/dead_enemy.png"));
                        }
                        else {
                            if(i == 0 || j == 0 || (i == MainFrame.map.y - 1) || (j == MainFrame.map.x - 1))
                                grass.setIcon(new ImageIcon("./src/main/resources/wall.png"));
                            else
                                grass.setIcon(new ImageIcon("./src/main/resources/grass.png"));
                        }
                        grass.setBorder(border);
                        container.add(grass);
                    }
                }
                MainFrame.currentHero.coordinates.setX(MainFrame.currentHero.coordinates.getX() + 1);

                if(checkMapEdge(MainFrame.currentHero.coordinates.getX(),MainFrame.currentHero.coordinates.getY(), MainFrame.map.x, MainFrame.map.y) == 1)
                    playAgain();

                if(MainFrame.map.map[MainFrame.currentHero.coordinates.getY()][MainFrame.currentHero.coordinates.getX()] == 'X') {
                    try {
                        iFightOrFlight(Battle.getVillain(MainFrame.arena.villains, MainFrame.currentHero.coordinates.getX(), MainFrame.currentHero.coordinates.getY()));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                scrollPane.validate();
                scrollPane.repaint();
            }
        });


        MainFrame.frame.setSize(1300, 1000);

        mainPanel.setVisible(true);
        MainFrame.frame.setContentPane(mainPanel);
        MainFrame.frame.validate();
        MainFrame.showFrame();

    }

    public void iFightOrFlight(final Villain villain) throws IOException {
        Random random = new Random();
        int rand = random.nextInt(42);

        Object[] options = {"Run Away", "Fight Enemy" };

        int n = JOptionPane.showOptionDialog(MainFrame.frame,
                "<html> <br>========================================<br>" +
                        "<br>YOU HAVE ENCOUNTERED AN ENEMEY!!!<br>" +
                        "<br> VILLAIN TYPE: " + villain.villainClass +
                        "<br>VILLAIN LEVEL: " + villain.level +
                        "<br>VILLAIN ATTACK: " + villain.stats.getAttack() +
                        "<br>VILLAIN DEFENCE: " + villain.stats.getDefence() +
                        "<br>VILLAIN HIT POINTS: " + villain.stats.getHitPoints() +
                        "<br>========================================<br>" +
                        "<br><br>" +
                        "WOULD YOU LIKE TO FIGHT OR RUN LIKE A LIL' BITCH? <br>", "Fight or Flight?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        if (n == 1){
            battleInfo.setText(battleInfo.getText() + "<br>You chose to fight like a real nigga!!<br>");
            if(iFight(villain, MainFrame.currentHero) == 1){
                MainFrame.map.map[villain.coordinates.getX()][villain.coordinates.getY()] = '.';
            }
        }
        else{
            if (rand%2 == 0){
                battleInfo.setText(battleInfo.getText() + "<br>You ran like a lil bitch<br>");
            }
            else {
                battleInfo.setText(battleInfo.getText() + "<br>You chose to run like a lil' bitch but the odds were against you. Now fight your enemy!!<br>");
                if(iFight(villain, MainFrame.currentHero) == 1){
                    MainFrame.map.map[villain.coordinates.getX()][villain.coordinates.getY()] = '.';
                }
            }
        }
    }

    public  void iWin(int villainLevel, Hero hero) {
        Random random = new Random();
        int artifact = random.nextInt(5);
        int artifactPoints;
        String artifactType = "";

        if (villainLevel < 4) {
            artifactPoints = random.nextInt(3);
        } else if (villainLevel < 8) {
            artifactPoints = (int) (Math.random() * (4 - 3) + 3);
        } else
            artifactPoints = 5;

        if (artifactPoints == 0)
            artifactPoints++;

        if (artifact == 0)
            artifactType = "Weapon";
        else if (artifact == 1)
            artifactType = "Armor";
        else if (artifact == 2)
            artifactType = "Helm";

        if(artifactType != "") {

        int n = JOptionPane.showConfirmDialog(MainFrame.frame,
                "Your enemy has dropped a " + artifactType + " with (" + artifactPoints + ") points.\n Would you like to take it?",
                "Take artifact?",
                JOptionPane.YES_NO_OPTION);

        if (artifact != 3 && artifact != 4) {
            if (n == 0) {
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
                    hero.xp += 2 * (25);
                else
                    hero.xp += 2 * (villainLevel * 25);
                hero.level = updateLevel(hero.xp, hero.level);
            } else if (n == 1) {
                battleInfo.setText(battleInfo.getText() + "<br>You chose to leave artifact<br>");
                if (villainLevel == 0)
                    hero.xp += 2 * (25);
                else
                    hero.xp += 2 * (villainLevel * 25);
                hero.level = updateLevel(hero.xp, hero.level);
                }
            }
        }
        else {
            if (villainLevel == 0)
                hero.xp += 2 * (25);
            else
                hero.xp += 2 * (villainLevel * 25);
            hero.level = updateLevel(hero.xp, hero.level);
            battleInfo.setText(battleInfo.getText() + "<br>Your enemy did not drop any artifact<br>");
        }
        updateHeroStats();
    }


    public  int iFight(Villain villain, Hero hero) throws IOException {
        int heroPoints = 0;
        int villainPoints = 0;

        battleInfo.setText(battleInfo.getText() + "<br>Fight simulation taking place...");

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
            battleInfo.setText(battleInfo.getText() + "<br>You kicked your enemy's ass!!!<br>");
            iWin(villain.level, hero);
            return (1);
        }
        else if (villainPoints > heroPoints && luck == 5){
            battleInfo.setText(battleInfo.getText() + "<br>Your enemy was way stronger than you. But you got lucky<br>");
            iWin(villain.level, hero);
            return (1);
        }
        else{
            battleInfo.setText(battleInfo.getText() + "<br>Your enemy was way stronger than you. He kicked your ass!!!<br>");
            int n = JOptionPane.showConfirmDialog(MainFrame.frame,
                    "Would you like to Play this shitty game again?",
                    "Play Again?",
                    JOptionPane.YES_NO_OPTION);
            if(n == 0) {
                MainFrame.arena.loadHeroes(MainFrame.currentHero);
                Logger.createHeroesFile("Heroes.txt");
                MainFrame.arena.saveHeroesToDB();
                new Splash();
                return 2;
            }else{
                MainFrame.arena.loadHeroes(MainFrame.currentHero);
                Logger.createHeroesFile("Heroes.txt");
                MainFrame.arena.saveHeroesToDB();
                System.exit(1);
            }
            return -1;
        }
    }

    public  void showVillain(Villain villain, JLabel grass){
        if(villain.villainClass.compareToIgnoreCase("Assassin") == 0){
            grass.setIcon(new ImageIcon("./src/main/resources/villains/1.png"));
        } else if(villain.villainClass.compareToIgnoreCase("Barbarian") == 0){
            grass.setIcon(new ImageIcon("./src/main/resources/villains/2.png"));

        } else if(villain.villainClass.compareToIgnoreCase("Knight") == 0){
            grass.setIcon(new ImageIcon("./src/main/resources/villains/3.png"));

        } else if(villain.villainClass.compareToIgnoreCase("Warrior") == 0){
            grass.setIcon(new ImageIcon("./src/main/resources/villains/4.png"));

        } else if(villain.villainClass.compareToIgnoreCase("Wizard") == 0){
            grass.setIcon(new ImageIcon("./src/main/resources/villains/5.png"));
        }
    }

    public void updateHeroStats(){
        heroInfo.setText(
                "<html><br>=============================<br>" +
                "<br>HERO STATS:<br><br>" +
                "<br>HERO TYPE: " + MainFrame.currentHero.heroClass +
                "<br>HERO LEVEL: " + MainFrame.currentHero.level +
                "<br>HERO XP: " + MainFrame.currentHero.xp +
                "<br>HERO ATTACK: " + MainFrame.currentHero.stats.getAttack() +
                "<br>HERO DEFENCE: " + MainFrame.currentHero.stats.getDefence() +
                "<br>HERO HIT POINTS: " + MainFrame.currentHero.stats.getHitPoints() +
                "<br>=============================<br>");
    }

    public int checkMapEdge(int heroX, int heroY, int mapX, int mapY){
        if(heroX == 0 || heroY == 0 || (heroX == mapX-1) || (heroY == mapY-1))
            return 1;
        return 0;
    }

    public void playAgain(){
        int n = JOptionPane.showConfirmDialog(MainFrame.frame,
                "Congratulations, You have won the game!!! Would you like to play again?",
                "Play Again?",
                JOptionPane.YES_NO_OPTION);
        if(n == 0) {
            MainFrame.arena.loadHeroes(MainFrame.currentHero);
            try {
                Logger.createHeroesFile("Heroes.txt");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            MainFrame.arena.saveHeroesToDB();
            new Splash();
        }else{
            MainFrame.arena.loadHeroes(MainFrame.currentHero);
            try {
                Logger.createHeroesFile("Heroes.txt");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            MainFrame.arena.saveHeroesToDB();
            System.exit(1);
        }
    }


}
