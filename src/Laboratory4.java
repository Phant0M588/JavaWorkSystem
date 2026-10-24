import java.util.Scanner;

void main() {
    Scanner in = new Scanner(System.in);
    try {
        System.out.print("Введите целое число: ");
        int num = in.nextInt();
        System.out.println("Вы ввели число " + num);
    }
    catch (Exception e){
        System.out.println("Ошибка! Вы ввели не целое число.");
    }
}