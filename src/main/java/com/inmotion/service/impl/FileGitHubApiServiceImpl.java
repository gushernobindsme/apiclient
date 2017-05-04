package com.inmotion.service.impl;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * GitHubのAPIからデータを取得し、ファイルに出力するためのサービス。
 * <p>
 * ファイルは実行したプログラムと同じディレクトリに出力されます。<br>
 * ファイル名は「GitHubIssues_yyyyMMddHHmmss.txt」の形式で出力されます。
 * </p>
 *
 * @author eratakumi
 */
public class FileGitHubApiServiceImpl extends SimpleGitHubApiServiceImpl {

	@Override
	public void write(final String result) {
		// ファイル名を生成
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		final String fileName = "GitHubIssues_" + simpleDateFormat.format(Calendar.getInstance().getTime()) + ".txt";

		// ファイルに書き込み
		try (final BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileName), StandardCharsets.UTF_8);
			final PrintWriter pw = new PrintWriter(bw, false)) {
			pw.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(Paths.get(fileName).toAbsolutePath().toString() + "に保存しました。");
	}

}
