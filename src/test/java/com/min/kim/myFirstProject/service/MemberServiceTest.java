package com.min.kim.myFirstProject.service;

import com.min.kim.myFirstProject.domain.Member;

import com.min.kim.myFirstProject.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;// = new MemberService(MemberRepository);
    MemoryMemberRepository MemberRepository;// = new MemoryMemberRepository();
    //테스트와 개발의 memoryMemberRepository가 다름.

    @BeforeEach
    public void beforeEach() {
        MemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(MemberRepository);
    }

    @AfterEach
    public void afterEach() {
        MemberRepository.clearStore();
    }
    //cmd +sht + t : 클래스명 + Test 로 testCase 생성
    @Test
    void join() {
        //givin
        Member member = new Member();
        member.setName("spring");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //givin
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}