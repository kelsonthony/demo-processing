package com.ebsco.folio.nortecprocessing.listener;

import com.ebsco.folio.nortecprocessing.domain.model.Nortec;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.SkipListener;

public class StepSkipListener implements SkipListener<Nortec, Number> {
    Logger logger = LoggerFactory.getLogger(StepSkipListener.class);

    @Override //item Reader
    public void onSkipInRead(Throwable throwable) {
        logger.info("A failure on read {} ", throwable.getMessage());
    }

    @Override // item Writer
    public void onSkipInWrite(Number item, Throwable throwable) {
        logger.info("A failure on write {} , {} ", throwable.getMessage(), item);
    }

    @SneakyThrows
    @Override //item Process
    public void onSkipInProcess(Nortec nortec, Throwable throwable) {
        logger.info("Process Item {} was skipped to the exception {}",
                new ObjectMapper().writeValueAsString(nortec), throwable.getMessage());
    }
}
