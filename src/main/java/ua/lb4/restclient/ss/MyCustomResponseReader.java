package ua.lb4.restclient.ss;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyReader;
import jakarta.ws.rs.ext.Provider;
import ua.lb4.restclient.boo.DeliveryType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Consumes(MediaType.TEXT_HTML)
public class MyCustomResponseReader implements MessageBodyReader<DeliveryType> {

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return genericType.equals(DeliveryType.class);
	}

	@Override
	public DeliveryType readFrom(Class aClass, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap multivaluedMap, InputStream inputStream) throws IOException, WebApplicationException {
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(inputStream))) {
			System.out.println(br.readLine());
		}
		return null;
	}

}