package pos.java.jpa.cap47;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import pos.java.jpa.JpaUtil;
import pos.java.jpa.dominio.Proprietario;
import pos.java.jpa.dominio.Veiculo;
import pos.java.jpa.dominio.Veiculo.TipoCombustivel;

public class PersistindoVeiculo {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();

        tx.begin();

        Proprietario proprietario = new Proprietario();
        proprietario.setNome("João das Couves");
        proprietario.setTelefone("(21) 1111-1111");

        manager.persist(proprietario);

        Veiculo veiculo = new Veiculo();

        veiculo.setFabricante("VW");
        veiculo.setModelo("Gol");
        veiculo.setAnoFabricacao(2019);
        veiculo.setAnoModelo(2019);
        veiculo.setValor(new BigDecimal(17_200));
        veiculo.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
        veiculo.setDataCadastro(new Date());

        veiculo.setProprietario(proprietario);

        manager.persist(veiculo);

        tx.commit();

        manager.close();
        JpaUtil.close();

    }
}