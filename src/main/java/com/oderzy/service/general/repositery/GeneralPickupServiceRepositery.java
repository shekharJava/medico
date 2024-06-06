package com.oderzy.service.general.repositery;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oderzy.service.general.model.GeneralPickup;

public interface GeneralPickupServiceRepositery extends JpaRepository<GeneralPickup, String> {

	@Modifying
	@Transactional
	@Query("Update GeneralPickup o set o.deliveryTime= :time, o.status = :status where o.serviceCode = :serviceId")
	int updateDelivery(@Param("time") LocalDateTime time, @Param("status") String status,
			@Param("serviceId") String serviceId);

	@Modifying
	@Transactional
	@Query("Update GeneralPickup o set o.pickupTime= :time, o.status = :status where o.serviceCode = :serviceId")
	int updatePickup(@Param("time") LocalDateTime time, @Param("status") String status,
			@Param("serviceId") String serviceId);

	@Modifying
	@Transactional
	@Query("Update GeneralPickup o set o.pickupTime= :time where o.serviceCode = :serviceId")
	int updatePickupTime(@Param("time") LocalDateTime time, @Param("serviceId") String serviceId);

	@Modifying
	@Transactional
	@Query("Update GeneralPickup o set o.status = :status where o.serviceCode = :serviceId")
	int updateOrderStatus(@Param("status") String status, @Param("serviceId") String serviceId);

	@Modifying
	@Transactional
	@Query("Update GeneralPickup o set o.deliveryAgentMobile = :mobile where o.serviceCode = :serviceId")
	int updateDeliveryBoy(@Param("mobile") String boy, @Param("serviceId") String serviceId);

	@Modifying
	@Transactional
	@Query("Update GeneralPickup o set o.status = :status, o.instruction = :msg where o.serviceCode = :serviceId")
	int rejectService(@Param("status") String status, @Param("msg") String msg, @Param("serviceId") String serviceId);

	@Modifying
	@Transactional
	@Query("Update GeneralPickup o set o.status = :status, o.serviceCharge = :fee, o.netAmount = (o.netAmount + :fee)  where o.serviceCode = :serviceId")
	int updateStatusAndFee(@Param("serviceId") String serviceId, @Param("status") String status, @Param("fee") double fee);

	@Modifying
	@Transactional
	@Query("Update GeneralPickup o set o.status = :status, o.instruction = :msg where o.serviceCode = :serviceId")
	int updateStatus(@Param("serviceId") String serviceId, @Param("status") String status, @Param("msg") String msg);

}
