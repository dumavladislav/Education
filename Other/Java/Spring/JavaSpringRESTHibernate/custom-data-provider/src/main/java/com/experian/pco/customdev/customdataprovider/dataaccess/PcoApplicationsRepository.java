package com.experian.pco.customdev.customdataprovider.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.experian.pco.customdev.customdataprovider.dataaccess.Solution.SolutionApplication;

public interface PcoApplicationsRepository extends JpaRepository<SolutionApplication, Long> {
    
    @Query("select pcoa from SolutionApplication pcoa where pcoa.status = :status_id")
    public List<SolutionApplication> findByStatus(@Param("status_id") String status_id);
    
    @Query("select pcoa from SolutionApplication pcoa where pcoa.status = :status_id and pcoa.internalid in :internalIds")
    public List<SolutionApplication> findByStatusFiltered(@Param("status_id") String status_id, @Param("internalIds") List<String> internalIds);
    
    @Query("select pcoa from SolutionApplication pcoa where pcoa.internalid = ?1")
    public List<SolutionApplication> findByInternalId(String internalid);
    
    @Modifying
    @Query("update SolutionApplication pcoa set pcoa.batchactionid = :batchactionid where pcoa.internalid = :internalid")
    public int setActionByInternalId(@Param("batchactionid") String batchactionid, @Param("internalid") String internalid);
}
