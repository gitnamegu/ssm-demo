package pers.pole.common;

public enum EnumUtil {
	
	success(200,"成功"),
	error(400,"失败");

	private int code;
	private String desc;
	private EnumUtil(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
