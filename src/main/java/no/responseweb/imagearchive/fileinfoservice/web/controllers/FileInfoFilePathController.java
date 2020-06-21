package no.responseweb.imagearchive.fileinfoservice.web.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import no.responseweb.imagearchive.fileinfoservice.model.FileItemDto;
import no.responseweb.imagearchive.fileinfoservice.model.FilePathDto;
import no.responseweb.imagearchive.fileinfoservice.model.FileStoreDto;
import no.responseweb.imagearchive.fileinfoservice.repositories.FileItemRepository;
import no.responseweb.imagearchive.fileinfoservice.repositories.FilePathRepository;
import no.responseweb.imagearchive.fileinfoservice.repositories.FileStoreRepository;
import no.responseweb.imagearchive.fileinfoservice.web.mappers.FileItemMapper;
import no.responseweb.imagearchive.fileinfoservice.web.mappers.FilePathMapper;
import no.responseweb.imagearchive.fileinfoservice.web.mappers.FileStoreMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
public class FileInfoFilePathController {

    private final FilePathRepository filePathRepository;
    private final FilePathMapper filePathMapper;

    @GetMapping("api/v1/filePath/{fileStoreId}")
    public List<FilePathDto> getFilePathsFromStoreId(@PathVariable UUID fileStoreId) {
        log.info("Finding filePaths: {}", fileStoreId);
        return filePathRepository.findByFileStoreId(fileStoreId).stream().map(filePathMapper::filePathToFilePathDto).collect(Collectors.toList());
    }

    @GetMapping("api/v1/filePath/{fileStoreId}/file-store-root-folder")
    public FilePathDto getFilePathRootFromStoreId(@PathVariable UUID fileStoreId) {
        log.info("Finding filePath root: {}", fileStoreId);
        return filePathMapper.filePathToFilePathDto(filePathRepository.findByFileStoreIdAndRelativePath(fileStoreId,""));
    }

    @GetMapping("api/v1/filePath/{fileStoreId}/{relativePath}")
    public FilePathDto getFilePathFromStoreIdAndRelativePath(@PathVariable UUID fileStoreId, @PathVariable String relativePath) {
        log.info("Finding filePath: {} + {}", fileStoreId, relativePath);
        return filePathMapper.filePathToFilePathDto(filePathRepository.findByFileStoreIdAndRelativePath(fileStoreId,relativePath));
    }

}
