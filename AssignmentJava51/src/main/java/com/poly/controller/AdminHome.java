package com.poly.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.entity.Account;
import com.poly.entity.Type_Video;
import com.poly.entity.Video;
import com.poly.repository.AccountRepository;
import com.poly.repository.TypeRepository;
import com.poly.repository.VideoRepository;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

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

	@Autowired
	ServletContext context;

	@GetMapping("/home")
	private String getHomeAdmin() {
		request.setAttribute("totalVid",vr.findByActive(true).size());
		request.setAttribute("link", "../admin/admin-trangnen.jsp");
		return "admin/admin-home";
	}

	@GetMapping("/manage-video")
	private String getManaVideo(Model model,
			@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "6") Integer pageSize) {
		// Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize, Sort.by("id").descending());
		Page<Video> page = vr.findAllByActive(true, pageable);
		request.setAttribute("all_type", tr.findByActive(true));
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("list", page.getContent());
		request.setAttribute("link", "../admin/manage-film.jsp");
		return "admin/admin-home";
	}

	@GetMapping("/type")
	private String getType(Model model,
			@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "6") Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize, Sort.by("id").descending());
		Page<Type_Video> page = tr.findAllByActive(true, pageable);
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("list", page.getContent());
		request.setAttribute("link", "../admin/admin-type.jsp");
		return "admin/admin-home";
	}

	@GetMapping("/user")
	private String getAccount(Model model,
			@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "6") Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize, Sort.by("id").descending());
		Page<Account> page = ur.findAllByActive(true, pageable);
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("list", page.getContent());
		request.setAttribute("link", "../admin/mange-account.jsp");
		return "admin/admin-home";
	}

	@GetMapping("/logout-admin")
	public String exitAccountAdm(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/view-login";
	}

	@GetMapping("/add-video")
	public String formaddNewVideo() {
		request.setAttribute("all_type", tr.findByActive(true));
		request.setAttribute("link", "../admin/film-add.jsp");
		return "admin/admin-home";
	}
	
	@GetMapping("delete-video/{id}")
	public String deleVideo(@PathVariable Integer id) {
		Video vd= vr.findById(id).orElse(null);
		vd.setActive(false);
		vr.save(vd);
		return "redirect:/admin/manage-video";
	}

	@PostMapping("/add-video")
	String addNewFilm(Model model, @Valid Video vd, BindingResult bindingResult, @RequestParam("posterVd") MultipartFile file) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("err", bindingResult.getAllErrors());
			request.setAttribute("all_type", tr.findByActive(true));
			request.setAttribute("link", "../admin/film-add.jsp");
			return "admin/admin-home";
		}

		if (!file.isEmpty()) {
		    String fileOriginal = file.getOriginalFilename();
		    String fileExtension = fileOriginal.substring(fileOriginal.lastIndexOf("."));
		    String randomFileName = UUID.randomUUID().toString() + fileExtension;
		    String fileDest = context.getRealPath("/upload/" + randomFileName);
		    
		    try {
		        file.transferTo(new File(fileDest));
		        System.out.println(fileOriginal);
		        vd.setPoster("/upload/" + randomFileName);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		vd.setType(tr.findById(vd.getType().getId()).orElse(null));
		vd.setActive(true);
		vr.save(vd);
		return "redirect:/admin/manage-video";
	}

	@GetMapping("/view-update-video/{id}")
	public String detailVideo( @PathVariable Integer id, Model model,
			@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "6") Integer pageSize) {
		Video vd= vr.findById(id).orElse(null);
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize, Sort.by("id").descending());
		Page<Video> page = vr.findAllByActive(true,pageable);
		request.setAttribute("v", vd);
		request.setAttribute("all_type", tr.findAll());
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("list", page.getContent());
		request.setAttribute("link", "../admin/manage-film.jsp");
		return "admin/admin-home";
		
	}

	@PostMapping("/update-video/{id}")
	public String updateVd(@PathVariable Integer id, Model model,
			@Valid Video vd, BindingResult bindingResult,
			@RequestParam("posterVd") MultipartFile file) {
		Video vid = vr.findById(id).orElse(null);
		vid.setTitle(vd.getTitle());
		vid.setDescription(vd.getDescription());
		vid.setHref(vd.getHref());
//		vid.setLikes(vd.getLikes());
//		vid.setShares(vd.getShares());
//		vid.setListHis(vd.getListHis());
		vid.setActive(true);
		vid.setType(vd.getType());
		if (bindingResult.hasErrors()) {
			model.addAttribute("err", bindingResult.getAllErrors());
			request.setAttribute("all_type", tr.findByActive(true));
			request.setAttribute("link", "../admin/film-add.jsp");
			return "admin/admin-home";
		}

		if(file.isEmpty()) {
			vid.setPoster(vid.getPoster());
		}
		if (!file.isEmpty()) {
		    String fileOriginal = file.getOriginalFilename();
		    String fileExtension = fileOriginal.substring(fileOriginal.lastIndexOf("."));
		    String randomFileName = UUID.randomUUID().toString() + fileExtension;
		    String fileDest = context.getRealPath("/upload/" + randomFileName);
		    
		    try {
		        file.transferTo(new File(fileDest));
		        System.out.println(fileOriginal);
		        vid.setPoster("/upload/" + randomFileName);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		
		vr.save(vid);
		return "redirect:/admin/manage-video";

	}
}
