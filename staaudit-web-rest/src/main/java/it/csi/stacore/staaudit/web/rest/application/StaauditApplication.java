package it.csi.stacore.staaudit.web.rest.application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.csi.stacore.staaudit.util.ApplicationContextManager;
import it.csi.stacore.staaudit.util.Constants;
import it.csi.stacore.staaudit.util.Tracer;
import it.csi.stacore.staaudit.web.rest.interceptor.LoggingInterceptor;
import it.csi.stacore.staaudit.web.rest.provider.ExceptionHandler;



@ApplicationPath("/api")
public class StaauditApplication extends Application {

	protected final static Logger LOG = LoggerFactory.getLogger(Constants.APPLICATION_CODE);

	private Set<Object> singletons = new HashSet<>();
	private Set<Class<?>> classes = new HashSet<>();


	private List<String> getServiceList(){
		List<String> l = new ArrayList<String>();
		l.add("testApi");
		return l;

	}

	private List<Class> getProviderList(){
		List<Class> l = new ArrayList<Class>();
		l.add(ExceptionHandler.class);
		l.add(LoggingInterceptor.class);
		return l;

	}

	public StaauditApplication() {
		final String method = "CONSTRUCTOR";
		try {

			// Resources
			for(String api : getServiceList()) {
				Tracer.info(LOG, getClass().getName(), method, "adding api " + api);
				this.singletons.add(ApplicationContextManager.getBean(api));
				Tracer.info(LOG, getClass().getName(), method, "api " + api + " added correctly");
			}
			// Providers
			for(Class provider : getProviderList()) {
				Tracer.info(LOG, getClass().getName(), method, "adding provider " + provider);
				classes.add(provider);
			}
			Tracer.info(LOG, getClass().getName(), method, "Startup rest services done correctly!");






		}
		catch(Exception e) {
			Tracer.error(LOG, getClass().getName(), method, "Exception: " + e);
			throw new RuntimeException("Errore infase di startup configurazione servizi rest", e);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.ws.rs.core.Application#getClasses()
	 */
	@Override
	public Set<Class<?>> getClasses() {
		return this.classes;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.ws.rs.core.Application#getSingletons()
	 */
	@Override
	public Set<Object> getSingletons() {
		return this.singletons;
	}
}
