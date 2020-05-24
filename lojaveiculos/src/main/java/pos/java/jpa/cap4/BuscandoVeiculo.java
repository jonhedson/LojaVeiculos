package pos.java.jpa.cap4;

import javax.persistence.EntityManager;

import pos.java.jpa.JpaUtil;
import pos.java.jpa.dominio.VeiculoCC;
import pos.java.jpa.dominio.VeiculoId;

public class BuscandoVeiculo {
    public static void main(String[] args) {

        EntityManager manager = JpaUtil.getEntityManager();

        VeiculoId id = new VeiculoId("AAA", "1111");
        VeiculoCC veiculo = manager.find(VeiculoCC.class, id);

        System.out.println("Placa: " + veiculo.getId().getPlaca());
        System.out.println("Cidade: " + veiculo.getId().getCidade());
        System.out.println("Fabricante: " + veiculo.getFabricante());
        System.out.println("Modelo: " + veiculo.getModelo());

        manager.close();
        JpaUtil.close();

    }
}