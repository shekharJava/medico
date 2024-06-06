package com.oderzy.doctor.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oderzy.doctor.dto.DoctorsTimeDTO;
import com.oderzy.doctor.model.DoctorsTime;

public interface DoctorsTimeRepositery extends JpaRepository<DoctorsTime, String> {

	
	List<DoctorsTimeDTO> findByDay(String day);

	@Query(value = "select new com.oderzy.doctor.dto.DoctorsTimeDTO(d) from DoctorsTime d where d.mobile = :mobile  and d.status = :status")
	List<DoctorsTimeDTO> findAllByMobile(@Param("mobile") String mobile, @Param("status") String status);

}
