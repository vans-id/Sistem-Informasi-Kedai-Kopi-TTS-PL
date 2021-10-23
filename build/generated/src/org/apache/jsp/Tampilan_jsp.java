package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import utils.HibernateUtil;
import view.MenuServiceImpl;
import model.Menu;
import view.MenuService;
import java.util.ArrayList;
import java.util.List;
import model.UserModel;

public final class Tampilan_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Nampilke Data</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <center><h1>Data seko DB</h1></center>\n");
      out.write("  <table style=\"margin:20px auto;\" border=\"1\">\n");
      out.write("\t<tr>\n");
      out.write("            <th>No</th>\n");
      out.write("            <th>KodeMenu</th>\n");
      out.write("            <th>NamaMenu</th>\n");
      out.write("            <th>TypeMenu</th>\n");
      out.write("            <th>HargaMenu</th>\n");
      out.write("\t</tr>\n");
      out.write("        ");

            
            MenuService ms = new MenuServiceImpl(HibernateUtil.getMenuDao());
            List<Menu> listdata = ms.getAllMenu();
            System.out.println("data : "+listdata.size());
            
            
            for (int x = 0; x < listdata.size(); x++) {
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print(x + 1);
      out.write("</td>\n");
      out.write("            <td>");
      out.print(listdata.get(x).getKodeMenu());
      out.write("</td>\n");
      out.write("            <td>");
      out.print(listdata.get(x).getNamaMenu());
      out.write("</td\n");
      out.write("            <td>");
      out.print(listdata.get(x).getTypeMenu());
      out.write("</td\n");
      out.write("            <td>");
      out.print(listdata.get(x).getHarga());
      out.write("</td\n");
      out.write("            <td>\n");
      out.write("                <a href=\"#\">Edit</a>\n");
      out.write("                <a href=\"#\">Hapus</a>\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("    </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
