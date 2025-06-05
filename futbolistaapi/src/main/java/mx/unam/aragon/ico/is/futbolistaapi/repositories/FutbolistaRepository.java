package mx.unam.aragon.ico.is.futbolistaapi.repositories;

import mx.unam.aragon.ico.is.futbolistaapi.entities.Futbolista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FutbolistaRepository extends JpaRepository<Futbolista, Integer> {

    public Futbolista findFutbolistaByClave(Integer clave);

    public Futbolista deleteByClave(Integer clave);

}
