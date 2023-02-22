package com.ebsco.folio.nortecprocessing.config;

import com.ebsco.folio.nortecprocessing.domain.model.Nortec;
import org.springframework.batch.item.ItemProcessor;

public class NortecProcessor implements ItemProcessor<Nortec, Nortec> {
    @Override
    public Nortec process(Nortec nortec) throws Exception {
        /*if (customer.getCountry().equals("United States")) {
            return  customer;
        } else {
            return null;
        }*/
        return nortec;
    }
}
