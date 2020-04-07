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
 * Servlet implementation class Login
 */
@WebServlet(
		name = "Login.do", 
		urlPatterns = { 
				"/Login.do"		
		})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }  
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		response.setContentType("text/html");  
		PrintWriter out= response.getWriter();
	    request.getRequestDispatcher("Login.do");	
		
		String conta = request.getParameter("conta");
		String senha = request.getParameter("senha");	
		
		HttpSession sessao = request.getSession();
			
		if(conta.equals("987654") && senha.equals("123456")) {	
			sessao.setAttribute("conta", conta);
            response.sendRedirect("Home.do");
			}
		else if(conta.equals("") || senha.equals("")){
			out.println("Preencha a caixa antes de seguir");
			request.getRequestDispatcher("login.html").include(request, response);
			}
		else {
			out.println("Dados incorretos faça login novamente");
			request.getRequestDispatcher("login.html").include(request, response);		
		}
		out.close();
	}	

}
