package week2.account.book.info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountInfoRepository {
    private static final Map<Long, AccountInfo> store = new HashMap<>(); //스프링 컨테이너 안에서 쓰면 어차피 싱글톤이지만
    private static long sequence = 0L;

    public void save(AccountInfo accountInfo) {
        accountInfo.setId(++sequence);
        System.out.println("@@@@@@@"+sequence);
        System.out.println("========" + store.size());
        for (long i = 0; i < store.size(); i++) {
            System.out.println("*******" + store.get(i));// get(i) NULL
        }
        store.put(accountInfo.getId(), accountInfo);

    }
    public List<AccountInfo> getList() {
        System.out.println("리스트");
        ArrayList<AccountInfo> accountInfos = new ArrayList<>(store.values());
        for (AccountInfo accountInfo : accountInfos) {
            System.out.println("@@@@" + accountInfo);
        }
        return accountInfos;
    }

    public void removeInfo(Long id) {
        store.remove(id);
    }

    public void updateIndo(Long id , AccountInfo accountInfo) {
        removeInfo(id);
        store.put(id, accountInfo);
    }
}
