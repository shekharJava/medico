package com.oderzy.lab.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oderzy.lab.model.LabAppointment;

public interface LabAppointmentRepositery extends JpaRepository<LabAppointment, String> {

	
}
