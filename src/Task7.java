import java.util.ArrayList;
import java.util.List;
import java.util.Random;

void main(String[] args) throws ExecutionException, InterruptedException {
    List<Integer> list = new ArrayList<>();
    Random ran = new Random();
    for (int i = 0; i < 1000; i++){
        list.add(ran.nextInt(1, 10000));
    }
    int Sum1 = 0;
    long startTime1 = System.nanoTime();
    for (int x : list) {
        Sum1 += x;
    }
    long endTime1 = System.nanoTime();
    long allTime1 = endTime1 - startTime1;
    double AllTime1 = allTime1 / 1_000_000.0;

    final int THREADS = 4;
    long[] partSums = new long[THREADS];
    Thread[] threads = new Thread[THREADS];
    int chunk = 1000 / THREADS;


    long startTime2 = System.nanoTime();
    for (int t = 0; t < THREADS; t++) {
        final int id = t;
        final int from = id * chunk;
        final int to = (id == THREADS - 1) ? 1000 : from + chunk;

        threads[id] = new Thread(() -> {
            long s = 0;
            for (int i = from; i < to; i++) {
                s += list.get(i);
            }
            partSums[id] = s;
        });
        threads[id].start();
    }
    for (Thread th : threads) {
        th.join();
    }
    long parSum = 0;
    for (long s : partSums) {
        parSum += s;
    }
    long endTime2 = System.nanoTime();
    long allTime2 = endTime2 - startTime2;
    double AllTime2 = allTime2 / 1_000_000.0;
    System.out.println();

    System.out.println("Последовательно: " + AllTime1);
    System.out.println("Паралельно :" + AllTime2);
}

/*Входные данные: список из 1000 чисел
Создать 4 потока, каждый из которых вычисляет свой блок
После завершения всех потоков получить их сумму
Сравнить время выполнения этой задачи и время выполнения этой задачи и при последовательном решение (системный таймер)*/

