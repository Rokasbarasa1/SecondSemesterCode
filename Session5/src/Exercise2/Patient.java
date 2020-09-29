package Exercise2;

import java.beans.PropertyChangeEvent;

public class Patient {
    private int ticketNumber;
    private boolean wasInRoom = false;
    public Patient(int ticketNumber, Subject subject){
        this.ticketNumber = ticketNumber;
        subject.addPropertyChangeListener(evt -> DoorOpened(evt));
    }

    public void DoorOpened(PropertyChangeEvent evt){
        if(!wasInRoom){
            System.out.println("Patient " + ticketNumber+ " looks up");
            if(ticketNumber == (int) evt.getNewValue()){
                System.out.println("Patient " + ticketNumber+ " enters room");
                wasInRoom = true;
            }
            else{
                System.out.println("looks back at phone");
            }
        }
    }

}
