package ru.job4j.parser.postgres;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.parser.vacancy.Vacancy;

import java.sql.*;
import java.util.List;

public class InteractionPostgres implements AutoCloseable {

    private final Connection connection;
    private static final Logger LOG = LogManager.getLogger(InteractionPostgres.class.getName());

    public InteractionPostgres(Connection connection) {
        this.connection = connection;
    }

    public boolean init() {
        try {
            PreparedStatement stCr = this.connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS vacancy(id serial primary key, name_vac varchar(400),"
                            + " info_vac varchar, link_vac varchar(300), date_vac date);");
            stCr.executeUpdate();
            stCr.close();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        LOG.info("Соединение с базой БД установлено.");
        return this.connection != null;
    }

    /**
     * add vacancies of list in DB
     * @param vacancyList
     */
    public void addVacancies(List<Vacancy> vacancyList) {
        LOG.info("Начало сохранения результатов БД.");
        try (PreparedStatement st = this.connection.prepareStatement("INSERT INTO "
                + "vacancy(name_vac, info_vac, link_vac, date_vac) values (?, ?, ?, ?)");) {
            for (Vacancy vac: vacancyList) {
                st.setString(1, vac.getName());
                st.setString(2, vac.getInfo());
                st.setString(3, vac.getLink());
                st.setDate(4, Date.valueOf(vac.getLocalDate()));
                st.addBatch();
            }
            st.executeBatch();
            LOG.info("Результаты сохранены в БД");
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    public void close() throws Exception {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }
}
