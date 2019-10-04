package ejbs;

import javax.ejb.Local;

@Local
public interface ContadorEjb {

		public void incrementar();
		public void decrementar();
		public int getValor();
}
