package com.wanghui.client;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.io.IOUtils;

public class HttpClientTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		InputStream is = null;

		HttpClient client = new HttpClient();

		PostMethod method = new PostMethod(
				"http://localhost:8081/helloService/sayHello");

		method.setRequestHeader("Host", "localhost:8081");

		method.setRequestHeader("Content-Type",
				"text/xml;charset=UTF-8");

		method.setParameter("name", "wanghui");

		try {

			client.executeMethod(method);

			is = method.getResponseBodyAsStream();

//			Document document = Jsoup.parse(is, "gbk", "");
//
//			System.err.println(document);
			
			System.out.println(IOUtils.toString(is, "UTF-8"));

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			method.releaseConnection();

			try {

				if (is != null) {

					is.close();

				}

			} catch (IOException e) {

				e.printStackTrace();

			}

		}
	}

}
