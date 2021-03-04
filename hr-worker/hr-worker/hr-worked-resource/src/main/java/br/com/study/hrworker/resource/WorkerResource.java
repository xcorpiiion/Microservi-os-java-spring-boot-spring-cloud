package br.com.study.hrworker.resource;

import br.com.study.hrworker.model.Worker;
import br.com.study.hrworker.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/workers")
public class WorkerResource {

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> workers = this.repository.findAll();
        return ok(workers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable("id") Long id) {
        Optional<Worker> worker = this.repository.findById(id);
        return worker.map(ResponseEntity::ok).orElseGet(() -> notFound().build());
    }

}
