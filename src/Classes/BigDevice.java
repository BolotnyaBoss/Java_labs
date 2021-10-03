package Classes;

public class BigDevice extends Device{
    private String type;

    @Override
    public String toString() {
        return "Device { " +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", status=" + status +
                ", type=" + type +
                " }";
    }
}
