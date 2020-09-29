package Exercise1;

import java.beans.PropertyChangeEvent;

public class Taxi {
    private String previousLight;
    private int id;
    public Taxi(int id, Subject subject){
        this.id = id;
        subject.addPropertyChangeListener(evt -> lightChanged(evt));
    }

    public void lightChanged(PropertyChangeEvent evt){

        if("GREEN".equals(evt.getNewValue())){
            System.out.println("Taxi " + id+ " drives");
        } else if("YELLOW".equals(evt.getNewValue())) {
            System.out.println("Taxi " + id+ " drives");
        } else if("RED".equals(evt.getNewValue())){
            System.out.println("Taxi " + id+ " stops");
        }
        previousLight = (String) evt.getNewValue();
    }
}
