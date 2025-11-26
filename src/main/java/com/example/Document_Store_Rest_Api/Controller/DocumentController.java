package com.example.Document_Store_Rest_Api.Controller;

import com.example.Document_Store_Rest_Api.DTO.FileResponseDTO;
import com.example.Document_Store_Rest_Api.Entity.DocumentFile;
import com.example.Document_Store_Rest_Api.Service.DocumentService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/files")
public class DocumentController {

    private final DocumentService service;

    public DocumentController(DocumentService service){
        this.service = service;
    }

    @PostMapping("/upload")
    public FileResponseDTO upload (@RequestParam("file") MultipartFile file)throws Exception {
    return service.upload(file);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Integer id) {
        DocumentFile file = service.downloadFile(id);
        if (file == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                .body(file.getData());
    }

    @GetMapping
    public List<FileResponseDTO> getAll(){
        return service.getAllFiles();
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable Integer id){
    boolean ok = service.deleteFile(id);
    return ok ? "deleted" : "not deleted";
    }
}
