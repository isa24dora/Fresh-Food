package com.fss.fresquinhos.domain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitasRepository extends JpaRepository<Receitas, Long> {

    Page<Receitas> findAllByAtivoTrue(Pageable paginacao);
}
