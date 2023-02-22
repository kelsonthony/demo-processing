package com.ebsco.folio.nortecprocessing.domain.service;

import com.ebsco.folio.nortecprocessing.domain.model.Nortec;
import com.ebsco.folio.nortecprocessing.domain.repository.NortecRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NortecService {

    @Autowired
    private NortecRepository nortecRepository;

    public Page<Nortec> listAll(Pageable pageable) {

        return nortecRepository.findAll(pageable);
    }
}
