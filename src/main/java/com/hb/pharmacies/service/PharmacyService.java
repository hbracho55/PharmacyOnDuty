package com.hb.pharmacies.service;

import com.hb.pharmacies.dto.PharmacyRequestDto;
import com.hb.pharmacies.dto.PharmacyResponseDto;

import java.util.List;

public interface PharmacyService {

    public List<PharmacyResponseDto> getPharmaciesOnDuty(PharmacyRequestDto pharmacyRequestDto);
}
