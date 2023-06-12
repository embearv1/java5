package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Type_Video;
import com.poly.repository.TypeRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/type")
public class AdminTypeController {

	@Autowired
	HttpServletRequest request;

	@Autowired
	TypeRepository tr;

	@GetMapping("/view-edit-type/{id}")
	public String getDetailType(@PathVariable Integer id, Model model,
			@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "6") Integer pageSize) {
		Type_Video type = tr.findById(id).orElse(null);
		request.setAttribute("type", type);
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize, Sort.by("id").descending());
		Page<Type_Video> page = tr.findAllByActive(true, pageable);
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("list", page.getContent());
		request.setAttribute("link", "../admin/admin-type.jsp");
		return "admin/admin-home";
	}

	@GetMapping("/delete-type/{id}")
	public String getDeleType(@PathVariable Integer id) {
		Type_Video type = tr.findById(id).orElse(null);
		type.setActive(false);
		tr.save(type);
		return "redirect:/admin/type";
	}

	@PostMapping("/add-type")
	public String addNewType(@RequestParam("name") String name) {
		Type_Video type = new Type_Video();
		type.setName(name);
		type.setActive(true);
		tr.save(type);
		request.setAttribute("all_type", tr.findByActive(true));
		request.setAttribute("link", "../admin/admin-type.jsp");
		return "admin/admin-home";
	}

	@PostMapping("/edit-type/{id}")
	public String updateType(@PathVariable Integer id, @RequestParam("name") String name) {
		Type_Video type = tr.findById(id).orElse(null);
		type.setName(name);
		tr.save(type);
		return "redirect:/admin/type";
	}
}
