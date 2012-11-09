package net.bluedash.resteasy.netty;

import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;
import org.jboss.resteasy.test.TestPortProvider;

public class PlayNettyServer {
	
	
	public static 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NettyJaxrsServer netty = new NettyJaxrsServer();
		ResteasyDeployment deployment = new ResteasyDeployment();
		deployment.getActualProviderClasses().add();
		netty.setDeployment(deployment);
		netty.setPort(TestPortProvider.getPort());
		netty.setRootResourcePath("");
		netty.setSecurityDomain(null);
		netty.start();

	}

}
