import java.util.Scanner;

public class view {
    public static void main(String[] args) {
        controller controller = new controller();
        model model = new model();
        Scanner scanner = new Scanner(System.in);
        int selectedAction = 0;

        System.out.println("Выберите действие: 1. Калькулятор 2. История формул 3. История результата 4. Выход");
        try {
            selectedAction = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        switch (selectedAction) {
            case 1:
                System.out.print("Введите: ");
                try {
                    String equation = scanner.next();
                    System.out.print(controller.calculator(equation));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    scanner.close();
                }
                break;
            case 2:
                model.showHistoryFromFile(model.FILE_HISTORY_OF_EQUATIONS);
                break;
            case 3:
                model.showHistoryFromFile(model.FILE_HISTORY_OF_RESULTS);
                break;
            default:
                System.out.print("Выход...");
                System.exit(1);
        }
    }

}
