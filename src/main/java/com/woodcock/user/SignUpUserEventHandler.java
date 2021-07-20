package com.woodcock.user;

import com.woodcock.notification.SendEmailService;
import com.woodcock.point.UpdatePointService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SignUpUserEventHandler {

    private final SendEmailService sendEmailService;
    private final UpdatePointService updatePointService;

//    @Async
    @EventListener
    public void sendMail(final SignUpUserEvent signUpUserEvent) {
        final String email = signUpUserEvent.getUser().getEmail();
        sendEmailService.send(email);
    }

//    @Async
    @EventListener
    public void rewardPoint(final SignUpUserEvent signUpUserEvent) {
        final Long userId = signUpUserEvent.getUser().getId();
        updatePointService.rewardPoint(userId);
    }
}
