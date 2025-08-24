package pattern;

public class Adapter {

	public static void main(String[] args) {
		SecretNetConnection connect = new ConnectionAdapter(new SpyPC("Wi-fi"));
		connect.secretNetConnect();

	}
	
	static interface SpyPCConnection
	{
		void spyPCConnect();
	}
	
	static class SpyPC implements SpyPCConnection
	{
		private String connectType;
		
		SpyPC (String connectType)
		{
			this.connectType = connectType;
		}

		@Override
		public void spyPCConnect() {
			System.out.println("Компьютер-шпион подсоединён к сети секретной лаборатории.\nТип связи: " + connectType);
			
		}
		
	}
	
	static interface SecretNetConnection
	{
		void secretNetConnect();
	}
	
	static class ConnectionAdapter implements SecretNetConnection
	{
		
		private SpyPCConnection spy;
		
		ConnectionAdapter(SpyPCConnection spy)
		{
			this.spy = spy;
		}

		@Override
		public void secretNetConnect() {
			spy.spyPCConnect();
			
		}
		
	}
	
	

}
