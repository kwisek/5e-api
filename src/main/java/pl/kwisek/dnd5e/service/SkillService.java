package pl.kwisek.dnd5e.service;

import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.dto.response.SkillDetailsResponse;

public interface SkillService {

    ListOfNamesResponse getAllNames();
    ListOfIndexesResponse getAllIndexes();
    SkillDetailsResponse getDetails(String index);
}
