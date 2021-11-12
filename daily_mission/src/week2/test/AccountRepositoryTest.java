package week2.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import week2.account.book.info.AccountInfo;
import week2.account.book.info.AccountInfoRepository;

public class AccountRepositoryTest {
    AccountInfoRepository accountInfoRepository;


    @Test
    void 저장테스트() {
        //given
        AccountInfo accountInfo1 = new AccountInfo("0811", "me", 1000, 10);
        AccountInfo accountInfo2 = new AccountInfo("0812", "you", 2000, 20);
        //when
        accountInfoRepository.save(accountInfo1);
        accountInfoRepository.save(accountInfo2);
        //then

    }



}
