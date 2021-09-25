package kg.amancompany.demo.service;

import kg.amancompany.demo.entity.Comment;
import kg.amancompany.demo.entity.Photo;
import kg.amancompany.demo.entity.Place;
import kg.amancompany.demo.entity.User;
import kg.amancompany.demo.exceptions.NotFoundException;
import kg.amancompany.demo.repository.CommentRepository;
import kg.amancompany.demo.repository.PhotoRepository;
import kg.amancompany.demo.repository.PlaceRepository;
import kg.amancompany.demo.repository.UserRepository;
import kg.amancompany.demo.util.MaltyPartFile;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final PhotoRepository photoRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
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

    public void addComment(Long id, String text,String email) {
        User user = userRepository.findByEmail(email).orElseThrow(NotFoundException::new);
        Place place = placeRepository.findById(id).orElseThrow(NotFoundException::new);
        LocalDate localDate = LocalDate.now();
        Comment comment = new Comment();
        comment.setContext(text);
        comment.setUser(user);
        comment.setCreatedDate(localDate);
        commentRepository.save(comment);
        place.getComment().add(comment);
        placeRepository.save(place);
    }

    public void addPhoto(Long id, MultipartFile file, Principal principal) {
        Place place = placeRepository.findById(id).orElseThrow(NotFoundException::new);
        try {
            Photo photo = new Photo();
            photo.setPhotoNamePath(maltyPartFile.uploadFile(uploadPath,file));
            place.getPhotos().add(photo);
            photoRepository.save(photo);
            placeRepository.save(place);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
