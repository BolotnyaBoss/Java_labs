package Classes;

import java.util.Comparator;

public class Device {
    protected String name;
    protected int capacity;
    protected boolean status;

    @Override
    public String toString() {
        return "Device { " +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", status=" + status +
                " }";
    }

    static class StaticInnerComparator implements Comparator<Device> {

        @Override
        public int compare(Device o1, Device o2) {
            return o1.name.compareTo(o2.getName());
        }
    }

    class InnerComparator implements Comparator<Device> {

        @Override
        public int compare(Device o1, Device o2) {
            return Integer.compare(o1.capacity, o2.getCapacity());
        }
    }


    public Device(String name, int capacity, boolean status) {
        this.name = name;
        this.capacity = capacity;
        this.status = status;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity1) {
        this.capacity = capacity1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Device() {
    }
}
