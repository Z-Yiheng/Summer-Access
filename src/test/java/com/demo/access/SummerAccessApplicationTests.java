package com.demo.access;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SummerAccessApplicationTests {

    @Test
    public void TestPw() {
        PasswordEncoder pw = new BCryptPasswordEncoder();
        String encode = pw.encode("123456");
        System.out.println(encode);
        boolean matches = pw.matches("123456",encode);
        System.out.println(matches);
    }

}
