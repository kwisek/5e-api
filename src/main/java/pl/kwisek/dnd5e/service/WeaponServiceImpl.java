package pl.kwisek.dnd5e.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kwisek.dnd5e.dto.response.WeaponResponse;
import pl.kwisek.dnd5e.entity.WeaponEntity;
import pl.kwisek.dnd5e.mapper.WeaponMapper;
import pl.kwisek.dnd5e.repo.WeaponRepository;

import java.util.Optional;

@Service
public class WeaponServiceImpl implements WeaponService {

    @Autowired
    private WeaponRepository weaponRepository;

    @Autowired
    private WeaponMapper weaponMapper;

    @Override
    public WeaponResponse getWeaponById(String weaponId) {
        Optional<WeaponEntity> weaponEntityOpt = weaponRepository.findById(weaponId);
        if (weaponEntityOpt.isPresent()) {
            return weaponMapper.toWeaponResponse(weaponEntityOpt.get());
        } else {
            throw new EntityNotFoundException("Weapon with ID " + weaponId + " not found");
        }
    }
}
