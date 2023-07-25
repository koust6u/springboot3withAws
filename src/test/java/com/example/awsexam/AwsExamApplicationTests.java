package com.example.awsexam;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AwsExamApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertThat("aa").isEqualTo("aa");
    }

}
