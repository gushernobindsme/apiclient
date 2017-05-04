package com.inmotion.controller;

import com.inmotion.service.impl.SimpleGitHubApiServiceImpl;

/**
 * GitHubのAPIからデータを取得し、標準出力するためのコントローラ。
 *
 * @author eratakumi
 */
public class GitHubApiController extends AbstractApiController{

    public GitHubApiController() {
		super();
		this.service = new SimpleGitHubApiServiceImpl();
	}

}