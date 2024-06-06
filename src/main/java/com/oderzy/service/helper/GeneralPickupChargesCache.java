package com.oderzy.service.helper;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.oderzy.$config.constants.$Pickup;

@Service
public class GeneralPickupChargesCache implements Serializable{

	private static final long serialVersionUID = -4717204370405550988L;
	// Bhog name -Bhog price
	private static ConcurrentHashMap<String, Double> bhogPrice;
	// Bhog name -delivery charge
	private static ConcurrentHashMap<String, Double> bhogCharges;
	// foodDelivery -charge
	private static ConcurrentHashMap<String, Double> foodCharges;
	// MedicineDelivery -charge
	private static ConcurrentHashMap<String, Double> medCharges;
	// DocumentDelivery -charge
	private static ConcurrentHashMap<String, Double> docCharges;
	// otherDelivery -charge
	private static ConcurrentHashMap<String, Double> otherCharges;

	public ConcurrentHashMap<String, Double> getBhogPrice() {
		return bhogPrice;
	}

	public ConcurrentHashMap<String, Double> getBhogCharges() {
		return bhogCharges;
	}
	public ConcurrentHashMap<String, Double> getFoodCharges() {
		return foodCharges;
	}

	public ConcurrentHashMap<String, Double> getMedCharges() {
		return medCharges;
	}

	public ConcurrentHashMap<String, Double> getDocumentCharges() {
		return docCharges;
	}

	public ConcurrentHashMap<String, Double> getOtherCharges() {
		return otherCharges;
	}

	@PostConstruct()
	public void loadCharges() {
		bhogPrice = new ConcurrentHashMap<>();
	
		foodCharges = new ConcurrentHashMap<>();
		foodCharges.put($Pickup._extra, $Pickup.food_extra);
		foodCharges.put($Pickup.Normal_0, $Pickup.food_Normal_0);
		foodCharges.put($Pickup.Normal_1, $Pickup.food_Normal_1);
		foodCharges.put($Pickup.Normal_2, $Pickup.food_Normal_1);
		foodCharges.put($Pickup.Exprerss_0, $Pickup.food_Exprerss_0);
		foodCharges.put($Pickup.Exprerss_1, $Pickup.food_Exprerss_1);
		foodCharges.put($Pickup.Exprerss_2, $Pickup.food_Exprerss_2);

		medCharges = new ConcurrentHashMap<>();
		medCharges.put($Pickup.Normal_0, $Pickup.med_Normal_0);
		medCharges.put($Pickup.Normal_1, $Pickup.med_Normal_1);
		medCharges.put($Pickup.Normal_2, $Pickup.med_Normal_1);
		medCharges.put($Pickup.Exprerss_0, $Pickup.med_Exprerss_0);
		medCharges.put($Pickup.Exprerss_1, $Pickup.med_Exprerss_1);
		medCharges.put($Pickup.Exprerss_2, $Pickup.med_Exprerss_2);

		docCharges = new ConcurrentHashMap<>();
		docCharges.put($Pickup.Normal_0, $Pickup.doc_Normal_0);
		docCharges.put($Pickup.Normal_1, $Pickup.doc_Normal_1);
		docCharges.put($Pickup.Normal_2, $Pickup.doc_Normal_1);
		docCharges.put($Pickup.Exprerss_0, $Pickup.doc_Exprerss_0);
		docCharges.put($Pickup.Exprerss_1, $Pickup.doc_Exprerss_1);
		docCharges.put($Pickup.Exprerss_2, $Pickup.doc_Exprerss_2);
		docCharges.put($Pickup._care, $Pickup.doc_care);
		docCharges.put($Pickup._extraCare, $Pickup.doc_extraCare);
		docCharges.put($Pickup._superLock, $Pickup.doc_superLock);

		otherCharges = new ConcurrentHashMap<>();
		otherCharges.put($Pickup.Normal_0, $Pickup.other_Normal_0);
		otherCharges.put($Pickup.Normal_1, $Pickup.other_Normal_1);
		otherCharges.put($Pickup.Normal_2, $Pickup.other_Normal_1);
		otherCharges.put($Pickup.Exprerss_0, $Pickup.other_Exprerss_0);
		otherCharges.put($Pickup.Exprerss_1, $Pickup.other_Exprerss_1);
		otherCharges.put($Pickup.Exprerss_2, $Pickup.other_Exprerss_2);
		otherCharges.put($Pickup._offer, $Pickup.offer);
		otherCharges.put($Pickup._extra, $Pickup.extra);
		otherCharges.put($Pickup._special, $Pickup.special);
		otherCharges.put($Pickup._safe, $Pickup.safe);
		otherCharges.put($Pickup._heavy, $Pickup.heavy);
		otherCharges.put($Pickup._large, $Pickup.large);
		otherCharges.put($Pickup._unique, $Pickup.rush);
		otherCharges.put($Pickup._rush, $Pickup.unique);
	}

}
