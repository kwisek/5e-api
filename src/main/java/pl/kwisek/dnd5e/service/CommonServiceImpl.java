package pl.kwisek.dnd5e.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kwisek.dnd5e.dto.response.BaseEntityResponse;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.entity.*;
import pl.kwisek.dnd5e.mapper.*;
import pl.kwisek.dnd5e.repo.*;

import java.util.Collection;
import java.util.Optional;

@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    private BaseEntityRepository baseEntityRepository;
    @Autowired
    private BaseEntityMapper baseEntityMapper;
    @Autowired
    private DescriptionRepository descriptionRepository;
    @Autowired
    private ArmorRepository armorRepository;
    @Autowired
    private ArmorDetailsMapper armorDetailsMapper;
    @Autowired
    private WeaponRepository weaponRepository;
    @Autowired
    private WeaponDetailsMapper weaponDetailsMapper;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private SkillDetailsMapper skillDetailsMapper;
    @Autowired
    private ConceptRepository conceptRepository;
    @Autowired
    private ConceptDetailsMapper conceptDetailsMapper;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemDetailsMapper itemDetailsMapper;
    @Autowired
    private SpellRepository spellRepository;
    @Autowired
    private SpellDetailsMapper spellDetailsMapper;
    @Autowired
    private ContainerRepository containerRepository;
    @Autowired
    private ContainerDetailsMapper containerDetailsMapper;
    @Autowired
    private EquipmentPackRepository equipmentPackRepository;
    @Autowired
    private EquipmentPackDetailsMapper equipmentPackDetailsMapper;

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
        Collection<String> description = this.descriptionRepository.findByIndex(index);

        if (baseEntity.isEmpty()) {
            throw new EntityNotFoundException("No entity matches index: " + index);
        }

        switch (baseEntity.get().getCategory()) {
            case "Armor" -> {
                Optional<ArmorEntity> armorEntity = this.armorRepository.findByIndex(index);
                return armorDetailsMapper.toArmorDetailsResponse(baseEntity.get(), armorEntity.get(), description);
            }
            case "Weapon" -> {
                Optional<WeaponEntity> weaponEntity = this.weaponRepository.findByIndex(index);
                return weaponDetailsMapper.toWeaponDetailsResponse(baseEntity.get(), weaponEntity.get(), description);
            }
            case "Skill" -> {
                Optional<SkillEntity> skillEntity = this.skillRepository.findByIndex(index);
                return skillDetailsMapper.toSkillDetailsResponse(baseEntity.get(), skillEntity.get(), description);
            }
            case "Concept" -> {
                Optional<ConceptEntity> conceptEntity = this.conceptRepository.findByIndex(index);
                return conceptDetailsMapper.toConceptDetailsResponse(conceptEntity.get(), description);
            }
            case "SimpleItem" -> {
                Optional<ItemEntity> itemEntity = this.itemRepository.findByIndex(index);
                return itemDetailsMapper.toItemDetailsResponse(baseEntity.get(), itemEntity.get(), description);
            }
            case "Spell" -> {
                Optional<SpellEntity> spellEntity = this.spellRepository.findByIndex(index);
                return spellDetailsMapper.toSpellDetailsResponse(baseEntity.get(), spellEntity.get(), description);
            }
            case "Container" -> {
                Optional<ContainerEntity> containerEntity = this.containerRepository.findByIndex(index);
                return containerDetailsMapper.toContainerDetailsResponse(baseEntity.get(), containerEntity.get(), description);
            }
            case "EquipmentPack" -> {
                Optional<EquipmentPackEntity> equipmentPackEntity = this.equipmentPackRepository.findByIndex(index);
                return equipmentPackDetailsMapper.toEquipmentPackDetailsResponse(baseEntity.get(), equipmentPackEntity.get(), description);
            }
        }

        return baseEntityMapper.toBaseEntityResponse(baseEntity.get(), description);
    }
}
