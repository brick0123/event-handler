package com.woodcock.user;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.woodcock.notification.SendEmailService;
import com.woodcock.point.UpdatePointService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class SignUpUserServiceTest {

    @Autowired
    SignUpUserService signUpUserService;

    @MockBean
    SendEmailService sendEmailService;

    @MockBean
    UpdatePointService updatePointService;

    @Test
    @DisplayName("유저를 저장하고 등록한 EventLister가 호출되는지 확인한다.")
    void verify_event() {
        final String email = "abc@naver.com";
        signUpUserService.register(email);

        verify(sendEmailService, times(1)).send(email);
        verify(updatePointService, times(1)).rewardPoint(anyLong());
    }
}
