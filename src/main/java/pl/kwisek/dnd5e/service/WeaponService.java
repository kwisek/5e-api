package pl.kwisek.dnd5e.service;

import pl.kwisek.dnd5e.dto.response.WeaponResponse;

public interface WeaponService {
    WeaponResponse getWeaponById(String weaponName);
}
