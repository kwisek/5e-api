package pl.kwisek.dnd5e.service;

import pl.kwisek.dnd5e.dto.response.EquipmentPackDetailsResponse;
import pl.kwisek.dnd5e.dto.response.ListOfIndexesResponse;
import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;

public interface EquipmentPackService {

    ListOfNamesResponse getAllNames();
    ListOfIndexesResponse getAllIndexes();
    EquipmentPackDetailsResponse getDetails(String index);
}
