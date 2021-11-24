package kodlama.io.hrmsproject.core.utilities.result.fileuploadvalidator;

import kodlama.io.hrmsproject.core.utilities.result.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
    DataResult<?> save(MultipartFile file);
}
