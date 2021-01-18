import job.JobConfig;
import org.quartz.SchedulerException;

public class Main {

    public static void main(String[] args) throws SchedulerException {
        JobConfig jobConfig = new JobConfig();
        jobConfig.init();
    }
}
