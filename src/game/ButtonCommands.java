package game;
import javax.swing.*;

/**
     * Methods for action of buttons.
     */
    public class ButtonCommands /*extends Model */{
        JRadioButton SoundButton;
        /**
         * Constructor for objects of class ButtonCommands.
         *
         */
        public ButtonCommands() {
        }
        public void soundOff(JRadioButton SoundButton) {
            this.SoundButton = SoundButton;
            if (SoundButton.isSelected()) {
                LevelOne.stopSound();
                LevelTwo.stopSound();
                LevelThree.stopSound();
                LevelFour.stopSound();
            } else if (!SoundButton.isSelected() /*&& game.currentLevel instanceof LevelOne*/) {
                LevelOne.getSound().play();
                LevelOne.getSound().loop();

                LevelTwo.getSound().play();
                LevelOne.getSound().stop();
                LevelTwo.getSound().loop();

                LevelThree.getSound().play();
                LevelTwo.getSound().stop();
                LevelThree.getSound().loop();

                LevelFour.getSound().play();
                LevelThree.getSound().stop();
                LevelFour.getSound().loop();
            }
            }
        }


