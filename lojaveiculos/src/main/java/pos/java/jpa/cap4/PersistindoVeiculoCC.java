package pos.java.jpa.cap4;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import pos.java.jpa.JpaUtil;
import pos.java.jpa.dominio.VeiculoCC;
import pos.java.jpa.dominio.VeiculoId;

public class PersistindoVeiculoCC {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        tx.begin();
        VeiculoCC veiculo = new VeiculoCC();

        veiculo.setId(new VeiculoId("ABC-1234", "Uberlândia"));
        veiculo.setFabricante("Honda");
        veiculo.setModelo("Civic");
        veiculo.setAnoFabricacao(2012);
        veiculo.setAnoModelo(2013);
        veiculo.setValor(new BigDecimal(71_300));

        manager.persist(veiculo);

        tx.commit();

        manager.close();
        JpaUtil.close();

    }
}