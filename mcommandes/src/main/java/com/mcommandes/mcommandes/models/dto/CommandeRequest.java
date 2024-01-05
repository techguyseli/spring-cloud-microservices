package com.mcommandes.mcommandes.models.dto;

import java.time.LocalDate;

public record CommandeRequest (
    String description,
    Integer quantite,
    LocalDate date,
    Double montant
){
    
}
