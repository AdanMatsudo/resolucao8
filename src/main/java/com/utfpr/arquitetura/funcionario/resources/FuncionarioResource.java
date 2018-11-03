package com.utfpr.arquitetura.funcionario.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.utfpr.arquitetura.funcionario.entidades.Funcionario;

@RestController
public class FuncionarioResource {

	public ArrayList<Funcionario> funcionarios = new ArrayList<>();

	public FuncionarioResource() {
		funcionarios.add(new Funcionario(1L, "Adam Matsudo", 35, 4500.00f));
	}

	@GetMapping("/funcionario")
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	@PostMapping("/funcionario")
	public ResponseEntity<?> adicionarFuncionario(@RequestBody Funcionario funcionario) {

		for (Funcionario f : funcionarios) {
			if (f.getId().equals(funcionario.getId())) {
				return ResponseEntity.badRequest().body("Já existe um cadastro com esse ID");
			}
		}

		funcionarios.add(funcionario);
		return ResponseEntity.ok(funcionario);

	}

	@GetMapping("/funcionario/{id}")
	public Funcionario buscaFuncionario(@PathVariable("id") Long id) {
		for (Funcionario f : funcionarios) {
			if (f.getId().equals(id)) {
				 return f;
			}
		}
		return null;
	}

	@PutMapping("/funcionario/{id}")
	public Funcionario atualizaFuncionario(@PathVariable("id") Long id, @RequestBody Funcionario funcionario) {
				
		funcionarios.forEach(f -> {
			if (f.getId().equals(id)) {
				f.setIdade(funcionario.getIdade());
				f.setNome(funcionario.getNome());
				f.setSalario(funcionario.getSalario());
			}
		});
		
	
		return funcionario;
	}

	@DeleteMapping("/funcionario/{id}")
	public HttpStatus deletaFuncionario(@PathVariable("id") Long id) {
		for (Funcionario f : funcionarios) {
			if (f.getId().equals(id)) {
				funcionarios.remove(f);
				return HttpStatus.OK;
			}
		}
		return HttpStatus.BAD_REQUEST;
	}

}
