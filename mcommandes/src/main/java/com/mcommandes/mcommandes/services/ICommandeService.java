package com.mcommandes.mcommandes.services;

import java.util.List;

import com.mcommandes.mcommandes.exceptions.CommandeNotFoundException;
import com.mcommandes.mcommandes.exceptions.ProductNotFoundException;
import com.mcommandes.mcommandes.models.dto.CommandeRequest;
import com.mcommandes.mcommandes.models.entities.Commande;

public interface ICommandeService {
    List<Commande> findAll();
    Commande find(Long id) throws CommandeNotFoundException;
    Commande add(CommandeRequest commandeRequest) throws ProductNotFoundException;
    Commande update(Long id, CommandeRequest commandeRequest) throws CommandeNotFoundException, ProductNotFoundException;
    void delete(Long id);
}
