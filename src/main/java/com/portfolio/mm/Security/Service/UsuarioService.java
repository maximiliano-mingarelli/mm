package com.portfolio.mm.Security.Service;

import com.portfolio.mm.Security.Entity.Usuario;
import com.portfolio.mm.Security.Repository.iUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
   @Autowired 
   iUsuarioRepository  iusuarioRepository;
  
   public Optional<Usuario> GetByNombreUsuario(String nombreUsuario){
   return iusuarioRepository.findByNombreUsuario(nombreUsuario);
           }
   public boolean existsByNombreUsuario(String nombreUsuario){
   return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
           }
    public boolean existsByEmail(String email){
   return iusuarioRepository.existsByEmail(email);
           }
    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }
}
