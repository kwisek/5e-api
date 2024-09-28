package pl.kwisek.dnd5e.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kwisek.dnd5e.dto.response.EquipmentPackDetailsResponse;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.EquipmentPackEntity;
import pl.kwisek.dnd5e.mapper.EquipmentPackDetailsMapper;
import pl.kwisek.dnd5e.repo.BaseEntityRepository;
import pl.kwisek.dnd5e.repo.DescriptionRepository;
import pl.kwisek.dnd5e.repo.EquipmentPackRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class EquipmentPackServiceImpl implements EquipmentPackService {
    @Autowired
    BaseEntityRepository baseEntityRepository;;
    @Autowired
    DescriptionRepository descriptionRepository;
    @Autowired
    EquipmentPackRepository equipmentPackRepository;
    @Autowired
    EquipmentPackDetailsMapper equipmentPackDetailsMapper;

    @Override
    public ListOfNamesResponse getAllNames() {
        List<String> equipmentPackNames = equipmentPackRepository.getNames();
        return new ListOfNamesResponse(equipmentPackNames);
    }

    @Override
    public ListOfIndexesResponse getAllIndexes() {
        List<String> equipmentPackIndexes = equipmentPackRepository.getIndexes();
        return new ListOfIndexesResponse(equipmentPackIndexes);
    }

    @Override
    public EquipmentPackDetailsResponse getDetails(String index) {
        Optional<BaseEntity> baseEntity = this.baseEntityRepository.findByIndex(index);
        Optional<EquipmentPackEntity> equipmentPackEntity = this.equipmentPackRepository.findByIndex(index);
        Collection<String> description = this.descriptionRepository.findByIndex(index);

        if (baseEntity.isEmpty() || equipmentPackEntity.isEmpty() || description.isEmpty()) {
            throw new EntityNotFoundException("No equipment pack matches index: " + index);
        }

        return equipmentPackDetailsMapper.toEquipmentPackDetailsResponse(baseEntity.get(), equipmentPackEntity.get(), description);
    }
}
