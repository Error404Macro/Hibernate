package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDao userDao = new UserDaoJDBCImpl();

        // Создание таблицы
        userDao.createUsersTable();
        System.out.println("Таблица пользователей создана");

        // Добавляем
        User user1 = new User("Artem", "2033", (byte) 25);
        userDao.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        System.out.println("Пользователь с именем " + user1.getName() + " добавлен в базу данных");

        User user2 = new User("Tom", "Cat", (byte) 30);
        userDao.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        System.out.println("Пользователь с именем " + user2.getName() + " добавлен в базу данных");

        User user3 = new User("Mike", "Johnson", (byte) 35);
        userDao.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        System.out.println("Пользователь с именем " + user3.getName() + " добавлен в базу данных");

        User user4 = new User("Ivan", "Ivanov", (byte) 40);
        userDao.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
        System.out.println("Пользователь с именем " + user4.getName() + " добавлен в базу данных");

        // Получаем
        List<User> userList = userDao.getAllUsers();
        System.out.println("Список всех пользователей:");
        for (User user : userList) {
            System.out.println(user.toString());
        }

        // Очищаем
        userDao.cleanUsersTable();
        System.out.println("Таблица пользователей очищена");
        System.out.flush();

        // Удаляем
        userDao.dropUsersTable();
        System.out.println("Таблица пользователей удалена");
        System.out.flush();
    }
}
