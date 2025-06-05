package mx.unam.aragon.ico.is.futbolistaapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

@Entity
@Table (name = "futbolistas")
public class Futbolista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clave;

    @Column(name = "nombre_futbolista", nullable = false, length = 50)
    private String nombre;


    @Column(name = "nacionalidad_futbolista",
            columnDefinition = "VARCHAR(50) not null")
    @NotBlank(message = "El campo no debe tener espacios en blanco")
    @NotNull(message = "No debe de ser null")
    private String nacionalidad;

    @Column(name = "url_foto", nullable = true,
            insertable = false, columnDefinition = "VARCHAR(300) DEFAULT 'https://archive.org/download/placeholder-image/placeholder-image.jpg' ")
    private String foto;

    @Column(name = "altura_futbolista", nullable = true)
    private Float altura;


    public Futbolista() {
    }

    public Futbolista(Integer clave, String nombre, String nacionalidad, String foto, Float altura) {
        this.clave = clave;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.foto = foto;
        this.altura = altura;
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Futbolista{" +
                "clave=" + clave +
                ", nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", foto='" + foto + '\'' +
                ", altura=" + altura +
                '}';
    }
}
