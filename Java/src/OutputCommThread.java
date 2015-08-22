
public class OutputCommThread extends Thread {
	
	private static boolean progress;
	
	public OutputCommThread(){
		super();
		progress = false;
	}
	
	public void run(){
		while(true){
			try{
				if(progress){
					MainAction.OCOMMSemaphore.acquire();
					MainAction.arduino.sendData();
					MainAction.OCOMMSemaphore.release();
				}				
				sleep(100);
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void pause(){
		progress = false;
	}
	
	public void threadContinue(){
		progress = true;
	}
}