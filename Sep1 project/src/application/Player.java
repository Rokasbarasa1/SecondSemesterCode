package application;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Player
{
   private StringProperty name;
   private StringProperty lastName;
   private StringProperty number;
   private StringProperty postion;
   private StringProperty availability;
   private ObjectProperty<OurDate> dateWhenAvailable;
   private ArrayList<String> pastPositions = new ArrayList<String>(10);
   private StringProperty mostPlayedPosition;

   public Player(String name, String lastName, String number, String postion, String availability, OurDate dateWhenAvailable)
   {
      this.name = new SimpleStringProperty(name);
      this.lastName = new SimpleStringProperty(lastName);
      this.number = new SimpleStringProperty(number);
      this.postion = new SimpleStringProperty(postion);
      this.availability = new SimpleStringProperty(availability);
      this.dateWhenAvailable = new SimpleObjectProperty<OurDate>(dateWhenAvailable);
   }
   /**
    * Constructor sets player details
    * 
    * @param name
    * @param lastName
    * @param number
    * @param postion
    * @param availability
    */
   public Player(String name, String lastName, String number, String postion, String availability)
   {
      this.name = new SimpleStringProperty(name);
      this.lastName = new SimpleStringProperty(lastName);
      this.number = new SimpleStringProperty(number);
      this.postion = new SimpleStringProperty(postion);
   }
   /**
    * Constructor sets name of player
    * 
    * @param name
    * @param lastName
    */
   public Player(String name, String lastName)
   {
      this.name = new SimpleStringProperty(name);
      this.lastName = new SimpleStringProperty(lastName);
   }
   
   public Player() {
      
   }
   /**
    * methode for getting first name
    * 
    * @return
    */
   public String getName()
   {
      return name.get();
   }
   /**
    * methode for getting first name of player
    * 
    * @return
    */
   public StringProperty getNameProperty()
   {
      return name;
   }
   /**
    * methode for setting first name of player
    * 
    * @param name
    */
   public void setName(String name)
   {
      this.name = new SimpleStringProperty(name);
   }
   /**
    * methode for getting last name of player
    * 
    * @return
    */
   public String getLastName()
   {
      return lastName.get();
   }
   /**
    * methode for getting last name of player
    * 
    * @return
    */
   public StringProperty getLastNameProperty()
   {
      return lastName;
   }
   /**
    * methode for setting last name of player
    * 
    * @param lastName
    */
   public void setLastName(String lastName)
   {
      this.lastName = new SimpleStringProperty(lastName);
   }
   /**
    * methode for getting player number
    * 
    * @return
    */
   public String getNumber()
   {
      return number.get();
   }
   /**
    * methode for getting player number
    * 
    * @return
    */
   public StringProperty getNumberProperty()
   {
      return number;
   }
   /**
    * methode for setting player number
    * 
    * @param number
    */
   public void setNumber(String number)
   {
      this.number = new SimpleStringProperty(number);
   }
   /**
    * methode for getting player position
    * 
    * @return
    */
   public String getPostion()
   {
      return postion.get();
   }
   /**
    * methode for getting player position 
    * 
    * @return
    */
   public StringProperty getPostionProperty()
   {
      return postion;
   }
   /**
    * methode for setting player position
    * 
    * @param postion
    */
   public void setPostion(String postion)
   {
      this.postion = new SimpleStringProperty(postion);
   }
   /**
    * methode for check about availability
    * 
    * @return
    */
   public String getAvailability()
   {
      return availability.get();
   }
   /**
    * methode for check about availability
    * 
    * @return
    */
   public StringProperty getAvailabilityProperty()
   {
      return availability;
   }
   /**
    * methode for setting availability
    * 
    * @param availability
    */
   public void setAvailability(String availability ) {
      this.availability = new SimpleStringProperty(availability);
   }
   /**
    * methode for check date for availability
    * 
    * @return
    */
   public OurDate getDate()
   {
      return dateWhenAvailable.get();
   }
   /**
    * methode for check about availability by using OurDate
    * 
    * @return
    */
   public ObjectProperty<OurDate> getDateAvailableProperty() {
      return dateWhenAvailable;
   }
   /**
    * methode for setting a date for availability
    * 
    * @param date
    */
   public void setDateAvailable(OurDate date) {
      dateWhenAvailable = new SimpleObjectProperty<OurDate>(date);
   }
   /**
    * toString methode for getting player info as a string
    * 
    */
   public String toString()
   {
      return name + ";" + lastName + ";" + number + ";" + postion;
   }
   /**
    * methodt to check for most played position
    * 
    */
   public void matchEnded() {
      pastPositions.add(postion.get());
      UpdateMostPlayed();
      
   }
   /**
    * methode for sorting players most played position
    * 
    */
   public void UpdateMostPlayed() {
      int biggestCount = 0;
      int indexOfPosition = 0;
      for (int i = 0; i < pastPositions.size(); i++)
      {
         int count = 0;;
         for (int j = 0; j < pastPositions.size(); j++)
         {
            if(pastPositions.get(i).equals(pastPositions.get(j)))
               count++;
         }
         if(biggestCount < count)
            indexOfPosition = i;
      }
      mostPlayedPosition = new SimpleStringProperty(pastPositions.get(indexOfPosition));
   }
   /**
    * methode for getting most played position
    * 
    * @return
    */
   public String getMostPlayedPosition() {
      return mostPlayedPosition.get();
   }
   /**
    * methode for getting most played position
    * 
    * @return
    */
   public StringProperty getMostPlayedPositionProperty() {
      return mostPlayedPosition;
   }
   /**
    * methode for checking if player unavailability has expired
    * 
    */
   public void hasUnavailabilityExpired() {
      if (dateWhenAvailable.get().isAfterMatch())
      {
         availability = new SimpleStringProperty("Available");
         dateWhenAvailable = null;
      }
   }
}
