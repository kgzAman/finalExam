package kg.amancompany.demo.repository;

import kg.amancompany.demo.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PlaceRepository extends JpaRepository<Place, Long> {

}
