package mx.unam.aragon.ico.is.futbolistaapi.services.interfaces;

import mx.unam.aragon.ico.is.futbolistaapi.entities.Futbolista;

import java.util.Optional;

public interface FutbolistaService {
    public abstract Futbolista crear(Futbolista futbolista);
    public abstract Iterable<Futbolista> listarTodos();
    public abstract Optional<Futbolista> buscarPorId(Long clave);
    public abstract Futbolista actualizar(Long clave, Futbolista futbolista);
    public abstract Futbolista eliminar(Long clave);
}
