package UI;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;

import java.math.MathContext;

import application.Match;
import application.OurDate;;


public class MatchController {
	
   @FXML
   private TableView<Match> matchTable;
   @FXML
   private TableColumn<Match, String> matchAgainst;
   @FXML
   private TableColumn<Match, String> matchType;
   @FXML
   private TableColumn<Match, OurDate> matchDate;
   @FXML
   private TableColumn<Match, String> matchLocation;
   @FXML
   private TableColumn<Match, String> matchFormation;
   @FXML
   private TableColumn<Match, Boolean> matchPassed;

   private MainApp mainApp;

   public  MatchController()
   {
   }
   @FXML
   private void handleGoToFormations() {
      System.out.println("sdasdasddasdasdasda");
      mainApp.showFormation();
   }
   
   @FXML
   private void initialize() {
      matchAgainst.setCellValueFactory(cellData -> cellData.getValue().getPlayingAgainstProperty());
      matchType.setCellValueFactory(cellData -> cellData.getValue().getMatchTypeProperty());
      matchDate.setCellValueFactory(cellData -> cellData.getValue().getDateProperty());
      matchLocation.setCellValueFactory(cellData -> cellData.getValue().getLocationProperty());
      matchFormation.setCellValueFactory(cellData -> cellData.getValue().getFormation().getFormationNameProperty());
      matchPassed.setCellValueFactory(cellData -> cellData.getValue().getPastMatchProperty());

   }
   
   public void setMainApp(MainApp mainApp) {
      this.mainApp = mainApp;

      matchTable.setItems(mainApp.getMatchData());
   }
   @FXML
   private void handleDeleteMatch() {
      int selectedIndex = matchTable.getSelectionModel().getSelectedIndex();
      matchTable.getItems().remove(selectedIndex);
   }

   @FXML
   private void handleNewMatch()
   {
      Match tempMatch = new Match();
      System.out.println("handleNewMatch wroked somewhat dasdasdas------------------***************************************");
      boolean okClicked = mainApp.showMatchEditDialog(tempMatch, false);
      if (okClicked)
      {
         mainApp.getMatchData().add(tempMatch);
      }
   }

   @FXML
   private void handleEditMatch()
   {
      Match selectedPerson = matchTable.getSelectionModel().getSelectedItem();
      System.out.println("handleNewMatch wroked somewhat dasdasdas------------------***************************************");
      if (selectedPerson != null)
      {
         boolean okClicked = mainApp.showMatchEditDialog(selectedPerson, true);

      }
      else
      {
         // Nothing selected.
         Alert alert = new Alert(AlertType.WARNING);
         alert.initOwner(mainApp.getPrimaryStage());
         alert.setTitle("No Selection");
         alert.setHeaderText("No Person Selected");
         alert.setContentText("Please select a person in the table.");

         alert.showAndWait();
      }
   }

}
