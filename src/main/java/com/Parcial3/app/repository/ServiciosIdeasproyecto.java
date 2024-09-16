package com.Parcial3.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Parcial3.app.variables.Ideasproyecto;
import com.Parcial3.app.variables.Profesor;


public interface ServiciosIdeasproyecto extends JpaRepository<Ideasproyecto, Integer> {
    List<Ideasproyecto> findByDirector(Profesor director);

	List<Ideasproyecto> findByDirectorAndEvaluadorIsNull(Profesor director);

	List<Ideasproyecto> findByEvaluador(Profesor evaluador);
}
