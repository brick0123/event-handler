package com.woodcock.coupon;

import com.woodcock.member.Member;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Coupon {

    protected Coupon() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "member_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Member member;

    private Integer couponAmount;

    public Coupon(final Member member, final Integer couponAmount) {
        this.member = member;
        this.couponAmount = couponAmount;
    }
}
