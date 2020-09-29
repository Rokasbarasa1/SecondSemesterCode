import org.junit.Test;

import static org.junit.Assert.*;

public class ClockTest {

    //Testing of cosntructor with seconds only and the values that are set afterwards
    @Test
    public void createClockWithZeroSeconds(){
        try{
            Clock clock = new Clock(0);
            assertTrue(clock.getSecond()==0);
            assertTrue(clock.getHour()==0);
            assertTrue(clock.getMinute()==0);
        } catch (IllegalArgumentException  e) {
            fail();
        }
    }
    @Test
    public void createClockWithOneSecond(){
        try{
            Clock clock = new Clock(1);
            assertTrue(clock.getSecond()==1);
            assertTrue(clock.getHour()==0);
            assertTrue(clock.getMinute()==0);
        } catch (IllegalArgumentException  e) {
            fail();
        }
    }
    @Test
    public void createClockWithNegativeSeconds(){
        try{
            Clock clock = new Clock(-1);
            fail();
        } catch (IllegalArgumentException  e) {
        }
    }
    @Test
    public void createClockWithLowerManySeconds(){
        try{
            Clock clock = new Clock(86399 );
            assertTrue(clock.getSecond()==59);
            assertTrue(clock.getHour()==23);
            assertTrue(clock.getMinute()==59);
        } catch (IllegalArgumentException  e) {
            fail();
        }
    }
    @Test
    public void createClockWithManySeconds(){
        try{
            Clock clock = new Clock(86400 );
            assertTrue(clock.getSecond()==0);
            assertTrue(clock.getHour()==0);
            assertTrue(clock.getMinute()==0);
        } catch (IllegalArgumentException  e) {
            fail();
        }
    }
    @Test
    public void createClockWithManyPlusOneSeconds(){
        try{
            Clock clock = new Clock(86401);
            assertTrue(clock.getSecond()==1);
            assertTrue(clock.getHour()==0);
            assertTrue(clock.getMinute()==0);
        } catch (IllegalArgumentException  e) {
        }
    }

    //Testing constructor with hours minutes and seconds and its afterwards time measurements
    @Test
    public void createClockZeroes(){
        try{
            Clock clock = new Clock(0,0,0);
            assertTrue(clock.getSecond()==0);
            assertTrue(clock.getHour()==0);
            assertTrue(clock.getMinute()==0);
        } catch (IllegalArgumentException  e) {
            fail();
        }
    }
    @Test
    public void createClockOnes(){
        try{
            Clock clock = new Clock(1,1,1);
            assertTrue(clock.getSecond()==1);
            assertTrue(clock.getHour()==1);
            assertTrue(clock.getMinute()==1);
        } catch (IllegalArgumentException  e) {
            fail();
        }
    }
    @Test
    public void createClockBelowMax(){
        try{
            Clock clock = new Clock(23,59,58);
            assertTrue(clock.getSecond()==58);
            assertTrue(clock.getHour()==23);
            assertTrue(clock.getMinute()==59);
        } catch (IllegalArgumentException  e) {
            fail();
        }
    }
    @Test
    public void createClockMax(){
        try{
            Clock clock = new Clock(23,59,59);
            assertTrue(clock.getSecond()==59);
            assertTrue(clock.getHour()==23);
            assertTrue(clock.getMinute()==59);
        } catch (IllegalArgumentException  e) {
            fail();
        }
    }
    @Test
    public void createClockNegatives(){
        try{
            Clock clock = new Clock(-1,-1,-1);
            fail();
        } catch (IllegalArgumentException  e) {
        }
    }
    @Test
    public void createClockOverMax(){
        try{
            Clock clock = new Clock(24,60,60);
            fail();
        } catch (IllegalArgumentException  e) {
        }
    }

    //Get methods
    @Test
    public void getHourTest(){
        Clock clock = new Clock(12,34,56);
        assertTrue(clock.getHour() == 12);
    }
    @Test
    public void getMinuteTest(){
        Clock clock = new Clock(12,34,56);
        assertTrue(clock.getMinute() == 34);
    }
    @Test
    public void getSecondTest(){
        Clock clock = new Clock(23,59,59);
        assertTrue(clock.getHour() == 59);
    }

