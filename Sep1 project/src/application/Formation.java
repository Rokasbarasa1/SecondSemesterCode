package application;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Formation
{
   // DONE
   private  StringProperty FormationName;
   private ArrayList<Player> players  = new ArrayList<Player>(11);
   public Formation(String name)
   {
      this.FormationName = new SimpleStringProperty(name);
   }
   public Formation() {}
   public void addPlayer(Player player) {
      players.add(player);
   }
   public void deletePlayer(Player player) {
      players.remove(player);
   }
   public Player getPlayer(int index) {
      return players.get(index);
   }
   public void setFormationName(String formation) { }
   public String getFormationName() {
      return FormationName.get();
   }
   public StringProperty  getFormationNameProperty() {
      return FormationName;
   }
   public int getFormationSize() {
      return players.size();
   }
   public String toString() {
      String output = "";
      for (int i = 0; i < players.size(); i++)
      {
         output += "     " + players.get(i).toString() + "\n";
      }
      return output;
   }
}
