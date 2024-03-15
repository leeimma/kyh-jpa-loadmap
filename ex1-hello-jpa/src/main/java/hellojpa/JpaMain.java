package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member findMember = em.find(Member.class, 1l);
            findMember.setName("HelloJPA");

            // 1.
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("helloA");
//            em.persist(member);

            tx.commit();
        } catch (Exception e) {
            em.close();
        }

        emf.close();
    }
}
