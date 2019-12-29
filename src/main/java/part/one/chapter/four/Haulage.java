package part.one.chapter.four;

/**
 * class describes haulage train that used to pull trains chain
 */
public class Haulage extends RailroadCar {

    /**
     * variable describes engine capacity in watts
     */
    private double enginePower;
    /**
     * variable describes speed of an object in kilometers per hour
     */
    private int speed;

    Haulage(int id, int speed, String model, int wheels, double enginePower) {
        super(id, model, wheels);
        this.enginePower = enginePower;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
