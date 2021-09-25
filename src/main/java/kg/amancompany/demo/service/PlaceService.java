package kg.amancompany.demo.service;

import kg.amancompany.demo.entity.Place;
import kg.amancompany.demo.repository.PlaceRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class PlaceService {

    private final PlaceRepository placeRepository;


    public List<Place> getAllPlace() {
        return placeRepository.findAll();
    }
}
