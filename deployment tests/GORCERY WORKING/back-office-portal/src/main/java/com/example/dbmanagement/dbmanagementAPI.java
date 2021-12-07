package com.example.dbmanagement;

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


public class dbmanagementAPI {

	private boolean DEBUG = false;

	private static String requestHost ;

	public static void setHost(String h) { requestHost = h ; }

	public static void debugConfig() {
		System.out.println( requestHost );
	}


	public static String payload = null ;

	


}