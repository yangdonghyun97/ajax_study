package com.study.study.controller;

import com.study.study.AjaxDTO.AjaxDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AjaxController {

    @GetMapping("/ex01")
    public String ex01() {
        System.out.println("ex01 실행됨");

        return "index"; // index.html이 출력
    }

    @PostMapping("/ex02")
    public @ResponseBody String ex02() {
        System.out.println("ex02 실행됨");

        return "index"; // index 문자 그대로 출력
    }

    @GetMapping("/ex03")
    public @ResponseBody String ex03(@RequestParam("param1") String param1, @RequestParam("param2") String param2) {
        System.out.println("param1 = " + param1);
        System.out.println("param2 = " + param2);
        return "ex03 완료";
    }

    @PostMapping("/ex04")
    public @ResponseBody String ex04(@RequestParam("param1") String param1, @RequestParam("param2") String param2) {
        System.out.println("param1 = " + param1);
        System.out.println("param2 = " + param2);
        return "ex04 완료";
    }

    @GetMapping("/ex05")
    public @ResponseBody AjaxDTO ex05(AjaxDTO dto) {
        System.out.println("dto = " + dto);
        return dto;
    }

    @PostMapping("/ex06")
    public @ResponseBody String ex06(AjaxDTO dto) {
        System.out.println("dto = " + dto);
        return "ex06 리턴 완료";
    }

    @PostMapping("/ex07")
    public @ResponseBody AjaxDTO ex07(@RequestBody AjaxDTO dto) {
        System.out.println("dto = " + dto);
        return dto;
    }

    private List<AjaxDTO> DTOList() {
        List<AjaxDTO> list = new ArrayList<>();
        list.add(new AjaxDTO("data1", "data2"));
        list.add(new AjaxDTO("data3", "data4"));

        return list;
    }

    @PostMapping("/ex08")
    public @ResponseBody List<AjaxDTO> ex08(AjaxDTO dto) {
        System.out.println("dto = " + dto);
        List<AjaxDTO> list = DTOList();
        list.add(dto);
        return list;
    }


    @PostMapping("/ex09")
    public ResponseEntity ex09(AjaxDTO dto) {
        System.out.println("dto = " + dto);

        return new ResponseEntity<>(dto, HttpStatus.OK);

    }

    @PostMapping("/ex10")
    public ResponseEntity ex10(@RequestBody AjaxDTO dto) {

        List<AjaxDTO> list = DTOList();
        list.add(dto);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
