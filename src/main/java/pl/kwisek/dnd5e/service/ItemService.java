package pl.kwisek.dnd5e.service;

import pl.kwisek.dnd5e.dto.response.ItemDetailsResponse;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;

public interface ItemService {
    ListOfNamesResponse getAllNames();
    ListOfIndexesResponse getAllIndexes();
    ItemDetailsResponse getDetails(String index);
}
