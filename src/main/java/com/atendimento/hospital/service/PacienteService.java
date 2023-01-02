package com.atendimento.hospital.service;


import com.atendimento.hospital.model.Medicacao;
import com.atendimento.hospital.model.Paciente;
import com.atendimento.hospital.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    // criação de dependencia
    @Autowired
    private PacienteRepository pacienteRepository;


    // Listar pacientes
    public List<Paciente> listarPacientes(){
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes;
    }

     // Cadastrar pacientes
    @Transactional  //caso erre alguma atualização de dado ele volta do inicio
    public Paciente cadastarPaciente(Paciente paciente){
        Medicacao medicacao1 = new Medicacao(1);
        Medicacao medicacao2 = new Medicacao(2);
        Medicacao medicacao3 = new Medicacao(3);
        Medicacao medicacao4 = new Medicacao(4);
        Medicacao medicacao5 = new Medicacao(5);
        Medicacao medicacao6 = new Medicacao(6);


        if (paciente.getNivel_dor() == 0){
            paciente.setAlta(true);
        }
        else if (paciente.getNivel_dor() == 1 && paciente.getNivel_dor() == 2){
            paciente.setMedicacao(medicacao1);
        } else if (paciente.getNivel_dor() == 3 && paciente.getNivel_dor() ==4) {
            paciente.setMedicacao(medicacao2);
            paciente.setAlta(false);
        } else if (paciente.getNivel_dor() == 5 && paciente.getNivel_dor() == 6){
            paciente.setMedicacao(medicacao3);
            paciente.setAlta(false);
        } else if (paciente.getNivel_dor() == 7 && paciente.getNivel_dor() == 8) {
            paciente.setMedicacao(medicacao4);
            paciente.setAlta(false);
        } else if (paciente.getNivel_dor() == 9){
            paciente.setMedicacao(medicacao5);
            paciente.setAlta(false);
        } if (paciente.getNivel_dor() == 10){
            paciente.setMedicacao(medicacao6);
            paciente.setAlta(false);
        }


        return pacienteRepository.save(paciente);

    }


    // Listar apenas um paciente
    public Optional<Paciente> listarPaciente(Integer id){
        return pacienteRepository.findById(id);
    }


    //Deletar paciente
    @Transactional
    public void deletarPaciente(Integer id){
        pacienteRepository.deleteById(id);
    }
}
