package com.pakhom.test;

import java.sql.*;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/my_new_schema?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123123";
    private static final String INSERT_NEW = "INSERT INTO prime VALUE (?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_ALL = "SELECT * FROM prime";
    private static final String DELETE = "DELETE FROM prime WHERE id = ?";


    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            /* удаляем из таблицы строку */
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, 2);
            preparedStatement.executeUpdate();

            /* 2 получаем всю строку из БД
            preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                float rating = resultSet.getFloat("rating");
                boolean published = resultSet.getBoolean("published");
                Date date = resultSet.getDate("created");
                byte[] icon = resultSet.getBytes("icon");
                System.out.println("id: " + id + "title: " + title + "description: " + description
                        + "rating: " + rating + "published: " + published + "created: " + date
                        + icon.length);

            }
             */


            /* 1 вносим данные в БД
            preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "Inserted title");
            preparedStatement.setString(3,"Inserted description");
            preparedStatement.setFloat(4, 0.2f);
            preparedStatement.setBoolean(5, true);
            preparedStatement.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
            preparedStatement.setBlob(7, new FileInputStream("smile.jpg"));
            preparedStatement.execute();
             */

        } catch (SQLException /*| FileNotFoundException не исп при выводе*/ e) {
            e.printStackTrace();
        }
        finally {
            preparedStatement.close();
            connection.close();
        }
    }
}

