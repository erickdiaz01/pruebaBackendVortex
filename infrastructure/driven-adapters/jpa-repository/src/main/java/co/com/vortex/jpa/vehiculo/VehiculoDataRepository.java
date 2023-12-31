package co.com.vortex.jpa.vehiculo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface VehiculoDataRepository
        extends CrudRepository<VehiculoData, Integer>, QueryByExampleExecutor<VehiculoData> {
}
