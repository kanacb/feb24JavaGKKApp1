/src/main/resources/application.properties

# Enabling H2 Console
spring.h2.console.enabled=true
#Turn Statistics on
spring.jpa.properties.hibernate.generate_statistics=true
logging.level.org.hibernate.stat=debug
# Show all queries
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
logging.level.org.hibernate.type=trace

spring.datasource.url=jdbc:h2:mem:testdb
spring.data.jpa.repositories.bootstrap-mode=default

/src/main/resources/data.sql
insert into student values(10001,'Firdaus', '122233-23-4567');
insert into student values(10002,'Fatin', '123243-12-3458');

/src/main/resources/schema.sql
create table student
(
   id integer not null,
   name varchar(255) not null,
   mykad varchar(255) not null,
   primary key(id)
);

/test 

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class AppApplicationTests {

    @Test
    public void contextLoads() {
    }

}