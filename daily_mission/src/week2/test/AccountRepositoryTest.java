package week2.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import week2.account.book.info.AccountInfo;
import week2.account.book.info.AccountInfoRepository;
import week2.account.book.info.User;
import week2.account.book.info.UserRepository;

import java.util.List;

public class AccountRepositoryTest {
    AccountInfoRepository accountInfoRepository;
    UserRepository userRepository;

    @AfterEach
    void clear() {
        accountInfoRepository.clear();
    }
    @Test
    void 데이터저장테스트() {
        //given
        AccountInfo accountInfo1 = new AccountInfo("08월11일", "me", 1000, 10);
        AccountInfo accountInfo2 = new AccountInfo("08월12일", "you", 2000, 20);
        AccountInfo accountInfo3 = new AccountInfo("08월12일", "you", 2000, 20);
        AccountInfo accountInfo4 = new AccountInfo("08월12일", "you", 2000, 20);
        AccountInfo accountInfo5 = new AccountInfo("08월12일", "you", 2000, 20);
        //when
        accountInfoRepository.save(accountInfo1);
        accountInfoRepository.save(accountInfo2);
        accountInfoRepository.save(accountInfo3);
        accountInfoRepository.save(accountInfo4);
        accountInfoRepository.save(accountInfo5);
        //then
        List<AccountInfo> list = accountInfoRepository.getList();
        assertEquals(list.size(), 5);
    }



}
