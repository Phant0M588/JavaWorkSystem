import java.io.*;
import java.util.*;


void main() {
        try {
            String filename = "C:\\Users\\egor2\\Downloads\\1111.txt";
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            ArrayList<Integer> numbers = new ArrayList<>();
            while (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            }
            scanner.close();
            int Min37 = Integer.MAX_VALUE;
            int Max73 = Integer.MIN_VALUE;
            for (int number : numbers) {
                if (number % 37 == 0 && number < Min37) {
                    Min37 = number;
                }
                if (number % 73 == 0 && number > Max73) {
                    Max73 = number;
                }
            }
            int Left = Math.min(Min37, Max73);
            int Right = Math.max(Min37, Max73);
            int CountPar = 0;
            int MinSum = Integer.MAX_VALUE;
            for (int i = 0; i < numbers.size() - 1; i++) {
                int a = numbers.get(i);
                int b = numbers.get(i + 1);
                boolean FirstInside = a > Left && a < Right;
                boolean SecondInside = b > Left && b < Right;
                if (FirstInside != SecondInside) {
                    CountPar++;
                    int sum = a + b;
                    if (sum < MinSum) {
                        MinSum = sum;
                    }
                }
            }
            System.out.println("Минимальное кратное 37 = " + Min37);
            System.out.println("Максимальное кратное 73 = " + Max73);
            System.out.println("Количество пар = " + CountPar);
            System.out.println("Минимальная сумма = " + MinSum);
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка! Такого файла нет");
        }
    }
