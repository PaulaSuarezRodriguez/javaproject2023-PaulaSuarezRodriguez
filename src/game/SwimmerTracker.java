package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class SwimmerTracker implements StepListener {

    private GameView view;
    private Swimmer swimmer;

    public SwimmerTracker(GameView view, Swimmer swimmer) {
        this.view = view;
        this.swimmer = swimmer;
    }

    public void preStep(StepEvent e) {
    }

    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(swimmer.getPosition()));
    }

    public void updateSwimmer(Swimmer newSwimmer) {
        swimmer = newSwimmer;
    }
}