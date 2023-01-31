package com.hb.pharmacies.controller;

import com.hb.pharmacies.dto.PharmacyRequestDto;
import com.hb.pharmacies.dto.PharmacyResponseDto;
import com.hb.pharmacies.service.PharmacyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PharmacyController {

    private final PharmacyService pharmacyService;

    @PostMapping(value = "/pharmacies",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PharmacyResponseDto>> getPharmaciesOnDuty(@RequestBody PharmacyRequestDto pharmacyRequestDto){

        return ResponseEntity.ok(pharmacyService.getPharmaciesOnDuty(pharmacyRequestDto));
    }
}
