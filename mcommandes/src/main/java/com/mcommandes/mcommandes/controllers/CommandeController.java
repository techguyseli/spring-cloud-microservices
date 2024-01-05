package com.mcommandes.mcommandes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcommandes.mcommandes.dao.CommandeDAO;
import com.mcommandes.mcommandes.exceptions.CommandeNotFoundException;
import com.mcommandes.mcommandes.models.dto.CommandeRequest;
import com.mcommandes.mcommandes.models.entities.Commande;
import com.mcommandes.mcommandes.services.ICommandeService;

@RestController
@RequestMapping("/commandes")
@CrossOrigin(origins = "*/*")
public class CommandeController implements HealthIndicator{
    
    @Autowired
    ICommandeService commandeService;

    @Autowired
    CommandeDAO commandeDAO;

    @GetMapping
    public ResponseEntity<List<Commande>> getCommandes(){
        List<Commande> commandes = commandeService.findAll();
        return new ResponseEntity<>(commandes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommande(@PathVariable Long id) throws CommandeNotFoundException{
        Optional<Commande> commandeOptional = Optional.of(commandeService.find(id));
        return ResponseEntity.of(commandeOptional);
    }

    @PostMapping
    public ResponseEntity<Commande> addCommande(@RequestBody CommandeRequest commande){
        Commande newCommande = commandeService.add(commande);
        return new ResponseEntity<>(newCommande, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commande> updateCommande(
        @PathVariable Long id, 
        @RequestBody CommandeRequest commande
        ) throws CommandeNotFoundException {

        Commande newCommande = commandeService.update(id, commande);
        Optional<Commande> newCommandeOptional = Optional.of(newCommande);
        return ResponseEntity.of(newCommandeOptional);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCommande(@PathVariable Long id){
        commandeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public Health health() {
        List<Commande> commandes = commandeDAO.findAll();

        if (commandes.isEmpty())
            return Health.down().build();

        return Health.up().build();
    }

}
