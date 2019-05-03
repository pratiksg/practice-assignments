import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration;

public class DemoServlet extends HttpServlet {

   protected void doGet(HttpServletRequest request, 
      HttpServletResponse response)
        throws ServletException, IOException 
   {

      response.setContentType("text/html;charset=UTF-8");
      PrintWriter pwriter = response.getWriter();
      ServletConfig sc=getServletConfig();

      Enumeration<String> e=sc.getInitParameterNames();
      String str;
      while(e.hasMoreElements()) {
        str=e.nextElement();
        pwriter.println("<br>Param Name: "+str);
        pwriter.println(" value: "+sc.getInitParameter(str));
      }
   }
}