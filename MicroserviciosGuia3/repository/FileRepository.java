package com.MicroserviciosGuia3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MicroserviciosGuia3.model.FileEntity;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {
}
