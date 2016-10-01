package com.ddkfang.constant;

public class HttpStatusConstant {

	public static enum userAccount {
		ok("操作成功", "A00000"), accountNotExist("账户不存在", "A10001"), vcodeError("验证码错误或过期", "A10002"), passwdError("密码错误,请尝试找回", "A10003"),
		oldPasswdError("旧密码不正确,请重试", "A10004");
		private String msg;
		private String code;
		
		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		private userAccount (String msg, String code) {
			this.msg = msg;
			this.code = code;
		}
	}
	
	public static enum roomStatus {
		ok("操作成功", "A00000"), roomNotExist("不存在该房源", "A10001"), roomNotAvalibale("房源状态有误", "A10002");
		private String msg;
		private String code;
		
		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		private roomStatus (String msg, String code) {
			this.msg = msg;
			this.code = code;
		}
	}
}
