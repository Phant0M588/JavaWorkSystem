import java.io.IOException;
import java.lang.ProcessBuilder;
import java.util.Scanner;

public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    boolean ii = true;
    int i = 1;
    while (ii) {
        System.out.println("Процесс №" + i);
        i ++;
        System.out.print("Выберите программу: \n1) Блокнот \n2) Калькулятор \n3) Командная строка \n\nПрограмма: ");
        int pr = in.nextInt();
        String program = "";
        if (pr == 1){
            program = "notepad";
        }
        else if (pr == 2){
            program = "calc";
        }
        else if (pr == 3){
            program = "conhost";
        }
        try {
            Process process = new ProcessBuilder(program).start();

            ProcessHandle handle = process.toHandle();
            ProcessHandle.Info info = handle.info();

            System.out.println("\nПроцесс запущен");
            System.out.println("PID: " + handle.pid());
            System.out.println("Путь: " + info.command().orElse("нет данных"));
            System.out.println("Аргументы: " + info.arguments().map(Object::toString).orElse("нет"));
            System.out.println("Время запуска: " + info.startInstant().map(Object::toString).orElse("нет данных"));
            System.out.println("Пользователь: " + info.user().orElse("нет данных"));
            System.out.print("\nЗавершить д/н: ");
            String con = in.next();
            if (con.equalsIgnoreCase("д") || con.equalsIgnoreCase("да")) {
                if (handle.destroy()) {
                    System.out.println("Процесс завершён.");
                } else {
                    System.out.println("Не удалось завершить процесс.");
                }
            } else {
                System.out.println("Процесс оставлен работать.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка запуска, попробуйте снова");
            i--;
        }
        System.out.println();
    }
}

