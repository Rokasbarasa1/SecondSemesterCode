import org.junit.Test;
import static org.junit.Assert.*;

public class ClockTest {
    @Test
    public void ticZero(){
        Clock clock = new Clock(0,0,0);
        clock.tic();
        System.out.println(clock.toString());
        assertTrue(clock.toString().endsWith("00:00:01"));
    }
    @Test
    public void ticSecondsOne(){
        Clock clock = new Clock(0,0,1);
        clock.tic();
        System.out.println(clock.toString());
        assertTrue(clock.toString().equals("00:00:02"));
    }
    @Test
    public void ticSecondsBeforeMax(){
        Clock clock = new Clock(0,0,58);
        clock.tic();
        System.out.println(clock.toString());
        assertTrue(clock.toString().equals("00:00:59"));
    }
    @Test
    public void ticSecondsMax(){
        Clock clock = new Clock(0,0,59);
        clock.tic();
        System.out.println(clock.toString());
        assertTrue(clock.toString().equals("00:01:00"));
    }
    @Test
    public void ticMinutesOne(){
        Clock clock = new Clock(0,1,59);
        clock.tic();
        System.out.println(clock.toString());
        assertTrue(clock.toString().equals("00:02:00"));
    }
    @Test
    public void ticMinutesBeforeMax(){
        Clock clock = new Clock(0,58,59);
        clock.tic();
        System.out.println(clock.toString());
        assertTrue(clock.toString().equals("00:59:00"));
    }
    @Test
    public void ticMinutesMax(){
        Clock clock = new Clock(0,59,59);
        clock.tic();
        System.out.println(clock.toString());
        assertTrue(clock.toString().equals("01:00:00"));
    }
    @Test
    public void ticHoursOne(){
        Clock clock = new Clock(1,59,59);
        clock.tic();
        System.out.println(clock.toString());
        assertTrue(clock.toString().equals("02:00:00"));
    }
    @Test
    public void ticHoursBeforeMax(){
        Clock clock = new Clock(22,59,59);
        clock.tic();
        System.out.println(clock.toString());
        assertTrue(clock.toString().equals("23:00:00"));
    }
    @Test
    public void ticHoursMax(){
        Clock clock = new Clock(23,59,59);
        clock.tic();
        System.out.println(clock.toString());
        assertTrue(clock.toString().equals("00:00:00"));
    }
}