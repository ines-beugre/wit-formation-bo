package fr.witentreprise.formation.service;

import fr.witentreprise.formation.exception.BusinessException;
import fr.witentreprise.formation.exception.CodeMessage;
import fr.witentreprise.formation.models.Formation;
import fr.witentreprise.formation.repositories.FormationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FormationService {
    Logger LOGGER = LoggerFactory.getLogger(FormationService.class);

    @Autowired
    FormationRepository formationRepository;

    /**
     * Get formation list
     * @return list of formation
     */
    public List<Formation> list() {
        LOGGER.info("List all Formations");
        return formationRepository.findAll();
    }

    /**
     * get a formation depend on its id
     * @param id
     * @return a formation
     */
    public Optional<Formation> getById(String id) {
        LOGGER.info("Get a formation ");
        return formationRepository.findById(id);
    }

    public String save(Formation formation) {
        LOGGER.info("Create a new formation");
        Optional<Formation> formations = formationRepository.findByName(formation.getName());
        Optional<Boolean> isformationExist = formations.map(form -> (form.getDate() == formation.getDate()));
        if (!isformationExist.isPresent()) {
            formationRepository.save(formation);
            return CodeMessage.XAF.getMessage();
        } else {
            return CodeMessage.XAE.getMessage();
        }
    }

}
