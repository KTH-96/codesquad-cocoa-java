package week2.account.book.member;

import java.util.HashMap;
import java.util.Map;

public class MemberRepository {
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }
    private static final Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    public Member save(Member member) {
        member.setId(sequence++);
        store.put(sequence, member);
        return member;
    }
    public Member findById(Long id){
        return store.get(id);
    }
}
