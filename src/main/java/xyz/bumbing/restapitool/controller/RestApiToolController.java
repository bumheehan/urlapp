package xyz.bumbing.restapitool.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import xyz.bumbing.restapitool.dto.RestApiDto;
import xyz.bumbing.restapitool.dto.RestApiParameterDto;
import xyz.bumbing.restapitool.repo.RestApiParamRepository;
import xyz.bumbing.restapitool.repo.RestApiRepository;

@Controller
public class RestApiToolController {

	@Autowired
	RestApiRepository repo;

	@Autowired
	RestApiParamRepository repop;

	@PostMapping("/insert")
	public String insert(RestApiDto dto, String search) {
		RestApiDto dbdto = repo.findByUrl(dto.getUrl());
		if (dbdto == null) {
			repo.save(dto);
		} else {
			dbdto.setClassName(dto.getClassName());
			dbdto.setContentType(dto.getContentType());
			dbdto.setTemplateUrl(dto.getTemplateUrl());
			dbdto.setMethodName(dto.getMethodName());
			dbdto.setRequestMethod(dto.getRequestMethod());
			repo.save(dbdto);
		}

		if ("".equals(search)) {
			return "redirect:/";

		} else {
			return "redirect:/?search=" + search;

		}
	}

	@RequestMapping("/delete")
	public String delete(int no, String search) {
		repo.deleteById(no);
		if ("".equals(search)) {
			return "redirect:/";

		} else {
			return "redirect:/?search=" + search;

		}
	}

	@PostMapping("/status")
	public String status(int restapino, String status, String search) {

		Optional<RestApiDto> dto = repo.findById(restapino);
		dto.get().setStatus(status);
		repo.save(dto.get());
		if ("".equals(search)) {
			return "redirect:/";

		} else {
			return "redirect:/?search=" + search;

		}
	}

	@GetMapping("/")
	public String list(Model mo, String search) {

		if (search == null || "".equals(search)) {
			List<RestApiDto> list = repo.findAllByUrlContainingOrderByUrlAsc("");
			mo.addAttribute("list", list);
			return "index";
		} else {
			if (search.charAt(search.length() - 1) == '/') {
				search = search.substring(0, search.length() - 1);
			}
			mo.addAttribute("search", search);
			List<RestApiDto> list = repo.findAllByUrlContainingOrderByUrlAsc(search);
			mo.addAttribute("list", list);
			return "index";
		}

	}

	@Transactional
	@RequestMapping("param")
	public String param(int restapino, Model mo) {

		List<RestApiParameterDto> result = repo.findById(restapino).get().getParameter();
		mo.addAttribute("list", result);
		return "param";

	}

	@PostMapping("paramin")
	public @ResponseBody void paramin(int restapino, RestApiParameterDto dto, RedirectAttributes redirectAttributes) {
		Optional<RestApiDto> dbdto = repo.findById(restapino);
		dto.setRestapi(dbdto.get());
		repop.save(dto);
		redirectAttributes.addAttribute("restapino", restapino);
	}

	@PostMapping("paramdel")
	public @ResponseBody void paramdel(int restapino, int paramno, RedirectAttributes redirectAttributes) {
		repop.deleteById(paramno);
		redirectAttributes.addAttribute("restapino", restapino);
	}

	@GetMapping("all")
	public @ResponseBody List<RestApiDto> tojson(String search) {
		if (search == null) {
			return repo.findAllByUrlContainingOrderByUrlAsc("");
		} else {
			return repo.findAllByUrlContainingOrderByUrlAsc(search);
		}
	}
}
