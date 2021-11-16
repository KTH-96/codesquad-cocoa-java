package week2.account.book.info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountInfoRepository {
    private static final Map<Long, AccountInfo> store = new HashMap<>();
    private static long sequence = 0L;

    private static final List<Integer> moneys = new ArrayList<>();

    public AccountInfo save(AccountInfo accountInfo) {
        accountInfo.setId(++sequence);
        store.put(accountInfo.getId(), accountInfo);
        return accountInfo;
    }

    public List<AccountInfo> getList() {
        ArrayList<AccountInfo> accountInfos = new ArrayList<>(store.values());
        return accountInfos;
    }

    public void removeInfo(Long id) {
        store.remove(id);
    }

    public void updateIndo(Long id , AccountInfo accountInfo) {
        removeInfo(id);
        store.put(id, accountInfo);
    }
    public void clear() {
        store.clear();
    }
}
