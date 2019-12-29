package part.one.chapter.four;

/**
 * class describes freight train that used to transfer heavy carryes
 */
public class FreightRailroadCar extends RailroadCar {

    /**
     *  variable describes the carrying weight of a freight train in kilo
     */
    private int carrying;

    FreightRailroadCar(int id, String model, int wheels, int carrying) {
        super(id, model, wheels);
        this.carrying=carrying;
    }

    public int getCarrying() {
        return carrying;
    }

    public void setCarrying(int carrying) {
        this.carrying = carrying;
    }
}
