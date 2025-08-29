import controller.CalendarController;
import Model.CalendarModel;
import view.CalendarView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o local (ex: Brasil, São Paulo, São Paulo cidade): ");
        String location = sc.nextLine();

        CalendarModel model = new CalendarModel(location);
        CalendarView view = new CalendarView();
        CalendarController controller = new CalendarController(model, view);

        controller.start();
    }
}
