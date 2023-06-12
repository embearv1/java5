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

import com.poly.entity.Account;
import com.poly.repository.AccountRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {
	
	@Autowired
	AccountRepository ur;
	
	@Autowired
	HttpServletRequest request;

	@GetMapping("/detail-user/{id}")
	public String getDetailUser(@PathVariable Integer id,Model model,
			@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "6") Integer pageSize) {
		Account user = ur.findById(id).orElse(null);
		request.setAttribute("uu", user);
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize, Sort.by("id").descending());
		Page<Account> page = ur.findAllByActive(true, pageable);
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("list", page.getContent());
		
		request.setAttribute("link", "../admin/mange-account.jsp");
		return "admin/admin-home";
	}
	
	@GetMapping("/delete-user/{id}")
	public String deleteUser(@PathVariable Integer id) {
		Account user = ur.findById(id).orElse(null);
		user.setActive(false);
		ur.save(user);
		return "redirect:/admin/user";
	}
	
	@PostMapping("/update-user/{id}")
	public String updateUser(@PathVariable Integer id,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("email") String email
			) {
		Account user = ur.findById(id).orElse(null);
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setEmail(email);
		ur.save(user);
		return "redirect:/admin/user";
	}
	
	@PostMapping("/add-user")
	public String addUser(@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("email") String email) {
		Account user = new Account();
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setEmail(email);
		user.setActive(true);
		user.setIs_admin(false);
		ur.save(user);
		return "redirect:/admin/user";
	}
	
}
