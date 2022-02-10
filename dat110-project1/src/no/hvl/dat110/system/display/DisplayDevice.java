package no.hvl.dat110.system.display;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCServer;
import no.hvl.dat110.system.controller.Common;


public class DisplayDevice {
	
	public static void main(String[] args) {
		
		System.out.println("Display server starting ...");
		
		RPCServer displayServer = new RPCServer(Common.DISPLAYPORT);
		
		DisplayImpl displayimpl = new DisplayImpl((byte)2, displayServer);
		
		displayServer.run();
		
		displayServer.stop();
	
		System.out.println("Display server stopping ...");
		
	}
}
