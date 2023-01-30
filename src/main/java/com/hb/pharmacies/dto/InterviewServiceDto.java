package com.hb.pharmacies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InterviewServiceDto {

    @JsonProperty(value="fecha")
    private String fecha;

    @JsonProperty(value="localId")
    private String localId;

    @JsonProperty(value="fkRegion")
    private String fkRegion;

    @JsonProperty(value="fkComuna")
    private String fkComuna;

    @JsonProperty(value="fkLocalidad")
    private String fkLocalidad;

    @JsonProperty(value="localNombre")
    private String localNombre;

    @JsonProperty(value="comunaNombre")
    private String comunaNombre;

    @JsonProperty(value="localidadNombre")
    private String localidadNombre;

    @JsonProperty(value="localDireccion")
    private String localDireccion;

    @JsonProperty(value="funcionamientoHoraApertura")
    private String funcionamientoHoraApertura;

    @JsonProperty(value="funcionamientoHoraCierre")
    private String funcionamientoHoraCierre;

    @JsonProperty(value="localTelefono")
    private String localTelefono;

    @JsonProperty(value="localLat")
    private String localLat;

    @JsonProperty(value="localLng")
    private String localLng;

    @JsonProperty(value="funcionamientoDia")
    private String funcionamientoDia;
}
