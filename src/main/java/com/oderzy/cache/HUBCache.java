package com.oderzy.cache;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class HUBCache implements Serializable {

	private static final long serialVersionUID = 1L;


	// {category of product, products}for SAMBALPUR
	//private static ConcurrentHashMap<String, List<HubDTO>> cache_SBP;
	// {category of product, products}for JAMSHEDPUR
	//private static ConcurrentHashMap<String, List<HubDTO>> cache_JSR;
	// {itemId, Product} for SAMBALPUR
	//private static Map<String, HubDTO> itemsCache_SBP;

	// {itemId, Product} for JAMSHEDPUR
	//private static Map<String, HubDTO> itemsCache_JSR;

	@PostConstruct
	private void initalize() {

		//cache_JSR = new ConcurrentHashMap<String, List<HubDTO>>();
		//cache_SBP = new ConcurrentHashMap<String, List<HubDTO>>();

		//itemsCache_SBP = new HashMap<String, HubDTO>();
		//itemsCache_JSR = new HashMap<String, HubDTO>();
	}

	/*public Map<String, HubDTO> getItemcache(String area) {
		switch (area) {
		case "SBP001":
			return itemsCache_SBP;
		case "JSR001":
			return itemsCache_JSR;
		default:
			return itemsCache_SBP;

		}
	}*/

/*	public ConcurrentHashMap<String, List<HubDTO>> getcache(String area) {
		switch (area) {
		case "SBP001":
			return cache_SBP;
		case "JSR001":
			return cache_JSR;
		default:
			return cache_SBP;

		}
	}*/

	/* -------------------- RetrivalOperations */
	/*public List<HubDTO> getItems(String category, String area) {
		return getcache(area).get(category);
	}
*/
	/*private void addToItemCache(List<HubDTO> data, String area) {
		switch (area) {
		case "SBP001":
			data.forEach(d -> itemsCache_SBP.put(d.getId(), d));
			break;
		case "JSR001":
			data.forEach(d -> itemsCache_JSR.put(d.getId(), d));
			break;
		default:
			data.forEach(d -> itemsCache_SBP.put(d.getId(), d));
			break;
		}
	}*/

	/*public HubDTO getItem(String id) {
		return itemsCache_SBP.get(id);
	}
*/
	/*public HubDTO getItem(String id, String area) {
		if (area.equals("SBP001"))
			return itemsCache_SBP.get(id);
		else
			return itemsCache_JSR.get(id);
	}
*/
	/*public double getItemCost(String id, String area) {
		try{if (area.equals("SBP001"))
			return itemsCache_SBP.get(id).getCost();
		else
			return itemsCache_JSR.get(id).getCost();
		}
		catch(NullPointerException n) {
			
		}
		return 0.0;
	}
*/
	/*public String getItemUnit(String id, String area) {
		if (area.equals("SBP001"))
			return itemsCache_SBP.get(id).getUnit();
		else
			return itemsCache_JSR.get(id).getUnit();

	}
*/
	/*public double getItemCost(String id) {
		return itemsCache_SBP.get(id).getCost();
	}
*/
	/*public Cart updatePrices(Cart c, String area) {
		HubDTO item = null;
		item = getItemcache(area).get(c.getItemCode());
		try {
			c.setValue(item.getMrp());
			if (c.getUnit().endsWith("g")) {
				try {
					int preweight = Integer.parseInt(c.getUnit().replace("g", ""));
					int newweight = 0;
					if (item.getUnit().endsWith("Kg"))
						newweight = 1000;
					else
						newweight = Integer.parseInt(item.getUnit().replace("g", ""));

					double price = (item.getPrice() / newweight) * preweight;
					c.setPrice(price);
				} catch (NumberFormatException n) {
					c.setPrice(item.getPrice());
				}
			} else {
				c.setPrice(item.getPrice());
			}
			c.setDiscount(item.getDiscount());
		} catch (NullPointerException ne) {

		}
		return c;
	}
	*//*-------------	Update operations*/

	/*public void refreshItemCache(List<ItemUpdateData> data, String area) {
		switch (area) {
		case "SBP001":
			data.forEach(d -> {
				HubDTO hd = itemsCache_SBP.get(d.getId());
				hd.setMrp(d.getMrp());
				hd.setDiscount(d.getDiscount());
				hd.setPrice(d.getPrice());
				itemsCache_SBP.put(hd.getId(), hd);
			});
			break;
		case "JSR001":
			data.forEach(d -> {
				HubDTO hd = itemsCache_JSR.get(d.getId());
				hd.setMrp(d.getMrp());
				hd.setDiscount(d.getDiscount());
				hd.setPrice(d.getPrice());
				itemsCache_JSR.put(hd.getId(), hd);
			});
		default:
			data.forEach(d -> {
				HubDTO hd = itemsCache_SBP.get(d.getId());
				hd.setMrp(d.getMrp());
				hd.setDiscount(d.getDiscount());
				hd.setPrice(d.getPrice());
				itemsCache_SBP.put(hd.getId(), hd);
			});
			break;
		}

	}
*/
	/*public void refreshItemCaches(List<HubDTO2> data, String area) {
		switch (area) {
		case "SBP001":
			data.forEach(d -> {
				HubDTO hd = itemsCache_SBP.get(d.getId());
				hd.setMrp(d.getMrp());
				hd.setDiscount(d.getDiscount());
				hd.setPrice(d.getPrice());
				itemsCache_SBP.put(hd.getId(), hd);
			});
			break;
		case "JSR001":
			data.forEach(d -> {
				HubDTO hd = itemsCache_JSR.get(d.getId());
				hd.setMrp(d.getMrp());
				hd.setDiscount(d.getDiscount());
				hd.setPrice(d.getPrice());
				itemsCache_JSR.put(hd.getId(), hd);
			});

		}

	}
*/
	/*public void refreshStocks(String category, String area) {

		Executors.newSingleThreadExecutor().execute(
			
				//Here we use Runnable FunctionalInterface run() method using lambfda Expression
				() -> {
					System.out.println(category);
					System.out.println(area);
					List<HubDTO> data;
					switch (area) {
					case "SBP001":
						data = service.findAll_ItemsByCategoryInArea(category, area);
						cache_SBP.put(category, data);

						data.forEach(d -> itemsCache_SBP.put(d.getId(), d));
						break;
					case "JSR001":
						data = service.findAll_ItemsByCategoryInArea(category, area);
						cache_JSR.put(category, data);

						data.forEach(d -> itemsCache_JSR.put(d.getId(), d));
						break;
					default:
						data = service.findAll_ItemsByCategoryInArea(category, area);
						cache_SBP.put(category, data);

						data.forEach(d -> itemsCache_SBP.put(d.getId(), d));
						break;
					}
			
				});
	}
*/
	// fOR nEW aPP
/*
	public void refreshStock11(String category, String area) {

		Executors.newSingleThreadExecutor().execute(() ->{
				System.out.println(category);
				System.out.println(area);
				List<HubDTO> data;
				switch (area) {
				case "SBP001":
					data = service.findAll_ItemsByCategoryInArea(category, area);
					cache_SBP.put(category, data);

					data.forEach(d -> itemsCache_SBP.put(d.getId(), d));
					break;
				case "JSR001":
					data = service.findAll_ItemsByCategoryInArea(category, area);
					cache_JSR.put(category, data);

					data.forEach(d -> itemsCache_JSR.put(d.getId(), d));
					break;

				}
			

		});
	}
*/

	//@PostConstruct
/*	public void refreshStocks() {

		Executors.newSingleThreadExecutor().execute(() -> {
				String[] categories;

				categories = new String[] { "Premium Vegetables", "₹10-Basket", "Fruits", "DryFruits","Vegetables", "Bath_Care",
						"Eat Now", "Daily-Needs", "Sauces & Spreads", "Flours & Grains", "Tea & Coffee", "Drinks",
						"Dal & Pulses", "Rice", "Oil & Ghee", "Biscuits", "Snacks & Choclate", "Masala", "Whole Spices",
						"Detergent & Dishwash", "Home Cleaning", "Bakery Special", "Women's Care", 
						"Salt&Sugar", "Puja Items", "Repellents-Fresheners", "Oral-Care",
						"Health Care", "Home Essentials" };
				for (String category : categories) {
					List<HubDTO> data = service.findAll_ItemsByCategoryInArea(category, "SBP001");
					cache_SBP.put(category, data);
					addToItemCache(data, "SBP001");
				}

				*//*categories = new String[] { "Premium Vegetables", "₹10-Basket", "Fruits", "Vegetables", "Bath_Care",
						"Eat Now", "Daily-Needs", "Sauces & Spreads", "Flours & Grains", "Tea & Coffee", "Dal & Pulses",
						"Rice", "Oil & Ghee", "Masala", "Whole Spices", "Detergent & Dishwash", "Home Cleaning",
						"Salt&Sugar", "Puja Items", "Repellents-Fresheners", "Oral-Care", "Health Care",
						"Home Essentials" };*//*
		*//*		for (String category : categories) {
					List<HubDTO> data = service.findAll_ItemsByCategoryInArea(category, "JSR001");
					cache_JSR.put(category, data);
					addToItemCache(data, "JSR001");
				}*//*

			
		});
	}*/
}
