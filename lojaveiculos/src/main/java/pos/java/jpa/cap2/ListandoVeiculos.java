package pos.java.jpa.cap2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pos.java.jpa.JpaUtil;
import pos.java.jpa.dominio.Veiculo;

public class ListandoVeiculos {
    public static void main(String[] args) {

        EntityManager manager = JpaUtil.getEntityManager();

        // createQuery = ("from Veiculo v")
        Query query = manager.createQuery("select v from Veiculo v");

        List<Veiculo> veiculos = query.getResultList();

        for (Veiculo veiculo : veiculos) {
            System.out.println(
                    veiculo.getCodigo() + " - " + veiculo.getFabricante() + " " + veiculo.getAnoModelo() + ", ano "
                            + veiculo.getAnoFabricacao() + "/" + veiculo.getAnoModelo() + " por " + veiculo.getValor());
        }

        manager.close();
        JpaUtil.close();
    }
}