package Task6;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите X (1 – AtomicInteger; 2 – synchronized): ");
        int x = scan.nextInt();

        if (x != 1 && x != 2) {
            System.out.println("Ошибка: введите 1 или 2.");
            return;
        }

        new InterferenceExample(x).example();
    }
}
