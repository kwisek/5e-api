package pl.kwisek.dnd5e.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.kwisek.dnd5e.dto.response.BaseEntityResponse;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.entity.*;
import pl.kwisek.dnd5e.enumeration.Category;
import pl.kwisek.dnd5e.exception.DataIntegrityException;
import pl.kwisek.dnd5e.mapper.*;
import pl.kwisek.dnd5e.repo.*;
import pl.kwisek.dnd5e.utils.StringDistanceUtils;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommonServiceImpl implements CommonService {

    private final BaseEntityRepository baseEntityRepository;
    private final BaseEntityMapper baseEntityMapper;
    private final DescriptionRepository descriptionRepository;
    private final ArmorRepository armorRepository;
    private final ArmorDetailsMapper armorDetailsMapper;
    private final WeaponRepository weaponRepository;
    private final WeaponDetailsMapper weaponDetailsMapper;
    private final SkillRepository skillRepository;
    private final SkillDetailsMapper skillDetailsMapper;
    private final ConceptRepository conceptRepository;
    private final ConceptDetailsMapper conceptDetailsMapper;
    private final ItemRepository itemRepository;
    private final ItemDetailsMapper itemDetailsMapper;
    private final SpellRepository spellRepository;
    private final SpellDetailsMapper spellDetailsMapper;
    private final ContainerRepository containerRepository;
    private final ContainerDetailsMapper containerDetailsMapper;
    private final EquipmentPackRepository equipmentPackRepository;
    private final EquipmentPackDetailsMapper equipmentPackDetailsMapper;

    @Override
    public ListOfNamesResponse getAllNames() {
        Collection<String> armorNames = baseEntityRepository.getAllNames();
        return new ListOfNamesResponse(armorNames);
    }
    @Override
    public ListOfIndexesResponse getAllIndexes() {
        Collection<String> armorIndexes = baseEntityRepository.getAllIndexes();
        return new ListOfIndexesResponse(armorIndexes);
    }

    @Override
    public BaseEntityResponse getDetails(String index) {
        Optional<BaseEntity> baseEntity = this.baseEntityRepository.findByIndex(index);

        if (baseEntity.isEmpty()) {
            throw new EntityNotFoundException("No entity matches index: " + index);
        }

        return this.completeEntityAndMapToResponse(baseEntity.get());
    }

    @Override
    public BaseEntityResponse getDetailsOfClosestMatch(String queryName) {

        String closestName = baseEntityRepository.getAllNames().stream()
            .min(Comparator.comparingInt(name -> StringDistanceUtils.stringDistance(queryName.toLowerCase(), name.toLowerCase())))
            .orElseThrow(() -> new EntityNotFoundException("No entity matches name: " + queryName));

        BaseEntity closestEntity = baseEntityRepository.findByName(closestName)
            .orElseThrow(() -> new EntityNotFoundException("No entity matches name: " + queryName));

        log.info("Closest match to " + queryName + " is " + closestName + " with score " +
            StringDistanceUtils.stringDistance(queryName.toLowerCase(), closestName.toLowerCase()));

        return this.completeEntityAndMapToResponse(closestEntity);
    }

    private BaseEntityResponse completeEntityAndMapToResponse(BaseEntity baseEntity) {

        String index = baseEntity.getIndexId();
        Collection<String> description = this.descriptionRepository.findByIndex(index);

        try {
            switch (Category.fromValue(baseEntity.getCategory())) {
                case ARMOR -> {
                    Optional<ArmorEntity> armorEntity = this.armorRepository.findByIndex(index);
                    return armorDetailsMapper.toArmorDetailsResponse(baseEntity, armorEntity.get(), description);
                }
                case WEAPON -> {
                    Optional<WeaponEntity> weaponEntity = this.weaponRepository.findByIndex(index);
                    return weaponDetailsMapper.toWeaponDetailsResponse(baseEntity, weaponEntity.get(), description);
                }
                case SKILL -> {
                    Optional<SkillEntity> skillEntity = this.skillRepository.findByIndex(index);
                    return skillDetailsMapper.toSkillDetailsResponse(baseEntity, skillEntity.get(), description);
                }
                case CONCEPT -> {
                    Optional<ConceptEntity> conceptEntity = this.conceptRepository.findByIndex(index);
                    return conceptDetailsMapper.toConceptDetailsResponse(conceptEntity.get(), description);
                }
                case ITEM -> {
                    Optional<ItemEntity> itemEntity = this.itemRepository.findByIndex(index);
                    return itemDetailsMapper.toItemDetailsResponse(baseEntity, itemEntity.get(), description);
                }
                case SPELL -> {
                    Optional<SpellEntity> spellEntity = this.spellRepository.findByIndex(index);
                    return spellDetailsMapper.toSpellDetailsResponse(baseEntity, spellEntity.get(), description);
                }
                case CONTAINER -> {
                    Optional<ContainerEntity> containerEntity = this.containerRepository.findByIndex(index);
                    return containerDetailsMapper.toContainerDetailsResponse(baseEntity, containerEntity.get(), description);
                }
                case EQUIPMENT_PACK -> {
                    Optional<EquipmentPackEntity> equipmentPackEntity = this.equipmentPackRepository.findByIndex(index);
                    return equipmentPackDetailsMapper.toEquipmentPackDetailsResponse(baseEntity, equipmentPackEntity.get(), description);
                }
            }
            return baseEntityMapper.toBaseEntityResponse(baseEntity, description);
        }
        catch (NoSuchElementException e) {
            throw new DataIntegrityException("Null entity for %s".formatted(baseEntity.getIndexId()));
        }


    }
}
