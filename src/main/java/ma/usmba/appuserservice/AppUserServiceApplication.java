package ma.usmba.appuserservice;

import antlr.collections.List;
import ma.usmba.appuserservice.entities.User;
import ma.usmba.appuserservice.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class AppUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppUserServiceApplication.class, args);
    }

    static String getPassword(){
        Random rnd = new Random();
        int n = 6+rnd.nextInt(4);
        String str="ABCDEFGHIKLMNOPQRSTUVWXYZ"+"acdefghijklmnopqrstuvwxyz";
        StringBuilder s=new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int k= (int) (str.length()*Math.random());
            s.append(str.charAt(k));
        }
        return s.toString();
    }

    @Bean
    CommandLineRunner start(UserRepository userRepository){
        return args -> {
            for (int i = 0; i < 4; i++) {
                userRepository.save(new User(null,"rachid","saoudi", new Date("1981/02/14"),
                        "Tanger", "Morocco","url","orca","Developer","0601005656",
                        "rach001","rach@gmail.com", getPassword(), Math.random()>0.5?"admin":"user"));
            }
            userRepository.findAll().forEach(user -> {
                System.out.println(user.getFirstName());
                System.out.println(user.getLastName());
            });
        };
    }

}
