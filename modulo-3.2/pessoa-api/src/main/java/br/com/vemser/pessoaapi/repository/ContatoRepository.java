package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entities.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {

}
