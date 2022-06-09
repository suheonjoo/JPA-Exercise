package study.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import study.querydsl.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long>, MemberRepositoryCustom, QuerydslPredicateExecutor<Member> {
    //QuerydslPredicateExecutor<Member>는 그냥 편이 들으라고 설명해준 부분
    List<Member> findByUsername(String username);
}








