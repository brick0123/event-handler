package com.woodcock.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SignUpUserEvent {

    private final User user;
}
