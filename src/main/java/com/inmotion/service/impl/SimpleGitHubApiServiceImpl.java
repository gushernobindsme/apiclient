package com.inmotion.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inmotion.dto.GitHubApiResponseDto;
import com.inmotion.service.ApiServiceInterface;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * GitHubのAPIからデータを取得し、標準出力するためのサービス。
 * <p>
 * GitHubのISSUESからデータを取得し、title、bodyをタブ区切りで出力します。<br>
 * titleは先頭10文字、bodyは先頭30文字を出力します。
 * </p>
 *
 * @author eratakumi
 */
public class SimpleGitHubApiServiceImpl implements ApiServiceInterface {

	/** GitHubのISSUESを取得するAPIのURL */
	private static final String URL = "https://api.github.com/repos/spring-projects/spring-boot/issues";

	/** title:の文字数 */
	private static final int TITLE_SIZE = 10;

	/** body:の文字数 */
	private static final int BODY_SIZE = 30;

	@Override
	public String read() {
		// GitHubのAPIからデータを取得
		final Client client = Client.create();
		final WebResource resource = client.resource(URL);
		final String json = resource.get(String.class);

		// JSON -> Dtoにデシリアライズ
		final ObjectMapper mapper = new ObjectMapper();
		List<GitHubApiResponseDto> results = new ArrayList<GitHubApiResponseDto>();
		try {
			results = Arrays.asList(mapper.readValue(json, GitHubApiResponseDto[].class));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 整形
		final StringBuffer sb = new StringBuffer();
		for(final GitHubApiResponseDto dto : results){
			sb.append(StringUtils.substring(dto.getTitle(),0,TITLE_SIZE));
			sb.append("\t");
			sb.append(StringUtils.substring(
					StringUtils.replace(dto.getBody(),"\r\n","\\r\\n"),// 改行文字がそのまま出力されるようエスケープ
					0,BODY_SIZE));
			sb.append("\n");
		}

		return sb.toString();
	}

	@Override
	public void write(final String result) {
		System.out.println(result);
	}

}
