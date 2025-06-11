package org.scoula.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
    /**
     * 어노테이션 방식으로 SQL 정의
     * MySQL의 현재 시간을 조회하는 쿼리
     */
    @Select("SELECT sysdate()")
    public String getTime();

    public String getTime2();
}
