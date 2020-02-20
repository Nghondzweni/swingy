package Views;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class PlayerCreate {
    private JComboBox heroType = new JComboBox();
    private JLabel nameLabel = new JLabel("Hero Name : ", SwingConstants.CENTER);
    private JLabel typeLabel = new JLabel("Hero Type : ", SwingConstants.CENTER);
    private JTextField heroName = new JTextField();
    private JLabel swingyLogo = new JLabel();
    private JButton createPlayer = new JButton("CREATE PLAYER");
    private JButton selectPlayer = new JButton("SELECT PLAYER");
    private JPanel logoContainer = new JPanel();
    private JPanel buttonsContainer = new JPanel();
    private JPanel mainPanel = new JPanel();

    public PlayerCreate (){

        buttonsContainer.setLayout(new GridBagLayout());
        buttonsContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 10, 5);
        mainPanel.setLayout(new BoxLayout(mainPanel,Y_AXIS));

        heroType.addItem( "ASSASSIN");
        heroType.addItem( "BARBARIAN");
        heroType.addItem( "KNIGHT");
        heroType.addItem( "WARRIOR");
        heroType.addItem( "WIZARD");


        logoContainer.add(swingyLogo);
        swingyLogo.setIcon(new ImageIcon("/home/variablecarp571/IdeaProjects/swingy/src/main/resources/swingy.png"));


        MainFrame.frame.add(logoContainer);
        buttonsContainer.add(nameLabel,gbc);
        buttonsContainer.add(heroName, gbc);
        buttonsContainer.add(typeLabel,gbc);
        buttonsContainer.add(heroType,gbc);
        buttonsContainer.add(createPlayer, gbc);
        buttonsContainer.add(selectPlayer,gbc);
        mainPanel.add(logoContainer);
        mainPanel.add(buttonsContainer);


        mainPanel.setVisible(true);

        MainFrame.frame.setContentPane(mainPanel);

        MainFrame.frame.validate();
        MainFrame.showFrame();

        createPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(heroName.getText().compareToIgnoreCase("") == 0)
                   JOptionPane.showMessageDialog(null,"Error : Hero Name Cannot Be Empty");
                else{
                    MainFrame.iCurrentHero(1, (String)heroType.getSelectedItem(), heroName.getText());
                    MainFrame.iCreateMap();
                    new BattleConsoleUI();
                }
            }
        });

        selectPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PlayerSelect();
            }
        });
    }


}

