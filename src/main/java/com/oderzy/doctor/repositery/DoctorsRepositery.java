package com.oderzy.doctor.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.oderzy.doctor.dto.DoctorsDTO;
import com.oderzy.doctor.model.Doctors;

public interface DoctorsRepositery extends JpaRepository<Doctors, String> {

	List<DoctorsDTO> findByArea(@Param("area") String area);
	// List<Doctors> findByArea(@Param("area") String area);

	Doctors findByMobile(@Param("mobile") String mobile);

	List<DoctorsDTO> findByAreaAndCategory(@Param("area") String area, @Param("category") String category);

	/*
	 * @Query("UPDATE Doctors d set d.deleted = true where d.id = :id") String
	 * safeDeleteDr(@Param("id") String id);
	 */
	 	void deleteById(String id);
}
