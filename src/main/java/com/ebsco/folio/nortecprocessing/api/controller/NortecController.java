package com.ebsco.folio.nortecprocessing.api.controller;

import com.ebsco.folio.nortecprocessing.domain.model.Nortec;
import com.ebsco.folio.nortecprocessing.domain.repository.NortecRepository;
import com.ebsco.folio.nortecprocessing.domain.service.NortecService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping(value = "/nortec", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
@RequestMapping(value = "/nortec")
public class NortecController {
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Autowired
    private NortecRepository nortecRepository;

    @Autowired
    private NortecService nortecService;

    @GetMapping("/list")
    public Page<Nortec> getAll(@PageableDefault(size = 10) Pageable pageable) {
        return nortecService.listAll(pageable);
    }

    @GetMapping(value = "/listnortec", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public List<Nortec> getAllNortec() {
        return nortecRepository.findAll();
    }

    /*@GetMapping(value = "/listnortec2", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public OAIDataList<Nortec> getAllNortec2() {
        return (OAIDataList) nortecRepository.findAll();
    }*/

    @PostMapping(path = "/importnortec")
    public void startBach() {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("startAt", System.currentTimeMillis()).toJobParameters();
        try {
            jobLauncher.run(job, jobParameters);
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
            e.printStackTrace();
        }
    }


}
