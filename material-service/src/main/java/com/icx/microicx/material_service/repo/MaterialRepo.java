package com.icx.microicx.material_service.repo;


import com.icx.microicx.material_service.entitiy.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface MaterialRepo extends JpaRepository<Material,Long> {

}
