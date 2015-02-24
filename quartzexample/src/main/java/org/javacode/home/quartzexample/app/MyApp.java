package org.javacode.home.quartzexample.app;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.Callable;

import org.javacode.home.quartzexample.job.ByeJob;
import org.javacode.home.quartzexample.job.HelloJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

public class MyApp {

	public static Scheduler scheduler2 ;
	public static void main(String[] args) {

		try {

			/*JobDetail job1 = JobBuilder.newJob(HelloJob.class).withIdentity("helloJob", "group1").build();

			Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "group1")
					.withSchedule(SimpleScheduleBuilder.repeatHourlyForever(30)).build();*/
			//.withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(30)).build();   

			//SimpleScheduleBuilder.



			/*scheduler1 = new StdSchedulerFactory().getScheduler();
			scheduler1.start();
			scheduler1.scheduleJob(job1, trigger1);*/


			JobDetail job2 = JobBuilder.newJob(ByeJob.class).withIdentity("byeJob", "group2").build();
			
			final JobKey jK = job2.getKey();
			

			Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("cronTrigger", "group2")

					//.withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?")).build();
			//"0 0 5 ? * 2,7"
					
					.withSchedule(CronScheduleBuilder.cronSchedule("0 0 5 ? * 2,7")).build();

			scheduler2 = new StdSchedulerFactory().getScheduler();

			scheduler2.start();

			scheduler2.scheduleJob(job2, trigger2);
			
			Thread th = new Thread(new Runnable() {

				public void run() {
					int i =0;
					
					boolean isDST = false;
					if (TimeZone.getDefault().inDaylightTime( new Date() )) {
						System.out.println("In DST");
						isDST = true;
					}
					else {
						System.out.println("In PST");						
					}
					
					while(true) {

						List<? extends Trigger> trgs;
						try {
							trgs = scheduler2.getTriggersOfJob(jK);
							
							//List<String> lst = scheduler2.getTriggerGroupNames();

							for (Trigger tg:trgs) {
								Date nextFire = tg.getNextFireTime();
								if (nextFire != null) {
									int secondsUntilFire = (int) (nextFire.getTime() - System.currentTimeMillis()) / 1000;
							        
									if ( TimeZone.getDefault().inDaylightTime( nextFire ) ) {
										System.out.println("Next fire time is in DST "+nextFire + "  sec "+ secondsUntilFire);
									}
									else {
										System.out.println("Next fire time is in PST "+nextFire + " sec "+ secondsUntilFire);
									}
								}
							}

							System.out.println("--------------------------------------------------------------- " + new Date());
							Thread.sleep(5000);
						} catch (SchedulerException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}});
			th.start();
			
			Thread.sleep(0);



		}

		catch(Exception e){

			e.printStackTrace();

		}

	}

}
