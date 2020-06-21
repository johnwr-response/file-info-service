package no.responseweb.imagearchive.fileinfoservice.web.mappers;

import no.responseweb.imagearchive.fileinfoservice.domain.FileItem;
import no.responseweb.imagearchive.fileinfoservice.domain.FilePath;
import no.responseweb.imagearchive.fileinfoservice.model.FileItemDto;
import no.responseweb.imagearchive.fileinfoservice.model.FilePathDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface FilePathMapper {
    FilePath filePathDtoToFilePath(FilePathDto filePathDto);
    FilePathDto filePathToFilePathDto(FilePath filePath);
}
