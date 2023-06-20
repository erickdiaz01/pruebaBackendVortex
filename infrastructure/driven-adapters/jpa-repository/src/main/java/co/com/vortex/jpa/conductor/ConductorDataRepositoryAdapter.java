package co.com.vortex.jpa.conductor;

import co.com.vortex.jpa.exception.UseCaseException;
import co.com.vortex.jpa.helper.AdapterOperations;
import co.com.vortex.model.conductor.Conductor;
import co.com.vortex.model.conductor.gateways.ConductorRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

import static co.com.vortex.jpa.converters.ConverterConductor.*;

@Repository
public class ConductorDataRepositoryAdapter extends AdapterOperations<Conductor, ConductorData, Integer, ConductorDataRepository>
 implements ConductorRepository
{

        public ConductorDataRepositoryAdapter(ConductorDataRepository repository, ObjectMapper mapper) {

            super(repository, mapper, d -> mapper.map(d, Conductor.class));
        }

    @Override
    public Conductor findConductorByIdentificacion(String identificacion) {
            try {
                return convertConductorDataToConductor(repository.findConductorDataByIdentificacion(identificacion));
            }catch (Exception error){
                throw new UseCaseException("No fue posible encontrar el conductor por la identificacion",error);
            }

    }

    @Override
    public List<Conductor> listarConductores() {
            try {
                List<ConductorData> conductores = (List<ConductorData>) repository.findAll();
                return !conductores.isEmpty() ? convertCondutoresDataToConductores(conductores) : List.of();
            }catch (Exception error){
                throw new UseCaseException("No fue posible listar los conductores, error en el repositorio",error);
            }

    }

    @Override
    public Conductor registrarConductor(Conductor conductor) {
       try {
           ConductorData  conductorData = repository.findConductorDataByIdentificacion(conductor.getIdentificacion());
           if(conductorData!=null){
               throw new IllegalArgumentException("Ya existe un conductor con esa identificacion");
           }
           conductorData = convertConductorToConductorData(conductor);
           return convertConductorDataToConductor(repository.save(conductorData));
       }catch (Exception error){
           throw new UseCaseException("No fue posible registrar el conductor",error);
       }
    }
}
