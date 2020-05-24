package pos.java.jpa.cap3;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import pos.java.jpa.JpaUtil;
import pos.java.jpa.dominio.Veiculo;

public class SalvandoDesanexados {
    public static void main(String[] args) {

        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        tx.begin();
        Veiculo veiculo = manager.find(Veiculo.class, 2L);

        tx.commit();
        manager.close();

        veiculo.setValor(new BigDecimal(5_000));

        manager = JpaUtil.getEntityManager();
        tx = manager.getTransaction();
        tx.begin();

        veiculo = manager.merge(veiculo);

        tx.commit();

        manager.close();
        JpaUtil.close();
    }
}