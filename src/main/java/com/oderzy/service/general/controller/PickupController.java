package com.oderzy.service.general.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oderzy.$config.constants.$Navigation;
import com.oderzy._security_.staff.StaffAuth;
import com.oderzy.service.general.model.GeneralPickupDTO;
import com.oderzy.service.general.model.GeneralPickupVO;
import com.oderzy.service.general.service.GeneralPickupService;
import com.oderzy.wrapper.StringResponse;

@RestController
@RequestMapping($Navigation._Pickup_controller)
@CrossOrigin
public class PickupController {

	@Autowired
	private GeneralPickupService service;

	/* =========================================== */



	/* ==================== Put Post mapping =========== */
	@PostMapping("/service/user/request")
	// @StaffAuth()
	public StringResponse requestByUser(@RequestBody GeneralPickupVO vo) {
		return new StringResponse(service.placeNewServiceByUser(vo));
	}

	
	@PostMapping("/service/propose/{id}")
	@StaffAuth()
	public StringResponse propose(@RequestBody GeneralPickupDTO pickup) {
		return new StringResponse(service.proposeServiceEstimate(pickup));
	}

	@PutMapping("/service/accept-service")
	public StringResponse accept(@RequestBody GeneralPickupDTO pickup) {
		return new StringResponse(service.confirmServiceRequest(pickup));
	}

	@PutMapping("/update/Status/{id}/{status}/{fee}")
	public void updateStatus(@PathVariable String id, @PathVariable String status, @PathVariable double fee) {
		service.updateStatus(id, status, fee);
	}

	@PutMapping("/update/Status/{id}/{status}")
	public void updateStatus(@PathVariable String id, @PathVariable String status, @RequestParam String info) {
		service.updateStatus(id, status, info);
	}

	@PutMapping("/service/accept-service/{id}")
	public StringResponse accept(@PathVariable String id) {
		return new StringResponse(service.confirmServiceRequest(id));
	}

	@PutMapping("/service/accept-proposal/{id}")
	public void acceptProposal(@PathVariable String id) {
		service.confirmServiceProposal(id);
	}

	@PutMapping("/service/reject/{id}/{msg}")
	public StringResponse rejectl(@PathVariable String id, @PathVariable String msg) {
		return new StringResponse(service.reject(id, msg));
	}

	


}
