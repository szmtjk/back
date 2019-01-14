package com.szmtjk.web.controller;

import com.szmtjk.business.model.Exam;
import com.szmtjk.business.model.ExamQuery;
import com.szmtjk.web.controller.base.BaseCRUDController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam")
public class ExamController extends BaseCRUDController<Exam, ExamQuery> {
}
