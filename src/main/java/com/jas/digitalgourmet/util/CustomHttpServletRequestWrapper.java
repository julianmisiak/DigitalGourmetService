package com.jas.digitalgourmet.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

public class CustomHttpServletRequestWrapper extends HttpServletRequestWrapper {
	private String body;

	public CustomHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);

		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;

		Logger logger = LoggerFactory.getLogger(CustomHttpServletRequestWrapper.class);
		try {
			InputStream inputStream = request.getInputStream();

			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

				char[] charBuffer = new char[128];
				int bytesRead;

				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			}
		} catch (IOException ex) {
			logger.error("Error reading the request body...");
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					logger.error("Error closing bufferedReader...");
				}
			}
		}

		body = stringBuilder.toString();

		logger.debug(String.format("  %s %s - %s", "Transaction ID:", request.getAttribute("numero"),
				body.isEmpty() ? "NO JSON REQUEST PROVIDED IN PAYLOAD" : "JSON REQUEST: " + body));
	}

	@Override
	public ServletInputStream getInputStream() {
		final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body.getBytes());

		return new ServletInputStream() {
			public int read() {
				return byteArrayInputStream.read();
			}

			@Override
			public boolean isFinished() {
				return false;
			}

			@Override
			public boolean isReady() {
				return false;
			}

			@Override
			public void setReadListener(ReadListener listener) {

			}
		};
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(this.getInputStream()));
	}

}
