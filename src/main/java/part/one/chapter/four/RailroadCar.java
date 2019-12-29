package part.one.chapter.four;

public class RailroadCar extends Transport {

    /**
     * variable describes number of wheels
     */
    private int wheels;

    RailroadCar(int id, String model, int wheels) {
        super(id, model);
        this.wheels=wheels;
    }

    RailroadCar() {}

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }
}
