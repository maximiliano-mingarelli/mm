package com.portfolio.mm.Controller;

import com.portfolio.mm.Entity.Persona;
import com.portfolio.mm.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/persona")

public class PersonaController {
    @Autowired  IPersonaService  ipersonaService;
    
    @GetMapping("/perfil")
    public List<Persona> getPersona(){
    return ipersonaService.getPersona();
    }
    
    @GetMapping("/{id}")
    public Persona getPersona(@PathVariable(value = "id") Long id){
    return ipersonaService.findPersona(id);
    }
    
    @PreAuthorize("hasRole('admin')")
    @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona){
    ipersonaService.savePersona(persona);
    return "la persona fue creada correctamente";    
    }
    
    @PreAuthorize("hasRole('admin')")
    @DeleteMapping("/{id}")
    public String deletePersona(@PathVariable Long id){
    ipersonaService.deletePersona(id);
    return "la persona fue eliminada correctamente";
    }

    @PreAuthorize("hasRole('admin')")
    @PutMapping("/{id}")
    public Persona editPersona(@PathVariable long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apelllido") String nuevoApellido,
                               @RequestParam("img") String nuevoImg){
        Persona persona = ipersonaService.findPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        ipersonaService.savePersona(persona);
        return persona;
    }
}
