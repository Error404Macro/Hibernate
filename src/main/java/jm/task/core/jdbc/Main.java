package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDao userDao = new UserDaoJDBCImpl();

        userDao.createUsersTable();
        System.out.println("Таблица пользователей создана");

        User user1 = new User("John", "Doe", (byte) 25);
        userDao.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        System.out.println("Пользователь с именем " + user1.getName() + " добавлен в базу данных");


        List<User> userList = userDao.getAllUsers();
        System.out.println("Список всех пользователей:");
        for (User user : userList) {
            System.out.println(user.toString());
        }


        userDao.cleanUsersTable();
        System.out.println("Таблица пользователей очищена");


        userDao.dropUsersTable();
        System.out.println("Таблица пользователей удалена");
    }
}
