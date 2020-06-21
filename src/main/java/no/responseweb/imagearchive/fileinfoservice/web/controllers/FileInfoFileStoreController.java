package no.responseweb.imagearchive.fileinfoservice.web.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import no.responseweb.imagearchive.filestoredbservice.mappers.FileStoreMapper;
import no.responseweb.imagearchive.filestoredbservice.repositories.FileStoreRepository;
import no.responseweb.imagearchive.model.FileStoreDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
public class FileInfoFileStoreController {

    private final FileStoreRepository fileStoreRepository;
    private final FileStoreMapper fileStoreMapper;

    @GetMapping("api/v1/fileStore")
    public List<FileStoreDto> getFileStores() {
        log.debug("Finding fileStores");
        return fileStoreRepository.findAll().stream().map(fileStoreMapper::fileStoreToFileStoreDto).collect(Collectors.toList());
    }

    @GetMapping("api/v1/fileStore/{fileStoreId}")
    public FileStoreDto getFileStoreFromId(@PathVariable UUID fileStoreId) {
        log.debug("Finding fileStore: {}", fileStoreId);
        return fileStoreMapper.fileStoreToFileStoreDto(fileStoreRepository.getOne(fileStoreId));
    }

    @GetMapping("api/v1/fileStoreNickname/{fileStoreNickname}")
    public FileStoreDto getFileStoreFromNickname(@PathVariable String fileStoreNickname) {
        log.debug("Finding fileStore: {}", fileStoreNickname);
        return fileStoreMapper.fileStoreToFileStoreDto(fileStoreRepository.findByNickname(fileStoreNickname));
    }
}
