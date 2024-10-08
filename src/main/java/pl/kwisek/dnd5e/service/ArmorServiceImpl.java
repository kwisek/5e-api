package pl.kwisek.dnd5e.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kwisek.dnd5e.dto.response.ArmorDetailsResponse;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.entity.ArmorEntity;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.mapper.ArmorDetailsMapper;
import pl.kwisek.dnd5e.repo.ArmorRepository;
import pl.kwisek.dnd5e.repo.BaseEntityRepository;
import pl.kwisek.dnd5e.repo.DescriptionRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArmorServiceImpl implements ArmorService {

    private final BaseEntityRepository baseEntityRepository;
    private final ArmorRepository armorRepository;
    private final DescriptionRepository descriptionRepository;
    private final ArmorDetailsMapper armorDetailsMapper;

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
        Optional<BaseEntity> baseEntity = this.baseEntityRepository.findByIndex(index);
        Optional<ArmorEntity> armorEntity = this.armorRepository.findByIndex(index);
        Collection<String> description = this.descriptionRepository.findByIndex(index);

        if (baseEntity.isEmpty() || armorEntity.isEmpty() || description.isEmpty()) {
            throw new EntityNotFoundException("No armor matches index: " + index);
        }

        return armorDetailsMapper.toArmorDetailsResponse(baseEntity.get(), armorEntity.get(), description);
    }
}
