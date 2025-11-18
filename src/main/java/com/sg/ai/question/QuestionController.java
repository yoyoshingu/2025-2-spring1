package com.sg.ai.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	private final QuestionService questionService;
	
	// 질문목록
	@GetMapping("/question/list")
	public String list(Model model) {
		
		List<Question> questionList = this.questionService.getList();
		model.addAttribute("questionList", questionList);
		return "question_list";
	}
	
	// 질문상세 페이지, 
	@GetMapping(value = "/question/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id ) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "question_detail";
	}
	
	// 질문등록 페이지
	// 2025.11.18 스프링수업
	@GetMapping("/question/create")
	public String questionCreate() {
		return "question_form";
	}
	
	@PostMapping("/question/create")
	public String questionCreate(@RequestParam(value="subject") String subject, 
				@RequestParam(value="content")String content) {
		// 완료: TODO subject와content를 가져와서 질문 저장
		// 2025.11.18
		this.questionService.create(subject, content);
		return "redirect:/question/list";
	}
	
	
}
