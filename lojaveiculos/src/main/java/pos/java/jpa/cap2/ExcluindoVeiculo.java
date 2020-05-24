package pos.java.jpa.cap2;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import pos.java.jpa.JpaUtil;
import pos.java.jpa.dominio.Veiculo;

public class ExcluindoVeiculo {
    public static void main(String[] args) {

        EntityManager manager = JpaUtil.getEntityManager();

        EntityTransaction tx = manager.getTransaction();

        tx.begin();

        Veiculo veiculo = manager.find(Veiculo.class, 1L);

        manager.remove(veiculo);

        tx.commit();

        manager.close();
        JpaUtil.close();
    }

}