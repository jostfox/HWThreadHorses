import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HorseApp {
    public static void main(String[] args)  {


        List <String> horseNames = Arrays.asList("Amelia", "Diamond", "Amar", "Gaks", "Woodward",
                                                "Davy", "Jak", "Zorro", "Milano", "Talisman");

        List <Thread> threadList = horseNames.stream()
                .map(name -> new Thread(new Horse(name, Math.random()*2)))
                .toList();

        threadList.forEach(t -> t.start());
        threadList.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        new Thread(new ResultPrinter(horseNames)).start();

    }
    public static Map resultMap = new ConcurrentHashMap<>();
}

