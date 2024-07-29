package pl.kwisek.dnd5e.service;

import pl.kwisek.dnd5e.dto.response.ListOfNamesResponse;
import pl.kwisek.dnd5e.dto.response.WeaponDetailsResponse;

public interface WeaponService {
    ListOfNamesResponse getWeaponNames();
    WeaponDetailsResponse getWeaponDetails(String index);
}
