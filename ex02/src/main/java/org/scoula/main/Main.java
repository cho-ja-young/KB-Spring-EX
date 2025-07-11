package org.scoula.main;

import org.scoula.beans.Parrot;
import org.scoula.beans.Person;
import org.scoula.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        // Spring Context (== Spring Container) 객체 얻어오기
        // - ProjectConfig.class 설정 적용
        // -> Bean 으로 Parrot, Person 등록
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Person Bean 얻어오기
        Person person = context.getBean(Person.class);

        // Parrot Bean 얻어오기
        Parrot parrot = context.getBean(Parrot.class);

        System.out.println("person's name: " + person.getName());
        System.out.println("parrot's name: " + parrot.getName());

        System.out.println("Person's parrot: " + person.getParrot());
    }
}
