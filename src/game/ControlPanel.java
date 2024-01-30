package game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel {
    private JButton growButton;
    private JButton quitButton;
    private JButton shrinkButton;
    private JPanel mainPanel;
    private JRadioButton SoundButton;
    private JButton Instructions;
    private ButtonCommands press;
    Game game;
    public ControlPanel(ButtonCommands press, Game game){
        this.game = game;
        this.press = press;

        Instructions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             JDialog instructions = new JDialog();
            }
        });
        SoundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                press.soundOff(SoundButton);
            }
        });
    }

    public JPanel getMainPanel(){
        return mainPanel;
    }
}
