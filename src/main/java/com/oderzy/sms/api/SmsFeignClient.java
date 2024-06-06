package com.oderzy.sms.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.oderzy.customer.model.Customer;
import com.oderzy.doctor.dto.DoctorsDTO;

@FeignClient(name = "sms-client", url = "https://49min.click")
public interface SmsFeignClient {

	@PostMapping("_doc/all/doctors/{area}")
	public List<DoctorsDTO> getAllDoctors( Customer cus, @PathVariable String area);
}
