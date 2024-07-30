package pl.kwisek.dnd5e.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kwisek.dnd5e.dto.response.ConceptDetailsResponse;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.entity.ConceptEntity;
import pl.kwisek.dnd5e.mapper.ConceptDetailsResponseMapper;
import pl.kwisek.dnd5e.repo.BaseEntityRepository;
import pl.kwisek.dnd5e.repo.ConceptRepository;
import pl.kwisek.dnd5e.repo.DescriptionRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ConceptServiceImpl implements ConceptService {
    @Autowired
    private BaseEntityRepository baseEntityRepository;
    @Autowired
    private ConceptRepository conceptRepository;
    @Autowired
    private DescriptionRepository descriptionRepository;
    @Autowired
    private ConceptDetailsResponseMapper conceptDetailsResponseMapper;

    @Override
    public ListOfNamesResponse getAllNames() {
        List<String> conceptNames = conceptRepository.getNames();
        return new ListOfNamesResponse(conceptNames);
    }
    @Override
    public ListOfIndexesResponse getAllIndexes() {
        List<String> conceptIndexes = conceptRepository.getIndexes();
        return new ListOfIndexesResponse(conceptIndexes);
    }

    @Override
    public ConceptDetailsResponse getDetails(String index) {
        Optional<ConceptEntity> conceptEntity = this.conceptRepository.findByIndex(index);
        Collection<String> description = this.descriptionRepository.findByIndex(index);

        if (conceptEntity.isEmpty()) {
            throw new EntityNotFoundException("No concept matches index: " + index);
        }

        return conceptDetailsResponseMapper.from(conceptEntity.get(), description);
    }
}
