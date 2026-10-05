package Laboratory2;

public class AnimalThread extends Thread {
    private final String animalName;
    private volatile int priority;
    private final int distance;
    private volatile int meters = 0;
    private volatile boolean finished = false;
    private volatile long finishTime = 0;
    public AnimalThread(String name, int priority, int distance) {
        super(name);
        this.animalName = name;
        this.priority = priority;
        this.distance = distance;
        setPriority(priority);
    }
    public void setAnimalPriority(int priority) {
        this.priority = priority;
        setPriority(priority);
    }
    public int getAnimalPriority() {
        return priority;
    }
    public int getMeters() {
        return meters;
    }
    public boolean isFinished() {
        return finished;
    }
    public long getFinishTime() {
        return finishTime;
    }
    @Override
    public void run() {
        while (meters < distance) {
            meters++;
            System.out.printf("%s: %d м (приоритет %d)%n",
                    animalName, meters, getPriority());
            try {
                int delay = Math.max(5, 120 - getPriority() * 10);
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println(animalName + " прерван.");
                return;
            }
        }
        finishTime = System.currentTimeMillis();
        finished = true;
        System.out.println(animalName + " финишировал!");
    }
}