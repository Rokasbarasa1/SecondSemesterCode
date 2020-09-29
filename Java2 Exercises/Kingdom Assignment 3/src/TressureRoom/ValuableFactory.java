package TressureRoom;

import TressureRoom.Valuables.*;

import java.util.HashMap;

public class ValuableFactory {
    static HashMap<String, Valuable> valuables = new HashMap<>();
    public static Valuable getValuable(String valuableType){
        Valuable valuable = valuables.get(valuableType);
        if(valuable == null){
            switch (valuableType){
                case "Diamond": {
                    valuable = new Diamond();
                    break;
                }
                case "Cow": {
                    valuable = new Cow();
                    break;
                }
                case "GoldCoin": {
                    valuable = new GoldCoin();
                    break;
                }
                case "Jewel": {
                    valuable = new Jewel();
                    break;
                }
                case "Ruby": {
                    valuable = new Ruby();
                    break;
                }
                case "WoodenCoin": {
                    valuable = new WoodenCoin();
                    break;
                }
            }
            valuables.put(valuableType,valuable);
        }
        return valuable;
    }
}
