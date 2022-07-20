package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Period;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {


    List<Pessoa> findByIdLike(Integer id);

    Pessoa findByIdOrIdNull(Integer id);


}
