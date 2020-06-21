package no.responseweb.imagearchive.fileinfoservice.bootstrap;

import lombok.RequiredArgsConstructor;
import no.responseweb.imagearchive.fileinfoservice.domain.FileItem;
import no.responseweb.imagearchive.fileinfoservice.domain.FilePath;
import no.responseweb.imagearchive.fileinfoservice.domain.FileStore;
import no.responseweb.imagearchive.fileinfoservice.repositories.FileItemRepository;
import no.responseweb.imagearchive.fileinfoservice.repositories.FilePathRepository;
import no.responseweb.imagearchive.fileinfoservice.repositories.FileStoreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.Instant;

@RequiredArgsConstructor
@Component
public class FileSampleDataLoader implements CommandLineRunner {

    private final FileStoreRepository fileStoreRepository;
    private final FilePathRepository filePathRepository;
    private final FileItemRepository fileItemRepository;

    @Override
    public void run(String... args) {
        if(fileStoreRepository.count() == 0 ) {
            loadObjects();
        }
    }
    private void loadObjects() {
        String baseFileStore = "//storage6000/Share/Test";
        Path pathBaseFileStore = Paths.get(baseFileStore);
        Path pathSampleSubDir = Paths.get(baseFileStore + "/Testfolder");
        FileStore store = FileStore.builder()
                .baseUri(Paths.get(baseFileStore).toString())
                .nickname("test a")
                .build();
        FileStore savedStore = fileStoreRepository.save(store);
        FilePath rootPath = FilePath.builder()
                .fileStoreId(savedStore.getId())
                .relativePath(pathBaseFileStore.relativize(pathBaseFileStore).toString())
                .build();
        FilePath savedRootPath = filePathRepository.save(rootPath);
        FilePath path = FilePath.builder()
                .fileStoreId(savedStore.getId())
                .relativePath(pathBaseFileStore.relativize(pathSampleSubDir).toString())
                .build();
        FilePath savedPath = filePathRepository.save(path);
        FileItem item1 = FileItem.builder()
                .filename("2013-10-05 20.53.06.jpg")
                .fileStorePathId(savedRootPath.getId())
                .createdDate(Timestamp.from(Instant.now()))
                .lastModifiedDate(Timestamp.from(Instant.now()))
                .build();
        fileItemRepository.save(item1);
        FileItem item2 = FileItem.builder()
                .filename("Ambassdorclass.jpg")
                .fileStorePathId(savedPath.getId())
                .createdDate(Timestamp.from(Instant.now()))
                .lastModifiedDate(Timestamp.from(Instant.now()))
                .build();
        fileItemRepository.save(item2);
    }
}
