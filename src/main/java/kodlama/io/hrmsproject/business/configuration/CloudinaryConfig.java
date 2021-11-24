package kodlama.io.hrmsproject.business.configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlama.io.hrmsproject.core.utilities.result.fileuploadvalidator.CloudinaryManager;
import kodlama.io.hrmsproject.core.utilities.result.fileuploadvalidator.CloudinaryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinaryUser() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "nurselii",
                "api_key", "746847123259937",
                "api_secret", "WETZg5b5XGWPKIFZE6fpvj_U42Y",
                "secure", true));
    }

    @Bean
    public CloudinaryService cloudinaryService() {
        return new CloudinaryManager(cloudinaryUser());
    }
}