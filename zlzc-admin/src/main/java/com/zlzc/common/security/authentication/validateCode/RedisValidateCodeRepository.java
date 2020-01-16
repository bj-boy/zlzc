package com.zlzc.common.security.authentication.validateCode;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import com.zlzc.common.security.support.ValidateCodeType;
import com.zlzc.common.security.validate.code.ValidateCode;
import com.zlzc.common.security.validate.code.ValidateCodeException;
import com.zlzc.common.security.validate.code.ValidateCodeRepository;

/**
 * 基于redis的验证码存取器，避免由于没有session导致无法存取验证码的问题
 * 
 * @author Lsr
 *
 */
@SuppressWarnings({"unchecked", "rawtypes"})
@Component
public class RedisValidateCodeRepository implements ValidateCodeRepository {

	@Autowired
	private RedisTemplate redisTemplate;
	
	@Override
	public void save(ServletWebRequest request, ValidateCode code, ValidateCodeType type) {
		redisTemplate.opsForValue().set(buildKey(request, type), code, 30, TimeUnit.MINUTES);
	}

	@Override
	public ValidateCode get(ServletWebRequest request, ValidateCodeType type) {
		Object value = redisTemplate.opsForValue().get(buildKey(request, type));
		if (value == null) {
			return null;
		}
		return (ValidateCode) value;
	}

	@Override
	public void remove(ServletWebRequest request, ValidateCodeType type) {
		redisTemplate.delete(buildKey(request, type));
	}

	/**
	 * @param request
	 * @param type
	 * @return
	 */
	private String buildKey(ServletWebRequest request, ValidateCodeType type) {
		String deviceId = request.getHeader("deviceId");
		if (StringUtils.isBlank(deviceId)) {
			throw new ValidateCodeException("请在请求头中携带deviceId参数");
		}
		return "code:" + type.toString().toLowerCase() + ":" + deviceId;
	}

}