package no.responseweb.imagearchive.fileinfoservice.repositories;

import no.responseweb.imagearchive.fileinfoservice.domain.FileStore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FileStoreRepository extends JpaRepository<FileStore, UUID> {
    FileStore findByNickname(String fileStoreNickname);
}
