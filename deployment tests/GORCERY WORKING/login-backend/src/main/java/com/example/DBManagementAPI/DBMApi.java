package com.example.DBManagementAPI;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;


@Slf4j
public class DBMApi {

	private static String APIKEY = "";

	private String apiHost;
	private String apiPort;


	public DBMApi (String apiHost, String apiPort) {
		this.apiHost = "http://" + apiHost;
		this.apiPort = apiPort;

		System.out.println("-------->" + this.apiHost);
		System.out.println("-------->" + this.apiPort);
	}

	private final String USER_AGENT = "Mozilla/5.0";
    public static String postRequestTarget = "REQUEST_TARGET_PALCEHOLDER";
    public static String APINAME = "APINAME_PLACEHOLDER";
    public static String resource = "resource_PLACEHOLDER";

    private boolean DEBUG = false;
    public static String payload = null;


 	public ResponseEntity<String> ping() throws Exception {

        	String res = sendGet(apiHost + ":" + apiPort + "/"  + "ping", "GET") ;
        
            return ResponseEntity.ok(res) ;
    }





    private String sendGet(String url, String action) throws Exception {
        /* HTTP connection */
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        /* Add Request Header
         * "Host" Host to send the request to.
         */
        con.setRequestProperty("Host", apiHost);

        if (action.equals("ClearOrder")){
            /* HTTP Method DELETE */
            con.setRequestMethod("DELETE");
        } else if (action.equals("GetOrder")){
            /* HTTP Method GET */
            con.setRequestMethod("GET");
        } else if (action.equals("PayOrder")){
            /* HTTP Method POST */
            con.setRequestMethod("POST");
        }

        /* Establishing HTTP connection*/
        int responseCode = con.getResponseCode();
        String responseHeader = con.getHeaderField("v-c-correlation-id");

        /* Reading Response Message */
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        
        in.close();

        /* print Response */
        System.out.println("\tResponse Payload :\n" + response.toString());

        return response.toString() ;
    }



}