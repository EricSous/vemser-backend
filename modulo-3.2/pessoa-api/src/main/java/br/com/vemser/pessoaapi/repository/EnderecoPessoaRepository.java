package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entities.EnderecoPessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoPessoaRepository extends JpaRepository<EnderecoPessoa, Integer> {
}
