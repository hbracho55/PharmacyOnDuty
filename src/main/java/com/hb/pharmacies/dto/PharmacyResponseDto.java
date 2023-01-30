package com.hb.pharmacies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PharmacyResponseDto {

    @JsonProperty(value="localNombre")
    private String localNombre;

    @JsonProperty(value="localDireccion")
    private String localDireccion;

    @JsonProperty(value="localTelefono")
    private String localTelefono;

    @JsonProperty(value="localLat")
    private String localLat;

    @JsonProperty(value="localLng")
    private String localLng;
}
