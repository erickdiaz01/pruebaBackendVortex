package co.com.vortex.jpa.pedido;

import co.com.vortex.jpa.conductor.ConductorData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface PedidoDataRepository extends CrudRepository<PedidoData, Integer>, QueryByExampleExecutor<PedidoData> {
}
