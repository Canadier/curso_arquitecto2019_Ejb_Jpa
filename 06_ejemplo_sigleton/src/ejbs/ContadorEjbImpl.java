package ejbs;

import javax.ejb.Singleton;

/**
 * Session Bean implementation class ContadorEjbImpl
 */
@Singleton
public class ContadorEjbImpl implements ContadorEjb {

	private int valor=0;
	
	@Override
	public void incrementar() {
		valor++;
		
	}

	@Override
	public void decrementar() {
		valor--;
		
	}

	@Override
	public int getValor() {
		// TODO Auto-generated method stub
		return valor;
	}

    

}
