package chat;

public class ChatClientReceiveThread extends Thread {


	@Override
	public void run() {
		while( true ) {
			String line = br.readLine();
			textArea.append( "둘리:" + message );
			textArea.append("\n");
		}
	}

}
