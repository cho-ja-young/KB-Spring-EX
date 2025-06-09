package org.scoula.domain;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
// complmentScam 이 진행됨
//
public class Parrot {
    private String name;
    // 생성자 생략해서 디폴트 생성자 들어감

    @PostConstruct
    public void init() {
        this.name = "Kiki";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
