package com.nooglers;

import com.nooglers.dao.test.QuestionDao;
import com.nooglers.domains.test.Question;
import com.nooglers.services.QuizService;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        final QuestionDao instance1 = QuestionDao.getInstance();
        final Question byId = instance1.findById(1);

        final QuizService instance = QuizService.getInstance();
        final String term = instance.getUserAnswer(byId);
        System.out.println(term
        );
    }
    private String gr(Integer n, Function<Integer,String> f){
        return f.apply(n);
    }
}
