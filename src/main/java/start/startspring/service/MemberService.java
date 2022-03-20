package start.startspring.service;

import org.springframework.stereotype.Service;
import start.startspring.domain.Member;
import start.startspring.repository.MemberRepository;
import start.startspring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;


public class MemberService {

    private final MemberRepository memberRepository;
    //


    // 리포지토리를 외부에서 넣어주게 바꿈 -> 달리 서비스를 생성해도 같은 리포지토리를 볼 수 있음
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
        회원가입
         */
    public Long join(Member member){

        //같은이름안됨
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m ->{
            throw new IllegalStateException("이미존재하는회원");
        });
    }

    /*
    전체회원조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
