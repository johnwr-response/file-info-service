package no.responseweb.imagearchive.fileinfoservice.web.mappers;

import no.responseweb.imagearchive.fileinfoservice.domain.FilePath;
import no.responseweb.imagearchive.fileinfoservice.domain.FileStore;
import no.responseweb.imagearchive.fileinfoservice.model.FilePathDto;
import no.responseweb.imagearchive.fileinfoservice.model.FileStoreDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface FileStoreMapper {
    FileStore fileStoreDtoToFileStore(FileStoreDto fileStoreDto);
    FileStoreDto fileStoreToFileStoreDto(FileStore fileStore);
}
