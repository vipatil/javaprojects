package org.javacode.home.quartzexample.job;

import org.javacode.home.quartzexample.service.ByeService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ByeJob implements Job {

	private ByeService bs = new ByeService();
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		bs.sayBye();
		

	}

}
