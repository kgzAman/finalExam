package kg.amancompany.demo.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
public class MaltyPartFile {

    public String uploadFile(String uploadPath, MultipartFile file) throws IOException {
        String filepath = "";
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath).getAbsoluteFile();
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFilename).getAbsoluteFile());
            filepath=resultFilename;
        }
            return filepath;
    }

}
