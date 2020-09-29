package Exercise1;

import java.beans.PropertyChangeEvent;

public class Pedestrian {
    private String previousLight;
    private int id;
    public Pedestrian(int id, Subject subject){
        this.id = id;
        subject.addPropertyChangeListener(evt -> lightChanged(evt));
    }

    public void lightChanged(PropertyChangeEvent evt){

        if("GREEN".equals(evt.getNewValue())){
            System.out.println("Pedestrian " + id+ " waits");
        } else if("YELLOW".equals(evt.getNewValue())) {
            if("RED".equals(previousLight)){
                System.out.println("Pedestrian " + id+ " runs faster accross");
            } else{
                System.out.println("Pedestrian " + id+ " gets ready to cross");
            }
        } else if("RED".equals(evt.getNewValue())){
            System.out.println("Pedestrian " + id+ " crosses");
        }
        previousLight = (String) evt.getNewValue();
    }
}
