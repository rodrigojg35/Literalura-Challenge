package com.juradogonzalezrodrigo.literalura.repository;

import com.juradogonzalezrodrigo.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    // Derived querys
    Optional<Autor> findByNombre(String nombre);
    List<Autor> findAllByOrderByNombreAsc();

    // Hubiese preferido hacerlo con JPQL pero como dice en el trello que se usen derived queries (en negritas)
    // supongo que respetaré la indicacion jeje
    List<Autor>
    findByFechaNacimientoLessThanEqualAndFechaFallecimientoGreaterThanEqual(
                                                                            int fechaNacimiento,
                                                                            int fechaFallecimiento
                                                                           );
}