package database;
import logic.Store;
import model.User;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DbStore implements Store {
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static final DbStore INSTANCE = new DbStore();
    private static final Logger LOG = LogManager.getLogger(DbStore.class.getName());

    public DbStore() {
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
             PreparedStatement st = connection.prepareStatement("INSERT INTO users (name, login, email, createdate) values (?, ?, ?, ?)");
        ) {
            st.setString(1, user.getName());
            st.setString(2, user.getLogin());
            st.setString(3, user.getEmail());
            st.setDate(4, Date.valueOf(user.getCreateDate()));
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
             PreparedStatement st = connection.prepareStatement("UPDATE users SET name = ?, login = ?, email = ?, createdate = ?"
                     + "WHERE id = ?");
        ) {
            st.setString(1, user.getName());
            st.setString(2, user.getLogin());
            st.setString(3, user.getEmail());
            st.setDate(4, Date.valueOf(user.getCreateDate()));
            st.setInt(5, user.getId());
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
                        rs.getDate("createDate").toLocalDate()
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
                    LocalDate.parse((CharSequence) rs.getDate("createdate"))
            );
        } catch (Exception e) {
            LOG.error("Error to find user", e);
        }
        return null;
    }
}