package pl.kwisek.dnd5e.service;

import pl.kwisek.dnd5e.dto.response.ContainerDetailsResponse;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;

public interface ContainerService {

    ListOfNamesResponse getAllNames();
    ListOfIndexesResponse getAllIndexes();
    ContainerDetailsResponse getDetails(String index);
}
