package pos.java.jpa.cap3;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import pos.java.jpa.JpaUtil;
import pos.java.jpa.dominio.Veiculo;

public class SincronizandoContexto {
    public static void main(String[] args) {

        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        tx.begin();
        Veiculo veiculo = manager.find(Veiculo.class, 2L);

        System.out.println("Valor Atual: " + veiculo.getValor());
        veiculo.setValor(veiculo.getValor().add(new BigDecimal(500)));

        manager.flush();

        System.out.println("Novo Valor: " + veiculo.getValor());

        tx.commit();

        manager.close();
        JpaUtil.close();
    }
}