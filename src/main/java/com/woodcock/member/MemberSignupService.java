package com.woodcock.member;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberSignupService {

    private final MemberRepository memberRepository;
    private final ApplicationEventPublisher eventPublisher;

    public void signUp(final String name) {
        final Member saveMember = memberRepository.save(new Member(name));
        eventPublisher.publishEvent(new SignUpMemberEvent(saveMember));
    }

}
