package com.woodcock.coupon;

import com.woodcock.member.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
@RequiredArgsConstructor
public class CouponIssueService {

    private final CouponRepository couponRepository;

    public void issue(final Member member) {
        couponRepository.save(new Coupon(member, 1));
//        log.error("쿠폰 발급 도중 오류 발생 memberId = [{}]", member.getId());
//        throw new IllegalStateException("쿠폰 발행 도중 오류 발생");
    }
}
