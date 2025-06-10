package org.scoula.ex03.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.ex03.dto.SampleDTO;
import org.scoula.ex03.dto.SampleDTOList;
import org.scoula.ex03.dto.TodoDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@Controller // 컨트롤러임을 명시 + Bean 등록
@RequestMapping("/sample") // "sample"로 시작하는 요청을 현재 컨트롤러로 매핑
@Log4j2 // log 필드 생성 (롬복)
public class SampleController {
    @RequestMapping("")
    public void basic() {
        log.info("basic............");
    }

    // 클래스 레벨 "/sample" + 메서드 레벨 "" -> "/sample" URL 요청 매핑
    // 단, GET, POST 요청 매핑
    @RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
    public void basicGet() {
        log.info("basic Get............");

    }

    @RequestMapping(value = "/basic1", method = {RequestMethod.GET})
    public void basicGet1() {
        log.info("basic Get............");
    }

    @GetMapping("/basicOnlyGet")
    public void basicGet2() {
        log.info("basic get only get...........");
    }

    @GetMapping("/ex01")
    public String ex01(SampleDTO dto) {
        log.info("" + dto);
        return "ex01";
    }

    @GetMapping("/ex02")
    public String ex02(
            @RequestParam("name") String name,
            @RequestParam("age") int age
    ) {
        log.info("name: " + name);
        log.info(", age: " + age);

        return "ex02";
    }


    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
        log.info("ids: " + ids);
        return "ex02List";
    }

    @GetMapping("/ex02Array")
    public String ex02Array(@RequestParam("ids") String[] ids) {
        log.info("array ids: " + Arrays.toString(ids));
        return "ex02Array";
    }

    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list) {
        log.info("list dtos: " + list);
        return "ex02Bean";
    }

    @GetMapping("/ex03")
    public String ex03(TodoDTO todo) {
        log.info("todo: " + todo);
        return "ex03";
    }

    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
        log.info("dto: " + dto);
        log.info("page: " + page);

        return "sample/ex04";
    }

    @GetMapping("/ex05")
    public void ex05() {
        log.info("/ex05");
    }

    @GetMapping("/ex06")
    public String ex06(RedirectAttributes ra) {
        log.info("ex06..........");
        ra.addAttribute("name", "AAA");
        ra.addAttribute("age", 22);

        return "redirect:/sample/ex06-2";
    }

    @GetMapping("/ex07")
    public @ResponseBody SampleDTO ex07() {
        log.info("ex07..........");

        SampleDTO dto = new SampleDTO();
        dto.setAge(22);
        dto.setName("홍길동");

        return dto;
    }

    @GetMapping("/ex08")
    public ResponseEntity<String> ex08() {
        log.info("ex08..........");

        String msg = "{\"name\":\"홍길동\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json;charset=UTF-8");

        return new ResponseEntity<>(msg, headers, HttpStatus.OK);
    }

    @GetMapping("/exUpload")
    public String exUpload() {
        log.info("/exUpload..........");
        return "sample/exUpload"; // forward
    }

    @PostMapping("/exUploadPost")
    public void exUploadPost(ArrayList<MultipartFile> files) {
        // MultipartFile: Spring이 제공하는 업로드 파일 래퍼 클래스
        for(MultipartFile file : files) {
            log.info("----------------------------------");
            log.info("name:" + file.getOriginalFilename());  // 원본 파일명
            log.info("size:" + file.getSize());              // 파일 크기 (바이트)
            log.info("contentType:" + file.getContentType()); // MIME 타입

            // 파일이 실제로 선택되었는지 확인
            if (!file.isEmpty()) {
                try {
                    // 파일을 지정된 위치에 저장
                    File saveFile = new File("c:/upload/" + file.getOriginalFilename());
                    file.transferTo(saveFile);  // 임시 파일을 최종 위치로 이동
                } catch (IOException e) {
                    log.error("파일 저장 실패", e);
                }
            }
        }
    }

    // - {id} :해당 위치에 존재하는 URL 값을 "id" 라고

    // - @PathVariable("id") long id :
    // 요청 주소에서 {id} 값을 얻어와 매개변수 long id 에 주입
    @RequestMapping("/board/{id:[0-9]+}") // 정수인 경우에만
    public void selectBoard(@PathVariable("id") Long id) {
        log.info("입력된 id: " + id);
    }

    @GetMapping("/input_page")
    public String ex011(SampleDTO dto) {
        log.info("" + dto);
        return "sample/input_page";
    }

    @PostMapping("/result_page")
    public String ex022(SampleDTO dto) {
        log.info("" + dto);
        return "sample/result_page";
    }

}
