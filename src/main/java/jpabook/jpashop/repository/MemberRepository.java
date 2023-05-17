package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
//    @PersistenceContext
//    private EntityManager em; //application.yml에서 설정한거 + 스프링부트 스타터에서 어노테이션보고 주입해줌
    private final EntityManager em;
    public void save(Member member) {
        // 멤버 반환안하고 ID 반환하는 이유 : 커맨드와 쿼리를 분리하라 원칙
        em.persist(member);
        // return member.getId();
    }
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select  m from Member m", Member.class)
                .getResultList();
    }

    public  List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
