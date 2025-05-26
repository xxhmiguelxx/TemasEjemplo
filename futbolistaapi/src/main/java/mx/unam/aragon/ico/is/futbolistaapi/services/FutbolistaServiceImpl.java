package mx.unam.aragon.ico.is.futbolistaapi.services;

import mx.unam.aragon.ico.is.futbolistaapi.entities.Futbolista;
import mx.unam.aragon.ico.is.futbolistaapi.repositories.FutbolistaRepository;
import mx.unam.aragon.ico.is.futbolistaapi.services.interfaces.FutbolistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FutbolistaServiceImpl implements FutbolistaService {

    @Autowired
    private FutbolistaRepository futbolistaRepository;

    @Override
    public Futbolista crear(Futbolista futbolista) {
        return futbolistaRepository.save(futbolista);
    }

    @Override
    public Iterable<Futbolista> listarTodos() {
        return futbolistaRepository.findAll();
    }

    @Override
    public Optional<Futbolista> buscarPorId(Long clave) {
        return futbolistaRepository.findById(clave);
    }

    @Override
    public Futbolista actualizar(Long clave, Futbolista futbolista) {
        Optional<Futbolista> futbolistaActual=futbolistaRepository.findById(clave);

        if (futbolistaActual.isPresent()){

            Futbolista tmp=futbolistaActual.get();

            tmp.setClave(futbolista.getClave());
            tmp.setNombre(futbolista.getNombre());
            tmp.setNacionalidad(futbolista.getNacionalidad());
            tmp.setFoto(futbolista.getFoto());
            tmp.setAltura(futbolista.getAltura());

            return futbolistaRepository.save(tmp);
        }else {
            return null;

        }

    }

    @Override
    public Futbolista eliminar(Long clave) {

       return futbolistaRepository.deleteByClave(clave);
    }
}
