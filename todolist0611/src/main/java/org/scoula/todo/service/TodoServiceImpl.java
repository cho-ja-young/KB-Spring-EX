package org.scoula.todo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.todo.domain.TodoDTO;
import org.scoula.todo.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service    // 서비스 계층임을 명시 + Bean 등록
@RequiredArgsConstructor    // final 필드 초기화하는 생성자 + @Autowired
public class TodoServiceImpl implements TodoService{

    private final TodoMapper todoMapper;

//    @Autowired
//    public TodoServiceImpl(TodoMapper todoMapper) {
//        this.todoMapper = todoMapper;
//    }


    @Override
    public List<TodoDTO> selectAll() {
        // todo 테이블 모든 내용 조회 sql 호출 -> 결과 반환
        List<TodoDTO> todos = todoMapper.selectAll();

        log.info("조회된 todo 개수: {}", todos.size());
        return todos;
    }

    @Override
    public int insertTodo(TodoDTO todo) {

        // INSERT 수행 후 결과 행 개수 반환
        int count = todoMapper.insertTodo(todo);
        log.info("삽입된 행의 개수 : {}", count);
        return count;
    }

    @Override
    public int updateTodo(Long id) {
        // UPDATE 수행 후 결과 행 개수 반환
        int count = todoMapper.updateTodo(id);
        log.info("수정된 행의 개수 : {}", count);
        return count;
    }

    @Override
    public int deleteTodo(Long id) {
        // DELETE 수행 후 결과 행 개수 반환
        int count = todoMapper.deleteTodo(id);
        log.info("삭제된 행의 개수 : {}", count);
        return count;
    }
}