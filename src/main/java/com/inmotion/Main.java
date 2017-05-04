package com.inmotion;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.inmotion.controller.GitHubApiController;
import com.inmotion.controller.GitHubApiToFileController;

/**
 * Jersey Clientを起動するためのクライアント。
 * <p>
 * GitHubAPIからデータを取得し、コンソールまたはファイルに出力します。<br>
 * どちらに出力するかは、起動時の引数により設定可能です(未入力の場合はコンソールに出力します)。<br>
 * 設定可能な引数は下記の通りです。
 * </p>
 * <ul>
 * <li>C・・・コンソール出力</li>
 * <li>F・・・ファイル出力</li>
 * </ul>
 *
 * @author eratakumi
 */
public class Main {

	/**
	 * エントリポイント。
	 *
	 * @param args
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public static void main(String args[]) {
		if(args.length == 0 || StringUtils.equals(args[0], "C")){
		    new GitHubApiController().run();
		}else if(StringUtils.equals(args[0], "F")){
			new GitHubApiToFileController().run();
		}else{
			throw new IllegalArgumentException("argument is not valid.");
		}
	}
}
