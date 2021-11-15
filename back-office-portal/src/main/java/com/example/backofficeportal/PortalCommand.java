package com.example.backofficeportal;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
class PortalCommand {

	private String action ;

	private String customerid ;

	private String orderid ;
}