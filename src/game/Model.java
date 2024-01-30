/*package game;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.LinkedList;
import java.util.List;

public class Model {
    /**
     * An abstract model, propagating changes to ChangeListeners.
     * This class is intended to be extended with a class containing actual data.
     */
    /**
     * List of listeners to be notified of any change to the model.
     */
  /*  private List<ChangeListener> listeners;

    /**
     * Initialize a model with no listeners.
     */
  /*  public Model() {
        this.listeners = new LinkedList<ChangeListener>();
    }

    /**
     * Register a listener to be notifed whenever the model changes.
     *
     * @param listener the listener to add
     */
  /*  public void addChangeListener(ChangeListener l) {
        listeners.add(l);
    }

    /**
     * Unregister a change listener.
     * Does nothing if the listener is not registered.
     *
     * @param l the listener to remove
     */
   /* public void removeChangeListener(ChangeListener l) {
        listeners.remove(l);
    }

    /**
     * Notify all listeners that the model has changed.
     * This method should be called by any method of a child class that
     * modifies the child data.
     */
  /*  protected void changed() {
        ChangeEvent e = new ChangeEvent(this);
        for (ChangeListener l : listeners) {
            l.stateChanged(e);
        }
    }
} */

