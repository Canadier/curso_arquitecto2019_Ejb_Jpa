package prueba;

import prueba.MiSingleton;

public class Test {

	public static void main(String[] args) {
		
		MiSingleton a=MiSingleton.getMiSingleton();
		MiSingleton b=MiSingleton.getMiSingleton();
		MiSingleton c=MiSingleton.getMiSingleton();
		
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(c.hashCode());
		
	}

}
