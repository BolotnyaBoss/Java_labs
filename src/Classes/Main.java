package Classes;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Device> devices = new ArrayList<>();

        devices.add(new Device("Iron", 2500, true));
        devices.add(new Device("Laptop", 950 ,false));
        devices.add(new Device("Kettle", 1500, true));
        devices.add(new Device("TV", 1000,true));
        devices.add(new Device("Microwave", 2700,true));
        devices.add(new Device("Oven", 3500,false));
        devices.add(new Device("Mixer", 600,false));
        devices.add(new Device("Blender", 850,true));
        devices.add(new Device("Hair_Dryer", 1200,true));

        DeviceManager manager = new DeviceManager();

        System.out.println("Use electricity-------------------------------------------");
        ArrayList<Device> useElectricity = manager.searchByStatus(devices, true);
        useElectricity.forEach(System.out::println);

        System.out.println("Use electricity (All capacity)----------------------------");
        System.out.println(manager.calculateAllCapacity(useElectricity));

        System.out.println("Don`t use electricity-------------------------------------");
        ArrayList<Device> fieldEquipment = manager.searchByStatus(devices, false);
        fieldEquipment.forEach(System.out::println);

        System.out.println("Sorting by name asc order --------------------------------");
        manager.sortByName(devices, Order.ASC);
        devices.forEach(System.out::println);

        System.out.println("Sorting by capacity desc order ---------------------------");
        manager.sortByCapacityInner(devices, Order.DESC);
        devices.forEach(System.out::println);

        System.out.println("Sorting by capacity asc order ----------------------------");
        manager.sortByCapacityAnonymous(devices, Order.ASC);
        devices.forEach(System.out::println);

        System.out.println("Sorting by name desc order -------------------------------");
        manager.sortByNameLambda(devices, Order.DESC);
        devices.forEach(System.out::println);
        System.out.println("----------------------------------------------------------");
    }
}
