package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entities.EnderecoPessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoPessoaRepository extends JpaRepository<EnderecoPessoaEntity, Integer> {
}
