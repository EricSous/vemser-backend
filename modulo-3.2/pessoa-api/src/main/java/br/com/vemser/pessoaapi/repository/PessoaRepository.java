package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.dtos.PessoaCompostaTudoDTO;
import br.com.vemser.pessoaapi.entities.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {


    @Query(value = """
           select new br.com.vemser.pessoaapi.dtos.PessoaCompostaTudoDTO(
           p.id,
           p.nome,
           p.email,
           c.numero,
           e.cep,
           e.cidade,
           e.estado,
           e.pais,
           pet.nome)
           from PESSOA p
           left join p.contatos c
           left join p.enderecoPessoa e
           left join p.pet pet
           """)
    List<PessoaCompostaTudoDTO> findPessoaCompostaTudo();

}
