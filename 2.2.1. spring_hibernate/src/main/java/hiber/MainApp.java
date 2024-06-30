package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

//import static jdk.internal.org.jline.utils.InfoCmp.Capability.user1;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        Car mazda = new Car("mazda", 40);
        Car bmw = new Car("bmw", 5);
        Car mercedes = new Car("mersedes", 300);
        User user1 = new User("Alex", "Stepanov", "stepanov@mail.ru");
        User user2 = new User("Bob", "Fedorov", "fedorov@mail.ru");
        User user3 = new User("Mike", "Sidorov", "Mike@mail.ru");
        user1.setCar(mazda);
        user2.setCar(bmw);
        user3.setCar(mercedes);
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("------------");
        }

        System.out.println("Find car" + userService.getUserByCar("BMW", 5));
        context.close();
    }
}
