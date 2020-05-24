package pos.java.jpa.cap49;

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
        proprietario.setTelefone("(21) 9999-9999");

        manager.persist(proprietario);

        Veiculo veiculo1 = new Veiculo();
        veiculo1.setFabricante("GM");
        veiculo1.setModelo("Celta");
        veiculo1.setAnoFabricacao(2015);
        veiculo1.setAnoModelo(2015);
        veiculo1.setValor(new BigDecimal(11_000));
        veiculo1.setTipoCombustivel(TipoCombustivel.GASOLINA);
        veiculo1.setDataCadastro(new Date());
        veiculo1.setProprietario(proprietario);

        manager.persist(veiculo1);

        Veiculo veiculo2 = new Veiculo();
        veiculo2.setFabricante("VW");
        veiculo2.setModelo("Gol");
        veiculo2.setAnoFabricacao(2018);
        veiculo2.setAnoModelo(2018);
        veiculo2.setValor(new BigDecimal(17_200));
        veiculo2.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
        veiculo2.setDataCadastro(new Date());
        veiculo2.setProprietario(proprietario);

        manager.persist(veiculo2);

        tx.commit();

        manager.close();
        JpaUtil.close();

    }
}