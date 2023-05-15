package com.portfolio.mm.Service;

import com.portfolio.mm.Entity.Persona;
import com.portfolio.mm.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPersonaService {
    @Autowired IPersonaRepository ipersonaRository;
    
    public List<Persona> list(){
        return ipersonaRository.findAll();
    }
    
    public Optional<Persona> getOne(int id){
        return ipersonaRository.findById(id);
    }
    public Optional <Persona> getByNombre(String nombre){
    return ipersonaRository.findByNombre(nombre);
    }
    public void save (Persona persona){
        ipersonaRository.save(persona);
    }
    public void delete (int id){
        ipersonaRository.deleteById(id);
    }
    public boolean existsById(int id){
    return ipersonaRository.existsById(id);
    }
    public boolean existByNombre (String nombre){
        return ipersonaRository.existsByNombre(nombre);
    }    
}
 
