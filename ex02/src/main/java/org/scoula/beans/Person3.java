package org.scoula.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person3 {
    private String name = "Ella";
    private final Parrot2 parrot; // final로 불변성 보장

    // 매개 변수로 Bean 의존성 주입

    @Autowired // -> Spring Container 에 등록된 Bean 중 같은 타입을 찾아서 자동 주입
    // 등록된 빈이 메서드의 매개 변수에 넣어준다
    // 생성자 : 클래스 이름과 똑같은 메서드
    public Person3(Parrot2 parrot) {
        this.parrot = parrot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot2 getParrot() {
        return parrot;
    }
}
