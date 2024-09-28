package pl.kwisek.dnd5e.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.dto.response.SpellDetailsResponse;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.SpellEntity;
import pl.kwisek.dnd5e.mapper.SpellDetailsMapper;
import pl.kwisek.dnd5e.repo.BaseEntityRepository;
import pl.kwisek.dnd5e.repo.DescriptionRepository;
import pl.kwisek.dnd5e.repo.SpellRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpellServiceImpl implements SpellService {

    private final BaseEntityRepository baseEntityRepository;
    private final DescriptionRepository descriptionRepository;
    private final SpellRepository spellRepository;
    private final SpellDetailsMapper spellDetailsMapper;

    @Override
    public ListOfNamesResponse getAllNames() {
        List<String> skillNames = spellRepository.getNames();
        return new ListOfNamesResponse(skillNames);
    }

    @Override
    public ListOfIndexesResponse getAllIndexes() {
        List<String> skillIndexes = spellRepository.getIndexes();
        return new ListOfIndexesResponse(skillIndexes);
    }

    @Override
    public SpellDetailsResponse getDetails(String index) {
        Optional<BaseEntity> baseEntity = this.baseEntityRepository.findByIndex(index);
        Optional<SpellEntity> spellEntity = this.spellRepository.findByIndex(index);
        Collection<String> description = this.descriptionRepository.findByIndex(index);

        if (baseEntity.isEmpty() || spellEntity.isEmpty() || description.isEmpty()) {
            throw new EntityNotFoundException("No spell matches index: " + index);
        }

        return spellDetailsMapper.toSpellDetailsResponse(baseEntity.get(), spellEntity.get(), description);
    }
}
