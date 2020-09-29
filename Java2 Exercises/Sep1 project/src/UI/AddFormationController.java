package UI;

import java.io.IOException;
import java.util.ArrayList;

import application.Formation;
import application.Match;
import application.OurDate;
import application.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AddFormationController
{
   
   @FXML
   private TableView<Player> allPlayers;

   @FXML
   private TableColumn<Player, String> namePerson;

   @FXML
   private TableColumn<Player, String> positionPerson;

   @FXML
   private TableColumn<Player, String> numberPerson;

   @FXML
   private TableColumn<Player, String> availabilityPerson;

   @FXML
   private TextField formationName;

   @FXML
   private ComboBox<String> formationsSelector;

   @FXML
   private TableView<Player> formationPlayers;

   @FXML
   private TableColumn<Player, String> formationNamePerson;

   @FXML
   private TableColumn<Player, String> formationPositionPerson;

   @FXML
   private TableColumn<Player, String> formationNumberPerson;

   @FXML
   private TableColumn<Player, String> fortmationAvailabilityPerson;

   private MainApp mainApp;
   private Stage dialogStage;
   private Match match;
   private ObservableList<Player> formationPlayerData = FXCollections
         .observableArrayList();
   
   public AddFormationController() {
   }
   
   public void setDialogStage(Stage dialogStage)
   {
      this.dialogStage = dialogStage;
   }
   
   public void setMainApp(MainApp mainApp) {
      this.mainApp = mainApp;
      
      ArrayList<String> formationNames = new ArrayList<String>();
      for (int i = 0; i < mainApp.getFormationData().size(); i++)
      {
         formationNames.add(mainApp.getFormationData().get(i).getFormationName());
         System.out.println("bump");
      }
      for (int i = 0; i < formationNames.size(); i++)
      {
         formationsSelector.getItems().add(formationNames.get(i));
      }
      
      allPlayers.setItems(mainApp.getPlayerData());
   }
   @FXML
   private void initialize() {
      namePerson.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
      positionPerson.setCellValueFactory(cellData -> cellData.getValue().getPostionProperty());
      numberPerson.setCellValueFactory(cellData -> cellData.getValue().getNumberProperty());
      availabilityPerson.setCellValueFactory(cellData -> cellData.getValue().getAvailabilityProperty());
      
      formationNamePerson.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
      formationPositionPerson.setCellValueFactory(cellData -> cellData.getValue().getPostionProperty());
      formationNumberPerson.setCellValueFactory(cellData -> cellData.getValue().getNumberProperty());
      fortmationAvailabilityPerson.setCellValueFactory(cellData -> cellData.getValue().getAvailabilityProperty());
      
   }
   
   @FXML
   void handleDeleteFormation(ActionEvent event) {
      int index = -1;
      formationPlayers.getItems().clear();
      for (int i = 0; i < mainApp.getFormationData().size(); i++)
      {
         System.out.println(mainApp.getFormationData().get(i).getFormationName());
         System.out.println(formationsSelector.getValue());
         
         if (mainApp.getFormationData().get(i).getFormationName()
               .equals(formationsSelector.getValue()))
         {
            System.out.println("Good worked");
            index = i;
            break;
         }
      }
      
      mainApp.getFormationData().remove(index);
      
      formationsSelector.getItems().remove(mainApp.getFormationData().get(index).getFormationName());
      formationPlayers.getItems().clear();
      formationName.setText("");
      
   }

   @FXML
   void handleDeletePlayer(ActionEvent event) {
      int selectedIndex = allPlayers.getSelectionModel().getSelectedIndex();
      allPlayers.getItems().remove(selectedIndex);
   }

   @FXML
   void handleEditPlayer(ActionEvent event) {
      Player selectedPerson = allPlayers.getSelectionModel().getSelectedItem();
      System.out.println("handleNewMatch wroked somewhat dasdasdas------------------***************************************");
      if (selectedPerson != null)
      {
         boolean okClicked = mainApp.showPlayerEditDialog(selectedPerson, true);

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

   @FXML
   void handleGoBack(ActionEvent event) {
      dialogStage.close();
   }

   @FXML
   void handleNewFormation(ActionEvent event) {
      Formation formation = new Formation("Temp");
      mainApp.getFormationData().add(formation);
      formationsSelector.getItems().add("Temp");
      formationName.setText("Temp");
      formationsSelector.setValue(formation.getFormationName());
      handleLoad();
      
   }

   @FXML
   void handleNewPlayer(ActionEvent event) {
      Player tempPlayer = new Player();
      System.out.println("handleNewMatch wroked somewhat dasdasdas------------------***************************************");
      boolean okClicked = mainApp.showPlayerEditDialog(tempPlayer, false);
      System.out.println("show dialog worked");
      if (okClicked)
      {
         mainApp.getPlayerData().add(tempPlayer);
      }
   }

   @FXML
   void handleSave(ActionEvent event) {
      int index = 0;
      for (int i = 0; i < mainApp.getFormationData().size(); i++)
      {
         if (mainApp.getFormationData().get(i).getFormationName()
               .equals(formationsSelector.getValue()))
         {
            System.out.println("Good worked");
            index = i;
            break;
         }
      }
      
      mainApp.getFormationData().get(index).setFormationName(formationName.getText());
      
      
   }
   @FXML
   void AddPlayerToFormation(ActionEvent event) {
      int selectedIndex = allPlayers.getSelectionModel().getSelectedIndex();
      
      int index = 0;
      for (int i = 0; i < mainApp.getFormationData().size(); i++)
      {
         if (mainApp.getFormationData().get(i).getFormationName()
               .equals(formationsSelector.getValue()))
         {
            System.out.println("good works");
            index = i;
            break;
         }
      }
      System.out.println("good ");
      Player nuew = mainApp.getPlayerData().get(selectedIndex);
      System.out.println("good ");
      mainApp.getFormationData().get(index).addPlayer(nuew);
      formationPlayers.getItems().add(nuew);
      formationPlayers.setItems(formationPlayerData);
   }

   @FXML
   void RemovePlayerFromFromation(ActionEvent event) {
      int selectedIndex = formationPlayers.getSelectionModel().getSelectedIndex();
      formationPlayers.getItems().remove(selectedIndex);
      
   }
   
   @FXML
   void handleLoadFormation(ActionEvent event) {
      handleLoad();
   }
   public void handleLoad() {
      int index = -1;
      formationPlayers.getItems().clear();
      for (int i = 0; i < mainApp.getFormationData().size(); i++)
      {
         System.out.println(mainApp.getFormationData().get(i).getFormationName());
         System.out.println(formationsSelector.getValue());
         
         if (mainApp.getFormationData().get(i).getFormationName()
               .equals(formationsSelector.getValue()))
         {
            System.out.println("Good worked");
            index = i;
            break;
         }
      }
      
      for (int i = 0; i < mainApp.getFormationData().get(index).getFormationSize(); i++)
      {
         formationPlayerData.add(mainApp.getFormationData().get(index).getPlayer(i));
      }
      System.out.println("Good");
      formationPlayers.setItems(formationPlayerData);
      
      formationName.setText(mainApp.getFormationData().get(index).getFormationName());
   }
   
}
