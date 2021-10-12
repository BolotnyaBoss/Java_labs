package com.company;

import java.util.ArrayList;

public class MockEvents {

    public static ArrayList<Event> mockEvents() {
        ArrayList<Event> mockEvents = new ArrayList<Event>();

        mockEvents.add(new Event("New year", 1, 1, 2022));
        mockEvents.add(new Event("Women day", 8, 3, 2022));
        mockEvents.add(new Event("Bolotnya day", 22, 5, 2021));
        mockEvents.add(new Event("Independence day", 24, 8, 2022));
        mockEvents.add(new Event("DevOps day", 23, 10, 2021));
        mockEvents.add(new Event("Halloween", 1, 11, 2021));
        mockEvents.add(new Event("St. Nicholas Day", 19, 12, 2021));
        mockEvents.add(new Event("Svyatoslav's birthday", 8, 8, 2022));
        mockEvents.add(new Event("Svyatoslav's birthday too", 9, 8, 2022));

        return mockEvents;
    }
}
