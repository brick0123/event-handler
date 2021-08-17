package com.woodcock.member;

import static org.assertj.core.api.Assertions.assertThat;

import com.woodcock.coupon.Coupon;
import com.woodcock.coupon.CouponRepository;
import com.woodcock.notification.SendEmailService;
import com.woodcock.point.UpdatePointService;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class MemberSignupServiceTest {

    @MockBean
    SendEmailService sendEmailService;

    @MockBean
    UpdatePointService updatePointService;

    @Autowired
    MemberSignupService memberSignupService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    CouponRepository couponRepository;

    @Test
    @DisplayName("쿠폰과 회원을 정상적으로 저장한다.")
    void success() {
        memberSignupService.signUp("woody");

        final List<Member> members = memberRepository.findAll();
        assertThat(members.size()).isEqualTo(1);

        final List<Coupon> coupons = couponRepository.findAll();
        assertThat(coupons.size()).isEqualTo(1);
    }
}
