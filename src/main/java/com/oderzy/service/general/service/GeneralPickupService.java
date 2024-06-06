package com.oderzy.service.general.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oderzy.$config.constants._Order;
import com.oderzy._notification.service.NotificationManger;
import com.oderzy.helper.OrderCodeGenerator;
import com.oderzy.service.general.model.GeneralPickup;
import com.oderzy.service.general.model.GeneralPickupDTO;
import com.oderzy.service.general.model.GeneralPickupVO;
import com.oderzy.service.general.repositery.GeneralPickupServiceRepositery;
import com.oderzy.service.helper.GeneralPickupChargesCache;
import com.oderzy.wrapper.MyLocalDate;

@Service
public class GeneralPickupService {

	@Autowired
	private GeneralPickupServiceRepositery repo;

	@Autowired
	private OrderCodeGenerator orderCodeGenerator;
	@Autowired
	private NotificationManger notificationManger;
	@Autowired
	private GeneralPickupChargesCache cache;

	public Map<String, Double> bhogCatelouge() {
		return cache.getBhogPrice();
	}

	/* ==================UPDATE sERVICE================= */
	public String placeNewServiceByUser(GeneralPickupVO vo) {
		double netAmount = 0;

		GeneralPickup gp = new GeneralPickup(orderCodeGenerator.getOrderCode().toString(), MyLocalDate.now(),
				MyLocalDate.convert(vo.getPickupTime()), _Order._Status_Requested, vo.getPickupPoint(),
				vo.getPickupMobile(), vo.getPickupType(), vo.getAmount(), 0.0, vo.getAmount(), vo.getCustomerMobile(),
				vo.getCustomerAddress(), vo.getGps(), vo.getItems(), vo.getPayment(), vo.getInstruction());
		gp.setNetAmount(netAmount);
		gp = repo.save(gp);
		notificationManger.notifyStaffNewService(gp);

		return gp.getServiceCode();
	}

	public void updateStatus(String id, String status, double fee) {
		repo.updateStatusAndFee(id, status, fee);
	}

	public void updateStatus(String id, String status, String info) {
		repo.updateStatus(id, status, info);

	}

	// staff will propse the estimated cost of items and delivery cost fro pickup
	public String proposeServiceEstimate(GeneralPickupDTO pp) {
		GeneralPickup pickup = new GeneralPickup(pp);
		pickup.setStatus(_Order._Status_Estimated);
		repo.save(pickup);
		return " ";
	}

	// customer will confirm the pickup estimated cost
	public void confirmServiceProposal(String serviceId) {
		repo.updateOrderStatus(_Order._Status_Accepted, serviceId);
	}

	// staff will confirm the pickup Request
	public String confirmServiceRequest(GeneralPickupDTO pp) {
		GeneralPickup service = new GeneralPickup(pp);
		service.setStatus(_Order._Status_Accepted);
		repo.save(service);
		return " ";
	}

	// staff will confirm the pickup Request
	public String confirmServiceRequest(String serviceId) {
		repo.updateOrderStatus(_Order._Status_Accepted, serviceId);
		return " ";
	}

	// staff will reject the pickup Request
	public String reject(String serviceId, String msg) {
		repo.rejectService(_Order._Status_Failed, msg, serviceId);
		return " ";
	}

	public String updateStatus(String serviceId, String status) {
		repo.updateOrderStatus(status, serviceId);
		return " ";
	}

	public String updateDelivery(String serviceId) {
		repo.updateDelivery(MyLocalDate.now(), _Order._Status_Delivered, serviceId);
		return " ";
	}

	public String updatePickup(String serviceId, LocalDateTime time) {
		repo.updatePickup(time, _Order._Status_Shipped, serviceId);
		return "";
	}

	public String updatePickupTime(String serviceId, LocalDateTime time) {
		repo.updatePickupTime(time, serviceId);
		return " ";
	}

	public String updateDeliveryAgent(String serviceId, String mobile) {
		repo.updateDeliveryBoy(mobile, serviceId);
		return " ";
	}

	public List<Map<String, Double>> getChargesList() {
		List<Map<String, Double>> l = new ArrayList<Map<String, Double>>();
		l.add(cache.getBhogCharges());
		l.add(cache.getFoodCharges());
		l.add(cache.getMedCharges());
		l.add(cache.getDocumentCharges());
		l.add(cache.getOtherCharges());

		return l;
	}

}
