package jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        //jpa의 모등 데이터 변경은 무조건 transaction안에서 일어나야 한다
        tx.begin();

        try {

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member");
            member.setAge(10);
            member.setType(MemberType.ADMIN);
            em.persist(member);

            member.setTeam(team);


            em.flush();
            em.clear();

            String query = "select m from Member m left outer join m.team t ";
            

            tx.commit();
       }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
        //was가 내려갈때 팩토리를 닫아줘야한, 그래야 리소스들이 릴리즈 된다
    }
}
