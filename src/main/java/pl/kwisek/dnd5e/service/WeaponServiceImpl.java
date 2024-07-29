package pl.kwisek.dnd5e.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.dto.response.WeaponDetailsResponse;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.WeaponEntity;
import pl.kwisek.dnd5e.mapper.WeaponMapper;
import pl.kwisek.dnd5e.repo.EntityDescriptionRepository;
import pl.kwisek.dnd5e.repo.EntityRepository;
import pl.kwisek.dnd5e.repo.WeaponRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class WeaponServiceImpl implements WeaponService {

    @Autowired
    private EntityRepository entityRepository;
    @Autowired
    private EntityDescriptionRepository entityDescriptionRepository;
    @Autowired
    private WeaponRepository weaponRepository;
    @Autowired
    private WeaponMapper weaponMapper;

    @Override
    public ListOfNamesResponse getWeaponNames() {
        List<String> weaponNames = weaponRepository.getWeaponNames();
        return weaponMapper.toListOfNamesResponse(weaponNames);
    }

    @Override
    public WeaponDetailsResponse getWeaponDetails(String index) {
        Optional<BaseEntity> baseEntity = this.entityRepository.findByIndex(index);
        Optional<WeaponEntity> weaponEntity = this.weaponRepository.findByIndex(index);
        Collection<String> description = this.entityDescriptionRepository.findByIndex(index);

        if (baseEntity.isEmpty() || weaponEntity.isEmpty() || description.isEmpty()) {
            throw new EntityNotFoundException("No weapon matches index: " + index);
        }

        return weaponMapper.toWeaponDetailsResponse(baseEntity.get(), weaponEntity.get(), description);
    }

}
