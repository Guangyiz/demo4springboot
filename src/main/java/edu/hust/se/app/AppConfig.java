package edu.hust.se.app;

import org.springframework.context.annotation.Configuration;

/**
 *app全局配置，以后可以放到数据库中
 */
public enum AppConfig {

	WECHAT_WALK("wechatWalk20200406", "", "");
	
	private String serverId;
	private String appId;
	private String appSecret;
	
	
	private AppConfig(String serverId, String appId, String appSecret) {
		this.serverId = serverId;
		this.appId = appId;
		this.appSecret = appSecret;
	}

	public static String getAppId(String serverId) {
		if (AppConfig.WECHAT_WALK.getServerId().equals(serverId)) {
			return AppConfig.WECHAT_WALK.getAppId();

		}

		return null;
	}

	public static AppConfig getInstance(String serverId) {
		if (AppConfig.WECHAT_WALK.getServerId().equals(serverId)) {
			return AppConfig.WECHAT_WALK;
		}

		return null;
	}

	public static AppConfig getInstanceByAppid(String appId) {
		if (AppConfig.WECHAT_WALK.getAppId().equals(appId)) {
			return AppConfig.WECHAT_WALK;
		}

		return null;
	}

	public String getServerId() {
		return serverId;
	}

	public String getAppId() {
		return appId;
	}

	public String getAppSecret() {
		return appSecret;
	}
	
}
