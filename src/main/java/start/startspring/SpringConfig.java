package start.startspring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import start.startspring.repository.JdbcMemberRepository;
import start.startspring.repository.JdbcTempleteMemberRepository;
import start.startspring.repository.MemberRepository;
import start.startspring.repository.MemoryMemberRepository;
import start.startspring.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){ // 어떤 리포지토리를 사용할지 빈에 직접 등록
        //return new JdbcTempleteMemberRepository(dataSource);
        //return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);

    }
}
