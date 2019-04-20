package cn.ixan.example.web.handler;

import cn.ixan.example.domain.ErrorResult;
import cn.ixan.example.web.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 * @author stack_zhang@outlook.com
 * @date 2019年3月30日, 0030
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	private static final String ERROR_PAGE_VIEW = "error";

	@ExceptionHandler(MyException.class)
	@ResponseBody
	public ErrorResult jsonErrorHandler(HttpServletRequest request, MyException e) {
		log.error("发生业务异常[{}]",e);
		ErrorResult<String> result = new ErrorResult<>();
		result.setCode(ErrorResult.ERROR);
		result.setMessage(e.getMessage());
		result.setUrl(request.getRequestURL().toString());
		result.setData(e.toString());
		return result;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest request,Exception e) {
		log.error("发生异常[{}]",e);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception",e);
		modelAndView.addObject("url",request.getRequestURL());
		modelAndView.setViewName(ERROR_PAGE_VIEW);
		return modelAndView;
	}
}
