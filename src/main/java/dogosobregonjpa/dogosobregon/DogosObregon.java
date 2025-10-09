package dogosobregonjpa.dogosobregon;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author alfre
 */
public class DogosObregon {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DogosObregonPU");
        EntityManager em = emf.createEntityManager();
    }
}
