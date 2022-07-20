package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entities.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {


    List<PessoaEntity> findByIdLike(Integer id);

    PessoaEntity findByIdOrIdNull(Integer id);


}
