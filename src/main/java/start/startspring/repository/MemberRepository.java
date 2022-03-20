package start.startspring.repository;


import start.startspring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    // Optional : find 후 Null 일때 옵셔널로 감싸서 반환하려고
    List<Member> findAll();

}
