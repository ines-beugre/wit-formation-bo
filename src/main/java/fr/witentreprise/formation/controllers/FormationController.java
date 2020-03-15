package fr.witentreprise.formation.controllers;

import fr.witentreprise.formation.exception.BusinessException;
import fr.witentreprise.formation.exception.CodeMessage;
import fr.witentreprise.formation.models.Formation;
import fr.witentreprise.formation.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("${base.api.path}/formations")
public class FormationController {

    @Autowired
    FormationService formationService;

    @GetMapping(value= "/test")
    public String test () {
        return "hello";
    }

    @GetMapping
    public ResponseEntity<List<Formation>> list() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(formationService.list());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Formation> getById(@PathVariable("id") String id) {
        Formation formation = formationService.getById(id)
                .orElseThrow(() -> new BusinessException("", CodeMessage.XAB.getCode()));
        return ResponseEntity.status(HttpStatus.OK).body(formation);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Formation formation) {
        return ResponseEntity.status(HttpStatus.OK).body(formationService.save(formation));
    }
}
