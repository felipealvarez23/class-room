
package com.ez.classroom.services.impl;

import com.ez.classroom.services.NotificacionService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificacionServiceImpl implements NotificacionService {

	public static final String ACCOUNT_SID = "ACffd0bcafa2b8d0097f56490ac5b11f2f";
	public static final String AUTH_TOKEN = "fa4afb2df6e8b5a401b937adddb729ba";

	@Override
	public void whatsAppNotification(String message) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message notifyMessage = Message.creator(
			new com.twilio.type.PhoneNumber("whatsapp:+573058507458"),
			new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
			message)
			.create();
		log.info("Notificacion de whatssapp enviada " + notifyMessage.getSid() );
	}
}
