package com.wanghui.client;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.io.IOUtils;

public class HttpClientTest2 {

	public static void main2(String[] args) throws Exception {
		String url = "/webservices/DomesticAirline.asmx/getDomesticAirlinesTime";
		String host = "www.webxml.com.cn";
		String param = "startCity=" + URLEncoder.encode("杭州", "utf-8")
				+ "&lastCity=&theDate=&userID=";
		HttpClient httpClient = new HttpClient();
		httpClient.getHostConfiguration().setHost(host, 80, "http");

		HttpMethod method = getMethod(url, param);
		// HttpMethod method = postMethod(url);

		httpClient.executeMethod(method);

		String response = method.getResponseBodyAsString();
		// String response = new
		// String(method.getResponseBodyAsString().getBytes("ISO-8859-1"));
		System.out.println(response);
	}
	public static void main1(String[] args) throws Exception {
		String url = "/webservices/DomesticAirline.asmx/getDomesticAirlinesTime";
		String host = "www.webxml.com.cn";
		HttpClient httpClient = new HttpClient();
		httpClient.getHostConfiguration().setHost(host, 80, "http");

		 HttpMethod method = postMethod(url);

		httpClient.executeMethod(method);

		System.out.println(method.getResponseBodyAsString());
//		 String response = new String(method.getResponseBodyAsString().getBytes("ISO-8859-1"));
//		System.out.println(response);
	}

	private static HttpMethod getMethod(String url, String param)
			throws IOException {
		GetMethod get = new GetMethod(url + "?" + param);
		get.releaseConnection();
		return get;
	}

	private static HttpMethod postMethod(String url) throws IOException {
		PostMethod post = new PostMethod(url);
		post.setRequestHeader("Content-Type",
				"text/xml;charset=gbk");
		NameValuePair[] param = { new NameValuePair("startCity", "杭州"),
				new NameValuePair("lastCity", "沈阳"),
				new NameValuePair("userID", ""),
				new NameValuePair("theDate", "") };
		post.setRequestBody(param);
		post.releaseConnection();
		return post;
	}
	public static void main(String[] args) throws Exception {
		String url = "/helloService/sayGoodbye";
		String host = "localhost";
		HttpClient httpClient = new HttpClient();
		httpClient.getHostConfiguration().setHost(host, 8081, "http");

		 HttpMethod method = postMethod(url);

		httpClient.executeMethod(method);

		System.out.println(IOUtils.toString(method.getResponseBodyAsStream()));
//		 String response = new String(method.getResponseBodyAsString().getBytes("ISO-8859-1"));
//		System.out.println(response);
	}
}