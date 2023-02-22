package com.ebsco.folio.nortecprocessing.config;

import com.ebsco.folio.nortecprocessing.domain.model.Nortec;
import com.ebsco.folio.nortecprocessing.domain.repository.NortecRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class NortecItemWriter implements ItemWriter<Nortec> {
    @Autowired
    private NortecRepository nortecRepository;

    @Override
    public void write(List<? extends Nortec> list) throws Exception {
        System.out.println("Thread Name: " + Thread.currentThread().getName());
        nortecRepository.saveAll(list);
    }
}
