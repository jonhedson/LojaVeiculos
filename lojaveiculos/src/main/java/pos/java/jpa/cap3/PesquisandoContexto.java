package pos.java.jpa.cap3;

import javax.persistence.EntityManager;

import pos.java.jpa.JpaUtil;
import pos.java.jpa.dominio.Veiculo;

public class PesquisandoContexto {
    public static void main(String[] args) {

        EntityManager manager = JpaUtil.getEntityManager();

        Veiculo veiculo1 = manager.find(Veiculo.class, 2L);

        System.out.println("Buscou veiculo primeira vez...");

        System.out.println("Gerenciado?" + manager.contains(veiculo1));

        manager.detach(veiculo1);

        System.out.println("E agora?" + manager.contains(veiculo1));

        Veiculo veiculo2 = manager.find(Veiculo.class, 2L);
        System.out.println("Buscou veiculo segunda vez...");

        System.out.println("Mesmo veículo?" + (veiculo1 == veiculo2));

        manager.close();
        JpaUtil.close();
    }

}