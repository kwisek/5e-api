package pl.kwisek.dnd5e.service;

import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.dto.response.SpellDetailsResponse;

public interface SpellService {
    ListOfNamesResponse getAllNames();
    ListOfIndexesResponse getAllIndexes();
    SpellDetailsResponse getDetails(String index);
}
