package com.nethru.myapp;

import java.net.MalformedURLException;
import java.net.URL;

import com.google.common.base.Strings;

public class UrlSplitter {
	
	private String source;
	private String protocol;
	private String[] domains;
	private String[] paths;
	private String[] params;
	
	/*
	@SuppressWarnings("unused")
	private UrlSplitter() {
	}
	*/
	
	public UrlSplitter(String source) {
		this.source = source;
		this.split(source);
	}
	
	private void split(String source) {
		try {
			URL url = new URL(source);
			this.protocol = url.getProtocol();
			this.domains = url.getHost().split("\\.");
			
			String path = url.getPath();
			if(!Strings.isNullOrEmpty(path)) {
				this.paths = path.substring(1).split("/");
			}
			
			String query = url.getQuery();
			if(!Strings.isNullOrEmpty(query)) {
				this.params = query.split("&");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public String getSource() {
		return source;
	}
	
	public String getProtocol() {
		return protocol;
	}

	public String[] getDomains() {
		return domains;
	}

	public String[] getPaths() {
		return paths;
	}

	public String[] getParams() {
		return params;
	}
}
