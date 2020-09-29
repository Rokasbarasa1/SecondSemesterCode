package twentyFiveThousand;

import java.util.ArrayList;

public class Player {
    private ArrayList<Integer> dices;

    public Player(){
        this.dices = new ArrayList<Integer>(7);
    }
    public void startTurn(){
        for (int i = 0; i <= 7; i++) {
            int randomNum = 1 + (int)(Math.random() * 6);
            System.out.println( "Dice "+ i + " rolled " + randomNum);

            //dices.set(i, randomNum);
        }
        //System.out.println("The numbers of the dice are \nFirst dice " + dices.get(0) +"\nFirst dice "+ dices.get(1) +"\nFirst dice "+ dices.get(2) +
                //"\nFirst dice "+ dices.get(3) +"\nFirst dice "+ dices.get(4) +"\nFirst dice "+ dices.get(5) +"\nFirst dice "+ dices.get(6));

    }


}
