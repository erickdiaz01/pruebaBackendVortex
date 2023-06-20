package co.com.vortex.jpa.pedido;

import co.com.vortex.jpa.exception.UseCaseException;
import co.com.vortex.jpa.helper.AdapterOperations;

import co.com.vortex.model.pedido.Pedido;
import co.com.vortex.model.pedido.gateways.PedidoRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

import static co.com.vortex.jpa.converters.ConverterPedido.*;

@Repository
public class PedidoDataRepositoryAdapter extends AdapterOperations<Pedido, PedidoData, Integer, PedidoDataRepository>
        implements PedidoRepository {

    public PedidoDataRepositoryAdapter(PedidoDataRepository repository, ObjectMapper mapper) {

        super(repository, mapper, d -> mapper.map(d, Pedido.class));
    }

    @Override
    public List<Pedido> listarPedidos() {
        try {
            List<PedidoData> pedidos = (List<PedidoData>) repository.findAll();
            return !pedidos.isEmpty() ? convertPedidosDataToPedidos(pedidos) : List.of();
        } catch (Exception error) {
            throw new UseCaseException("No fue posible listar los pedidos", error);
        }
    }

    @Override
    public Pedido crearPedido(Pedido pedido) {
        try {
            PedidoData pedidoData = convertPedidoToPedidoData(pedido);
            return convertPedidoDataToPedido(repository.save(pedidoData));
        } catch (Exception error) {
            throw new UseCaseException("No fue posible crear el pedido", error);
        }
    }

    @Override
    public Pedido findPedidoById(Integer id) {
        try {
            PedidoData pedidoData = repository.findById(id)
                    .orElseThrow(() -> new UseCaseException("No se encontro el pedido por el Id",
                            new Exception(new Throwable("Error con el id"))));
            return convertPedidoDataToPedido(pedidoData);
        } catch (Exception error) {
            throw new UseCaseException("No fue posible encontrar el pedido", error);
        }
    }
}
