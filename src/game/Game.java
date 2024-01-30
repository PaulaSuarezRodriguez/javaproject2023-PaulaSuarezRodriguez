package game;

import javax.swing.*;

import java.awt.*;


/**
 * Your main game entry point
 */
public class Game {
    Swimmer swimmer;
    GameLevel currentLevel;
    String levelName;
    GameView view;
    SwimmerController swimmerController;
    private SwimmerTracker swimmerTracker;
    ButtonCommands circle;
    private int count = 0;

    /**
     * Initialise a new Game.
     */
    public Game() {

// In order to start in level one, definite version:
        currentLevel = new LevelOne(this);

        //3. make a view to look into the game world
        // UserView view = new UserView(world, 500, 500);
        view = new GameView(currentLevel, 800, 600, false, false, this, view);

        // Creation of SwimmerController object
        swimmerController = new SwimmerController(currentLevel.getSwimmer(), this, currentLevel, levelName);
        view.addKeyListener(swimmerController);

        // Creation of MouseHandler object
        MouseHandler mouseHandler = new MouseHandler(currentLevel, view, currentLevel.getCrab1(), currentLevel.getSwimmer());
        view.addMouseListener(mouseHandler);

        // Creation of SwimmerTracker object
        swimmerTracker = new SwimmerTracker(view, currentLevel.getSwimmer());
        currentLevel.addStepListener(swimmerTracker);
        // view.requestFocus();


        // Creation of GiveFocus object
        GiveFocus GiveFocusObject = new GiveFocus(currentLevel, view);
        view.addMouseListener(GiveFocusObject);

        //optional: draw a 1-metre grid over the view
        // view.setGridResolution(1);

        //4. create a Java window (frame) and add the game view to it
        final JFrame frame = new JFrame("City Game");
        frame.add(view);

        ButtonCommands press = new ButtonCommands();

        // window.pack();
        view.setVisible(true);

        ControlPanel controlPanel = new ControlPanel(press, this);
        view.add(controlPanel.getMainPanel(), BorderLayout.SOUTH);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        // start our game world simulation!
        currentLevel.start();
    }

    public void goToNextLevel() {
        System.out.println("Call count: " + ++count);
        if (currentLevel instanceof LevelOne) {
            System.out.println("Moving onto next level -- level two!");
            currentLevel.stop();
            Swimmer prevSwimmer = currentLevel.getSwimmer();
            currentLevel = new LevelTwo(this);
            Swimmer currentSwimmer = currentLevel.getSwimmer();
            view.setWorld(currentLevel);
            swimmerController.updateSwimmer(currentLevel.getSwimmer());
            swimmerTracker.updateSwimmer(currentLevel.getSwimmer());
            currentLevel.addStepListener(swimmerTracker);
            currentLevel.start();
        } else if (currentLevel instanceof LevelTwo) {
            System.out.println("Moving onto next level -- level three!");
            currentLevel.stop();
            Swimmer prevSwimmer = currentLevel.getSwimmer();
            currentLevel = new LevelThree(this);
            Swimmer currentSwimmer = currentLevel.getSwimmer();
            view.setWorld(currentLevel);
            swimmerController.updateSwimmer(currentLevel.getSwimmer());
            swimmerTracker.updateSwimmer(currentLevel.getSwimmer());
            currentLevel.addStepListener(swimmerTracker);
            currentLevel.start();
        } else if (currentLevel instanceof LevelThree) {
            System.out.println("Moving onto next level -- level four, last level!");
            currentLevel.stop();
            Swimmer prevSwimmer = currentLevel.getSwimmer();
            currentLevel = new LevelFour(this);
            Swimmer currentSwimmer = currentLevel.getSwimmer();
            view.setWorld(currentLevel);
            swimmerController.updateSwimmer(currentLevel.getSwimmer());
            swimmerTracker.updateSwimmer(currentLevel.getSwimmer());
            currentLevel.addStepListener(swimmerTracker);
            currentLevel.start();
        }
    }

    /**
     * Run the game.
     */
    public static void main(String[] args) {
        new Game();
    }
}

