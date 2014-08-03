package com.nethru.myapp;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class UrlSplitterTest {
	
	@Test
	public void test() {
		String sample = "http://www.11st.co.kr/browsing/DisplayCategory.tmall?method=getDisplayCategory3Depth&dispCtgrNo=930964&";
		UrlSplitter splitter = new UrlSplitter(sample); 

		assertArrayEquals(new String[] { "www", "11st", "co", "kr" }, splitter.getDomains());
		assertArrayEquals(new String[] { "browsing", "DisplayCategory.tmall" }, splitter.getPaths());
		assertArrayEquals(new String[] { "method=getDisplayCategory3Depth", "dispCtgrNo=930964" }, splitter.getParams());
	}
}
