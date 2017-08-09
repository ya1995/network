package thread;

public class MultiThreadEx {
	public static void main(String[] args) {
		Thread thread1 = new AlphabetThread();
		Thread thread2 = new Thread( new DigitThread() );
		thread1.start();
		thread2.start();
	
		new Thread( new Runnable () {
			@Override
			public void run() {
				for( char c = 'A'; c <= 'Z' ; c++ ) {
					System.out.print( c );
					
					try {
						Thread.sleep( 1000 );
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}).start();
		
		
		/*	
		for( int i=0; i<10; i++ ) {
			System.out.print( i );
			try {
				Thread.sleep( 1000 );
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
		/*
		for( char c = 'a'; c<='z'; c++) {
			System.out.print( c );
		}
		*/
	}

}
