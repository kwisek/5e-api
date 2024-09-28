package pl.kwisek.dnd5e.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kwisek.dnd5e.dto.response.ContainerDetailsResponse;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.ContainerEntity;
import pl.kwisek.dnd5e.mapper.ContainerDetailsMapper;
import pl.kwisek.dnd5e.repo.BaseEntityRepository;
import pl.kwisek.dnd5e.repo.ContainerRepository;
import pl.kwisek.dnd5e.repo.DescriptionRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContainerServiceImpl implements ContainerService {

    private final BaseEntityRepository baseEntityRepository;
    private final ContainerRepository containerRepository;
    private final DescriptionRepository descriptionRepository;
    private final ContainerDetailsMapper containerDetailsMapper;

    @Override
    public ListOfNamesResponse getAllNames() {
        List<String> conceptNames = containerRepository.getNames();
        return new ListOfNamesResponse(conceptNames);
    }
    @Override
    public ListOfIndexesResponse getAllIndexes() {
        List<String> conceptIndexes = containerRepository.getIndexes();
        return new ListOfIndexesResponse(conceptIndexes);
    }

    @Override
    public ContainerDetailsResponse getDetails(String index) {
        Optional<BaseEntity> baseEntity = this.baseEntityRepository.findByIndex(index);
        Optional<ContainerEntity> containerEntity = this.containerRepository.findByIndex(index);
        Collection<String> description = this.descriptionRepository.findByIndex(index);

        if (baseEntity.isEmpty()) {
            throw new EntityNotFoundException("No container matches index: " + index);
        }

        return containerDetailsMapper.toContainerDetailsResponse(baseEntity.get(), containerEntity.get(), description);
    }
}
