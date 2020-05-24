package pos.java.jpa.cap2;

import javax.persistence.EntityManager;

import pos.java.jpa.JpaUtil;
import pos.java.jpa.dominio.Veiculo;

public class BuscandoVeiculo {
    public static void main(String[] args) {

        EntityManager manager = JpaUtil.getEntityManager();

        // Veiculo veiculo = manager.find(Veiculo.class, 1L);
        Veiculo veiculo = manager.getReference(Veiculo.class, 1L);

        System.out.println("Veiculo de código " + veiculo.getCodigo() + " é um " + veiculo.getModelo());

        manager.close();
        JpaUtil.close();
    }
}