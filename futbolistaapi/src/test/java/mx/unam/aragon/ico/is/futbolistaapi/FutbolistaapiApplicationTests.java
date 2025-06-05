package mx.unam.aragon.ico.is.futbolistaapi;

import mx.unam.aragon.ico.is.futbolistaapi.entities.Futbolista;
import mx.unam.aragon.ico.is.futbolistaapi.repositories.FutbolistaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FutbolistaapiApplicationTests {

	@Autowired
	private FutbolistaRepository futbolistaRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void insertarFutbolista(){

		Futbolista futbolista=new Futbolista(0, "Piero Quispe", "Peruana", null, 172.0f);
		futbolistaRepository.save(futbolista);
	}

	@Test
	void leerFutbolistaPorClave(){

		Integer claveTmp=2;
		Futbolista tmp = futbolistaRepository.findFutbolistaByClave(claveTmp);
		System.out.println(tmp);
	}

	@Test
	public void eliminarFutbolista(){
		Integer claveTmp=3;
		futbolistaRepository.deleteById(claveTmp);
	}

	@Test
	public void actualizarFutbolista(){

		Integer claveTmp=5;
		Futbolista tmp=futbolistaRepository.findFutbolistaByClave(claveTmp);
		tmp.setNacionalidad("Sin dato");
		futbolistaRepository.save(tmp);

	}

}
