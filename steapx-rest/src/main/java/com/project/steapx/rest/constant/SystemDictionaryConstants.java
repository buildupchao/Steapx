package com.project.steapx.rest.constant;

/**
 * 
 * Created by jangz on 6/8/18
 */
public enum SystemDictionaryConstants {

	PROJECT_STATUE(100),
	MEETING_STATUS(200),
	MATERIAL_TYPE(300),
	PICTURE_TYPE(400),
	DOMAIN_TYPE(500),
	INSTITUTION_TYPE(600);
	
	private Integer code;

	private SystemDictionaryConstants(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
/*	public static SystemDictionaryConstants from(Integer code) {
		SystemDictionaryConstants target = null;
		for (SystemDictionaryConstants value : SystemDictionaryConstants.values()) {
			if (Objects.equals(value.getCode(), code)) {
				target = value;
				break;
			}
		}
		return target;
	}*/
}
