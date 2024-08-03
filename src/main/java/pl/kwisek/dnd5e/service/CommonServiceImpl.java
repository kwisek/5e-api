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
    private ArmorDetailsResponseMapper armorDetailsResponseMapper;
    @Autowired
    private WeaponRepository weaponRepository;
    @Autowired
    private WeaponDetailsResponseMapper weaponDetailsResponseMapper;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private SkillDetailsResponseMapper skillDetailsResponseMapper;
    @Autowired
    private ConceptRepository conceptRepository;
    @Autowired
    private ConceptDetailsResponseMapper conceptDetailsResponseMapper;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemDetailsResponseMapper itemDetailsResponseMapper;
    @Autowired
    private SpellRepository spellRepository;
    @Autowired
    private SpellDetailsResponseMapper spellDetailsResponseMapper;
    @Autowired
    private ContainerRepository containerRepository;
    @Autowired
    private ContainerDetailsResponseMapper containerDetailsResponseMapper;
    @Autowired
    private EquipmentPackRepository equipmentPackRepository;
    @Autowired
    private EquipmentPackDetailsResponseMapper equipmentPackDetailsResponseMapper;

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
                return armorDetailsResponseMapper.from(baseEntity.get(), armorEntity.get(), description);
            }
            case "Weapon" -> {
                Optional<WeaponEntity> weaponEntity = this.weaponRepository.findByIndex(index);
                return weaponDetailsResponseMapper.from(baseEntity.get(), weaponEntity.get(), description);
            }
            case "Skill" -> {
                Optional<SkillEntity> skillEntity = this.skillRepository.findByIndex(index);
                return skillDetailsResponseMapper.from(baseEntity.get(), skillEntity.get(), description);
            }
            case "Concept" -> {
                Optional<ConceptEntity> conceptEntity = this.conceptRepository.findByIndex(index);
                return conceptDetailsResponseMapper.from(conceptEntity.get(), description);
            }
            case "SimpleItem" -> {
                Optional<ItemEntity> itemEntity = this.itemRepository.findByIndex(index);
                return itemDetailsResponseMapper.from(baseEntity.get(), itemEntity.get(), description);
            }
            case "Spell" -> {
                Optional<SpellEntity> spellEntity = this.spellRepository.findByIndex(index);
                return spellDetailsResponseMapper.from(baseEntity.get(), spellEntity.get(), description);
            }
            case "Container" -> {
                Optional<ContainerEntity> containerEntity = this.containerRepository.findByIndex(index);
                return containerDetailsResponseMapper.from(baseEntity.get(), containerEntity.get(), description);
            }
            case "EquipmentPack" -> {
                Optional<EquipmentPackEntity> equipmentPackEntity = this.equipmentPackRepository.findByIndex(index);
                return equipmentPackDetailsResponseMapper.from(baseEntity.get(), equipmentPackEntity.get(), description);
            }
        }

        return baseEntityMapper.from(baseEntity.get(), description);
    }
}
