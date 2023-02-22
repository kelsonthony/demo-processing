package com.ebsco.folio.nortecprocessing.domain.repository;

import com.ebsco.folio.nortecprocessing.domain.model.Nortec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NortecRepository extends JpaRepository<Nortec, Integer> {
}
