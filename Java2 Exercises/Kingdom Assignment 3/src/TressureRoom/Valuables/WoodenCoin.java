package TressureRoom.Valuables;

import TressureRoom.Valuables.Valuable;

public class WoodenCoin implements Valuable {
    @Override
    public String getName() {
        return "WoodenCoin";
    }

    @Override
    public int getValue() {
        return 1;
    }
}
