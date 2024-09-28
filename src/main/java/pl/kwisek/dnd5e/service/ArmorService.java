package pl.kwisek.dnd5e.service;

import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.dto.response.ArmorDetailsResponse;

public interface ArmorService {

    ListOfNamesResponse getAllNames();
    ListOfIndexesResponse getAllIndexes();
    ArmorDetailsResponse getDetails(String index);
}
