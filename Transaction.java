import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private List<String> history = new ArrayList<>();

    public void add(String record) {
        history.add(record);
    }

    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        for (String h : history) {
            System.out.println(h);
        }
    }
}
