package com.oderzy.whatsapp;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oderzy.$config.constants.$Navigation;

@RestController
@RequestMapping(value = $Navigation.whatsapp_Controller)
@CrossOrigin()
public class WhatsappController {
	/*
	 * @Autowired private Whatsapp_Service service;
	 * 
	 * @PostMapping("/whtsp/webhooks") public void smshit(@RequestBody TextReply
	 * reply) { try { System.out.println("hitteddddddddddddddddddd"); // Message msg
	 * = reply.getEntry()[0].getChanges()[0].getValue().getMessages()[0]; //
	 * service.newMessageReceived(msg); } catch (NullPointerException e) { // TODO:
	 * handle exception } }
	 * 
	 * @GetMapping("/whtsp/webhooks") public int smshits(@RequestParam("hub.mode")
	 * String mode, @RequestParam("hub.challenge") int challenge,
	 * 
	 * @RequestParam("hub.verify_token") String token) {
	 * 
	 * return challenge;
	 * 
	 * }
	 * 
	 * @PostMapping("/test/1") public void smshit() {
	 * 
	 * service.sendTextMessage("Om", "8674957111"); }
	 * 
	 * @PostMapping("/test/{mobile}") public void smshit2(@PathVariable String
	 * mobile) {
	 * 
	 * service.sendTextMessage("Om", mobile); }
	 * 
	 * @PostMapping("/test/2") public void senAll() {
	 * 
	 * service.SendMessageToAll(); }
	 */

}



