package com.experian.pco.customdev.customdataprovider.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PcoApplicationsRepository extends JpaRepository<PcoApplication, Long> {
    
    @Query("select pcoa from PcoApplication pcoa where pcoa.status = ?1")
    public List<PcoApplication> findByStatus(String status_id);
    
    @Query("select pcoa from PcoApplication pcoa where pcoa.internalid = ?1")
    public List<PcoApplication> findByInternalId(String internalid);
}
