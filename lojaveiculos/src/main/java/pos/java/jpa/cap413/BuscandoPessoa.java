package pos.java.jpa.cap413;

import java.util.List;

import javax.persistence.EntityManager;

import pos.java.jpa.JpaUtil;
import pos.java.jpa.dominio.Cliente;

public class BuscandoPessoa {
    public static void main(String[] args) {
        EntityManager manager = JpaUtil.getEntityManager();

        List<Cliente> clientes = manager.createQuery("select c from Cliente c", Cliente.class).getResultList();

        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNome() + " - " + cliente.getRendaMensal());
        }

        manager.close();
        JpaUtil.close();

    }
}