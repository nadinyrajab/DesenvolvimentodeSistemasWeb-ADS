package br.usjt.gerenciadordeprodutos.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.gerenciadordeprodutos.model.Produto;
import br.usjt.gerenciadordeprodutos.service.ProdutoService;

	@WebServlet("/excluirProduto.do")
	public class ExcluiProdutoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
      
	private final ProdutoService produtoService = new ProdutoService(); 
	
	/**
	 * M�todo respons�vel por deletar um professor pela matricula
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Produto produto = new Produto();
		produto.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		
		produtoService.deletarProduto(produto);
		
		response.sendRedirect("listaProdutos.do");
	}
}
