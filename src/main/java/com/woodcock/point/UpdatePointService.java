package com.woodcock.point;

public interface UpdatePointService {

    void rewardPoint(final Long userId);

    void spendPoint(final Long userId);
}
