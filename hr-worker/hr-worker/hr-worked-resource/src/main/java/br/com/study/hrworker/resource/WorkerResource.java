package br.com.study.hrworker.resource;

import br.com.study.hrworker.model.Worker;
import br.com.study.hrworker.repository.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/workers")
public class WorkerResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkerResource.class);

    @Autowired
    private Environment environment;

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> workers = this.repository.findAll();
        return ok(workers);
    }

    @GetMapping("/configs")
    public ResponseEntity<Void> findConfig() {
        LOGGER.info("Config: " + this.environment.getActiveProfiles());
        return noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable("id") Long id) {
        LOGGER.info("Port: " + this.environment.getProperty("local.server.port"));
        Optional<Worker> worker = this.repository.findById(id);
        return worker.map(ResponseEntity::ok).orElseGet(() -> notFound().build());
    }

}
