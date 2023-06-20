package co.com.vortex.jpa.pedido;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface PedidoDataRepository extends CrudRepository<PedidoData, Integer>, QueryByExampleExecutor<PedidoData> {
}
