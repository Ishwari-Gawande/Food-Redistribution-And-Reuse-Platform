package com.food.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchDTO {

	private Long donationRequestId;

    private Long receiverRequestId;

    private Long matchedBy;
}
