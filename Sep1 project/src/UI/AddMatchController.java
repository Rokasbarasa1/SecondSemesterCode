package UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

import application.Formation;
import application.Match;
import application.OurDate;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;

public class AddMatchController
{
   @FXML
   private TextField DateAddM;
   @FXML
   private TextField YearAddM;
   @FXML
   private TextField MonthAddM;
   @FXML
   private TextField LocationAddM;
   @FXML
   private TextField OpponentAddM;

   @FXML
   private RadioButton LeagueMatch;
   @FXML
   private RadioButton CupMatch;
   @FXML
   private RadioButton FriendlyMatch;

   @FXML
   private Button toMainPage;
   @FXML
   private Button AddAMatch;
   @FXML
   private ComboBox<String> BoxOfFormations;

   private ObservableList<Formation> formsss;
   private Stage dialogStage;
   private Match match;
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
   public void setMainApp(MainApp mainApp) {
      this.mainApp = mainApp;
   }
   public void setPerson(Match match, boolean isItNotNew)
   {
      this.match = match;
      
      ArrayList<String> formationNames = new ArrayList<String>();
      for (int i = 0; i < mainApp.getFormationData().size(); i++)
      {
         formationNames.add(mainApp.getFormationData().get(i).getFormationName());
         System.out.println("bump");
      }
      for (int i = 0; i < formationNames.size(); i++)
      {
         BoxOfFormations.getItems().add(formationNames.get(i));
      }
      
      if(isItNotNew) {
         
         DateAddM.setText(Integer.toString(match.getDate().getDay()));
         YearAddM.setText(Integer.toString(match.getDate().getYear()));
         MonthAddM.setText(Integer.toString(match.getDate().getMonth()));
         
         LocationAddM.setText(match.getLocation());
         OpponentAddM.setText(match.getPlayingAgainst());

      
         if (match.getMatchType().equals("League"))
            LeagueMatch.setSelected(true);
         if (match.getMatchType().equals("Cup"))
            CupMatch.setSelected(true);
         else
            FriendlyMatch.setSelected(true);
         
         
         
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
         match.setLocation(LocationAddM.getText());
         match.setPlayingAgainst(OpponentAddM.getText());
         if (LeagueMatch.isSelected())
         {
            match.setMatchType("League");
         }
         else if (CupMatch.isSelected())
         {
            match.setMatchType("Cup");
         }
         else
         {
            match.setMatchType("Friendly");
         }
         match.setDate(new OurDate(Integer.parseInt(YearAddM.getText()),Integer.parseInt(MonthAddM.getText()),Integer.parseInt(DateAddM.getText())));
         System.out.println("setting done, formation left");
         int index = 0;
         for (int i = 0; i < mainApp.getFormationData().size(); i++)
         {
            if (mainApp.getFormationData().get(i).getFormationName()
                  .equals(BoxOfFormations.getValue()))
            {
               index = i;
               break;
            }
         }

         match.setFormation(mainApp.getFormationData().get(index));

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
