import java.text.SimpleDateFormat;
import java.util.Map;

public class Horse implements Runnable {

    final double HIPPODROME = 1000;

    private String name;

    private double step;

    public String getName() {
        return name;
    }

    public double getStep() {
        return step;
    }

    public Horse(String name, double step) {
        this.name = name;
        this.step = step;
    }

    @Override
    public void run() {
        try {
            runningHorse();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected Map runningHorse() throws InterruptedException {
        Map resultMap = HorseApp.resultMap;
        double distanceMadeGood = 0;
        while (distanceMadeGood < HIPPODROME) {
            if (step < (HIPPODROME - distanceMadeGood)) {
                distanceMadeGood += step;
            } else {
                distanceMadeGood += (HIPPODROME - distanceMadeGood);
            }
            Thread.sleep(1);
        }
        long finishRacing = System.currentTimeMillis();
        resultMap.put(name, new SimpleDateFormat("dd-MM-yyyy HH:mm:ss SS").format(finishRacing));
        return resultMap;
    }
}




