package com.inmotion.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * GitHubのAPIのレスポンス情報。
 * <p>
 * レスポンスの仕様：<br>
 * https://developer.github.com/v3/issues/#response
 * </p>
 *
 * @author eratakumi
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class GitHubApiResponseDto {

	private String title;
	private String body;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}
