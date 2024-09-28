package pl.kwisek.dnd5e.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kwisek.dnd5e.dto.response.ConceptDetailsResponse;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.entity.ConceptEntity;
import pl.kwisek.dnd5e.mapper.ConceptDetailsMapper;
import pl.kwisek.dnd5e.repo.BaseEntityRepository;
import pl.kwisek.dnd5e.repo.ConceptRepository;
import pl.kwisek.dnd5e.repo.DescriptionRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConceptServiceImpl implements ConceptService {

    private final BaseEntityRepository baseEntityRepository;
    private final ConceptRepository conceptRepository;
    private final DescriptionRepository descriptionRepository;
    private final ConceptDetailsMapper conceptDetailsMapper;

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

        return conceptDetailsMapper.toConceptDetailsResponse(conceptEntity.get(), description);
    }
}
