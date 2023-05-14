
package com.portfolio.mm.Repository;

import com.portfolio.mm.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
   public Optional<Educacion> findByNombreE(String nombreE);
   public boolean existsByNombreE(String nombreE);
}