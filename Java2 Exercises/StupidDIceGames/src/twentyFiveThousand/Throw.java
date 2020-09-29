package twentyFiveThousand;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Throw {
    private ArrayList<Dice> dices;

    public Throw(){
        this.dices = new ArrayList<Dice>(7);
    }
    public void startTurn(){
        for (int i = 0; i <= 7; i++) {
            int randomNum = 1 + (int)(Math.random() * 6);
            dices.get(i).setEyeValue() = randomNum;
            System.out.println( "Dice "+ i + " rolled " + randomNum);
        }
        System.out.println("The numbers of the dice are \nFirst dice " + dices.get(0).getEyeValue() +"\nFirst dice "+ dices.get(1).getEyeValue() +"\nFirst dice "+ dices.get(2).getEyeValue() +
        "\nFirst dice "+ dices.get(3).getEyeValue() +"\nFirst dice "+ dices.get(4).getEyeValue() +"\nFirst dice "+ dices.get(5).getEyeValue() +"\nFirst dice "+ dices.get(6).getEyeValue());

    }

    public void keepDice(string i) {
        for (int j = 0; j < 7; j++) {
            if(dices.get(j).diceName.equals(i)){
                dices.get(j).throwAgain(false);
                break;
            }
        }
        System.out.println("Dice " + i + " is now put aside");
    }

    public void unkeepDice(String i){
        for (int j = 0; j < 7; j++) {
            if(dices.get(j).diceName.equals(i)){
                dices.get(j).throwAgain(true);
                break;
            }
        }
        System.out.println("Dice " + i + " is now put back into the rollable section");
    }

}
