package com.inmotion.service;

/**
 * APIから情報を取得するためのサービスインタフェース。
 * <p>
 * 入出力の手段を追加したい場合は、本インタフェースを実装してください。
 * </p>
 *
 * @author eratakumi
 */
public interface ApiServiceInterface {

	/**
	 * データを取得する。
	 *
	 * @return String
	 */
	String read();

	/**
	 * 取得したデータを出力する。
	 */
	void write(final String result);

}
