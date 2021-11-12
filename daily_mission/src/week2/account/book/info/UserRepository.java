package week2.account.book.info;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static final Map<Long, User> store = new HashMap<>();
    private static long sequence = 0L;

    public void save(User user) {
        user.setId(++sequence);
        store.put(user.getId(), user);
    }
}
