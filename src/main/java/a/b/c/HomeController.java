package a.b.c;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	@Inject
	private UserService service;

	// private static final Logger logger =
	// LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
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
		log.info("test1 start");
	}

	@GetMapping("/test1Ajax")
	@ResponseBody
	public Map<String, Object> test1Ajax(UserVo vo) throws Exception {
		log.info("test1Ajax start");
		Map<String, Object> param = new HashMap<>();
		param.put("id", vo.getId());
		param.put("pw", vo.getPw());
		UserVo result = new UserVo();
		Map<String, Object> resultMap = new HashMap<>();
		
		try {
			result = service.login(param);
			System.out.println("result!!!!!!!!!" + result);
			resultMap.put("result", result);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("error", "server error");
		}

		return resultMap;
	}
}