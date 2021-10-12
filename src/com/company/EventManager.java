package com.company;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class EventManager {

    public static HashMap<Integer, ArrayList<Event>> createMap (){
        ArrayList<Event> mock = MockEvents.mockEvents();
        var eventsMap = new HashMap<Integer, ArrayList<Event>>();
        for (Event e : mock) {
            if (!eventsMap.containsKey(e.year)) {
                var tmp = new ArrayList<Event>();
                tmp.add(e);
                Collections.sort(tmp,
                        (Event e1, Event e2) -> e1.compareTo(e2));
                eventsMap.put(e.year, tmp);
            }
            else {
                var tmp = eventsMap.get(e.year);
                tmp.add(e);
                Collections.sort(tmp,
                        (Event e1, Event e2) -> e1.compareTo(e2));
                eventsMap.put(e.year, tmp);
            }
        }
        return eventsMap;
    }

    public static void printMap(HashMap<Integer, ArrayList<Event>> eventsMap){
        var keys = eventsMap.keySet();
        for (Integer key : keys) {
            System.out.println(key + " : ");
            var events = eventsMap.get(key);
            for (Event e : events) {
                System.out.println(e.toString());
            }
            System.out.println();
        }
    }

    public static void printArray(ArrayList<Event> events){
        for (Event e : events) {
            System.out.println(e.toString());
        }
        System.out.println();
    }

    public static ArrayList<Event> fillArrayFromFile(List<String> lines){
        var events = new ArrayList<Event>();
        for (String line : lines) {
            events.add(new Event(line));
        }
        return events;
    }

    public static HashMap<Integer, ArrayList<Event>> oneDayDiffirence (HashMap<Integer, ArrayList<Event>> eventsMap){

        var keys = eventsMap.keySet();
        for (var key : keys) {
            var events = eventsMap.get(key);
            var needRemove = new ArrayList<Event>();
            for (int i = 0; i < events.size() - 1; i++) {
                var firstEvent = events.get(i);
                var secondEvent = events.get(i + 1);
                if (firstEvent.month.equals(secondEvent.month) &&
                        Math.abs(firstEvent.day - secondEvent.day) == 1) {
                    if (!needRemove.contains(firstEvent)) {
                        needRemove.add(firstEvent);
                    }
                    if (!needRemove.contains(secondEvent)) {
                        needRemove.add(secondEvent);
                    }
                }
            }
            for (var item : needRemove) {
                events.remove(item);
            }
        }
        return eventsMap;
    }

    public static ArrayList<Event> UniqueList(ArrayList<Event> first, ArrayList<Event> second){
        var uniqueArr = new ArrayList<Event>();
        for (Event e1 : first) {
            boolean unique = true;
            for (Event e2 : second) {
                if (e1.dateEquals(e2)) {
                    unique = false;
                }
            }
            if (unique) {
                uniqueArr.add(e1);
            }
        }
        return uniqueArr;
    }

    public static void printUniqueEventCombination(ArrayList<Event> uniqueEvents){
        var eventsCount = uniqueEvents.size();
        for (int i = 0; i < eventsCount - 1; i++) {
            var currentEvent = uniqueEvents.get(i);
            for (int j = i + 1; j < eventsCount; j++) {
                var eventToCompare = uniqueEvents.get(j);
                if (Math.abs(currentEvent.year - eventToCompare.year) > 1) {
                    System.out.println(currentEvent + " - " + eventToCompare);
                } else if (Math.abs(currentEvent.year - eventToCompare.year) == 1) {
                    if (currentEvent.year > eventToCompare.year) {
                        if (currentEvent.month > eventToCompare.month) {
                            System.out.println(currentEvent + " - " + eventToCompare);
                        }
                        else if (eventToCompare.month.equals(currentEvent.month)) {
                            if (currentEvent.day > eventToCompare.day) {
                                System.out.println(currentEvent + " - " + eventToCompare);
                            }
                        }
                    } else {
                        if (eventToCompare.month > currentEvent.month) {
                            System.out.println(currentEvent + " - " + eventToCompare);
                        }
                        else if (eventToCompare.month.equals(currentEvent.month)) {
                            if (eventToCompare.day > currentEvent.day) {
                                System.out.println(currentEvent + " - " + eventToCompare);
                            }
                        }
                    }
                }
            }
        }
    }
}
