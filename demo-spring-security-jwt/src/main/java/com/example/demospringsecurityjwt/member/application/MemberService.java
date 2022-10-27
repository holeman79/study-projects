package com.example.demospringsecurityjwt.member.application;

import com.example.demospringsecurityjwt.generic.config.security.jwt.JwtTokenProvider;
import com.example.demospringsecurityjwt.member.dto.SignupRequest;
import com.example.demospringsecurityjwt.member.exception.MemberAlreadyExistException;
import com.example.demospringsecurityjwt.member.domain.Member;
import com.example.demospringsecurityjwt.member.domain.MemberRepository;
import com.example.demospringsecurityjwt.member.dto.LoginRequest;
import com.example.demospringsecurityjwt.member.dto.MemberDto;
import com.example.demospringsecurityjwt.member.exception.MemberNotFoundException;
import com.example.demospringsecurityjwt.member.exception.MemberPasswordNotMatchedException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final JwtTokenProvider jwtTokenProvider;

    private final PasswordEncoder passwordEncoder;

    public MemberDto login(final LoginRequest loginRequest) {
        Member member = findMember(loginRequest);
        String token = generateToken(member);
        return MemberDto.of(member, token);
    }

    private Member findMember(final LoginRequest loginRequest) {
        Member member = memberRepository.findByLoginId(loginRequest.getLoginId()).orElseThrow(() -> new MemberNotFoundException());
        validatePassword(loginRequest.getPassword(), member.getPassword());
        return member;
    }

    private void validatePassword(final String requestPassword, final String targetPassword) {
        if (!passwordEncoder.matches(requestPassword, targetPassword)) {
            throw new MemberPasswordNotMatchedException();
        }
    }

    public MemberDto signup(final SignupRequest signupRequest) {
        validateDuplicateMember(signupRequest.getLoginId());
        String encodedPassword = passwordEncoder.encode(signupRequest.getPassword());

        Member member = Member.createMember(signupRequest.getLoginId(), encodedPassword,
                signupRequest.getNickName(), signupRequest.getMemberRole());
        Member savedMember = memberRepository.save(member);
        String token = generateToken(savedMember);
        return MemberDto.of(savedMember, token);
    }

    private void validateDuplicateMember(final String loginId) {
        if (memberRepository.findByLoginId(loginId).isPresent()) {
            throw new MemberAlreadyExistException();
        }
    }

    private String generateToken(final Member member) {
        return jwtTokenProvider.generateToken(member.getLoginId(), member.getMemberRole());
    }
}
