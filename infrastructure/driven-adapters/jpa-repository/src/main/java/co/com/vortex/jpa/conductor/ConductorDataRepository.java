package co.com.vortex.jpa.conductor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ConductorDataRepository  extends CrudRepository<ConductorData, Integer>, QueryByExampleExecutor<ConductorData> {
    ConductorData findConductorDataByIdentificacion(String identificacion);
}
