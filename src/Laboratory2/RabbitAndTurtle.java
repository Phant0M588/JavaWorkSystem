package Laboratory2;

public class RabbitAndTurtle {
    public static void main(String[] args) throws InterruptedException {
        final int DISTANCE = 100;
        AnimalThread rabbit = new AnimalThread("Кролик", Thread.MAX_PRIORITY, DISTANCE);
        AnimalThread turtle = new AnimalThread("Черепаха", Thread.MIN_PRIORITY, DISTANCE);
        System.out.println("Старт!");
        rabbit.start();
        turtle.start();
        while (rabbit.getMeters() < 30 && !rabbit.isFinished()) {
            printScore(rabbit, turtle);
            Thread.sleep(200);
        }
        System.out.println("\n>>> Черепаха отстала");
        System.out.println(">>> Меняем приоритеты: Черепаха = MAX, Кролик = MIN");
        turtle.setAnimalPriority(Thread.MAX_PRIORITY);
        rabbit.setAnimalPriority(Thread.MIN_PRIORITY);
        while (turtle.getMeters() <= rabbit.getMeters() && !rabbit.isFinished()) {
            printScore(rabbit, turtle);
            Thread.sleep(200);
        }
        System.out.println("\n>>> Черепаха догнала и перегнала Кролика!");
        rabbit.setAnimalPriority(Thread.NORM_PRIORITY);
        turtle.setAnimalPriority(Thread.NORM_PRIORITY);
        while (!rabbit.isFinished() || !turtle.isFinished()) {
            printScore(rabbit, turtle);
            Thread.sleep(300);
        }
        rabbit.join();
        turtle.join();
        System.out.println("\nГонка завершена!");
        System.out.printf("Итог: Кролик %d м, Черепаха %d м%n",
                rabbit.getMeters(), turtle.getMeters());
        long rabbitFinish = rabbit.getFinishTime();
        long turtleFinish = turtle.getFinishTime();

        if (rabbitFinish < turtleFinish) {
            System.out.println("Победил Кролик!");
        } else if (turtleFinish < rabbitFinish) {
            System.out.println("Победила Черепаха!");
        } else {
            System.out.println("Ничья!");
        }
    }
    private static void printScore(AnimalThread rabbit, AnimalThread turtle) {
        System.out.printf("Счет: Кролик %d м (P=%d), Черепаха %d м (P=%d)%n",
                rabbit.getMeters(), rabbit.getPriority(),
                turtle.getMeters(), turtle.getPriority());
    }
}