package database;
import logic.Store;
import model.Role;
import model.User;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbStore implements Store {
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static final DbStore INSTANCE = new DbStore();
    private static final Logger LOG = LogManager.getLogger(DbStore.class.getName());

    private DbStore() {
        SOURCE.setDriverClassName("org.postgresql.Driver");
        SOURCE.setUrl("jdbc:postgresql://127.0.0.1:5432/users_servlet");
        SOURCE.setUsername("postgres");
        SOURCE.setPassword("root");
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
    }

    public static DbStore getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean add(User user) {
        LOG.info("Start to add new user in DB");
        boolean result = false;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement(
                     "INSERT INTO users (name, login, email, createdate, password, role, name_country, name_town)"
                             + "values (?, ?, ?, ?, ?, ?, ?, ?)"
             );
        ) {
            st.setString(1, user.getName());
            st.setString(2, user.getLogin());
            st.setString(3, user.getEmail());
            st.setDate(4, Date.valueOf(user.getCreateDate()));
            st.setString(5, user.getPassword());
            st.setString(6, user.getRole().toString());
            st.setString(7, user.getCountry());
            st.setString(8, user.getTown());
            st.executeUpdate();
            result = true;
            LOG.info("New user was added.");
        } catch (SQLException e) {
            LOG.error("Error adding user", e);
        }
        return result;
    }

    @Override
    public boolean update(User user) {
        boolean result = false;
        LOG.info("Start to delete user.");
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement(
                     "UPDATE users SET name = ?, login = ?, email = ?,"
                             + " createdate = ?, password = ?, role = ?, name_country = ?, name_town = ?"
                     + "WHERE id = ?"
             );
        ) {
            st.setString(1, user.getName());
            st.setString(2, user.getLogin());
            st.setString(3, user.getEmail());
            st.setDate(4, Date.valueOf(user.getCreateDate()));
            st.setString(5, user.getPassword());
            st.setString(6, user.getRole().toString());
            st.setString(7, user.getCountry());
            st.setString(8, user.getTown());
            st.setInt(9, user.getId());
            st.executeUpdate();
            result = true;
            LOG.info("User was updated.");
        } catch (SQLException e) {
            LOG.error("Error updating user.", e);
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        LOG.info("Start to delete user.");
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement("DELETE FROM users WHERE id = ?");
        ) {
            st.setInt(1, id);
            st.executeUpdate();
            result = true;
            LOG.info("User was deleted.");
        } catch (SQLException e) {
            LOG.error("Error deleting user.", e);
        }
        return result;
    }

    @Override
    public List<User> findAll() {
        LOG.info("Start to get all users.");
        List<User> userList = new ArrayList<>();
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM users");
        ) {
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("login"),
                        rs.getString("email"),
                        rs.getDate("createDate").toLocalDate(),
                        rs.getString("password"),
                        Role.valueOf(rs.getString("role")),
                        rs.getString("name_country"),
                        rs.getString("name_town")
                );
                userList.add(user);
            }
            LOG.info("All users is getting.");
        } catch (Exception e) {
            LOG.error("Error to get all users", e);
        }
        return userList;
    }

    @Override
    public User findById(int id) {
        LOG.info("Start to find user.");
        User findedUser;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement("SELECT * FROM users WHERE id = ?")
        ) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            findedUser = new User(
                    id,
                    rs.getString("name"),
                    rs.getString("login"),
                    rs.getString("email"),
                    rs.getDate("createdate").toLocalDate(),
                    rs.getString("password"),
                    Role.valueOf(rs.getString("role")),
                    rs.getString("name_country"),
                    rs.getString("name_town")
            );
        } catch (Exception e) {
            LOG.error("Error to find user", e);
        }
        return null;
    }

    @Override
    public User isCredentional(String login, String password) {
        User findedUser = null;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement("SELECT * FROM users WHERE login = ? AND password = ?")
        ) {
            st.setString(1, login);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            rs.next();
            findedUser = new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("login"),
                    rs.getString("email"),
                    rs.getDate("createdate").toLocalDate(),
                    rs.getString("password"),
                    Role.valueOf(rs.getString("role")),
                    rs.getString("name_country"),
                    rs.getString("name_town")
            );
        } catch (SQLException e) {
            LOG.error("Пользователь с такими данными отсутствует в бд", e);
        }

        //for (User user: findAll()) {
         //   if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
         //       findedUser = user;
         //   }
        return findedUser;
    }

    @Override
    public List<String> getCountries() {
        List<String> listContries = new ArrayList<>();
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("SELECT name_country FROM country")
        ) {
            while (rs.next()) {
                listContries.add(rs.getString("name_country"));
            }
        } catch (SQLException e) {
            LOG.error("Ошибка получения списка стран", e);
        }
        return listContries;
    }

    @Override
    public List<String> getTowns(String country) {
        List<String> listTowns = new ArrayList<>();
        try (Connection connection = SOURCE.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT name_town FROM town INNER JOIN country\n"
                    + "ON town.country_id = country.id\n"
                    + "WHERE country.name_country = '" + country + "';")
        ) {
            while (rs.next()) {
                listTowns.add(rs.getString("name_town"));
            }
        } catch (SQLException e) {
            LOG.error("Ошибка получения списка городов", e);
        }
        return listTowns;
    }
}