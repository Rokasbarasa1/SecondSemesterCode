package UI;

import application.Formation;
import application.Match;
import application.MatchList;
import application.OurDate;
import application.Player;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainApp extends Application
{

   private ObservableList<Match> MatchData = FXCollections
         .observableArrayList();
   private ObservableList<Player> PlayerData = FXCollections
         .observableArrayList();
   
   private ObservableList<Formation> formationData = FXCollections
         .observableArrayList();
   private Stage primaryStage;
   private BorderPane rootLayout;

   public MainApp()
   {

      // Add some sample data
      OurDate date1 = new OurDate(2019, 5, 29);
      OurDate date2 = new OurDate(2019, 6, 27);
      OurDate date3 = new OurDate(2019, 6, 31);
      OurDate date4 = new OurDate(2010, 1, 5);

      System.out.println(date1.toString());
      System.out.println(date1.isAfterMatch());
      System.out.println(date2.toString());
      System.out.println(date2.isAfterMatch());
      System.out.println(date3.toString());
      System.out.println(date3.isAfterMatch());
      System.out.println(date4.toString());
      System.out.println(date4.isAfterMatch());

      Player p1 = new Player("Rokas", "Barasa", "1", "Striker", "Available");
      Player p2 = new Player("Ryan", "Rimkus", "8", "Middle", "Available");
      Player p3 = new Player("Roma", "Juodis", "4", "Goal Keeper", "Available");
      Player p4 = new Player("Jamie", "Rekasius", "9", "Striker", "Available");
      Player p5 = new Player("Lukas", "Drasutis", "3", "Middle", "Available");
      Player p6 = new Player("Rokas", "Anuzis", "10", "Striker", "Available");
      Player p7 = new Player("Mahmund", "Domarkas", "11", "Striker", "Available");
      Player p8 = new Player("Emmanuel", "Tekorius", "7", "Defender","Available");
      Player p9 = new Player("Rokas", "Adomaitis", "2", "Middle", "Available");
      Player p10 = new Player("Francesko", "Kuprelis", "5", "Middle","Available");
      Player p11 = new Player("Bartek", "Eglynas", "6", "Defender", "Available");
      
      PlayerData.add(p1);
      PlayerData.add(p2);
      PlayerData.add(p3);
      PlayerData.add(p4);
      PlayerData.add(p5);
      PlayerData.add(p6);
      PlayerData.add(p7);
      PlayerData.add(p8);
      PlayerData.add(p9);
      PlayerData.add(p10);
      PlayerData.add(p11);
      
      
      Formation greenBastards = new Formation("Sudai");
      Formation kakai = new Formation("Debilai");
      Formation durniai = new Formation("Kakuliai");

      ArrayList<Formation> forms = new ArrayList<Formation>();

      kakai.addPlayer(p1);
      kakai.addPlayer(p2);
      kakai.addPlayer(p3);
      kakai.addPlayer(p4);
      kakai.addPlayer(p5);
      kakai.addPlayer(p6);
      kakai.addPlayer(p7);
      kakai.addPlayer(p8);
      kakai.addPlayer(p9);
      kakai.addPlayer(p10);
      kakai.addPlayer(p11);

      durniai.addPlayer(p1);
      durniai.addPlayer(p2);
      durniai.addPlayer(p3);
      durniai.addPlayer(p4);
      durniai.addPlayer(p5);
      durniai.addPlayer(p6);
      durniai.addPlayer(p7);
      durniai.addPlayer(p8);
      durniai.addPlayer(p9);
      durniai.addPlayer(p10);
      durniai.addPlayer(p11);
      
      greenBastards.addPlayer(p1);
      greenBastards.addPlayer(p2);
      greenBastards.addPlayer(p3);
      greenBastards.addPlayer(p4);
      greenBastards.addPlayer(p5);
      greenBastards.addPlayer(p6);
      greenBastards.addPlayer(p7);
      greenBastards.addPlayer(p8);
      greenBastards.addPlayer(p9);
      greenBastards.addPlayer(p10);
      greenBastards.addPlayer(p11);
      
      formationData.add(kakai);
      formationData.add(durniai);
      formationData.add(greenBastards);
      
      
      Match match1 = new Match("Red Indians", date1, "Friendly", greenBastards,
            "Fenstad");
      Match match2 = new Match("Bundle sticks", date2, "Cup", greenBastards,
            "Bergen");
      Match match3 = new Match("Dumb Turtles", date3, "League", greenBastards,
            "Oslo");
      Match match4 = new Match("Chavs", date4, "Cup", greenBastards,
            "Jassheim");

      MatchList mlist = new MatchList();



      mlist.addMatch(match1);
      mlist.checkDates();
      p4.setPostion("Middle");
      mlist.addMatch(match2);
      mlist.checkDates();
      p4.setPostion("Defender");
      mlist.addMatch(match3);
      mlist.checkDates();
      p4.setPostion("Middle");
      mlist.addMatch(match4);
      mlist.checkDates();

      mlist.sortMatchesByDate();

      System.out.println(mlist.toString());
      mlist.checkDates();
      System.out.println(p4.getMostPlayedPosition());
      mlist.getMatch(1).hasMatchPassed();
      System.out.println(mlist.getMatch(1).getPastMatch());
      /*
       * ERRORS AFTER THIS
       */
      for (int i = 0; i < mlist.listSize(); i++)
      {
         MatchData.add(mlist.getMatch(i));
      }
      System.out.println(forms.size());
      mlist.checkDates();
      //System.out.println(new Integer(p1.getDateAvailable().getDay()).toString());
   }

   public void initRootLayout()
   {
      try
      {

         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(MainApp.class.getResource("RootLayout.fxml"));
         rootLayout = (BorderPane) loader.load();

         Scene scene = new Scene(rootLayout);
         primaryStage.setScene(scene);
         primaryStage.show();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }

   public void showMatchOverview()
   {
      try
      {

         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(MainApp.class.getResource("MainPage.fxml"));
         AnchorPane matchOverview = (AnchorPane) loader.load();

         rootLayout.setCenter(matchOverview);

         MatchController controller = loader.getController();
         controller.setMainApp(this);
         
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }

   public boolean showMatchEditDialog(Match match, Boolean nuw)
   {
      try
      {

         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(MainApp.class.getResource("NewMatch.fxml"));
         AnchorPane page = (AnchorPane) loader.load();
                  
         Stage dialogStage = new Stage();
         dialogStage.setTitle("Edit Person");
         dialogStage.initModality(Modality.WINDOW_MODAL);
         dialogStage.initOwner(primaryStage);
         Scene scene = new Scene(page);
         dialogStage.setScene(scene);
         
         
         // Set the person into the controller.
         AddMatchController controller = loader.getController();
         controller.setDialogStage(dialogStage);
         controller.setMainApp(this);
         controller.setPerson(match, nuw);

         
         // Show the dialog and wait until the user closes it
         dialogStage.showAndWait();
         System.out.println("THE SHOW MATCH EDIT DIALOG WORKED");
         return controller.isOkClicked();
      }
      catch (IOException e)
      {
         e.printStackTrace();
         return false;
      }
   }

   public void showFormation() {
      try {
         
         FXMLLoader loader = new FXMLLoader();
         loader.setLocation(MainApp.class.getResource("FormationsAndPlayers.fxml"));
        
         Stage dialogStage = new Stage();
         dialogStage.setTitle("Formations and Players");
         dialogStage.initModality(Modality.WINDOW_MODAL);
         dialogStage.initOwner(primaryStage);
         
         Scene scene = new Scene(loader.load());
         dialogStage.setScene(scene);
         
         
         AddFormationController controller = loader.getController();
         controller.setDialogStage(dialogStage);
         controller.setMainApp(this);
         
         dialogStage.showAndWait();
      }catch (Exception e) {
         System.out.println("error in show formation");
      }
   }
   public boolean showPlayerEditDialog(Player player, Boolean edit)
   {
      try
      {
         
         FXMLLoader loader = new FXMLLoader();
         System.out.println("About to scan fxml file");
         loader.setLocation(MainApp.class.getResource("NewPlayer.fxml"));
         System.out.println("Scan file worked");
         AnchorPane page = (AnchorPane) loader.load();
         
         System.out.println("Anchor load wokred");
         Stage dialogStage = new Stage();
         dialogStage.setTitle("Edit Person");
         dialogStage.initModality(Modality.WINDOW_MODAL);
         dialogStage.initOwner(primaryStage);
         Scene scene = new Scene(page);
         dialogStage.setScene(scene);
         System.out.println("set scene worked");
         
         // Set the person into the controller.
         AddPlayerController controller = loader.getController();
         controller.setDialogStage(dialogStage);
         controller.setPerson(player, edit);
         System.out.println("set person worked");

         
         // Show the dialog and wait until the user closes it
         dialogStage.showAndWait();
         System.out.println("THE SHOW MATCH EDIT DIALOG WORKED");
         return controller.isOkClicked();
      }
      catch (IOException e)
      {
         System.out.println("nit workind");
         return false;
      }
   }
   public ObservableList<Match> getMatchData()
   {
      return MatchData;
   }

   public ObservableList<Formation> getFormationData()
   {
      return formationData;
   }

   public ObservableList<Player> getPlayerData(){
      return PlayerData;
   }
   @Override
   public void start(Stage primaryStage)
   {
      this.primaryStage = primaryStage;
      this.primaryStage.setTitle("WElkom");

      initRootLayout();

      showMatchOverview();
   }

   public Stage getPrimaryStage()
   {
      return primaryStage;
   }

   public static void main(String[] args)
   {
      launch(args);
   }
}
