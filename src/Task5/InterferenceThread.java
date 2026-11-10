package Task5;

public class InterferenceThread extends Thread {
    private final InterferenceExample checker;
    private static int i;

    InterferenceThread(InterferenceExample checker) {
        this.checker = checker;
    }

    private void increment() {
        i++;
    }

    int getI() {
        return i;
    }

    public void run() {
        while (!checker.stop()) {
            increment();
        }
    }
}
