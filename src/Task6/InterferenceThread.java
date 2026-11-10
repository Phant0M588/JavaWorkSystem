package Task6;

public class InterferenceThread extends Thread{
    private final InterferenceExample checker;

    InterferenceThread(InterferenceExample checker) {
        this.checker = checker;
    }

    @Override
    public void run() {
        while (!checker.stop()) {
            checker.incrementResult();
        }
    }
}
