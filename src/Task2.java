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
        int result4 = 10000;
        for (int i = 0; i < numbers.length; i++){
            if(numbers[i] % 21 == 0){
                if(numbers[i] < result1){
                    result1 = numbers[i];
                }
            }
            else if (numbers[i] % 3 == 0){
              if(numbers[i] < result3){
                    result3 = numbers[i];
              }
            }
            else if (numbers[i] % 7 == 0){
                if(numbers[i] < result4){
                    result4 = numbers[i];
                }
            }
            else if (numbers[i] < result2){
                result2 = numbers[i];
            }
        }
        //Нашли минимальные числа, соответсвующие треюованиям
        int result3pro4 = result3 * result4;
        int result1pro2 = result1 * result2;
        int result;
        if (result1pro2 < result3pro4){
            result = result1pro2;
            System.out.print("Минимальное значение из файла:" +
                    "\nПроизведение двух чисел, одно из которых кратно 21, а другое минимальное в массиве" +
                    "\nВывод: ");
        }
        else if(result1pro2 > result3pro4){
            result = result3pro4;
            System.out.print("Минимальное значение из файла:" +
                    "\nПроизведение двух чисел, одно из которых кратно 3, а другое - 7" +
                    "\nВывод: ");
        }
        else{
            result = result3pro4;
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