package ru.job4j.parser.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class QuartzStart {
    public static void main(String[] args) {

        final Logger LOG = LogManager.getLogger(QuartzStart.class);

        Properties properties = new Properties();
        if (args.length > 0) {
            try {
                properties.load(new FileReader(args[0]));
            } catch (IOException e) {
                LOG.error(String.format("Ошибка загрузки настроек из файла %s", args[0]));
            }
        } else {
            LOG.error("Ошибка загрузки параметров");
        }

        if (!properties.isEmpty()) {
            LOG.info(String.format("Сron string %s", properties.getProperty("cron.time")));
            JobDetail jobSQL = JobBuilder.newJob(ParserSiteSqlRu.class)
                    .withIdentity("sqlParser", "group1")
                    .usingJobData("url", properties.getProperty("url"))
                    .usingJobData("username", properties.getProperty("username"))
                    .usingJobData("password", properties.getProperty("password"))
                    .build();

            Trigger triggerSQL = TriggerBuilder
                    .newTrigger()
                    .withIdentity("sqlParser", "group1")
                    .withSchedule(
                            CronScheduleBuilder.cronSchedule(properties.getProperty("cron.time")))
                    .build();

            Scheduler scheduler;
            try {
                scheduler = new StdSchedulerFactory().getScheduler();
                scheduler.scheduleJob(jobSQL, triggerSQL);
                scheduler.start();
            } catch (SchedulerException e) {
                LOG.error(String.format("Error scheduler %s", e.getMessage()));
            }
        }
    }
}
