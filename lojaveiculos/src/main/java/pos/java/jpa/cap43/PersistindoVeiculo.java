package pos.java.jpa.cap43;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import pos.java.jpa.JpaUtil;
import pos.java.jpa.dominio.Veiculo;
import pos.java.jpa.dominio.Veiculo.TipoCombustivel;

public class PersistindoVeiculo {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        tx.begin();
        Veiculo veiculo = new Veiculo();

        veiculo.setFabricante("Ford");
        veiculo.setModelo("Focus");
        veiculo.setAnoFabricacao(2019);
        veiculo.setAnoModelo(2020);
        veiculo.setValor(new BigDecimal(41_500));
        veiculo.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
        veiculo.setDataCadastro(new Date());

        manager.persist(veiculo);

        tx.commit();

        manager.close();
        JpaUtil.close();

    }
}