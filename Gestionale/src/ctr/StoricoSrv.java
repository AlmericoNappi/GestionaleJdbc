package ctr;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StoricoDao;
import dao.StoricoDaoJdbcImpl;
import model.Storico;

/**
 * Servlet implementation class StoricoSrv
 */
@WebServlet("/StoricoSrv")
public class StoricoSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoricoSrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StoricoDao stDao = new StoricoDaoJdbcImpl();

		String tipoOp = request.getParameter("tipoOperazione");
		System.out.println("tipoOperazione=" + tipoOp);

		if (tipoOp != null && tipoOp.equals("inserisci")) {
			String matr = request.getParameter("matricola");
			String idR = request.getParameter("idRuolo");
			String dateI = request.getParameter("dataInizio");
			String dateF = request.getParameter("dataFine");

			int matricola = Integer.parseInt(matr);
			int idRuolo = Integer.parseInt(idR);
			
			Storico r = new Storico();
			r.setIdRuolo(idRuolo);
			r.setMatricola(matricola);
			r.setDataFine(convert(dateF));
			r.setDataInizio(convert(dateI));
			
			stDao.inserisci(r);
		}

		if (tipoOp != null && tipoOp.equals("aggiorna")) {
			String idS = request.getParameter("idStorico");
			String matr = request.getParameter("matricola");
			String idR = request.getParameter("idRuolo");
			String dateI = request.getParameter("dataInizio");
			String dateF = request.getParameter("dataFine");

			int matricola = Integer.parseInt(matr);
			int idRuolo = Integer.parseInt(idR);
			int idStorico= Integer.parseInt(idS);
			
			Storico r = new Storico();
			r.setIdRuolo(idRuolo);
			r.setMatricola(matricola);
			r.setDataFine(convert(dateF));
			r.setDataInizio(convert(dateI));
			r.setIdStorico(idStorico);
			
			stDao.aggiorna(r);
		}

		if (tipoOp != null && tipoOp.equals("elimina")) {
			String id = request.getParameter("idStorico");
			int idR = Integer.parseInt(id);
			stDao.elimina(idR);
		}

		if (tipoOp != null && tipoOp.equals("ricercaperid")) {
			String id = request.getParameter("idStorico");
			int idR = Integer.parseInt(id);

			Storico imp = stDao.ricercaPerId(idR);
			System.out.println("Storico trovato:" + imp.getMatricola());
		}

		response.getWriter().append("HELLOOOOOOOOO: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private Date convert(String s) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

		
		Date date = null;
		try {
			date = formatter.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

}
