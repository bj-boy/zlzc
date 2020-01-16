package com.zlzc.common.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zlzc.common.utils.Result;

import lombok.extern.slf4j.Slf4j;

/**
 * 异常处理器
 */
@Slf4j
@RestControllerAdvice
public class ZExceptionHandler {
	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(ZException.class)
	public Result handleZException(ZException e) {
		Result r = new Result();
		r.put("code", e.getCode());
		r.put("msg", e.getMessage());

		return r;
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public Result handleDuplicateKeyException(DuplicateKeyException e) {
		log.error(e.getMessage(), e);
		return Result.error("数据库中已存在该记录");
	}

	@ExceptionHandler(AuthorizationException.class)
	public Result handleAuthorizationException(AuthorizationException e) {
		log.error(e.getMessage(), e);
		return Result.error("没有权限，请联系管理员授权");
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public Result handleAuthorizationException(AccessDeniedException e) {
		log.error(e.getMessage(), e);
		return Result.error("没有权限，请联系管理员授权");
	}

	@ExceptionHandler(Exception.class)
	public Result handleException(Exception e) {
		log.error(e.getMessage(), e);
		return Result.error();
	}
}
