package mx.unam.aragon.ico.is.futbolistaapi.repositories;

import mx.unam.aragon.ico.is.futbolistaapi.entities.Futbolista;
import org.springframework.data.repository.CrudRepository;

public interface FutbolistaRepository extends CrudRepository<Futbolista, Long> {

    public Futbolista findFutbolistaByClave(Long clave);

    public Futbolista deleteByClave(Long clave);

}
