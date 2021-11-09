package week2.account.book.data;

import week2.account.book.member.MemberRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataRepository {
    private static final DataRepository instance = new DataRepository();

    public static  DataRepository getInstance() {
        return instance;
    }
    private static final Map<Long, Data> store = new HashMap<>();
    private static long sequence = 0L;

    public Data dataSave(Data data){
        data.setId(sequence++);
        store.put(sequence, data);
        return data;
    }
    public Data findById(Long id){
        return store.get(id);
    }

    public List<Data> findByAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long id, Data updateDate){
        Data findData = findById(id);
        System.out.println("###updateDate.getDate() = "+ updateDate.getDate());
        findData.setDate(updateDate.getDate());
        findData.setReciever(updateDate.getReciever());
        findData.setIncome(updateDate.getIncome());
        findData.setOutput(updateDate.getOutput());
    }
    public void remove(Long id){
        store.remove(id);
    }
}
