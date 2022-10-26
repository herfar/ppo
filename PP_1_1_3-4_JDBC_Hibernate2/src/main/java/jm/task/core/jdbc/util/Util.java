package jm.task.core.jdbc.util;
import java.sql.*;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/forS";
    private static final String user = "root";
    private static final String password = "GggAt3321fff";
    private static Connection connection;
    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
// реализуйте настройку соеденения с БД
//Ну что ж, как было у меня: установил я MySqlServer и Workbench, скопировал заготовку по ссылке,
// создал подключение к БД как на скрине,  и вот тут встал у меня вопрос, а дальше то что делать,
// в какой из классов код то писать??? (возможно это я такой глупый, поддержите лайками,
// если я не один себя так чувствую))))
//Для начала посмотреть видосы, которые рекомендуют ниже.
//
//А потом уже читаете дальше:
//Чуть чуть подскажу, в каком классе что прописывать:
//1. Util - подключаем нашу БД (тут самое лёгкое "почти")
//2. UserServiceImpl - внутри класса создаём экземпляр UserDaoJDBCImpl (дальше сообразите что делать, идея поможет)))
//3. User - тут только переопределяем метод toString (идея сама всё cделает)
//4. UserDaoJDBCImpl - здесь расписываем основной функционал с таблицей
// (создать, удалить, сохранить пользователя и т.д.)
//        - создаём: String переменная = "команда на языке БД"
//        - создаём: Statement переменная = наш метод из класса Util
//        - используя нашу созданную переменную Statement, запихиваем
//        туда нашу переменную String (та, что с командами БД)