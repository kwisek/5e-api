package pl.kwisek.dnd5e.service;

import pl.kwisek.dnd5e.dto.response.ConceptDetailsResponse;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;

public interface ConceptService {

    ListOfNamesResponse getAllNames();
    ListOfIndexesResponse getAllIndexes();
    ConceptDetailsResponse getDetails(String index);
}
