package Model;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class CalendarModel {
    private List<Event> events;
    private String location;

    public CalendarModel(String location) {
        this.location = location;
        this.events = new ArrayList<>();
        loadHolidays(location);
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public List<Event> getEvents() {
        events.sort(Comparator.comparing(Event::getDate));
        return events;
    }

    public String getLocation() {
        return location;
    }

    private void loadHolidays(String location) {
        int year = LocalDate.now().getYear();

        // Feriados nacionais fixos
        addHoliday("Confraternização Universal", LocalDate.of(year, Month.JANUARY, 1));
        addHoliday("Tiradentes", LocalDate.of(year, Month.APRIL, 21));
        addHoliday("Dia do Trabalho", LocalDate.of(year, Month.MAY, 1));
        addHoliday("Independência do Brasil", LocalDate.of(year, Month.SEPTEMBER, 7));
        addHoliday("Nossa Senhora Aparecida", LocalDate.of(year, Month.OCTOBER, 12));
        addHoliday("Finados", LocalDate.of(year, Month.NOVEMBER, 2));
        addHoliday("Proclamação da República", LocalDate.of(year, Month.NOVEMBER, 15));
        addHoliday("Natal", LocalDate.of(year, Month.DECEMBER, 25));

        // Feriados móveis
        LocalDate easter = calculateEaster(year);
        addHoliday("Páscoa", easter);
        addHoliday("Sexta-feira Santa", easter.minusDays(2));
        addHoliday("Carnaval", easter.minusDays(47));

        // Feriados estaduais (exemplo São Paulo)
        if (location.equalsIgnoreCase("São Paulo") || location.equalsIgnoreCase("SP")) {
            addHoliday("Revolução Constitucionalista", LocalDate.of(year, Month.JULY, 9));
        }

        // Feriados municipais (exemplo São Paulo cidade)
        if (location.equalsIgnoreCase("São Paulo cidade") || location.equalsIgnoreCase("São Paulo")) {
            addHoliday("Aniversário de São Paulo", LocalDate.of(year, Month.JANUARY, 25));
        }
    }

    private void addHoliday(String title, LocalDate date) {
        events.add(new Holiday(title, date, location));
    }

    // Algoritmo para calcular a Páscoa (ano gregoriano)
    private LocalDate calculateEaster(int year) {
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        int month = (h + l - 7 * m + 114) / 31;
        int day = ((h + l - 7 * m + 114) % 31) + 1;

        return LocalDate.of(year, month, day);
    }
}
