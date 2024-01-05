package com.mcommandes.mcommandes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcommandes.mcommandes.models.entities.Commande;

@Repository
public interface CommandeDAO extends JpaRepository<Commande, Long>{
    
}
