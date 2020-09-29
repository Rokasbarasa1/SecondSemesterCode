package Exercise1;

public class RunTrafficLight {
    public static void main(String[] args) throws InterruptedException {
        TrafficLight trafficLight = new TrafficLight();
        Car kar1 = new Car(1, trafficLight);
        Taxi tax1 = new Taxi(2,trafficLight);
        SleepyDriver driver1 = new SleepyDriver(3, trafficLight);
        Pedestrian person1 = new Pedestrian(4, trafficLight);
        trafficLight.start();
    }
}
