package com.mcommandes.mcommandes.services.implementations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcommandes.mcommandes.configurations.ApplicationPropertiesConfiguration;
import com.mcommandes.mcommandes.dao.CommandeDAO;
import com.mcommandes.mcommandes.exceptions.CommandeNotFoundException;
import com.mcommandes.mcommandes.mappers.IMapper;
import com.mcommandes.mcommandes.models.dto.CommandeRequest;
import com.mcommandes.mcommandes.models.entities.Commande;
import com.mcommandes.mcommandes.services.ICommandeService;

@Service
public class CommandeServiceV1 implements ICommandeService{

    @Autowired
    private CommandeDAO commandeDAO;

    @Autowired
    private ApplicationPropertiesConfiguration applicationPropertiesConfiguration;

    @Autowired
    private IMapper<Commande, CommandeRequest> mapper;

    @Override
    public List<Commande> findAll() {
        int numOfDays = applicationPropertiesConfiguration.getCommandesLast();
        List<Commande> commandes = commandeDAO.findAll();
        
        commandes.removeIf(cmd ->
                cmd.getCommandeDate()
                .isBefore(
                    LocalDate.now()
                    .minusDays(numOfDays)));

        return commandes;
    }

    @Override
    public Commande find(Long id) throws CommandeNotFoundException {
        Optional<Commande> commandeOptional = commandeDAO.findById(id);
        
        if (commandeOptional.isEmpty())
            throw new CommandeNotFoundException(id);

        return commandeOptional.get();
    }

    @Override
    public Commande add(CommandeRequest commandeRequest) {
        Commande commande = mapper.dtoToObject(commandeRequest);
        Commande savedCommand = commandeDAO.save(commande);
        return savedCommand;
    }

    @Override
    public Commande update(Long id, CommandeRequest commandeRequest) throws CommandeNotFoundException {
        if (commandeDAO.findById(id).isEmpty())
            throw new CommandeNotFoundException(id);

        Commande commande = mapper.dtoToObject(commandeRequest);
        commande.setId(id);

        Commande savedCommande = commandeDAO.save(commande);
        return savedCommande;
    }

    @Override
    public void delete(Long id) {
        commandeDAO.deleteById(id);
    }
    
}
