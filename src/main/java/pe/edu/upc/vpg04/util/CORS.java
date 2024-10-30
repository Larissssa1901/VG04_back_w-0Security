package pe.edu.upc.vpg04.util; // Define el paquete donde se encuentra la clase CORS.

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component // Indica que esta clase es un componente de Spring y debe ser gestionada por el contenedor de Spring.
@Order(Ordered.HIGHEST_PRECEDENCE) // Establece que este filtro debe ejecutarse primero en la cadena de filtros.
public class CORS implements Filter { // Define la clase CORS que implementa la interfaz Filter.

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// metodo llamado al inicializar el filtro Puede contener lógica de configuración, pero está vacío en este caso.
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// metodo que se invoca para cada solicitud que pasa por el filtro.

		HttpServletResponse response = (HttpServletResponse) res; // Convierte ServletResponse a HttpServletResponse.
		HttpServletRequest request = (HttpServletRequest) req; // Convierte ServletRequest a HttpServletRequest.

		response.setHeader("Access-Control-Allow-Origin", "*"); // Permite el acceso desde cualquier origen.
		response.setHeader("Access-Control-Allow-Methods", "DELETE, GET, OPTIONS, PATCH, POST, PUT"); // Permite métodos HTTP específicos.
		response.setHeader("Access-Control-Max-Age", "3600"); // Establece el tiempo en caché para solicitudes CORS (1 hora).
		response.setHeader("Access-Control-Allow-Headers",
				"x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN"); // Permite encabezados personalizados en las solicitudes.

		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) { // Verifica si la solicitud es de tipo OPTIONS (solicitud preflight).
			response.setStatus(HttpServletResponse.SC_OK); // Responde con estado 200 (OK) para solicitudes OPTIONS.
		} else {
			chain.doFilter(req, res); // Continúa la cadena de filtros si no es una solicitud OPTIONS.
		}
	}

	@Override
	public void destroy() {
		// metodo llamado al destruir el filtro. Puede liberar recursos, pero está vacío en este caso.
	}
}
