package com.food.service;

import java.util.List;

import com.food.DTO.NotificationDTO;
import com.food.entities.Notification;

public interface NotificationService {
	public String sendNotification(NotificationDTO request);

	public List<Notification> getMyNotifications();

	public String markAsRead(Long id);
}
