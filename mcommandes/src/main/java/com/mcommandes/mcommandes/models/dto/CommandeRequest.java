package com.mcommandes.mcommandes.models.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public record CommandeRequest (
    String description,
    Integer quantite,
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate date,
    Double montant,
    Long idProduct
){
    
}
