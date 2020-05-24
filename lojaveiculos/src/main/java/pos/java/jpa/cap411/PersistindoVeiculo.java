package pos.java.jpa.cap411;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import pos.java.jpa.JpaUtil;
import pos.java.jpa.dominio.Acessorio;
import pos.java.jpa.dominio.Veiculo;
import pos.java.jpa.dominio.Veiculo.TipoCombustivel;

public class PersistindoVeiculo {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        // instancia acessórios
        Acessorio roda = new Acessorio();
        roda.setDescricao("Rodas de liga leve");
        Acessorio sensor = new Acessorio();
        sensor.setDescricao("Sensores de estacionamento");
        Acessorio mp3 = new Acessorio();
        mp3.setDescricao("MP3 Player");
        Acessorio pintura = new Acessorio();
        pintura.setDescricao("Pintura metalizada");

        manager.persist(roda);
        manager.persist(sensor);
        manager.persist(mp3);
        manager.persist(pintura);

        Veiculo veiculo1 = new Veiculo();
        veiculo1.setFabricante("GM");
        veiculo1.setModelo("Celta");
        veiculo1.setAnoFabricacao(2015);
        veiculo1.setAnoModelo(2015);
        veiculo1.setValor(new BigDecimal(11_000));
        veiculo1.setTipoCombustivel(TipoCombustivel.GASOLINA);
        veiculo1.setDataCadastro(new Date());
        veiculo1.getAcessorios().add(roda);
        veiculo1.getAcessorios().add(mp3);

        manager.persist(veiculo1);

        Veiculo veiculo2 = new Veiculo();
        veiculo2.setFabricante("VW");
        veiculo2.setModelo("Gol");
        veiculo2.setAnoFabricacao(2018);
        veiculo2.setAnoModelo(2018);
        veiculo2.setValor(new BigDecimal(17_200));
        veiculo2.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
        veiculo2.setDataCadastro(new Date());
        veiculo2.getAcessorios().add(roda);
        veiculo2.getAcessorios().add(sensor);
        veiculo2.getAcessorios().add(mp3);
        veiculo2.getAcessorios().add(pintura);

        manager.persist(veiculo1);
        manager.persist(veiculo2);

        Veiculo veiculo = manager.find(Veiculo.class, 1L);

        System.out.println("Veículo: " + veiculo.getModelo());
        for (Acessorio acessorio : veiculo.getAcessorios()) {
            System.out.println("Acessório: " + acessorio.getDescricao());
        }

        tx.commit();

        manager.close();
        JpaUtil.close();

    }
}