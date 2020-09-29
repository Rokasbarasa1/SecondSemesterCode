package TressureRoom.Valuables;

public class Cow implements Valuable {
    @Override
    public String getName() {
        return "Cow";
    }

    @Override
    public int getValue() {
        return 5;
    }
}
