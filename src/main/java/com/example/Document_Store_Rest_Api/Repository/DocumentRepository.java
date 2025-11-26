package com.example.Document_Store_Rest_Api.Repository;

import com.example.Document_Store_Rest_Api.Entity.DocumentFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<DocumentFile,Integer> {

}
