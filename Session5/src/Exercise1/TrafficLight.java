package Exercise1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TrafficLight implements Subject{
    private String[] lights = {"GREEN","YELLOW", "RED", "YELLOW"};
    private int count = 2;
    private String currentLight;

    private PropertyChangeSupport lightChangeSupport  = new PropertyChangeSupport(this);

    public TrafficLight(){
        currentLight = lights[2];
    }

    @Override
    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        lightChangeSupport.addPropertyChangeListener(name, listener);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        lightChangeSupport.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        lightChangeSupport.removePropertyChangeListener(name, listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        lightChangeSupport.removePropertyChangeListener(listener);
    }

    public void start() throws InterruptedException {
        String previous = "";
        for (int i = 0; i < 10; i++) {
            Thread.sleep(2000);
            count = (++count) % 4;
            currentLight = lights[count];
            System.out.println("\nLight is "+ currentLight);
            lightChangeSupport.firePropertyChange("LightsCHange", previous, currentLight);
        }
    }
}
