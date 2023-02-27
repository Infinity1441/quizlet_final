package com.nooglers.dao;

import com.nooglers.domains.test.QuizHistory;

public class QuizHistoryDao extends BaseDAO<QuizHistory, Integer> {

    private static final ThreadLocal<QuizHistoryDao> QUIZ_HISTORY_DAO = ThreadLocal.withInitial(QuizHistoryDao::new);

    public static QuizHistoryDao getInstance() {
        return QUIZ_HISTORY_DAO.get();
    }


}
