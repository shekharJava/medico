package com.oderzy._data_.config;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oderzy._data_.model.DataCount;
import com.oderzy._data_.repositery.CartCodeRepositery;
import com.oderzy._data_.repositery.CustomerCodeRepositery;
import com.oderzy._data_.repositery.DataCountRepositery;
import com.oderzy._data_.repositery.OrderCodeRepositery;
import com.oderzy.helper.CartCodeGenerator;
import com.oderzy.helper.CustomerCodeGenerator;
import com.oderzy.helper.OrderCodeGenerator;

@Service
public class DailyActivity {

	@Autowired
	private DataCountRepositery dataCountRepositery;

	@Autowired
	private CartCodeRepositery cartCodeRepositery;
	@Autowired
	private CartCodeGenerator cartCodeGenerator;
	@Autowired
	private CustomerCodeRepositery customerCodeRepositery;
	@Autowired
	private CustomerCodeGenerator customerCodeGenerator;
	@Autowired
	private OrderCodeRepositery orderCodeRepositery;
	@Autowired
	private OrderCodeGenerator orderCodeGenerator;

	private SecureRandom rand;

	DailyActivity() {

		try {
			this.rand = SecureRandom.getInstanceStrong();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// SecureRandom is preferred to Random
	}

	@PostConstruct
	public void updateCodes() {
		LocalDate today = LocalDate.now();
		this.setCartCode(today);
		this.setCustomerCode(today);

		this.setOrderCode(today);

		this.todayUniqueCodeGenerator(2500);
		this.setTodayDataCountForAll();

	}

	// @PreDestroy()
	public void backupTodayDataCountForAll() {
		List<DataCount> data = new ArrayList<>();

		data.add(new DataCount("CART", cartCodeGenerator.cartNo()));
		data.add(new DataCount("CUSTOMER", customerCodeGenerator.customerNo()));
		data.add(new DataCount("CUSTOMER-ADDRESS", customerCodeGenerator.customerAddressNo()));

		dataCountRepositery.saveAll(data);

	}

	private void setTodayDataCountForAll() {

		dataCountRepositery.findAll().forEach(f -> {
			switch (f.getDataType()) {
			case "CART":
				cartCodeGenerator.setCartNo(f.getDataValue());
				break;
			case "CUSTOMER":
				customerCodeGenerator.setCustomerNo(f.getDataValue());
				break;
			case "CUSTOMER-ADDRESS":
				customerCodeGenerator.setCustomerAddressNo(f.getDataValue());
				break;

			}
		});
	}

	/*
	 * private void setAttendenceCode(LocalDate now) {
	 * attendenceCodeGenerator.setAttendenceCode(attendenceCodeRepositery.
	 * findCodeByDate(now)); }
	 */

	private void setCartCode(LocalDate now) {
		cartCodeGenerator.setCartCode(cartCodeRepositery.findCodeByDate(now));
	}

	private void setCustomerCode(LocalDate now) {
		customerCodeGenerator.setTodayCustomerCode(customerCodeRepositery.findCodeByDate(now));
	}
	/*
	 * private void setJobCode(LocalDate now) {
	 * jobCodeGenerator.setTodayJobCode(jobCodeRepo.findCodeByDate(now)); }
	 */

	private void setOrderCode(LocalDate now) {
		orderCodeGenerator.setTodayOrderCode(orderCodeRepositery.findCodeByDate(now));
	}

	// set orderCode List and invoice code list with unique code
	private void todayUniqueCodeGenerator(int count) {
		Set<Integer> s = new HashSet<Integer>();

		this.rand.ints(count, 10001, 9999999).forEach(x -> {
			s.add(x);
		});
		orderCodeGenerator.setTodayOrderCodeList(s);
		orderCodeGenerator.setTodayInvoiceCodeList(s);
	}

}