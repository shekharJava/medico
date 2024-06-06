package com.oderzy._data_.repositery;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oderzy._data_.model.CustomerCode;

public interface CustomerCodeRepositery  extends JpaRepository<CustomerCode, String>  {

	@Query("select c.code from CustomerCode c where c.date = :now")
	String findCodeByDate(@Param("now") LocalDate now);
	
	

}
