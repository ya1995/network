package echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchoServer {
	private static final int PORT = 6000;
	private static final int BUFFER_SIZE = 1024;
	
	public static void main(String[] args) {
		DatagramSocket socket = null;
		
		try {
			//	1. 소켓 생성
			socket = new DatagramSocket( PORT );
			
			while( true ) {
				// 2. 수신 패킷 생성
				DatagramPacket receivePacket = 
						new DatagramPacket( new byte[ BUFFER_SIZE ], BUFFER_SIZE );
					
				//3. 데이터 수신 대기
				socket.receive( receivePacket ); // blocking
	
				//4. 수신
				String message = 
						new String( receivePacket.getData(), 0, receivePacket.getLength(), "utf-8" );
				System.out.println( "[UDP Echo Server] received:" + message );
			
				//5. 데이터 송신
				byte[] sendData = message.getBytes( "UTF-8" );
				DatagramPacket sendPacket = 
						new DatagramPacket( sendData, sendData.length,
								receivePacket.getAddress(), receivePacket.getPort());
				
				socket.send( sendPacket );
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if( socket != null && socket.isClosed() == false ) {
				socket.close();
			}
		}
	}

}
