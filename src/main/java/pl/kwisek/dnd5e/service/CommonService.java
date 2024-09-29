package pl.kwisek.dnd5e.service;

import pl.kwisek.dnd5e.dto.response.BaseEntityResponse;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;

public interface CommonService {

    ListOfNamesResponse getAllNames();
    ListOfIndexesResponse getAllIndexes();
    BaseEntityResponse getDetails(String index);
    BaseEntityResponse getDetailsOfClosestMatch(String queryName);
}
