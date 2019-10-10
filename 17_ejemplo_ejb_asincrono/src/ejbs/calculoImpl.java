package ejbs;

import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class calculoImpl
 */
@Stateless
public class calculoImpl implements calculo {

	@Asynchronous
	@Override
	public Future<Integer> sumaNumeros(int n) {
		int res=0;
		for (int i=1;i<=n;i++) {
			res+=i;
			try {
				Thread.sleep(100); //Retardo
			}
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
			return new AsyncResult<>(res);	
	}

}
