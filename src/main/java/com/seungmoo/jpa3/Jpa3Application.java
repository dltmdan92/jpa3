package com.seungmoo.jpa3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// repositoryImplementationPostfix : 커스텀 Repository의 구현체 postfix 설정, DEFAULT는 "Impl" 이다.
// repositoryBaseClass : 커스텀한 Common(공통) Repository 등록
@EnableJpaRepositories(repositoryImplementationPostfix = "Impl", repositoryBaseClass = SimpleMyRepository.class)
public class Jpa3Application {

    public static void main(String[] args) {
        SpringApplication.run(Jpa3Application.class, args);
    }

}
