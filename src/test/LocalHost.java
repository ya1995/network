package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			String hostName = inetAddress.getHostName();
			String hostAddress = inetAddress.getHostAddress();
			byte[] address = inetAddress.getAddress();
			
			System.out.println(hostName);
			System.out.println( hostAddress );
		
			for( int i=0; i<address.length; i++ ) {
				System.out.print( address[i] & 0x000000ff );
				if( i<3 ) {
					System.out.print( "." );
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
