package filesystem.service;

import filesystem.model.FileSystemObject;
import filesystem.repository.FileRepository;
import filesystem.repository.FileSystemObjectRepository;
import filesystem.repository.FolderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileSystemObjectService {

    FileRepository fileRepository;

    FileSystemObjectRepository fileSystemObjectRepository;

    FolderRepository folderRepository;

    public FileSystemObjectService(FileRepository fileRepository,
                                   FileSystemObjectRepository fileSystemObjectRepository,
                                   FolderRepository folderRepository) {

        this.fileRepository = fileRepository;
        this.fileSystemObjectRepository = fileSystemObjectRepository;
        this.folderRepository = folderRepository;

    }

    public List<FileSystemObject> findFileSystemObjectsByParent(Integer parent) {

        if (parent == null) return new ArrayList<>();
        return fileSystemObjectRepository.findByParent(parent);
    }
}
