package Views;

import Models.Arena;
import Models.Hero;
import Views.old.RootWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.BoxLayout.Y_AXIS;

public class Splash {
    private JComboBox heroType;
    private JTextField heroName;
    private JLabel swingyLogo = new JLabel();
    private JButton createButton = new JButton("CREATE PLAYER");
    private JButton selectButton = new JButton("SELECT PLAYER");
    private JPanel logoContainer = new JPanel();
    private JPanel buttonsContainer = new JPanel();
    private JPanel mainPanel = new JPanel();
    private JLabel welcomeText = new JLabel("Would you like to Create or Select A previously Created Player?");


    public Splash(){
        MainFrame.frame.setSize(700, 500);
        buttonsContainer.setLayout(new GridBagLayout());
        buttonsContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        welcomeText.setHorizontalAlignment(JLabel.CENTER);

        mainPanel.setLayout(new BoxLayout(mainPanel,Y_AXIS));

        logoContainer.add(swingyLogo);
        swingyLogo.setIcon(new ImageIcon("./src/main/resources/swingy.png"));


        MainFrame.frame.add(logoContainer);
        buttonsContainer.add(welcomeText, gbc);
        buttonsContainer.add(createButton, gbc);
        buttonsContainer.add(selectButton, gbc);
        mainPanel.add(logoContainer);
        mainPanel.add(buttonsContainer);

        mainPanel.setVisible(true);

        MainFrame.frame.setContentPane(mainPanel);

        MainFrame.frame.validate();
        MainFrame.showFrame();


        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PlayerCreate();
            }
        });
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PlayerSelect();
            }
        });
    }
}
