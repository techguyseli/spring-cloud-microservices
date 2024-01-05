package com.mcommandes.mcommandes.mappers;

import org.springframework.stereotype.Component;

import com.mcommandes.mcommandes.models.dto.CommandeRequest;
import com.mcommandes.mcommandes.models.entities.Commande;

@Component
public class CommandeMapper implements IMapper<Commande, CommandeRequest>{

    @Override
    public Commande dtoToObject(CommandeRequest dto) {
        return new Commande(
            null,
            dto.description(),
            dto.quantite(), 
            dto.date(), 
            dto.montant());
    }

    @Override
    public CommandeRequest objectToDto(Commande object) {
        return new CommandeRequest(
            object.getDescription(), 
            object.getQuantite(), 
            object.getCommandeDate(), 
            object.getMontant());
    }
}
