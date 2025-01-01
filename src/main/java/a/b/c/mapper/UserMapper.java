package a.b.c.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import a.b.c.UserVo;

@Mapper
public interface UserMapper {
	UserVo login(Map<String, Object> param);
}
