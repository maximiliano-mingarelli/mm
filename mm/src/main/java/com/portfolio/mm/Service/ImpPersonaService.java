package com.portfolio.mm.Service;

import com.portfolio.mm.Entity.Persona;
import com.portfolio.mm.Interface.IPersonaService;
import com.portfolio.mm.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService{
    @Autowired IPersonaRepository ipersonaRository;
    @Override
    public List<Persona> getPersona() {
     List<Persona> persona = ipersonaRository.findAll();
     return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRository.findById(id).orElse(null);
        return persona;
    }
    
}
