package com.example.Document_Store_Rest_Api.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileResponseDTO {

    private Integer id;
    private String fileName;
    private String fileType;
}
