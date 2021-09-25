package kg.amancompany.demo.service;

import kg.amancompany.demo.entity.Place;
import kg.amancompany.demo.exceptions.NotFoundException;
import kg.amancompany.demo.repository.PlaceRepository;
import kg.amancompany.demo.util.MaltyPartFile;
import lombok.Data;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final MaltyPartFile maltyPartFile;

    private final String uploadPath = "upload/photo";

    public List<Place> getAllPlace() {
        return placeRepository.findAll();
    }

    public void createPlace(MultipartFile file, String nameOfPlace, String description)  {
        if(placeRepository.findByNameOfPlace(nameOfPlace).isEmpty()){
            Place place = new Place();
            place.setNameOfPlace(nameOfPlace);
            place.setDescription(description);
            place.setComment(new ArrayList<>());
            place.setPhotos(new ArrayList<>());
            place.setCounter(0.0);
            try {
                place.setMainPhotoPath(maltyPartFile.uploadFile(uploadPath,file));
            } catch (IOException e) {
                e.printStackTrace();
            }
            placeRepository.save(place);
        }
    }

    public Place getPlaceById(Long id) {
        return placeRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}
