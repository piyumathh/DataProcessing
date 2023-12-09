import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class DBTests {

    @Test
    void test1() throws Exception {
        Database db = new Database();
        // should return null, because A doesn’t exist in the DB yet
        assertNull(db.get("A"));
    }
    @Test
    void test2() throws Exception {
        Database db = new Database();
        //should throw an error because a transaction is not in progress
        Exception e = assertThrows(Exception.class, () -> {
            db.put("A", 5);
        });
        System.out.println(e.getMessage());
    }

    @Test
    void test3() throws Exception {
        Database db = new Database();
        // starts a new transaction
        db.begin_transaction();
        // set’s value of A to 5, but it's not committed yet
        db.put("A", 5);
        // should return null, because updates to A are not committed yet
        assertNull(db.get("A"));
        // update A’s value to 6 within the transaction
        db.put("A", 6);
        // commits the open transaction
        db.commit();
        // should return 6, that was the last value of A to be committed
        db.get("A");
        assertEquals(6, (int) db.get("A"));
        // throws an error, because there is no open transaction
        Exception e = assertThrows(Exception.class, db::commit);
        System.out.println(e.getMessage());
        // throws an error because there is no ongoing transaction
        Exception e2 = assertThrows(Exception.class, db::rollback);
        System.out.println(e2.getMessage());
        assertNull(db.get("B"));
        // starts a new transaction
        db.begin_transaction();
        // Set key B’s value to 10 within the transaction
        db.put("B", 10);
        // Rollback the transaction - revert any changes made to B
        db.rollback();
        // Should return null because changes to B were rolled back
        assertNull(db.get("B"));
    }
}
