package a.b.c.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import a.b.c.UserVo;

@Mapper
public interface UserMapper {
	int login(UserVo vo);

	int idCheck(String id);
	
	int signUp(UserVo vo);
	
	List<UserVo> userList(UserVo vo);
}
