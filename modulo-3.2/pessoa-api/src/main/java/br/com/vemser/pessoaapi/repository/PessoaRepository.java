package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
