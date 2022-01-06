package com.example.demospringsecurityjwt.member.api;

import com.example.demospringsecurityjwt.generic.response.ApiResponseDto;
import com.example.demospringsecurityjwt.member.application.MemberService;
import com.example.demospringsecurityjwt.member.dto.SignupRequest;
import com.example.demospringsecurityjwt.generic.config.security.jwt.JwtMember;
import com.example.demospringsecurityjwt.member.dto.LoginRequest;
import com.example.demospringsecurityjwt.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/login")
    public ApiResponseDto<MemberDto> login(@RequestBody @Valid LoginRequest loginRequest){
        MemberDto memberDto = memberService.login(loginRequest);
        return ApiResponseDto.OK(memberDto);
    }

    @PostMapping("/signup")
    public ApiResponseDto<MemberDto> signup(@RequestBody @Valid SignupRequest signupRequest){
        MemberDto memberDto = memberService.signup(signupRequest);
        return ApiResponseDto.OK(memberDto);
    }

    @GetMapping("/{id}")
    public ApiResponseDto<?> getMember(@PathVariable Long id){
        JwtMember jwtMember = (JwtMember)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(jwtMember);
        return ApiResponseDto.OK();

    }
}
