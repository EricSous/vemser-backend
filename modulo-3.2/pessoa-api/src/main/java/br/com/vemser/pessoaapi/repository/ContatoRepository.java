package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entities.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {

}
