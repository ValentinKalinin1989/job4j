package ru.job4j.parser.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import ru.job4j.parser.parser.SqlRuParser;
import ru.job4j.parser.postgres.InteractionPostgres;
import ru.job4j.parser.utill.ConfigParser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ParserSiteSqlRu implements Job {

    private static final Logger LOG = LogManager.getLogger(ParserSiteSqlRu.class);

    public void execute(JobExecutionContext context) {
        ConfigParser configParser = new ConfigParser();
        configParser.init();
        SqlRuParser sqlRuParser = new SqlRuParser("https://www.sql.ru/forum/job-offers");
        try (Connection connection = DriverManager.getConnection(configParser.get("jdbc.url"),
                configParser.get("jdbc.username"), configParser.get("jdbc.password"));) {
            InteractionPostgres interactionPostgres = new InteractionPostgres(connection);
            interactionPostgres.init();
            interactionPostgres.addVacancies(sqlRuParser.parse());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
