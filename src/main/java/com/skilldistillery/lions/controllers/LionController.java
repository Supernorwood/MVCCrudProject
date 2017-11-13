package com.skilldistillery.lions.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.lions.data.Lion;
import com.skilldistillery.lions.data.LionDAO;

@SessionAttributes("bestLion")
@Controller
public class LionController {
	
	@Autowired
	LionDAO dao;
	
	@ModelAttribute("bestLion")
	public Lion newLion() {
		return new Lion();
	}
	@RequestMapping("info.do")
	public ModelAndView getLionById(@RequestParam("id") Integer id) {
		ModelAndView mv = new ModelAndView("info");
		Lion best = dao.getLionById(id);
		mv.addObject("lion", best);
		return mv;
	}
	@RequestMapping("delete.do")
	public ModelAndView delete(@RequestParam("id") Integer id) {
		ModelAndView mv = new ModelAndView("deleted");//different view
	
		Lion best = dao.getLionById(id);
		mv.addObject("name", best.getName());
		dao.deleteLion(best);
		return mv;
	}
	@RequestMapping(path="update.do")
	public ModelAndView update(@RequestParam("id") Integer id) {
		ModelAndView mv = new ModelAndView("update");//different view
		
		Lion best = dao.getLionById(id);
		mv.addObject("lion", best);
		return mv;
	}
	@RequestMapping(path="getLion.do", method=RequestMethod.POST)
	public ModelAndView getLionByIdForm(@Valid @ModelAttribute("idForm") LionIdForm f, Errors e) {
		ModelAndView mv = new ModelAndView("index2");
		if(e.hasErrors()) {
			mv.setViewName("index2");
			return mv;
		}
		mv.setViewName("info");
		
		
		Lion best = dao.getLionById(f.getId());
		mv.addObject("lion", best);
		return mv;
	}
	public String home() {
		return "index";
	}
	@RequestMapping(path="home.do", method=RequestMethod.GET)
	public ModelAndView homeWithValidation() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index2");
		LionIdForm f = new LionIdForm();
		mv.addObject("idForm", f);
		
		List<Lion> allLions = dao.getAllLions();
		mv.addObject("list", allLions);
		return mv;
	}
	@RequestMapping(path="add.do", method=RequestMethod.GET)
	public String addLion(Model model) {
		Lion l = new Lion();
		model.addAttribute("lion", l);
		return ("add");
	}
	@RequestMapping(path="addLion.do", method=RequestMethod.POST)
	public ModelAndView doAdd(@Valid Lion lion, Errors e) {
		ModelAndView mv = new ModelAndView();
		if(e.hasErrors()) {
			mv.setViewName("add");
			return mv;
		}
		dao.addLion(lion);
		mv.setViewName("added");
		return mv;
	}
	@RequestMapping(path="updateLion.do", method=RequestMethod.POST)
	public ModelAndView doUpdate(@Valid Lion lion, Errors e) {
		ModelAndView mv = new ModelAndView();
		if(e.hasErrors()) {
			mv.setViewName("update");
			return mv;
		}
		dao.updateLion(lion);
		mv.setViewName("added");
		return mv;
	}
	
	

}
