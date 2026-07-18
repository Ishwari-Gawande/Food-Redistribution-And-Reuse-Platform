package com.food.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationDTO {
	 private Long userId;

	    private String title;

	    private String message;

	    private String type;
}
