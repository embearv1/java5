package com.poly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Type_Video;
import com.poly.entity.Video;
import com.poly.repository.AccountRepository;
import com.poly.repository.TypeRepository;
import com.poly.repository.VideoRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminHome {
	@Autowired
	TypeRepository tr;

	@Autowired
	AccountRepository ur;

	@Autowired
	VideoRepository vr;

	@Autowired
	HttpServletRequest request;

	@GetMapping("/home")
	private String getHomeAdmin() {
		request.setAttribute("link", "../admin/admin-trangnen.jsp");
		return "admin/admin-home";
	}

	@GetMapping("/manage-video")
	private String getManaVideo(Model model,
			@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "6") Integer pageSize) {
		// Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize, Sort.by("id").descending());
		Page<Video> page = vr.findAll(pageable);
		request.setAttribute("all_type", tr.findAll());
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("list", page.getContent());
		request.setAttribute("link", "../admin/manage-film.jsp");
		return "admin/admin-home";
	}

	@GetMapping("/type")
	private String getType() {
		request.setAttribute("all_type", tr.findAll());
		request.setAttribute("link", "../admin/admin-type.jsp");
		return "admin/admin-home";
	}

	@GetMapping("/account")
	private String getAccount() {
		request.setAttribute("all_acc", ur.findAll());
		request.setAttribute("link", "../admin/mange-account.jsp");
		return "admin/admin-home";
	}

	@GetMapping("/logout-admin")
	public String exitAccountAdm(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/view-login";
	}

	@GetMapping("/view-add-video")
	public String formaddNewVideo() {
		request.setAttribute("all_type", tr.findAll());
		request.setAttribute("link", "../admin/film-add.jsp");
		return "admin/admin-home";
	}
	
	@PostMapping("/add-video")
	String addNewFilm() {
		Video vd = new Video();
		String type_id =request.getParameter("type");
		Type_Video type = tr.getById(Integer.parseInt(type_id));
		vd.setType(type);
		vd.setActive(true);
		vd.setListHis(null);
		vd.setTitle(request.getParameter("title"));
		vd.setHref(request.getParameter("href"));
		vd.setDescription(request.getParameter("description"));
		vd.setPoster(request.getParameter("poster"));
		vr.save(vd);
		return "redirect:/admin/manage-video";
	}
	
	String idall;
	
	@GetMapping("/view-update-video")
	public String detailVideo(Model model,
			@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "6") Integer pageSize) {
		String idvd = request.getParameter("id");
		idall = idvd;
		Video vd= vr.getById(Integer.parseInt(idvd));
		request.setAttribute("v",vd);
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize, Sort.by("id").descending());
		Page<Video> page = vr.findAll(pageable);
		request.setAttribute("all_type", tr.findAll());
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("list", page.getContent());
		request.setAttribute("link", "../admin/manage-film.jsp");
		return "admin/admin-home";
		
	}
	
	@PostMapping("/update-video")
	public String updateVd() {
		Video vd = vr.getById(Integer.parseInt(idall));
		String type_id =request.getParameter("type");
		Type_Video type = tr.getById(Integer.parseInt(type_id));
		vd.setType(type);
		vd.setActive(true);
		vd.setListHis(null);
		vd.setTitle(request.getParameter("title"));
		vd.setHref(request.getParameter("href"));
		vd.setDescription(request.getParameter("description"));
		vd.setPoster(request.getParameter("poster1"));
		System.out.println("eee:"+request.getParameter("poster"));
		vr.save(vd);
		return "redirect:/admin/manage-video";
	}
	
	@GetMapping("/delete-video")
	public String deleteVid(){
		String idvd = request.getParameter("id");
	    vr.deleteById(Integer.parseInt(idvd));
	    return "redirect:/admin/manage-video";
	}
}
