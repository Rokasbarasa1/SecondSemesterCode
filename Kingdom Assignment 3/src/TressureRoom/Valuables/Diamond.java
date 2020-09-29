package TressureRoom.Valuables;

public class Diamond implements Valuable {
    @Override
    public String getName() {
        return "Diamond";
    }

    @Override
    public int getValue() {
        return 25;
    }
}
