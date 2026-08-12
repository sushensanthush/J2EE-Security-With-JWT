package lk.susa.web;

import lk.susa.web.util.JwtUtil;

import java.util.Set;

public class Test {
    public static void main(String[] args) {
//        String token = JwtUtil.generateToken("Sushen", Set.of("ADMIN","USER"));
//        System.out.println(token);

        boolean valid = JwtUtil.isValid("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJTdXNoZW4iLCJyb2xlcyI6WyJBRE1JTiIsIlVTRVIiXSwiaWF0IjoxNzg2NTI2NjMwLCJleHAiOjE3ODY1MzAyMzB9.VBlOt8CFwiL7NCNH754m4tNL0Rnc6XwVuEYnUX358YI");
        System.out.println(valid);
    }
}
