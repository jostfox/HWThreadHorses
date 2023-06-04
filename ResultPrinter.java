import java.util.*;

public class ResultPrinter implements Runnable {

    private List<String> horseList;

    public ResultPrinter(List<String> horseList) {
        this.horseList = horseList;
    }

    @Override
    public void run() {
        printResultTable(horseList);
    }

    public void printResultTable(List<String> horseList) {
        Map resultMap = HorseApp.resultMap;
        if (horseList.size() == resultMap.size()) {
            List<Map.Entry<String, String>> myList = new ArrayList<>(resultMap.entrySet());
            myList.sort((e1, e2) -> e1.getValue().compareTo(e2.getValue()));
            myList.forEach(element -> {
                System.out.println(element.toString()
                        .replace("=", " finished time: "));

            });
        }
    }
}
