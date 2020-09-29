package Exercise1;

import java.beans.PropertyChangeEvent;

public class Car {
    private String previousLight;
    private int id;
    public Car(int id, Subject subject){
        this.id = id;
        subject.addPropertyChangeListener(evt -> lightChanged(evt));
    }

    public void lightChanged(PropertyChangeEvent evt){

        if("GREEN".equals(evt.getNewValue())){
            System.out.println("Car " + id+ " drives");
        } else if("YELLOW".equals(evt.getNewValue())) {
            if("RED".equals(previousLight)){
                System.out.println("Car " + id+ " starts engine");
            } else{
                System.out.println("Car " + id+ " slows down");
            }
        } else if("RED".equals(evt.getNewValue())){
            System.out.println("Car " + id+ " stops");
        }
        previousLight = (String) evt.getNewValue();
    }
}
