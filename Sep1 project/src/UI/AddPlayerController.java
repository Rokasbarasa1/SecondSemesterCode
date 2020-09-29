package UI;

import application.Match;
import application.OurDate;
import application.Player;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class AddPlayerController{
	 
   
   @FXML
   private TextField playerName;

   @FXML
   private TextField playerLastName;

   @FXML
   private TextField playerNumber;

   @FXML
   private RadioButton goalKeeper;

   @FXML
   private ToggleGroup sdsdf;
   
   @FXML
   private RadioButton defense;

   @FXML
   private RadioButton middle;

   @FXML
   private RadioButton front;

   @FXML
   private TextField playerDay;

   @FXML
   private TextField playerMonth;

   @FXML
   private TextField playerYear;
   
   @FXML
   private RadioButton available;

   @FXML
   private ToggleGroup kjkk;

   @FXML
   private RadioButton injured;

   @FXML
   private RadioButton suspended;

   
   private Stage dialogStage;
   private Player person;
   private boolean okClicked = false;
   private MainApp mainApp;

   @FXML
   private void initialize()
   {
   }

   public void setDialogStage(Stage dialogStage)
   {
      this.dialogStage = dialogStage;
   }

   public void setPerson(Player person, Boolean editPlayer)
   {
      try {
      this.person = person;
      if(editPlayer) {
         
         playerName.setText(person.getName());
         playerLastName.setText(person.getLastName());
         playerNumber.setText(person.getNumber());
         try {
         playerDay.setText(Integer.toString(person.getDate().getDay()));
         playerDay.setText(Integer.toString(person.getDate().getDay()));
         playerDay.setText(Integer.toString(person.getDate().getDay()));
         }catch (Exception e) {
            System.out.println("PLayer is available so it doesnt have a ");
         }
         
         if(person.getPostion().equals("Goal Keeper"))
            goalKeeper.setSelected(true);
         else if(person.getPostion().equals("Defense"))
            defense.setSelected(true);
         else if(person.getPostion().equals("Middle"))
            middle.setSelected(true);
         else
            front.setSelected(true);
         System.out.println("position got");
         if(person.getAvailability().equals("Available"))
            available.setSelected(true);
         else if(person.getAvailability().equals("Injured"))
            injured.setSelected(true);
         else if(person.getAvailability().equals("Suspended"))
            suspended.setSelected(true);
         System.out.println("availability got");
         System.out.println("works");
      }
      }catch (Exception e) {
         // TODO: handle exception
         e.printStackTrace(); 
      }
   }

   public boolean isOkClicked()
   {
      return okClicked;
   }

   @FXML
   private void handleOk()
   {
      if (/* isInputValid() */true)
      {
         System.out.println("entered handle ok");
         person.setName(playerName.getText());
         person.setLastName(playerLastName.getText());
         person.setNumber(playerNumber.getText());
         
         if(available.isSelected())
            person.setAvailability("Available");
         else if(injured.isSelected())
            person.setAvailability("Injured");
         else if(suspended.isSelected())
            person.setAvailability("Suspended");
         
         if(goalKeeper.isSelected())
            person.setPostion("Goal Keeper");
         else if(defense.isSelected())
            person.setPostion("Defense");
         else if(middle.isSelected())
            person.setAvailability("Middle");
         else
            person.setPostion("Front");
         
         okClicked = true;
         dialogStage.close();
      }
   }

   @FXML
   private void handleCancel()
   {
      dialogStage.close();
   }
}
