package org.scoula.app;

import org.scoula.config.ProjectConfig;
import org.scoula.config.ProjectConfig2;
import org.scoula.domain.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig2.class);

        // 같은 타입의 Bean 이 여러개 등록되어있을때 타입으로만 조회하면 예외 발생


        Parrot p = context.getBean("miki", Parrot.class);
        System.out.println(p.getName());
    }
}
