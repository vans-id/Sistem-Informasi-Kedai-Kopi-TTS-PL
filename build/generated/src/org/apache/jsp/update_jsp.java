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

public final class update_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\" />\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.4.1.slim.min.js\" integrity=\"sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\" integrity=\"sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <title>Update Menu</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-light bg-light\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <span class=\"navbar-brand mb-0 h1 text-center ml-auto mr-auto\">Update Menu</span>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
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
      out.write("</td>\n");
      out.write("            <td>");
      out.print(listdata.get(x).getTypeMenu());
      out.write("</td>\n");
      out.write("            <td>");
      out.print(listdata.get(x).getHarga());
      out.write("</td>\n");
      out.write("            <td>\n");
      out.write("                <form method=\"post\" action=\"updateData.jsp\">\n");
      out.write("                    <input hidden=\"true\" name=\"data\" value=\"");
      out.print(listdata.get(x).getKodeMenu());
      out.write("\"></input>\n");
      out.write("                    <input type=\"submit\" class=\"btn btn-success\" value=\"Edit\"></input>\n");
      out.write("                </form>\n");
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
