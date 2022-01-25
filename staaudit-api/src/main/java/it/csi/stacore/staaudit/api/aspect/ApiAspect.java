package it.csi.stacore.staaudit.api.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import it.csi.stacore.staaudit.business.aspect.CommonAspect;
import it.csi.stacore.staaudit.util.Constants;
import it.csi.stacore.staaudit.util.Tracer;


@Component("adapterAspectApi")
@Aspect
public class ApiAspect extends CommonAspect{

	public static final String LOGGER_PREFIX = Constants.APPLICATION_CODE + ".aspect";


	@Before(value="execution(*  it.csi.stacore.staaudit.api.service.impl..*.*(..))")
	public void beforeAspect(JoinPoint joinPoint) throws Throwable {
		super.beforeAspect(joinPoint);
	}
	//@Around(value = "execution(* it.csi.fpcommon.fpdoc.business.helper.impl..*.*(..))", argNames = "joinPoint")
	@Before(value="execution(*  it.csi.stacore.staaudit.api.service.impl..*.*(..))")
	public void afterAspect(JoinPoint joinPoint) throws Throwable {
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String method = joinPoint.getSignature().getName();


		Tracer.debug(LOG, className, method, "afterAspect....");


	}



}