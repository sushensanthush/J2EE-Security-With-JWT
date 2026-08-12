package lk.susa.web;

import lk.susa.web.util.JwtUtil;

import java.util.Set;

public class Test {

    public static void main(String[] args) {

        String token = JwtUtil.generateToken(
                "Sushen",
                Set.of("ADMIN", "USER")
        );

        System.out.println(token);

//        boolean valid = JwtUtil.isValid("6a4ea8f0caac9b4d5539483ac2f2c18f46f6d079c47784e0daa50629e95712dd");
//        System.out.println(valid);
    }
}
