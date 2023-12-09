import java.util.HashMap;
import java.util.Map;
public class Database {
    Map<String, Integer> database = new HashMap<>();
    Map<String, Integer> stagingArea = new HashMap<>();
    boolean inTransaction;

    public Database() {
        inTransaction = false;
    }

    public void begin_transaction() {
        if (!inTransaction)
            inTransaction = true;
        else
            System.out.println("Already in a transaction.");
    }

    public void put(String key, Integer value) throws Exception {
        if (inTransaction)
            stagingArea.put(key, value);
        else
            throw new Exception("Can't invoke put() when not in a transaction.");
    }

    public Integer get(String key) {
        return database.get(key);
    }

    public void commit() throws Exception {
        if (!inTransaction)
            throw new Exception("Can't invoke commit() when not in a transaction.");
        else {
            database.putAll(stagingArea);
            stagingArea.clear();
            inTransaction = false;
        }
    }

    public void rollback() throws Exception {
        if (!inTransaction)
            throw new Exception("Can't invoke rollback() when not in a transaction.");
        else {
            stagingArea.clear();
            inTransaction = false;
        }
    }

}
