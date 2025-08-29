package Model;

import java.time.LocalDate;

public class Event {
    private String title;
    private LocalDate date;
    private String location;

    public Event(String title, LocalDate date, String location) {
        this.title = title;
        this.date = date;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return date + " - " + title + " (" + location + ")";
    }
}
