package com.mcommandes.mcommandes.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String description;
    Integer quantite;
    LocalDate commandeDate;
    Double montant;
    Long idProduct;
    
}
