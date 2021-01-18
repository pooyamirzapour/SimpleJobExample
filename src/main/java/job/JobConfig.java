package job;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class JobConfig {

    public void init() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        Trigger trigger = newTrigger().withIdentity("identity", "group").
                withSchedule(simpleSchedule().withIntervalInSeconds(30).repeatForever()).build();
        scheduler.scheduleJob(newJob().withDescription("NotifierJob").
                ofType(JobImpl.class).build(), trigger);
        scheduler.start();

    }
}
