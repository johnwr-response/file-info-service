package no.responseweb.imagearchive.fileinfoservice.web.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import no.responseweb.imagearchive.filestoredbservice.services.FileEntityService;
import no.responseweb.imagearchive.model.FileEntityDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
public class FileEntityController {

    private final FileEntityService fileEntityService;

    @GetMapping("api/v1/fileEntity/{fileEntityId}")
    public FileEntityDto getFileEntity(@PathVariable UUID fileEntityId) {
        log.info("Finding fileEntity: {}", fileEntityId);
        return fileEntityService.findFirstById(fileEntityId);
    }
    @GetMapping("api/v1/fileEntity/{fileEntityId}/listAllExcept")
    public List<FileEntityDto> getAllFileEntitiesExceptCurrent(@PathVariable UUID fileEntityId) {
        return fileEntityService.findDistinctByIdNotLike(fileEntityId);
    }
}
