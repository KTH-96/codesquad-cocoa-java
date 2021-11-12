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

    @AfterEach
    void clear() {
        accountInfoRepository.clear();
    }

    @Test
    void 데이터저장테스트() {
        //given
        //when
        //then

    }



}