    //Testing setting of time after creating class
    @Test
    public void setNegative(){
        Clock clock = new Clock(0);
        try{
            clock.set(-1);
            fail();
        }catch (IllegalArgumentException e){
        }
    }
    @Test
    public void setZero(){
        Clock clock = new Clock(0);
        try{
            clock.set(0);
            assertTrue(clock.getSecond()==0);
            assertTrue(clock.getHour()==0);
            assertTrue(clock.getMinute()==0);
        }catch (IllegalArgumentException e){
            fail();
        }
    }
    @Test
    public void setOne(){
        Clock clock = new Clock(0);
        try{
            clock.set(1);
            assertTrue(clock.getSecond()==1);
            assertTrue(clock.getHour()==0);
            assertTrue(clock.getMinute()==0);
        }catch (IllegalArgumentException e){
            fail();
        }
    }
    @Test
    public void setBeforeUpperLimit(){
        Clock clock = new Clock(0);
        try{
            clock.set(86399);
            assertTrue(clock.getSecond()==59);
            assertTrue(clock.getHour()==23);
            assertTrue(clock.getMinute()==59);
        }catch (IllegalArgumentException e){
            fail();
        }
    }
    @Test
    public void setUpperLimit(){
        Clock clock = new Clock(0);
        try{
            clock.set(86400);
            assertTrue(clock.getSecond()==0);
            assertTrue(clock.getHour()==0);
            assertTrue(clock.getMinute()==0);
        }catch (IllegalArgumentException e){
            fail();
        }
    }
    @Test
    public void setUpperLimitPlusOne(){
        Clock clock = new Clock(0);
        try{
            clock.set(86401);
            assertTrue(clock.getSecond()==1);
            assertTrue(clock.getHour()==0);
            assertTrue(clock.getMinute()==0);
        }catch (IllegalArgumentException e){
            fail();
        }
    }

    //Testing getting time in seconds after creation
    @Test
    public void getTimeInSecondZero(){
        try{
            Clock clock = new Clock(0,0,0);
            assertTrue(clock.getTimeInSeconds()== 0);
        } catch (IllegalArgumentException  e) {
            fail();
        }
    }
    @Test
    public void getTimeInSecondsOne(){
        try{
            Clock clock = new Clock(0,0,1);
            assertTrue(clock.getTimeInSeconds()== 1);
        } catch (IllegalArgumentException  e) {
            fail();
        }
    }
    @Test
    public void getTimeInSecondsBellowMax(){
        try{
            Clock clock = new Clock(23,59,58);
            assertTrue(clock.getTimeInSeconds() == 86399);
        } catch (IllegalArgumentException  e) {
            fail();
        }
    }
    @Test
    public void getTimeInSecondsMax(){
        try{
            Clock clock = new Clock(23,59,59);
            assertTrue(clock.getTimeInSeconds() == 86400);
        } catch (IllegalArgumentException  e) {
            fail();
        }
    }

    //Testing of tic method
    @Test
    public void ticBeforeMaxSeconds(){
        try{
            Clock clock = new Clock(13,12,58);
            clock.tic();
            assertTrue(clock.getTimeInSeconds()==47579 );
        } catch (IllegalArgumentException  e) {
            fail();
        }
    }
    @Test
    public void ticAtMaxSeconds(){
        try{
            Clock clock = new Clock(13,12,59);
            clock.tic();
            assertTrue(clock.getTimeInSeconds()==47580 );
        } catch (IllegalArgumentException  e) {
            fail();
        }
    }
    @Test
    public void ticAtMaxMinutes(){
        try{
            Clock clock = new Clock(13,59,59);
            clock.tic();
            assertTrue(clock.getTimeInSeconds()==50400 );
        } catch (IllegalArgumentException  e) {
            fail();
        }
    }
    @Test
    public void ticAtMaxHours(){
        try{
            Clock clock = new Clock(23,59,59);
            clock.tic();
            assertTrue(clock.getTimeInSeconds()==0);
        } catch (IllegalArgumentException  e) {
            fail();
        }
    }

    //Test of the to string method
    @Test
    public void toStringZero(){
            Clock clock = new Clock(0,0,0);
            assertTrue(clock.toString().endsWith("00:00:00"));
    }
    @Test
    public void toStringOne(){
            Clock clock = new Clock(1,1,1);
            assertTrue(clock.toString().endsWith("01:01:01"));
    }
    @Test
    public void toStringBeforeMax(){
            Clock clock = new Clock(22,58,58);
            assertTrue(clock.toString().endsWith("22:58:58"));
    }
    @Test
    public void toStringMax(){
        Clock clock = new Clock(23,59,59);
        assertTrue(clock.toString().endsWith("23:59:59"));
    }
}