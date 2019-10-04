package prueba;

public class MiSingleton {

	//Implementaci�n de un patr�n SINGLETON
	
	private static MiSingleton obj;
	
	static {
		obj=new MiSingleton();
	}
	private MiSingleton() {
		
	}
	
	public static MiSingleton getMiSingleton() {
		return obj;
	}
}
