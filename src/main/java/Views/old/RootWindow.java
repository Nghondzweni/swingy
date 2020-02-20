package Views.old;

import Models.Arena;
import Views.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RootWindow  implements ActionListener{
    public JPanel splashPanel;
    private JButton CREATEPLAYERButton;
    private JButton SELECTPLAYERButton;
    private JLabel swingyLogo;

//    private PlayerCreate playerCreate = new PlayerCreate();
    private PlayerSelect playerSelect;

    public RootWindow(Arena arena){
//        playerSelect = new PlayerSelect(arena);

        CREATEPLAYERButton.addActionListener(this);
        SELECTPLAYERButton.addActionListener(this);

        createUIComponents();
    }

    private void createUIComponents() {
        swingyLogo = new JLabel(new ImageIcon("swingy.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        splashPanel.removeAll();
        if(e.getSource() == CREATEPLAYERButton) {
        }
        else if (e.getSource() == SELECTPLAYERButton){

        }
    }
}
