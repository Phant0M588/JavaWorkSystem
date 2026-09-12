import java.io.File;
import java.util.Scanner;
//Импортируем всё необходимое

void main() {
    String filename = "C:\\Users\\egor2\\Downloads\\Посл поиск.txt";
    File file = new File(filename);
    try (Scanner scanner = new Scanner(file)){
        int count = scanner.nextInt();
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++){
            numbers[i] = scanner.nextInt();
        }
        //Открыли файл и переместили все значения в массив
        int result1 = 10000;
        int result2 = 10000;
        int result3 = 10000;
        for (int i = 0; i < numbers.length; i++){
            if(numbers[i] % 21 == 0){
                if(numbers[i] < result1){
                    result1 = numbers[i];
                }
            }
            else if (numbers[i] % 3 == 0){
              if(numbers[i] < result2){
                    result2 = numbers[i];
              }
            }
            else if (numbers[i] % 7 == 0){
                if(numbers[i] < result3){
                    result3 = numbers[i];
                }
            }
        }
        //Нашли минимальные числа, соответсвующие треюованиям
        int result2pro3 = result2 * result3;
        int result;
        if (result1 < result2pro3){
            result = result1;
            System.out.print("Минимальное значение из файла:" +
                    "\nЧисло кратное 21" +
                    "\nВывод: ");
        }
        else if(result1 > result2pro3){
            result = result2pro3;
            System.out.print("Минимальное значение из файла:" +
                    "\nПроизведение двух чисел, одно из которых кратно 3, а другое - 7" +
                    "\nВывод: ");
        }
        else{
            result = result2pro3;
            System.out.print("Минимальное значение из файла:" +
                    "\nМинимальному значению соответсвует, " +
                    "как произведению двух чисел, одно из которых кратно 3, а другое - 7" +
                    "\nТак и числу кратное 21" +
                    "\nВывод: ");
        }
        //Сравнили 2 результата
        System.out.println(result);
        //Вывели результат
    }
    catch (IOException e) {
        System.out.println("Ошибка! Такого файла нет");
    }
}