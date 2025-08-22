package ProyectoModulo_AngelRivera_20230272.AngelRivera_20230272.Repositories.librosRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<librosEntity, Long> {
    Page<librosEntity> findAll(Pageable pageable);
}
