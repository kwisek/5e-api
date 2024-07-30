package pl.kwisek.dnd5e.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.dto.response.SkillDetailsResponse;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.SkillEntity;
import pl.kwisek.dnd5e.mapper.SkillDetailsResponseMapper;
import pl.kwisek.dnd5e.repo.DescriptionRepository;
import pl.kwisek.dnd5e.repo.BaseEntityRepository;
import pl.kwisek.dnd5e.repo.SkillRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    private BaseEntityRepository baseEntityRepository;
    @Autowired
    private DescriptionRepository descriptionRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private SkillDetailsResponseMapper skillDetailsResponseMapper;

    @Override
    public ListOfNamesResponse getAllNames() {
        List<String> skillNames = skillRepository.getNames();
        return new ListOfNamesResponse(skillNames);
    }

    @Override
    public ListOfIndexesResponse getAllIndexes() {
        List<String> skillIndexes = skillRepository.getIndexes();
        return new ListOfIndexesResponse(skillIndexes);
    }

    @Override
    public SkillDetailsResponse getDetails(String index) {
        Optional<BaseEntity> baseEntity = this.baseEntityRepository.findByIndex(index);
        Optional<SkillEntity> skillEntity = this.skillRepository.findByIndex(index);
        Collection<String> description = this.descriptionRepository.findByIndex(index);

        if (baseEntity.isEmpty() || skillEntity.isEmpty() || description.isEmpty()) {
            throw new EntityNotFoundException("No skill matches index: " + index);
        }

        return skillDetailsResponseMapper.from(baseEntity.get(), skillEntity.get(), description);
    }
}
