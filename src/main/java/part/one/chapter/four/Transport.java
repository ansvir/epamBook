package part.one.chapter.four;

/**
 * Task 8 from B sector chapter 4
 */
public class Transport {
    /**
     * id of an object
     */
    private int id;
    /**
     * variable describes model of an object
     */
    private String model;

    Transport(int id, String model ) {
        this.id=id;
        this.model=model;
    }

    Transport() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
