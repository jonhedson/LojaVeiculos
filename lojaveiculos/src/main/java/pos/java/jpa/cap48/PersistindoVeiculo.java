package pos.java.jpa.cap48;

import java.util.List;

import javax.persistence.EntityManager;

import pos.java.jpa.JpaUtil;
import pos.java.jpa.dominio.Proprietario;
import pos.java.jpa.dominio.Veiculo;

public class PersistindoVeiculo {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();

        List<Veiculo> veiculos = manager.createQuery("select v from Veiculo v", Veiculo.class).getResultList();

        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo.getModelo() + " - " + veiculo.getProprietario().getNome());
        }

        Proprietario proprietario = manager.find(Proprietario.class, 1L);
        System.out.println(proprietario.getVeiculo().getModelo() + " - " + proprietario.getNome());

        manager.close();
        JpaUtil.close();

    }
}