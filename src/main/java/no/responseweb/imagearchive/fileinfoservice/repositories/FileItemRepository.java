package no.responseweb.imagearchive.fileinfoservice.repositories;

import no.responseweb.imagearchive.fileinfoservice.domain.FileItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FileItemRepository extends JpaRepository<FileItem, UUID> {
    List<FileItem> findAllByFileStorePathId(UUID filePathId);
}
