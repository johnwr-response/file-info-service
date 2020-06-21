package no.responseweb.imagearchive.fileinfoservice.repositories;

import no.responseweb.imagearchive.fileinfoservice.domain.FilePath;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FilePathRepository extends JpaRepository<FilePath, UUID> {
    List<FilePath> findByFileStoreId(UUID fileStoreId);
    FilePath findByFileStoreIdAndRelativePath(UUID fileStoreId, String relativePath);
}
