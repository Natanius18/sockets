package com.example.sockets.controlller;

import com.example.sockets.dto.Person;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {


    @PostMapping("person")
    public Person readPerson(@RequestBody Person person) {
        log.info("read person: {}", person);
        return person;
    }
}
