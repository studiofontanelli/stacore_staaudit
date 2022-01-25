package it.csi.stacore.staaudit.api.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import it.csi.stacore.staaudit.business.aspect.CommonAspect;
import it.csi.stacore.staaudit.util.Constants;
import it.csi.stacore.staaudit.util.Tracer;


@Component("apiAspect")
@Aspect
public class AdapterAspectApi extends CommonAspect{

	public static final String LOGGER_PREFIX = Constants.APPLICATION_CODE + ".aspect";

	//@Before(value="execution(*  it.csi.stacore.staaudit.api.service.impl..*.*(..))")
	@Before(value="execution(*  it.csi.stacore.staaudit.api.adapter..*.*(..))")
	public void beforeAspect(JoinPoint joinPoint) throws Throwable {
		super.beforeAspect(joinPoint);
	}

	@Before(value="execution(*  it.csi.stacore.staaudit.api.adapter..*.*(..))")
	public void afterAspect(JoinPoint joinPoint) throws Throwable {
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String method = joinPoint.getSignature().getName();


		Tracer.debug(LOG, className, method, "afterAspect....");


	}



}