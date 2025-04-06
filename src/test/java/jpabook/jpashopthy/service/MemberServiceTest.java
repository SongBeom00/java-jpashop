package jpabook.jpashopthy.service;

import jpabook.jpashopthy.domain.Member;
import jpabook.jpashopthy.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    @Rollback(value = false)
    void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("kim");
        
        //when
        Long savedId = memberService.join(member);

        //then
        assertEquals(member,memberRepository.findOne(savedId));

    }

    @Test
    void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("kim1");
        Member member2 = new Member();
        member2.setName("kim1");

        //when
        memberService.join(member1);
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2); //예외가 발생해야 한다!!
        });

        //then
        assertEquals("이미 존재하는 회원입니다",exception.getMessage());

    }


}