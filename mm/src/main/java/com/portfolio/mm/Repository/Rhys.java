package com.portfolio.mm.Repository;

import com.portfolio.mm.Entity.hys;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;



public interface Rhys extends JpaRepository<hys, Integer>{
        Optional<hys>findByNombre(String nombre);
        public boolean existsByNombre(String nombre);
}
