package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.constant.SessionAtri;
import com.poly.entity.Account;
import com.poly.repository.AccountRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	HttpServletRequest request;
	HttpServletResponse response;

	@Autowired
	AccountRepository ur;

	@GetMapping("/view-login")
	public String getViewLogin() {
		return "/views/login";
	}

	@GetMapping("/view-signup")
	public String getViewSignUp() {
		return "/views/sign-up";
	}

	@GetMapping("/view-forget")
	public String getViewForget() {

		return "/views/forget";
	}

	@GetMapping("/my-profile")
	public String myProfile(HttpSession session) {
		Account u = (Account) session.getAttribute(SessionAtri.Current_User);
		request.setAttribute("user", u);
		return "/views/myprofile";
	}

	@GetMapping("/logout")
	public String exitAccount(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/view-login";
	}

	@PostMapping("/login")
	public String getLogin(Model model, @RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password, HttpSession session) {
		Account u = ur.findByUsernameAndPassword(username, password);
		if (u != null) {
			if (u.isActive() != true) {
				request.setAttribute("err", "Please check your input user or password");
				return "/views/login";
			}
			session.setAttribute(SessionAtri.Current_User, u);
			Boolean isAdmin = u.isIs_admin();
			if (isAdmin == true) {
				return "redirect:/admin/home";
			} else {
				return "redirect:/video/all-video";
			}
		} else {
			request.setAttribute("err", "Please check your input user or password");
			return "/views/login";

		}
	}

	@GetMapping("/change-pass")
	public String myViewChangePass(HttpSession session) {
		return "/views/changePass";
	}

	@PostMapping("/sign-up")
	public String addNew() {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String repass = request.getParameter("repass");
		String mail = request.getParameter("email");
		if (!pass.equals(repass)) {
			request.setAttribute("err", "Password is not correct");
			return "/views/sign-up";
		}
		Account acc = new Account();
		acc.setUsername(user);
		acc.setPassword(pass);
		acc.setEmail(mail);
		acc.setActive(true);
		ur.save(acc);
		return "/views/login";
	}

	@PostMapping("/change-pass")
	public String changePass(@RequestParam(name = "oldpass") String oldpass,
			@RequestParam(name = "pass") String password, @RequestParam(name = "repass") String repass) {
		Account user =(Account) request.getSession().getAttribute("user");
		if(!oldpass.equals(user.getPassword())) {
			request.setAttribute("err","Password is incorrect, please check old pass!");
			return "/views/changePass";
		}else {
			if(!password.equals(repass)) {
				request.setAttribute("err","New Password is different, please check!");
				return "/views/changePass";
			}
			user.setPassword(password);
			ur.save(user);
			request.getSession().setAttribute("user", user);
			return "redirect:/my-profile";
		}
	}

	@PostMapping("/change-infor")
	public String changeInfor(
			@RequestParam(name = "name") String name, @RequestParam(name = "email") String email) {
		Account user =(Account) request.getSession().getAttribute("user");
		user.setEmail(email);
		user.setName(name);
		ur.save(user);
		request.getSession().setAttribute("user", user);
		return "redirect:/my-profile";
	}

}
