package ctr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImpiegatoDao;
import dao.ImpiegatoDaoJdbcImpl;
import model.Impiegato;

/**
 * Servlet implementation class ImpiegatoSrv
 */
@WebServlet("/ImpiegatoSrv")
public class ImpiegatoSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ImpiegatoSrv() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		ImpiegatoDao impDao = new ImpiegatoDaoJdbcImpl();

		String tipoOp = request.getParameter("tipoOperazione");
		System.out.println("tipoOperazione=" + tipoOp);

		if (tipoOp != null && tipoOp.equals("inserisci")) {
			String cf = request.getParameter("cf");
			String cogn = request.getParameter("cognome");
			String nom = request.getParameter("nome");

			Impiegato imp = new Impiegato();

			imp.setCodiceFiscale(cf);
			imp.setCognome(cogn);
			imp.setNome(nom);

			impDao.inserisci(imp);
			request.getRequestDispatcher("/inserimentoImpiegatoOk.jsp").forward(request, response);

		}

		if (tipoOp != null && tipoOp.equals("aggiorna")) {
			String cf = request.getParameter("cf");
			String cogn = request.getParameter("cognome");
			String nom = request.getParameter("nome");
//			String matr = request.getParameter("matr");
//			int matricola = Integer.parseInt(matr);

			Impiegato imp = new Impiegato();

			imp.setCodiceFiscale(cf);
			imp.setCognome(cogn);
			// imp.setMatricola(matricola);
			imp.setNome(nom);

			impDao.aggiorna(imp);
			request.getRequestDispatcher("/aggiornaImpiegatoOK.jsp").forward(request, response);

		}

		if (tipoOp != null && tipoOp.equals("elimina")) {
			String cf = request.getParameter("cf");

			impDao.elimina(cf);
		}

		if (tipoOp != null && tipoOp.equals("ricercaCF")) {
			String cf = request.getParameter("cf");

			Impiegato imp = impDao.ricercaPerCodiceFiscale(cf);
			if (imp != null) {
				System.out.println("impiegato trovato:" + imp.getMatricola());
				request.getSession().setAttribute("impiegatoTrovato", imp);
				request.getRequestDispatcher("/aggiornaImpiegato.jsp").forward(request, response);
			} else
				request.getRequestDispatcher("/ricercaImpiegatoKo.jsp").forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
