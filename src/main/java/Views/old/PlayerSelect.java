package Views.old;

import Models.Arena;
import Models.Hero;

import javax.swing.*;


public class PlayerSelect {
    private JLabel swingyLogo;
    private JPanel selectRootPanel;
    private JPanel swingLogo;
    private JList Heroes;
    public DefaultListModel playersList;


    public PlayerSelect(Arena arena){
        playersList = addPlayersList(arena);

        Heroes.setModel(playersList);
        createUIComponents(arena);
    }

    private void createUIComponents(Arena arena) {
        swingyLogo = new JLabel(new ImageIcon("swingy.png"));
    }

    private DefaultListModel addPlayersList(Arena arena){

        DefaultListModel listModel = new DefaultListModel();

        for (int i = 0; i < arena.heroes.size(); i++){
            listModel.add(i,arena.heroes.get(i).heroName);
        }
        return listModel;
    }

    public JPanel getSelectRootPanel() {
        return selectRootPanel;
    }


}
