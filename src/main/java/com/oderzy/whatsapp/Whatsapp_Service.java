package com.oderzy.whatsapp;

import org.springframework.stereotype.Service;

@Service
public class Whatsapp_Service {
	/*
	 * @Autowired private Wasp_Repositery repo;
	 * 
	 * @Autowired private RestTemplate restTemplate;
	 * 
	 * @Autowired private Cart_Service cartService;
	 * 
	 * @Autowired private CustomerRepositery crepo;
	 * 
	 * public int sendTemplateMessage(String templatename, String mobile) {
	 * 
	 * return 1; }
	 * 
	 * public int sendTextMessage(String text, String mobile) {
	 * com.oderzy.whatsapp.vo.Message msg = new com.oderzy.whatsapp.vo.Message();
	 * 
	 * msg.setMessaging_product("whatsapp"); msg.setTo(mobile); msg.setType("text");
	 * msg.setText(new Text("Radhe Krishna"));
	 * 
	 * //sendMessageObj(msg); return 1; }
	 * 
	 * 
	 * 
	 * Send Text Message
	 * 
	 * 
	 * public void sendTextMsg(com.oderzy.whatsapp.vo.Message msg) { HttpHeaders
	 * headers = null;
	 * 
	 * JSONObject json = new JSONObject(); JSONObject tmpltJson = new JSONObject();
	 * JSONObject langJson = new JSONObject();
	 * 
	 * headers = new HttpHeaders();
	 * headers.setContentType(MediaType.APPLICATION_JSON);
	 * headers.add("Authorization",
	 * "Bearer EAAPoHloZCzqMBANgVPAB4ZB4OZCoeZAZAHz1oRi7DsMNnKKNmkJciuSl3eoh9hBDZC4YKqUGe37GHh46fN8TSquk7Jdz0yd7RziXwQVmUHVMH6pLFQ78Nl3HhLasaxKyXiJseW7oLG4xLYGCpwsQWwRBUI9YYPQZAl8JtoJ8bZBz6aRvZBCRyzpZAB"
	 * ); try {
	 * 
	 * json.put("messaging_product", "whatsapp"); json.put("to", msg.getTo());
	 * json.put("type", msg.getType());
	 * 
	 * langJson.put("code", "en"); tmpltJson.put("name", "");
	 * tmpltJson.put("language", langJson);
	 * 
	 * json.put("template", tmpltJson);
	 * 
	 * HttpEntity<String> request = new HttpEntity<String>(json.toString(),
	 * headers);
	 * 
	 * restTemplate.postForEntity(
	 * "https://graph.facebook.com/v13.0/109940415123250/messages", request,
	 * String.class);
	 * 
	 * } catch (Exception e) { System.out.println(e); }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * Send Template Message
	 * 
	 * 
	 * public void sendTemplateWithImg(com.oderzy.whatsapp.vo.Message msg, String
	 * tmpltName, String imgLink) { HttpHeaders headers = null; JSONObject json =
	 * new JSONObject(); JSONObject tmpltJson = new JSONObject(); JSONObject
	 * langJson = new JSONObject(); JSONObject compoJson = new JSONObject();
	 * JSONObject paramJson = new JSONObject(); JSONObject imgJson = new
	 * JSONObject();
	 * 
	 * JSONArray params = new JSONArray(); JSONArray comps = new JSONArray();
	 * 
	 * headers = new HttpHeaders();
	 * headers.setContentType(MediaType.APPLICATION_JSON);
	 * headers.add("Authorization",
	 * "Bearer EAAPoHloZCzqMBANgVPAB4ZB4OZCoeZAZAHz1oRi7DsMNnKKNmkJciuSl3eoh9hBDZC4YKqUGe37GHh46fN8TSquk7Jdz0yd7RziXwQVmUHVMH6pLFQ78Nl3HhLasaxKyXiJseW7oLG4xLYGCpwsQWwRBUI9YYPQZAl8JtoJ8bZBz6aRvZBCRyzpZAB"
	 * ); try {
	 * 
	 * json.put("messaging_product", "whatsapp"); json.put("to", msg.getTo());
	 * json.put("type", "template");
	 * 
	 * langJson.put("code", "en_GB"); tmpltJson.put("name", tmpltName);
	 * tmpltJson.put("language", langJson);
	 * 
	 * imgJson.put("link", imgLink);
	 * 
	 * paramJson.put("type", "image"); paramJson.put("image", imgJson);
	 * 
	 * params.put(paramJson);
	 * 
	 * compoJson.put("type", "header"); compoJson.put("parameters", params);
	 * 
	 * comps.put(compoJson);
	 * 
	 * tmpltJson.put("components", comps);
	 * 
	 * json.put("template", tmpltJson);
	 * 
	 * HttpEntity<String> request = new HttpEntity<String>(json.toString(),
	 * headers);
	 * 
	 * restTemplate.postForEntity(
	 * "https://graph.facebook.com/v13.0/109940415123250/messages", request,
	 * String.class);
	 * 
	 * } catch (Exception e) { System.out.println(e); }
	 * 
	 * }
	 * 
	 * public void sendTemplate(com.oderzy.whatsapp.vo.Message msg, String
	 * tmpltName) { HttpHeaders headers = null;
	 * 
	 * JSONObject json = new JSONObject(); JSONObject tmpltJson = new JSONObject();
	 * JSONObject langJson = new JSONObject();
	 * 
	 * headers = new HttpHeaders();
	 * headers.setContentType(MediaType.APPLICATION_JSON);
	 * headers.add("Authorization",
	 * "Bearer EAAPoHloZCzqMBANgVPAB4ZB4OZCoeZAZAHz1oRi7DsMNnKKNmkJciuSl3eoh9hBDZC4YKqUGe37GHh46fN8TSquk7Jdz0yd7RziXwQVmUHVMH6pLFQ78Nl3HhLasaxKyXiJseW7oLG4xLYGCpwsQWwRBUI9YYPQZAl8JtoJ8bZBz6aRvZBCRyzpZAB"
	 * ); try {
	 * 
	 * json.put("messaging_product", "whatsapp"); json.put("to", msg.getTo());
	 * json.put("type", msg.getType());
	 * 
	 * langJson.put("code", "en"); tmpltJson.put("name", tmpltName);
	 * tmpltJson.put("language", langJson);
	 * 
	 * json.put("template", tmpltJson);
	 * 
	 * HttpEntity<String> request = new HttpEntity<String>(json.toString(),
	 * headers);
	 * 
	 * restTemplate.postForEntity(
	 * "https://graph.facebook.com/v13.0/109940415123250/messages", request,
	 * String.class);
	 * 
	 * } catch (Exception e) { System.out.println(e); }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * Message Received
	 * 
	 * 
	 * @Transactional public void newMessageReceived(Message msg) { Wmessage wmsg =
	 * new Wmessage(); wmsg.setFrom_(msg.getFrom());
	 * 
	 * wmsg.setId(msg.getId()); wmsg.setTimestamp_(msg.getTimestamp());
	 * wmsg.setType_(msg.getType()); switch (msg.getType()) { case "text":
	 * wmsg.setText_(msg.getText().getBody()); repo.save(wmsg);
	 * 
	 * break; case "order": Order o__ = msg.getOrder(); String user =
	 * msg.getFrom().substring(2); System.out.println(o__.getCatalog_id());
	 * System.out.println("catlouge");
	 * System.out.println((o__.getProduct_items()[0]).getProduct_retailer_id());
	 * System.out.println(o__.getProduct_items()[0].getQuantity());
	 * ArrayList<ProductItem> plst = (ArrayList<ProductItem>)
	 * Arrays.asList(o__.getProduct_items());
	 * 
	 * cartService.getDeliverySpeedWhatsapp(plst, user, "SBP001"); break;
	 * 
	 * case "interactive": {
	 * wmsg.setInteractionType(msg.getInteractive().getType()); if
	 * (msg.getInteractive().getType().equals("list_reply")) {
	 * wmsg.setInteractionId(msg.getInteractive().getList_reply().getId());
	 * wmsg.setInteractionTitle(msg.getInteractive().getList_reply().getTitle());
	 * wmsg.setInteractionDesc(msg.getInteractive().getList_reply().getDescription()
	 * ); } else {
	 * wmsg.setInteractionId(msg.getInteractive().getButton_reply().getId());
	 * wmsg.setInteractionTitle(msg.getInteractive().getButton_reply().getTitle());
	 * 
	 * } }
	 * 
	 * 
	 * case "button":
	 * 
	 * break; case "image":
	 * 
	 * break; case "document":
	 * 
	 * break; case "audio":
	 * 
	 * break; case "sticker":
	 * 
	 * break; default: break; }
	 * 
	 * }
	 * 
	 * public String SendMessageToAll() {
	 * Executors.newSingleThreadExecutor().execute(new Runnable() {
	 * 
	 * @Override public void run() { // ArrayList<String> mobiles =
	 * (ArrayList<String>) orepo.findAllMobile(); ArrayList<String> mobiles =
	 * (ArrayList<String>) crepo.getAllUserMobile("ACTIVE"); mobiles.forEach(m -> {
	 * System.out.println(m); sendTextMessage("Hare Krishna", "91" + m); try {
	 * Thread.sleep(_Oderzy.MsgTime); } catch (InterruptedException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }); } }); return "Om"; }
	 */
}
