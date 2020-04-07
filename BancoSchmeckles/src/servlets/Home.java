package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home.do")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
   
          
        HttpSession sessao=request.getSession();  
        
        String conta =(String)sessao.getAttribute("conta");

        
        if(conta == null){ 
                out.print("Por favor faça Login antes");
                out.println(" <a href='login.html'>Login</a>");
            }  
            else{              	
            	out.print("Conta: " + conta);
            	out.println(" <a href='Logoff.do'>Desconectar</a>");
                 }         
        out.close();  
    }  
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
}
}
