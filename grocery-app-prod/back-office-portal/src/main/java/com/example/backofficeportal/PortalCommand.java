package com.example.backofficeportal;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
class PortalCommand {

	private String action ;

	private String customerid ;

	private String customername ;

	private String customerpassword ;

	private String orderid ;

	private String amount ;

	private String details ;

	private String status ;
}