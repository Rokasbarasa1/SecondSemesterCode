package Exercise2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WaitingRoom implements Subject{

    private int counter ;


    private PropertyChangeSupport patientChangeSupport  = new PropertyChangeSupport(this);

    public WaitingRoom(int counter){
        this.counter = 0;
    }

    @Override
    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        patientChangeSupport.addPropertyChangeListener(name, listener);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        patientChangeSupport.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        patientChangeSupport.removePropertyChangeListener(name, listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        patientChangeSupport.removePropertyChangeListener(listener);
    }

    public void start() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            counter++;
            System.out.println("DING!!!");
            patientChangeSupport.firePropertyChange("NextPatient", counter--, counter);
        }
    }
}
