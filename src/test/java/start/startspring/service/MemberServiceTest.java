package start.startspring.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import start.startspring.domain.Member;
import start.startspring.repository.MemoryMemberRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    // 테스트 간 데이터 클리어를 위해 리포지토리가 존재해야함
    MemoryMemberRepository memberRepository;

    @BeforeEach
    void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }


    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        // 해당예외가 터지면 성공, 해당 메세지 반환함
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));


//        memberService.join(member1);
//        try{
//            memberService.join(member2);
//            fail();
//        } catch(IllegalStateException e){
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미존재하는회원");
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