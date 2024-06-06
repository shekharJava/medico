package com.oderzy._data_.repositery;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oderzy._data_.model.OrderCode;

public interface OrderCodeRepositery extends JpaRepository<OrderCode, String> {

	@Query("select oc.code from OrderCode oc where oc.date = :now")
	String findCodeByDate(@Param("now") LocalDate ld);

	@Query("select oc.code from OrderCode oc where oc.date = :now")
	String findCodeByDate(@Param("now") String now);

}
