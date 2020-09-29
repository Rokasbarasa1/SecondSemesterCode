package application;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;


public class Match
{
   //DONE
   private StringProperty  playingAgainst;
   private ObjectProperty<OurDate> date;
   private StringProperty  matchType;
   private ObjectProperty<Formation> formation;
   private StringProperty  location;
   private BooleanProperty pastMatch;
   private StringProperty  score;

   /**
    * Constructor sets match details
    * 
    * @param playingAgainst
    * @param date
    * @param matchType
    * @param formation
    * @param location
    * @param pastMatch
    * @param score
    */
   public Match(String playingAgainst, OurDate date, String matchType, Formation formation, String location, Boolean pastMatch, String score)
   {
      this.playingAgainst = new SimpleStringProperty(playingAgainst);
      this.date = new SimpleObjectProperty<OurDate>(date);
      this.matchType = new SimpleStringProperty(matchType);
      this.formation = new SimpleObjectProperty<Formation>(formation);
      this.location = new SimpleStringProperty(location);
      this.pastMatch = new SimpleBooleanProperty(pastMatch);
      this.score = new SimpleStringProperty(score);
   }

   /**
    * Constructor sets match details
    * 
    * @param playingAgainst
    * @param date
    * @param matchType
    * @param formation
    * @param location
    */
   public Match(String playingAgainst, OurDate date, String matchType, Formation formation, String location)
   {
      this.playingAgainst = new SimpleStringProperty(playingAgainst);
      this.date = new SimpleObjectProperty<OurDate>(date);
      this.matchType = new SimpleStringProperty(matchType);
      this.formation = new SimpleObjectProperty<Formation>(formation);
      this.location = new SimpleStringProperty(location);
   }
 
   /**
    * Constructor sets match details without parameters
    * 
    */
   public Match() {
   }

   /**
    * methode to get opponent
    * 
    * @return
    */
   public String getPlayingAgainst()
   {
      return playingAgainst.get();
   }
   
   /**
    * methode to get opponent
    * 
    * @return
    */
   public StringProperty getPlayingAgainstProperty()
   {
      return playingAgainst;
   }

   /**
    * methode to set opponent
    * 
    * @param playingAgainst
    */
   public void setPlayingAgainst(String playingAgainst)
   {
      this.playingAgainst = new SimpleStringProperty(playingAgainst);
   }

   /**
    * methode for getting match date
    * 
    * @return
    */
   public OurDate getDate()
   {
      return date.get();
   }

   /**
    * methode for getting date object from OurDate
    * 
    * @return
    */
   public ObjectProperty<OurDate> getDateProperty()
   {
      return date;
   }

   /**
    * methode for setting date object by OurDate
    * 
    * @param date
    */
   public void setDate(OurDate date)
   {
      this.date = new SimpleObjectProperty<OurDate>(date);
   }
   
   /**
    * methode for getting match type
    * 
    * @return
    */
   public StringProperty getMatchTypeProperty()
   {
      return matchType;
   }
 
   /**
    * methode for getting match type
    * 
    * @return
    */
   public String getMatchType()
   {
      return matchType.get();
   }

   /**
    * methode for setting match type
    * 
    * @param matchType
    */
   public void setMatchType(String matchType)
   {
      this.matchType = new SimpleStringProperty(matchType);
   }

   /**
    * methode for getting match formation
    * 
    * @return
    */
   public Formation getFormation()
   {
      return formation.get();
   }
   
   /**
    * methode for getting match formation object
    * 
    * @return
    */
   public ObjectProperty<Formation> getFormationProperty()
   {
      return formation;
   }

   /**
    * methode for creating a new formation
    * 
    * @param formation
    */
   public void setFormation(Formation formation)
   {
      this.formation = new SimpleObjectProperty<Formation>(formation);
   }

   /**
    * methode for getting match location
    * 
    * @return
    */
   public String getLocation()
   {
      return location.get();
   }

   /**
    * methode for getting match location
    * 
    * @return
    */
   public StringProperty getLocationProperty()
   {
      return location;
   }
 
   /**
    * methode for setting match location 
    * 
    * @param location
    */
   public void setLocation(String location)
   {
      this.location = new SimpleStringProperty(location);
   }

   /**
    * methode for getting match score
    * 
    * @return
    */
   public String getScore()
   {
      return score.get();
   }
  
   /**
    * methode for getting match score
    * 
    * @return
    */
   public StringProperty getScoreProperty()
   {
      return score;
   }

   /**
    * methode for setting match score
    * 
    * @param score
    */
   public void setScore(String score)
   {
      this.score = new SimpleStringProperty(score);
   }

   /**
    * methode for check if match has passed
    * 
    */
   public void hasMatchPassed()
   {
      if (getDate().isAfterMatch())
      {
         pastMatch = new SimpleBooleanProperty(true);
         for (int i = 0; i < getFormation().getFormationSize(); i++)
         {
            getFormation().getPlayer(i).matchEnded();
         }
      }
      else
      {
         pastMatch = new SimpleBooleanProperty(false);
      }
   }
  
   /**
    * methode for getting passed matches
    * 
    * @return
    */
   public boolean getPastMatch() {
      return pastMatch.get();
   }

   /**
    * methode for getting passed matches
    * 
    * @return
    */
   public BooleanProperty getPastMatchProperty() {
      return pastMatch;
   }
 
   /**
    * toString methode to get a string with match information
    * 
    */
   public String toString() {
      return playingAgainst + " " + date.toString() + "\n" + formation.toString();
   }
}
