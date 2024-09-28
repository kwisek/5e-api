package pl.kwisek.dnd5e.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kwisek.dnd5e.dto.response.ItemDetailsResponse;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.entity.BaseEntity;
import pl.kwisek.dnd5e.entity.ItemEntity;
import pl.kwisek.dnd5e.mapper.ItemDetailsMapper;
import pl.kwisek.dnd5e.repo.BaseEntityRepository;
import pl.kwisek.dnd5e.repo.DescriptionRepository;
import pl.kwisek.dnd5e.repo.ItemRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final BaseEntityRepository baseEntityRepository;
    private final DescriptionRepository descriptionRepository;
    private final ItemRepository itemRepository;
    private final ItemDetailsMapper itemDetailsMapper;

    @Override
    public ListOfNamesResponse getAllNames() {
        List<String> itemNames = itemRepository.getNames();
        return new ListOfNamesResponse(itemNames);
    }

    @Override
    public ListOfIndexesResponse getAllIndexes() {
        List<String> itemIndexes = itemRepository.getIndexes();
        return new ListOfIndexesResponse(itemIndexes);
    }

    @Override
    public ItemDetailsResponse getDetails(String index) {
        Optional<BaseEntity> baseEntity = this.baseEntityRepository.findByIndex(index);
        Optional<ItemEntity> itemEntity = this.itemRepository.findByIndex(index);
        Collection<String> description = this.descriptionRepository.findByIndex(index);

        if (baseEntity.isEmpty() || itemEntity.isEmpty() || description.isEmpty()) {
            throw new EntityNotFoundException("No item matches index: " + index);
        }

        return itemDetailsMapper.toItemDetailsResponse(baseEntity.get(), itemEntity.get(), description);
    }
}
