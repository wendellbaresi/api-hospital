package com.atendimento.hospital.controller;

import com.atendimento.hospital.model.Paciente;
import com.atendimento.hospital.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/{paciente}")
public class PacienteController {


    @Autowired
    private PacienteService pacienteService;


    // Listar todos pacientes
    @GetMapping
    public ResponseEntity<List<Paciente>> pegarTodosPacientes(){
        return ResponseEntity.ok().body(pacienteService.listarPacientes());
    }


    // Listar apenas um paciente
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> pegarPaciente( @PathVariable(value = "id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.listarPaciente(id));
    }


    // Inserir o paciente
    @PostMapping
    public ResponseEntity<Object> inserirPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.cadastarPaciente(paciente));
    }

    // Deletar o paciente
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletarPaciente(@PathVariable(value = "id") Integer id){
        pacienteService.deletarPaciente(id);
        return ResponseEntity.status(HttpStatus.OK).body("Paciente Removido do Sistema");
    }

    // Atualizar Paciente
    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> atualizarPaciente(@PathVariable(value = "id") Integer id,@RequestBody Paciente paciente){
        Optional<Paciente> dadosPaciente = pacienteService.listarPaciente(id);
        Paciente atualizarPaciente = dadosPaciente.get();
        atualizarPaciente.setCpf(paciente.getCpf());
        atualizarPaciente.setData_nascimento(paciente.getData_nascimento());
        atualizarPaciente.setDor(paciente.getDor());
        atualizarPaciente.setNivel_dor(paciente.getNivel_dor());
        atualizarPaciente.setNome(paciente.getNome());
        atualizarPaciente.setRg(paciente.getRg());

        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.cadastarPaciente(atualizarPaciente));
    }
}
