package a.b.c;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import a.b.c.mapper.UserMapper;

@Service
public class UserService {
	@Inject
	private UserMapper mapper;

	public UserVo login(Map<String, Object> param) throws Exception {
		return mapper.login(param);
	}
}
