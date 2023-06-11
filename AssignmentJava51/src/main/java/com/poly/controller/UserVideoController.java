package com.poly.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.constant.SessionAtri;
import com.poly.entity.Account;
import com.poly.entity.History;
import com.poly.entity.Type_Video;
import com.poly.entity.Video;
import com.poly.repository.HistoryRepository;
import com.poly.repository.TypeRepository;
import com.poly.repository.VideoRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/video")
public class UserVideoController {
	@Autowired
	HttpServletRequest request;
	HttpServletResponse response;

	@Autowired
	VideoRepository vdrepo;
	@Autowired
	HistoryRepository hr;
	@Autowired
	TypeRepository tr;

	@GetMapping("/all-video")
	public String getHome(Model model,
			@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "6") Integer pageSize) {
		// Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize, Sort.by("id").descending());
		Page<Video> page = vdrepo.findAllByActive(true, pageable);

		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("list", page.getContent());
		model.addAttribute("_listType", tr.findByActive(true));
		request.setAttribute("view", "views/movie.jsp");
		return "index";
	}

	@GetMapping("/blog")
	public String getBlog() {
		request.setAttribute("view", "views/blog.jsp");
		return "index";
	}

	@GetMapping("/home")
	public String getHomeVideo() {
		List<Video> mostVideo = vdrepo.findTop6ByActiveOrderByViewsDesc(true);
		List<Video> newVideo = vdrepo.findTop4ByActiveOrderByIdDesc(true);
		request.setAttribute("_list", mostVideo);
		request.setAttribute("_ds", newVideo);
		request.setAttribute("view", "views/home.jsp");
		return "index";
	}

	@GetMapping("/my-history")
	public String getListHisVideo() {
		Account user = (Account) request.getSession().getAttribute("user");
		request.setAttribute("videohis", hr.findByUser(user));
		request.setAttribute("view", "views/history.jsp");
		return "index";
	}

	@GetMapping("/favorite")
	public String getListFavoVideo(HttpSession session) {
		Account u = (Account) session.getAttribute(SessionAtri.Current_User);
		List<Video> ds = hr.getVideoByHis(u.getId());
		request.setAttribute("videolike", ds);
		request.setAttribute("view", "views/myfavarite.jsp");
		return "index";
	}

	@GetMapping("/view-share")
	public String getFormShareVideo() {
		request.setAttribute("view", "views/shareVideo.jsp");
		return "index";
	}

	@GetMapping("/like/{id}")
	public String getLikeVideo(@PathVariable Integer id, Model model, HttpSession session) {
		Account u = (Account) session.getAttribute(SessionAtri.Current_User);
		Video vd = vdrepo.findById(id).orElse(null);
		if (u == null) {
			return "redirect:/view-login";
		} else {
			History hisCheck = hr.findByIdVideoandIdUser(vd.getId(), u.getId());
			Date date = new Date(Calendar.getInstance().getTime().getTime());
			if (hisCheck.isIs_liked() == true) {
				hisCheck.setIs_liked(false);
				vd.setLikes(vd.getLikes() - 1);
				vd.setViews(vd.getViews() - 1);
				hr.save(hisCheck);
				request.setAttribute("liked", false);
			} else {
				hisCheck.setIs_liked(true);
				hisCheck.setLiked_date(date);
				vd.setLikes(vd.getLikes() + 1);
				vd.setViews(vd.getViews() - 1);
				hr.save(hisCheck);
				request.setAttribute("liked", true);
			}
		}
		vdrepo.save(vd);
		String getBack = this.getDetailVideo(id, model, session);
		return getBack;
	}

	@GetMapping("/detail/{id}")
	public String getDetailVideo(@PathVariable Integer id, Model model, HttpSession session) {
		Video vd = vdrepo.findById(id).orElse(null);
		if (vd.isActive() != true) {
			return "redirect:/video/nonVideo";
		}

		vd.setViews(vd.getViews() + 1);
		vdrepo.save(vd);
		Account u = (Account) session.getAttribute(SessionAtri.Current_User);
		if (u != null) {
			History hisCheck = hr.findByIdVideoandIdUser(vd.getId(), u.getId());
			Date date = new Date(Calendar.getInstance().getTime().getTime());
			if (hisCheck == null) {
				History his1 = new History(u, vd, date, false, null);
				hr.save(his1);
				request.setAttribute("liked", false);
			} else {
				hisCheck.setIs_liked(hisCheck.isIs_liked());
				hisCheck.setView_date(date);
				hisCheck.setLiked_date(hisCheck.getLiked_date());
				hr.save(hisCheck);
				request.setAttribute("liked", hisCheck.isIs_liked());
			}
		}

		model.addAttribute("video", vdrepo.findById(id).orElse(null));
		request.setAttribute("view", "views/about-film.jsp");
		return "index";
	}

	@GetMapping("/nonVideo")
	public String getNoneVideo() {
		request.setAttribute("view", "views/nonVideoDisplay.jsp");
		return "index";
	}

	@GetMapping("/genre/{id}")
	public String getVideoByType(@PathVariable Integer id, Model model,
			@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "6") Integer pageSize) {
		Type_Video type = tr.findById(id).orElse(null);

		Pageable pageable = PageRequest.of(pageNum - 1, pageSize, Sort.by("id").descending());
		Page<Video> page = vdrepo.findAllByTypeAndActive(type,true,pageable);
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("list", page.getContent());
		request.setAttribute("_listType", tr.findByActive(true));
		request.setAttribute("view", "views/the-loai.jsp");
		return "index";
	}
}
