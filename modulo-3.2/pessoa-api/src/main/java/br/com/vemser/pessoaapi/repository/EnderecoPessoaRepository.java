package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entities.EnderecoPessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoPessoaRepository extends JpaRepository<EnderecoPessoa, Integer> {
}
