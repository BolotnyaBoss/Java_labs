package com.company;

import java.util.Arrays;
import java.util.List;

public class Event{
    public String title;
    public Integer day;
    public Integer month;
    public Integer year;

    public Event(String t, Integer d, Integer m, Integer y) {
        title = t;
        day = d;
        month = m;
        year = y;
    }

    public Event(String line) {
        List<String> props = Arrays.asList(line.split(" "));
        title = props.get(0);
        day = Integer.parseInt(props.get(1));
        month = Integer.parseInt(props.get(2));
        year = Integer.parseInt(props.get(3));
    }

    public boolean dateEquals(Event e) {
        if (year.equals(e.year) &&
            day.equals(e.day) &&
            month.equals(e.month)) {
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
        return title + " (" + year + "/" + month + "/" + day + ")";
    }

    public int compareTo(Event e) {
        if (year > e.year) {
            return 1;
        } else if (year < e.year) {
            return -1;
        } else {
            if (month > e.month) {
                return 1;
            } else if (month < e.month) {
                return -1;
            } else {
                if (day > e.day) {
                    return 1;
                } else if (day < e.day) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}
