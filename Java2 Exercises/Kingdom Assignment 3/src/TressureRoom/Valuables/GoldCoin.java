package TressureRoom.Valuables;

public class GoldCoin implements Valuable{
    @Override
    public String getName() {
        return "GoldCoin";
    }

    @Override
    public int getValue() {
        return 10;
    }
}
