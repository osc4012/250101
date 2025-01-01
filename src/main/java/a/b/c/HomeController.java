package a.b.c;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Slf4j
public class HomeController {
	static final String error = "server error";
	@Inject
	private UserService service;

	// private static final Logger logger =
	// LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("info");
		log.debug("debug");
		System.out.println("!!!!!!!!!!!!!!!");
		// logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@GetMapping("/test1")
	public void test1() throws Exception {
		// log.info("12345 {}", "test1 start");
	}

	@GetMapping("/login")
	@ResponseBody
	public Map<String, Object> test1Ajax(UserVo vo) throws Exception {
		Map<String, Object> result = new HashMap<>();
		try {
			result.put("result", service.login(vo));
		} catch (Exception e) {
			e.printStackTrace();
			result.put("result", error);
		}

		return result;
	}

	@GetMapping("/idCheck")
	@ResponseBody
	public Map<String, Object> idCheck(UserVo vo) throws Exception {
		Map<String, Object> res = new HashMap<>();
		int result = 1;
		try {
			result = service.idCheck(vo.getId());
		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
		}

		res.put("result", result);
		return res;
	}

	@PostMapping("/signUp")
	@ResponseBody
	public int signUp(UserVo vo) throws Exception {
		int result = 0;
		try {
			result = service.signUp(vo);
		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
		}

		return result;
	}

	@GetMapping("/userList")
	@ResponseBody
	public Map<String, Object> userList(UserVo vo) throws Exception {
		Map<String, Object> result = new HashMap<>();
		// log.info(vo.getSearchSelect().getClass().getName());
		// log.info(vo.getSearchText().getClass().getName());

		try {
			List<UserVo> userList = service.userList(vo);
			result.put("result", userList);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("result", error);
		}

		return result;
	}
}