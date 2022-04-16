package com.min.kim.myFirstProject;

import com.min.kim.myFirstProject.repository.MemberRepository;
import com.min.kim.myFirstProject.repository.MemoryMemberRepository;
import com.min.kim.myFirstProject.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
