package view;

import Model.Event;

import java.util.List;
import java.util.Scanner;

public class CalendarView {
    private Scanner scanner;

    public CalendarView() {
        scanner = new Scanner(System.in);
    }

    public void showWelcome(String location) {
        System.out.println("=== Gerenciador de Calendário - Local: " + location + " ===");
    }

    public void showMenu() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Listar eventos");
        System.out.println("2 - Adicionar evento personalizado");
        System.out.println("3 - Sair");
        System.out.print("Opção: ");
    }

    // 
    public int getUserOption() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void showEvents(List<Event> events) {
        if (events.isEmpty()) {
            System.out.println("Nenhum evento encontrado.");
        } else {
            System.out.println("\nEventos:");
            for (Event e : events) {
                System.out.println(e);
            }
        }
    }

    public String askEventTitle() {
        System.out.print("Título do evento: ");
        return scanner.nextLine();
    }

    public String askEventDate() {
        System.out.print("Data do evento (AAAA-MM-DD): ");
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
