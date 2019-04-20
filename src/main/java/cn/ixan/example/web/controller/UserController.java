package cn.ixan.example.web.controller;

import cn.ixan.example.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月31日, 0031
 */
@Api(value = "用户管理")
@RestController
public class UserController {
	//创建线程安全的Map
	private Map<Long, User> userMap = Collections.synchronizedMap(new HashMap<>());

	@ApiOperation(value = "获取用户列表")
	@RequestMapping(value = "/users/", method = RequestMethod.GET)
	public List<User> getUserList() {
		ArrayList<User> users = new ArrayList<>(userMap.values());
		return users;
	}

	@ApiOperation(value = "获取用户")
	@ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long",paramType = "path")
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable(value = "id") Long id) {
		return userMap.get(id);
	}

	@ApiOperation(value = "新增用户")
	@PostMapping("/users/")
	public Long postUser(@RequestBody User user) {
		Long id = user.getId();
		userMap.put(id, user);
		return id;
	}

	@ApiOperation(value = "修改用户")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path"),
			@ApiImplicitParam(name = "user", value = "user", required = true, dataType = "User")
	})
	@PutMapping("/users/{id}")
	public Long putUser(@PathVariable(value = "id") Long id, @RequestBody User user) {
		User u = userMap.get(id);
		u.setAge(user.getAge());
		u.setName(user.getName());
		userMap.put(id, u);
		return id;
	}

	@ApiOperation(value = "删除用户")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path")
	@DeleteMapping("/users/{id}")
	public User deleteUser(@PathVariable(value = "id") Long id) {
		return userMap.remove(id);
	}


}
