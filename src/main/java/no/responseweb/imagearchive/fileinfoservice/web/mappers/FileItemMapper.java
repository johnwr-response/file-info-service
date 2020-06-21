package no.responseweb.imagearchive.fileinfoservice.web.mappers;

import no.responseweb.imagearchive.fileinfoservice.domain.FileItem;
import no.responseweb.imagearchive.fileinfoservice.model.FileItemDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface FileItemMapper {
    FileItem fileItemDtoToFileItem(FileItemDto fileItemDto);
    FileItemDto fileItemToFileItemDto(FileItem fileItem);
}
