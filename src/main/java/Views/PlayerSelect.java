package Views;

import Models.Arena;
import Models.Hero;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class PlayerSelect{

    private JLabel swingyLogo = new JLabel();
    private JPanel mainPanel = new JPanel();
    private JList Heroes = new JList();
    private JButton selectButton = new JButton("SELECT PLAYER");
    private JButton createButton = new JButton("CREATE PLAYER");
    private JPanel logoContainer  = new JPanel();
    private JPanel HeroStats = new JPanel();
    private JPanel infoPanel = new JPanel();
    private JLabel heroStatsInfo = new JLabel("SELECT PLAYER");
    public DefaultListModel playersList;


    public PlayerSelect(){
        mainPanel.setLayout(new BoxLayout(mainPanel,Y_AXIS));

        swingyLogo.setIcon(new ImageIcon("./src/main/resources/swingy.png"));
        logoContainer.add(swingyLogo);
        mainPanel.add(logoContainer);
        playersList = addPlayersList(MainFrame.arena);
        Heroes.setModel(playersList);


        JScrollPane jScrollPane = new JScrollPane(Heroes);
        jScrollPane.setPreferredSize(new Dimension(200,300));
        infoPanel.add(jScrollPane, BorderLayout.LINE_START);
        infoPanel.add(HeroStats, BorderLayout.LINE_END);
        infoPanel.add(heroStatsInfo, BorderLayout.LINE_START);

        mainPanel.add(infoPanel);
//        mainPanel.add(Heroes);
        mainPanel.add(selectButton);
        mainPanel.add(createButton);
        mainPanel.setVisible(true);
        MainFrame.frame.setContentPane(mainPanel);
        MainFrame.frame.validate();
        MainFrame.showFrame();

        Heroes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Hero hero;
                for (int i = 0; i < MainFrame.arena.heroes.size(); i++){
                    if(MainFrame.arena.heroes.get(i).heroName.compareToIgnoreCase( (String) Heroes.getSelectedValue()) == 0){
                        hero = MainFrame.arena.heroes.get(i);
                        heroStatsInfo.setText("<html> HERO NAME :   " + hero.heroName +
                                                "<br> HERO CLASS      :   " + hero.heroClass +
                                                "<br> HERO LEVEL      :   " + hero.level +
                                                "<br> XP              :   " + hero.xp +
                                                "<br> ATTACK POINTS   :   " + hero.stats.getAttack() +
                                                "<br> DEFENCE POINTS  :   " + hero.stats.getDefence() +
                                                "<br> HIT POINTS      :   " + hero.stats.getHitPoints() + "</html>");
                    }
                }
            }
        });

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Heroes.isSelectionEmpty())
                    JOptionPane.showMessageDialog(null,"Error : Please Select a Hero to continue");
                else{
                    MainFrame.iCurrentHero(0, null, Heroes.getSelectedValue().toString());
                    MainFrame.iCreateMap();
                    new BattleConsoleUI();
                }
            }
        });

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PlayerCreate();
            }
        });
    }

    private DefaultListModel addPlayersList(Arena arena){
        DefaultListModel listModel = new DefaultListModel();

        for (int i = 0; i < arena.heroes.size(); i++){
            listModel.add(i,arena.heroes.get(i).heroName);
        }
        return listModel;
    }




}
