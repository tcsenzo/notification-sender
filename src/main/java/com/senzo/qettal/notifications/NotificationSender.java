package com.senzo.qettal.notifications;

import com.senzo.qettal.event.EventListDTO;

public interface NotificationSender {
	public void send(EventListDTO events);
}
