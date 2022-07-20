package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entities.Professor;
import br.com.vemser.pessoaapi.entities.ProfessorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, ProfessorId> {
}
