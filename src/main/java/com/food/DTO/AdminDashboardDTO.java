package com.food.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDashboardDTO {
	   private long totalUsers;

	    private long totalRequests;

	    private long completedDeliveries;

	    private long activeMatches;
}
