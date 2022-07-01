package jpabook.jpashop;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

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
        tx.begin();

        try {

            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("김영한");

            Member member = new Member();
            member.setName("sss");
            member.setId(1l);
            String jpql = "SELECT m.name, 'a'||'b' , m.id FROM Member m";
            //String jpql = "SELECT m.name, concat('a','b') , m.id FROM Member m";
            List<Object[]> resultList = em.createQuery("SELECT m.name, 'Hello' , m.id FROM Member m ").getResultList();

            Object[] o = resultList.get(0);
            System.out.println("o1[0] = " + o[0]);
            System.out.println("o1[1] = " + o[1]);


            em.persist(book);

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
