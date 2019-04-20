package cn.ixan.example.utils;

import cn.ixan.example.domain.Result;

/**
 * @author stack_zhang@outlook.com
 * @date 2019年3月31日, 0031
 */
public class ResultGenerate {
	private ResultGenerate() {
	}
	private static final String SUCCESS = "success";
	private static final String FAILURE = "failure";
	private static final String SUCCESS_CODE = "200";
	private static final String FAILURE_CODE = "500";

	public static <T> Result<T> generateSuccess(T data){
		Result<T> result = generateResult(data, SUCCESS_CODE, SUCCESS);
		return result;
	}

	private static <T> Result<T> generateResult(T data, String code, String msg) {
		Result<T> result = new Result<>();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}

	public static <T> Result<T> generateFailure(T data){
		Result<T> result = generateResult(data, FAILURE_CODE, FAILURE);
		return result;
	}

	public static <T> Result<T> generateFailure(T data,String msg){
		Result<T> result = generateResult(data, FAILURE_CODE, msg);
		return result;
	}

	public static <T> Result<T> generateFailure(String msg){
		Result<T> result = new Result<>();
		result.setCode(FAILURE_CODE);
		result.setMsg(msg);
		return result;
	}
}
