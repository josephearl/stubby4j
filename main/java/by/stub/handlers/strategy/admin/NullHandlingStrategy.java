package by.stub.handlers.strategy.admin;

import by.stub.database.DataStore;
import by.stub.javax.servlet.http.HttpServletResponseWithGetStatus;
import org.eclipse.jetty.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author: Alexander Zagniotov
 * Created: 4/25/13 11:16 PM
 */
public class NullHandlingStrategy implements AdminResponseHandlingStrategy {

   @Override
   public void handle(final HttpServletRequest request, final HttpServletResponseWithGetStatus wrapper, final DataStore dataStore) throws IOException {
      wrapper.setStatus(HttpStatus.NOT_IMPLEMENTED_501);
      wrapper.getWriter().println(String.format("Support for ethod %s is not implemented on URI ", request.getMethod(), request.getRequestURI()));
   }
}
