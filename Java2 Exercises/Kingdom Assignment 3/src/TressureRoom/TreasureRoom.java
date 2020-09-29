package TressureRoom;

import TressureRoom.Valuables.Valuable;

import java.util.ArrayList;

public class TreasureRoom {
    private ArrayList<Valuable> valuables;

    public TreasureRoom(){
        this.valuables = new ArrayList<>(1000);
    }

    public void addValue(Valuable thing){
        valuables.add(thing);
    }

    public Valuable getValuable(int index){
        try {
            return valuables.get(index);
        } catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    public Valuable removeValuable(int index ){
            return valuables.remove(index);
    }

    public int size(){
        return valuables.size();
    }
}
