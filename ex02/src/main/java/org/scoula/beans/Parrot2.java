package org.scoula.beans;

import org.springframework.stereotype.Component;

@Component // 자동으로 등록될 클래스임을 표시
public class Parrot2 {
    private String name = "Koko";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parrot : " + name;
    }

}