package ctr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RuoloDao;
import dao.RuoloDaoJdbcImpl;
import model.Ruolo;

/**
 * Servlet implementation class RuoloSrv
 */
@WebServlet("/RuoloSrv")
public class RuoloSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RuoloSrv() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		RuoloDao ruoloDao = new RuoloDaoJdbcImpl();

		String tipoOp = request.getParameter("tipoOperazione");
		System.out.println("tipoOperazione=" + tipoOp);

		if (tipoOp != null && tipoOp.equals("inserisci")) {
			String descr = request.getParameter("descr");

			Ruolo r = new Ruolo();
			r.setDescrizione(descr);
			ruoloDao.inserisci(r);
		}

		if (tipoOp != null && tipoOp.equals("aggiorna")) {
			String descr = request.getParameter("descr");
			String id = request.getParameter("id");
			int idR = Integer.parseInt(id);
			
			Ruolo r = new Ruolo();
			r.setDescrizione(descr);
			r.setIdRuolo(idR);
			ruoloDao.aggiorna(r);
		}

		if (tipoOp != null && tipoOp.equals("elimina")) {
			String id = request.getParameter("id");
			int idR = Integer.parseInt(id);
			ruoloDao.elimina(idR);
		}

		if (tipoOp != null && tipoOp.equals("ricercaperid")) {
			String id = request.getParameter("id");
			int idR = Integer.parseInt(id);

			Ruolo imp = ruoloDao.ricercaPerId(idR);
			System.out.println("Ruolo trovato:" + imp.getDescrizione());
		}

		response.getWriter().append("HELLOOOOOOOOO: ").append(request.getContextPath());
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
