package it.csi.stacore.staaudit.scheduling;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import it.csi.stacore.staaudit.util.Constants;
import it.csi.stacore.staaudit.util.Tracer;

@Configuration
@EnableScheduling
public class SchedulingTasksApplication {
	
	private static final String LOGGER_PREFIX = Constants.APPLICATION_CODE + ".scheduling";
	protected final static Logger LOG = LoggerFactory.getLogger(LOGGER_PREFIX);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 5000000)
	public void reportCurrentTime() {
		final String method = "reportCurrentTime";
		Tracer.info(LOG, getClass().getName(), method, "The time is now {} " + dateFormat.format(new Date()));
		
		/*
		
		Properties p = System.getProperties();
		Enumeration en = p.keys();
		while(en.hasMoreElements()) {
			String key = (String)en.nextElement();
			Object value = p.getProperty(key);
			Tracer.info(LOG, getClass().getName(), method, "KEY[ " + key + "] " + value);
		}
		
		
		Map<String, String> map = System.getenv();
		
		Iterator<String> it =  map.keySet().iterator();
		while(it.hasNext()) {
			String nnn = it.next();
			
			Tracer.info(LOG, getClass().getName(), method, "ENV KEY[ " + nnn + "] " + map.get(nnn));
			
		}
		*/
	}

}
