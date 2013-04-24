package by.stub.builder.stubs;

import by.stub.yaml.stubs.StubRequest;
import org.eclipse.jetty.http.HttpMethods;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Alexander Zagniotov
 * @since 4/14/13, 4:54 PM
 */
public final class StubRequestBuilder {

   private String url = null;
   private ArrayList<String> methods = new ArrayList<String>();
   private String post = null;
   private Map<String, String> headers = new HashMap<String, String>();
   private Map<String, String> query = new LinkedHashMap<String, String>();
   private byte[] fileBytes;

   public StubRequestBuilder() {

   }

   public StubRequestBuilder withMethod(final String value) {
      this.methods.add(value);

      return this;
   }

   public StubRequestBuilder withMethodGet() {
      this.methods.add(HttpMethods.GET);

      return this;
   }

   public StubRequestBuilder withMethodPut() {
      this.methods.add(HttpMethods.PUT);

      return this;
   }

   public StubRequestBuilder withMethodPost() {
      this.methods.add(HttpMethods.POST);

      return this;
   }

   public StubRequestBuilder withMethodHead() {
      this.methods.add(HttpMethods.HEAD);

      return this;
   }

   public StubRequestBuilder withUrl(final String value) {
      this.url = value;

      return this;
   }

   public StubRequestBuilder withHeaders(final String key, final String value) {
      this.headers.put(key, value);

      return this;
   }

   public StubRequestBuilder withHeaderContentType(final String value) {
      this.headers.put("content-type", value);

      return this;
   }

   public StubRequestBuilder withHeaderContentLength(final String value) {
      this.headers.put("content-length", value);

      return this;
   }

   public StubRequestBuilder withHeaderContentLanguage(final String value) {
      this.headers.put("content-language", value);

      return this;
   }

   public StubRequestBuilder withHeaderContentEncoding(final String value) {
      this.headers.put("content-encoding", value);

      return this;
   }

   public StubRequestBuilder withHeaderPragma(final String value) {
      this.headers.put("pragma", value);

      return this;
   }

   public StubRequestBuilder withHeaderAuthorization(final String value) {
      this.headers.put("authorization", value);

      return this;
   }

   public StubRequestBuilder withHeaderLocation(final String value) {
      this.headers.put("location", value);

      return this;
   }

   public StubRequestBuilder withPost(final String post) {
      this.post = post;

      return this;
   }

   public StubRequestBuilder withFileBytes(final byte[] fileBytes) {
      this.fileBytes = fileBytes;

      return this;
   }

   public StubRequestBuilder withQuery(final String key, final String value) {
      this.query.put(key, value);

      return this;
   }

   public StubRequest build() {
      final StubRequest stubRequest = new StubRequest();

      stubRequest.setPost(post);
      stubRequest.setFile(fileBytes);
      stubRequest.setUrl(url);
      stubRequest.setHeaders(new HashMap<String, String>(headers));
      stubRequest.setQuery(new LinkedHashMap<String, String>(query));

      try {
         final Field field = stubRequest.getClass().getDeclaredField("method");
         AccessController.doPrivileged(new PrivilegedAction<Boolean>() {
            public Boolean run() {
               field.setAccessible(true);
               return true;
            }
         });
         field.set(stubRequest, this.methods);
      } catch (Exception ignored) {

      }

      this.url = null;
      this.methods = new ArrayList<String>();
      this.post = null;
      this.fileBytes = null;
      this.headers = new HashMap<String, String>();
      this.query = new LinkedHashMap<String, String>();

      return stubRequest;
   }
}
