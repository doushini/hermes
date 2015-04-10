package com.ctrip.hermes.meta.rest;

import org.junit.Test;
import org.unidal.lookup.ComponentTestCase;

import com.ctrip.hermes.meta.server.MetaRestServer;

public class StandaloneRestServer extends ComponentTestCase {

	public static final String HOST ="http://0.0.0.0:8080/";
	
	@Test
	public void startServer() throws InterruptedException {
		MetaRestServer server = lookup(MetaRestServer.class);
		server.start();
		Thread.currentThread().join();
	}
}
