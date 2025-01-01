package a.b.c;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import a.b.c.mapper.UserMapper;

@Service
public class UserService {
	@Inject
	private UserMapper mapper;

	public int login(UserVo vo) throws Exception {
		return mapper.login(vo);
	}

	public int idCheck(String id) throws Exception {
		return mapper.idCheck(id);
	}
	
	public int signUp(UserVo vo) throws Exception {
		return mapper.signUp(vo);
	}
	
	public List<UserVo> userList(UserVo vo) throws Exception {
		return mapper.userList(vo);
	}	
}
