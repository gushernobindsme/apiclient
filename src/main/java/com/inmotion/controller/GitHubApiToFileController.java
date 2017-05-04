package com.inmotion.controller;

import com.inmotion.service.impl.FileGitHubApiServiceImpl;

/**
 * GitHubのAPIからデータを取得し、ファイルに出力するためのコントローラ。
 *
 * @author eratakumi
 */
public class GitHubApiToFileController extends AbstractApiController{

    public GitHubApiToFileController() {
		super();
		this.service = new FileGitHubApiServiceImpl();
	}

}