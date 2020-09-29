package Exercise1;

import java.beans.PropertyChangeEvent;

public class SleepyDriver {
    private String previousLight;
    private int id;
    public SleepyDriver(int id, Subject subject){
        this.id = id;
        subject.addPropertyChangeListener(evt -> lightChanged(evt));
    }

    public void lightChanged(PropertyChangeEvent evt){

        if("GREEN".equals(evt.getNewValue())){
            System.out.println("Sleepy driver " + id+ "starts engine and drives");
        } else if("YELLOW".equals(evt.getNewValue())) {
            if("RED".equals(previousLight)){
                System.out.println("Sleepy driver " + id+ " sits");
            } else{
                System.out.println("Sleepy driver " + id+ " slows down");
            }
        } else if("RED".equals(evt.getNewValue())){
            System.out.println("Sleepy driver " + id+ " stops");
        }
        previousLight = (String) evt.getNewValue();
    }
}
