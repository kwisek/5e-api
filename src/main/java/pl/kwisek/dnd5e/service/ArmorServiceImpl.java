package pl.kwisek.dnd5e.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kwisek.dnd5e.dto.response.ArmorDetailsResponse;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.entity.ArmorEntity;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.mapper.ArmorDetailsResponseMapper;
import pl.kwisek.dnd5e.repo.ArmorRepository;
import pl.kwisek.dnd5e.repo.EntityDescriptionRepository;
import pl.kwisek.dnd5e.repo.EntityRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ArmorServiceImpl implements ArmorService {

    @Autowired
    private EntityRepository entityRepository;
    @Autowired
    private ArmorRepository armorRepository;
    @Autowired
    private EntityDescriptionRepository entityDescriptionRepository;
    @Autowired
    private ArmorDetailsResponseMapper armorDetailsResponseMapper;

    @Override
    public ListOfNamesResponse getAllNames() {
        List<String> armorNames = armorRepository.getNames();
        return new ListOfNamesResponse(armorNames);
    }
    @Override
    public ListOfIndexesResponse getAllIndexes() {
        List<String> armorIndexes = armorRepository.getIndexes();
        return new ListOfIndexesResponse(armorIndexes);
    }

    @Override
    public ArmorDetailsResponse getDetails(String index) {
        Optional<BaseEntity> baseEntity = this.entityRepository.findByIndex(index);
        Optional<ArmorEntity> armorEntity = this.armorRepository.findByIndex(index);
        Collection<String> description = this.entityDescriptionRepository.findByIndex(index);

        if (baseEntity.isEmpty() || armorEntity.isEmpty() || description.isEmpty()) {
            throw new EntityNotFoundException("No armor matches index: " + index);
        }

        return armorDetailsResponseMapper.from(baseEntity.get(), armorEntity.get(), description);
    }
}
