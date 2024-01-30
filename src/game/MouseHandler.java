package game;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class MouseHandler implements MouseListener {
    private GameLevel world;
    private GameView view;
    private Enemies crab1;
    private Swimmer swimmer;

    public MouseHandler(GameLevel world, GameView view, Enemies crab1, Swimmer swimmer) {
        this.world = world;
        this.view = view;
        this.crab1 = crab1;
        this.swimmer = swimmer;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        /*get the coordinates of the mouse click - these are in pixels (the location in the window where the click happened). The mouse click needs to be added at *world* coordinates which are in meters. So, we transform mouse coordinates into world coordinates using a method provided by the view class:*/
        Point mousePoint = e.getPoint();
        Vec2 worldPoint = view.viewToWorld(mousePoint);

        /*subtract coordinates for mouse position and position of the crab to compare the location of the two and if the difference between the two is less than the radius of the circle shape for the crab then, the mouse must be currently located inside the radius of the circle shape for the crab, in which case, a MousePressed and MouseReleased event should result in the removal of the Body object of class Enemies (crab1). Implement condition based on position of the mouse relative to the current position of the Body object with the use of an if statement. */
        Vec2 positionOfCrab = crab1.getPosition();

        if (Math.abs(worldPoint.x - positionOfCrab.x) < 1.5f && Math.abs(worldPoint.y - positionOfCrab.y) < 1.5f) {
            crab1.removeAllImages();
            crab1.addImage(new BodyImage("data/explosion.png", 3.5f));
        }
    }

        @Override
        public void mouseReleased(MouseEvent e) {
            /*get the coordinates of the mouse click - these are in pixels (the location in the window where the click happened). The mouse click needs to be added at *world* coordinates which are in meters. So, we transform mouse coordinates into world coordinates using a method provided by the view class:*/
            Point mousePoint = e.getPoint();
            Vec2 worldPoint = view.viewToWorld(mousePoint);

            /*subtract coordinates for mouse position and position of the crab to compare the location of the two and if the difference between the two is less than the radius of the circle shape for the crab then, the mouse must be currently located inside the radius of the circle shape for the crab, in which case, a MousePressed and MouseReleased event should result in the removal of the Body object of class Enemies (crab1). Implement condition based on position of the mouse relative to the current position of the Body object with the use of an if statement. */
            Vec2 positionOfCrab = crab1.getPosition();

            if (Math.abs(worldPoint.x - positionOfCrab.x) < 1.5f && Math.abs(worldPoint.y - positionOfCrab.y) < 1.5f) {
                crab1.removeAllImages();
                crab1.addImage(new BodyImage("data/explosion.png", 3.5f));
                crab1.destroy();
                swimmer.setCrabsDestroyedCount(1);
                }
            }


        @Override
        public void mouseEntered(MouseEvent e){
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

}
