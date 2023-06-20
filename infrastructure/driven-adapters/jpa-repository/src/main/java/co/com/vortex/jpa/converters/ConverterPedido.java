package co.com.vortex.jpa.converters;

import co.com.vortex.jpa.pedido.PedidoData;

import co.com.vortex.model.pedido.Pedido;

import java.util.List;

public class ConverterPedido {

    private ConverterPedido() {
        throw new IllegalStateException("Utility Class");
    }

    public static Pedido convertPedidoDataToPedido(PedidoData pedidoData) {
        return pedidoData != null ? Pedido.builder()
                .id(pedidoData.getId())
                .conductor(pedidoData.getConductor() == null ? null
                        : ConverterConductor.convertConductorDataToConductor(pedidoData.getConductor()))
                .tipoPedido(pedidoData.getTipoPedido())
                .direccion(pedidoData.getDireccion())
                .build()
                : Pedido.builder().build();

    }

    public static List<Pedido> convertPedidosDataToPedidos(List<PedidoData> pedidoDataList) {
        return pedidoDataList.stream().map(ConverterPedido::convertPedidoDataToPedido).toList();
    }

    public static PedidoData convertPedidoToPedidoData(Pedido pedido) {
        PedidoData pedidoData = new PedidoData();
        if (pedido != null) {
            pedidoData.setId(pedido.getId());
            pedidoData.setConductor(pedido.getConductor() == null ? null
                    : ConverterConductor.convertConductorToConductorData(pedido.getConductor()));
            pedidoData.setTipoPedido(pedido.getTipoPedido());
            pedidoData.setDireccion(pedido.getDireccion());
        }
        return pedidoData;
    }

    public static List<PedidoData> convertPedidosToPedidosData(List<Pedido> pedidos) {
        return pedidos.stream().map(ConverterPedido::convertPedidoToPedidoData).toList();
    }
}
