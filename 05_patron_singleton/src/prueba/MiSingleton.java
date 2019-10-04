package prueba;

public class MiSingleton {

	//Implementación de un patrón SINGLETON
	
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
