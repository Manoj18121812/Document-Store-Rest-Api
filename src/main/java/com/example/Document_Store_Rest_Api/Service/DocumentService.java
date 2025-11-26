package com.example.Document_Store_Rest_Api.Service;

import com.example.Document_Store_Rest_Api.DTO.FileResponseDTO;
import com.example.Document_Store_Rest_Api.Entity.DocumentFile;
import com.example.Document_Store_Rest_Api.Repository.DocumentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class DocumentService {

    private final DocumentRepository repo;

    public DocumentService(DocumentRepository repo){
        this.repo = repo;
    }

    public FileResponseDTO upload (MultipartFile file)throws Exception{
        DocumentFile doc = new DocumentFile();

        doc.setFileName(file.getOriginalFilename());
        doc.setFileType(file.getContentType());
        doc.setData(file.getBytes());

        DocumentFile save = repo.save(doc);

        return new FileResponseDTO(save.getId(),save.getFileName(),save.getFileType());
    }

    public DocumentFile downloadFile(Integer id){
        return repo.findById(id).orElse(null);
    }

    public List<FileResponseDTO> getAllFiles(){

        return repo.findAll()
                .stream()
                .map(f -> new FileResponseDTO(f.getId(), f.getFileName(), f.getFileType()))
                .collect(Collectors.toList());
    }

    public boolean deleteFile(Integer id){
        if(!repo.existsById(id)){
            return false;
        }
        repo.deleteById(id);
        return true;
    }
}
