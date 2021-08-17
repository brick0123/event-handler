package com.woodcock.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SignUpMemberEvent {

    private final Member member;
}
