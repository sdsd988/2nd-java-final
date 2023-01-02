package sy.testPractice.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sy.testPractice.domain.member.entity.Member;

import java.util.Optional;


@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    Optional<Member> findByMemberName(String MemberName);

    Optional<Member> findById(Long memberId);
}
