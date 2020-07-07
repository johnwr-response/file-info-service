package no.responseweb.imagearchive.fileinfoservice.web.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import no.responseweb.imagearchive.filestoredbservice.mappers.FileEntityMapper;
import no.responseweb.imagearchive.filestoredbservice.repositories.FileEntityRepository;
import no.responseweb.imagearchive.model.FileEntityDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
public class FileEntityController {

    private final FileEntityRepository fileEntityRepository;
    private final FileEntityMapper fileEntityMapper;

    @GetMapping("api/v1/fileEntity/{fileEntityId}")
    public FileEntityDto getFileEntity(@PathVariable UUID fileEntityId) {
        log.info("Finding fileEntity: {}", fileEntityId);
        return fileEntityMapper.fileEntityToFileEntityDto(fileEntityRepository.findFirstById(fileEntityId));
    }
    @GetMapping("api/v1/fileEntity/{fileEntityId}/listAllExcept")
    public List<FileEntityDto> getAllFileEntitiesExceptCurrent(@PathVariable UUID fileEntityId) {
        return fileEntityRepository.findDistinctByIdNotLike(fileEntityId).stream().map(fileEntityMapper::fileEntityToFileEntityDto).collect(Collectors.toList());
    }
}
