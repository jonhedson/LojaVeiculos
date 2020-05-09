package pos.java.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VeiculoFactory {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lojaveiculos-PU");
        entityManagerFactory.close();
    }

}