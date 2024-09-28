package pl.kwisek.dnd5e.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.dto.response.WeaponDetailsResponse;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.WeaponEntity;
import pl.kwisek.dnd5e.mapper.WeaponDetailsMapper;
import pl.kwisek.dnd5e.repo.DescriptionRepository;
import pl.kwisek.dnd5e.repo.BaseEntityRepository;
import pl.kwisek.dnd5e.repo.WeaponRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class WeaponServiceImpl implements WeaponService {

    @Autowired
    private BaseEntityRepository baseEntityRepository;
    @Autowired
    private DescriptionRepository descriptionRepository;
    @Autowired
    private WeaponRepository weaponRepository;
    @Autowired
    private WeaponDetailsMapper weaponDetailsMapper;

    @Override
    public ListOfNamesResponse getAllNames() {
        List<String> weaponNames = weaponRepository.getNames();
        return new ListOfNamesResponse(weaponNames);
    }
    @Override
    public ListOfIndexesResponse getAllIndexes() {
        List<String> weaponIndexes = weaponRepository.getIndexes();
        return new ListOfIndexesResponse(weaponIndexes);
    }

    @Override
    public WeaponDetailsResponse getDetails(String index) {
        Optional<BaseEntity> baseEntity = this.baseEntityRepository.findByIndex(index);
        Optional<WeaponEntity> weaponEntity = this.weaponRepository.findByIndex(index);
        Collection<String> description = this.descriptionRepository.findByIndex(index);

        if (baseEntity.isEmpty() || weaponEntity.isEmpty() || description.isEmpty()) {
            throw new EntityNotFoundException("No weapon matches index: " + index);
        }

        return weaponDetailsMapper.toWeaponDetailsResponse(baseEntity.get(), weaponEntity.get(), description);
    }

}
