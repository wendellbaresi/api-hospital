package com.atendimento.hospital.repository;

import com.atendimento.hospital.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository  extends JpaRepository<Paciente, Integer> {
}
