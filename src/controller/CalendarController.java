package controller;

import Model.CalendarModel;
import Model.Event;
import view.CalendarView;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class CalendarController {
    private CalendarModel model;
    private CalendarView view;

    public CalendarController(CalendarModel model, CalendarView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        view.showWelcome(model.getLocation());

        boolean running = true;
        while (running) {
            view.showMenu();
            int option = view.getUserOption(); // 
            switch (option) {
                case 1:
                    view.showEvents(model.getEvents());
                    break;
                case 2:
                    addCustomEvent();
                    break;
                case 3:
                    running = false;
                    view.showMessage("Saindo... Até logo!");
                    break;
                default:
                    view.showMessage("Opção inválida. Tente novamente.");
            }
        }
    }

    private void addCustomEvent() {
        String title = view.askEventTitle();
        String dateStr = view.askEventDate();

        try {
            LocalDate date = LocalDate.parse(dateStr);
            Event event = new Event(title, date, model.getLocation());
            model.addEvent(event);
            view.showMessage("Evento adicionado com sucesso!");
        } catch (DateTimeParseException e) {
            view.showMessage("Data inválida. Use o formato AAAA-MM-DD.");
        }
    }
}
