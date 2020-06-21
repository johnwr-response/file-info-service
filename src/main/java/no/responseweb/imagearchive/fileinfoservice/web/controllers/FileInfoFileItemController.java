package no.responseweb.imagearchive.fileinfoservice.web.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import no.responseweb.imagearchive.filestoredbservice.mappers.FileItemMapper;
import no.responseweb.imagearchive.filestoredbservice.repositories.FileItemRepository;
import no.responseweb.imagearchive.model.FileItemDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
public class FileInfoFileItemController {

    private final FileItemRepository fileItemRepository;
    private final FileItemMapper fileItemMapper;

    @SuppressWarnings("SpellCheckingInspection")
    @GetMapping("api/v1/filesinfolder/{filePathId}")
    public List<FileItemDto> listFileItemsInPath(@PathVariable UUID filePathId) {
        log.debug("Finding all files in path: {}", filePathId);
        return fileItemRepository.findAllByFileStorePathId(filePathId)
                .stream()
                .map(fileItemMapper::fileItemToFileItemDto)
                .collect(Collectors.toList());
    }
}
