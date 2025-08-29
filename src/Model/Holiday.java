package Model;

import java.time.LocalDate;

public class Holiday extends Event {

    public Holiday(String title, LocalDate date, String location) {
        super(title, date, location);
    }

    @Override
    public String toString() {
        return "[Feriado] " + super.toString();
    }
}
