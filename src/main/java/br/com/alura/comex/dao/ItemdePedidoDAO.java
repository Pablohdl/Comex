package dao;

import br.com.alura.comex.model.ItemDePedido;

import javax.persistence.EntityManager;

public class ItemdePedidoDAO {

    private EntityManager em;

    public ItemdePedidoDAO(EntityManager em) {
        this.em = em;
    }

    public void inserirItemPedido(ItemDePedido item){
        this.em.persist(item);

    }
}
