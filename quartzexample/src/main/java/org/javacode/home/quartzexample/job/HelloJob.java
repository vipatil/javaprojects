package org.javacode.home.quartzexample.job;

import org.javacode.home.quartzexample.service.HelloService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {

	private HelloService hs = new HelloService();
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		hs.sayHello();

	}

}
