package com.sg.ai;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sg.ai.question.Question;
import com.sg.ai.question.QuestionRepository;

@SpringBootTest
class SbbApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void testJpa() {
		Question q1 = new Question();
		q1.setSubject("sbb가 뭔가요?");
		q1.setContent("sbb에 대해서 알고 싶습니다. 오늘은 11월4일입니다");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);
		
		Question q2 = new Question();
		q2.setSubject("기말시험 관련");
		q2.setContent("스프링 기말 평가는 어떻게 하나요, 시험도 보나요");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);
	}

}
