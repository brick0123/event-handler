package com.woodcock.member;

import com.woodcock.coupon.CouponIssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class SignUpMemberEventHandler {

    private final CouponIssueService couponIssueService;

    @Async
    @TransactionalEventListener
    public void couponIssue(final SignUpMemberEvent signUpMemberEvent) {
        couponIssueService.issue(signUpMemberEvent.getMember());
    }
}
