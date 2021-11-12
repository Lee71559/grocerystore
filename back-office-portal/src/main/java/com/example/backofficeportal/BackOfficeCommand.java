package com.example.backofficeportal;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BackOfficeCommand {

	private String action ;
	private String orderid ;
	private String cutomername;

}