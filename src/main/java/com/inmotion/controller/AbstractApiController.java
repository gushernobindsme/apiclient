package com.inmotion.controller;

import com.inmotion.service.ApiServiceInterface;

/**
 * コントローラの抽象クラス。
 * <p>
 * 本クラスを継承し、任意のサービスをコンストラクタでインジェクションすることで、入出力の方法を追加できます。
 * </p>
 *
 * @author eratakumi
 */
public abstract class AbstractApiController {

	protected ApiServiceInterface service;

	/**
	 * 本処理。
	 * <p>
	 * APIからの情報の取得、出力を行う。
	 * </p>
	 */
	public void run() {
		// APIから情報を取得
		final String result = service.read();
		// 取得した情報を出力
		service.write(result);
    }
}
