package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDao userDao = new UserDaoHibernateImpl();

        // Создание таблицы
        userDao.createUsersTable();

        // Добавляем
        User user1 = new User("Artem", "2033", (byte) 25);
        userDao.saveUser(user1.getName(), user1.getLastName(), user1.getAge());

        User user2 = new User("Tom", "Cat", (byte) 30);
        userDao.saveUser(user2.getName(), user2.getLastName(), user2.getAge());

        User user3 = new User("Mike", "Johnson", (byte) 35);
        userDao.saveUser(user3.getName(), user3.getLastName(), user3.getAge());

        User user4 = new User("Ivan", "Ivanov", (byte) 40);
        userDao.saveUser(user4.getName(), user4.getLastName(), user4.getAge());

        // Получаем
        List<User> userList = userDao.getAllUsers();
        System.out.println("Список всех пользователей:");
        for (User user : userList) {
            System.out.println(user.toString());
        }

        // Очищаем
        userDao.cleanUsersTable();

        // Удаляем
        userDao.dropUsersTable();
    }
}
