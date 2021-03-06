package osu.kip.prodmis.service.api;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

    void init();

    void store(MultipartFile file, String fprefix);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    Resource loadAsResourceFromRoot(String fileName);
    
    void deleteAll();

	void delete(String fileName);

}
