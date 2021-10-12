package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        var eventsMap = EventManager.createMap();

        // first task
        System.out.println("Print map before filtering");
        EventManager.printMap(eventsMap);

        // second task
        System.out.println("Remove events with 1 day difference");
        eventsMap = EventManager.oneDayDiffirence(eventsMap);
        System.out.println("Done...\n");

        System.out.println("Print current map");
        EventManager.printMap(eventsMap);

        // third task
        System.out.println("Third task: 2 files and operations with data\n");
        var eventsFromFirstFile = EventManager.fillArrayFromFile(Files.readAllLines(Paths.get("first.txt")));
        System.out.println("Events from first file:");
        EventManager.printArray(eventsFromFirstFile);

        var eventsFromSecondFile = EventManager.fillArrayFromFile(Files.readAllLines(Paths.get("second.txt")));
        System.out.println("Events from second file:");
        EventManager.printArray(eventsFromSecondFile);

        var uniqueEvents = EventManager.UniqueList(eventsFromFirstFile,eventsFromSecondFile);
        System.out.println("Unique events from first file :");
        EventManager.printArray(uniqueEvents);

        System.out.println("All combinations unique events:");
        EventManager.printUniqueEventCombination(uniqueEvents);

    }
}
