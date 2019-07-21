package br.com.eskinfotechweb.eskvenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eskinfotechweb.eskvenda.domain.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{

}
