package start.startspring.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import start.startspring.domain.Member;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        //Assertions.assertEquals(member, null);
        Assertions.assertThat(result).isEqualTo(member);
        // assertj

    }

    @Test
    public void findByNamd(){
        Member member1 = new Member();
        member1.setName("mem1");
        repository.save((member1));


        Member member2 = new Member();
        member2.setName("mem2");
        repository.save((member2));

        Member result1 = repository.findByName("mem1").get();

        Assertions.assertThat(result1).isEqualTo(member1);


    }

    //findAll 만들기
}
