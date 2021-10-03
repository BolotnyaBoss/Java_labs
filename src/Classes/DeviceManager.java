package Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

enum Order {
    ASC,
    DESC
}

public class DeviceManager {
    void sortByCapacityAnonymous(ArrayList<Device> devices, Order order) {
        Comparator<Device> comparator = new Comparator<Device>() {
            @Override
            public int compare(Device o1, Device o2) {
                return Integer.compare(o1.getCapacity(), o2.getCapacity());
            }
        };

        if (order.name().equals("ASC")) {
            devices.sort(comparator);
        } else {
            devices.sort(comparator.reversed());
        }
    }

    void sortByCapacityInner(ArrayList<Device> devices, Order order) {
        Device device = new Device();
        Device.InnerComparator comparator = device.new InnerComparator();

        if (order.name().equals("ASC")) {
            devices.sort(comparator);
        } else {
            devices.sort(comparator.reversed());
        }
    }

    void sortByName(ArrayList<Device> devices, Order order) {
        if (order.name().equals("ASC")) {
            devices.sort(new Device.StaticInnerComparator());
        } else {
            devices.sort(new Device.StaticInnerComparator().reversed());
        }
    }

    void sortByNameLambda(ArrayList<Device> devices, Order order) {
        if (order.name().equals("ASC")) {
            devices.sort((a, b) -> a.getName().compareTo(b.getName()));
        } else {
            devices.sort((a, b) -> a.getName().compareTo(b.getName()) * -1);
        }
    }

    ArrayList<Device> searchByStatus(ArrayList<Device> devices, boolean status_ ) {
        return devices
                .stream()
                .filter(x -> x.getStatus() == status_)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    int calculateAllCapacity(ArrayList<Device> devices){
        ArrayList<Device> turned_on = searchByStatus(devices, true);
        int sum = 0;
        for (Device d: turned_on) {
            sum += d.getCapacity();
        }
        return sum;
    }
}
