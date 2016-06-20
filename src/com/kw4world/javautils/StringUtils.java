package com.kw4world.javautils;

import java.util.ArrayList;
import java.util.List;

/**
 * 文字列ユーティリティクラス
 */
public class StringUtils {

	/**
	 * コンストラクタ
	 * 
	 * <pre>
	 * 静的メソッドだけなのでインスタンス化できないようにprivate
	 * </pre>
	 */
	private StringUtils() {
	}

	/**
	 * 文字列がNULLまたは空か判定する
	 * 
	 * @param str
	 *            文字列
	 * @return true:NULLまたは空 / false:文字あり
	 */
	public static boolean isEmpty(String str) {
		// NULLの場合true
		if (str == null) {
			return true;
		}
		// 文字数が0の場合true
		else if (str.length() <= 0) {
			return true;
		}

		// それ以外はfalse
		return false;
	}

	/**
	 * 文字列をそのまま返す。Nullの場合は空文字を返す
	 * 
	 * @param str
	 * @return
	 */
	public static String nullToEmpty(String str) {
		if (str == null) {
			return "";
		} else {
			return str;
		}
	}

	/**
	 * 文字列を大文字で分割する。大文字は先頭文字になる。
	 * 
	 * @param str
	 *            分割する文字列
	 * @return 分割した配列
	 */
	public static String[] splitUpper(String str) {
		// 文字列がNULLまたは空の場合は、空配列を返す
		if (isEmpty(str)) {
			return new String[0];
		}

		List<String> list = new ArrayList<String>();

		int upper = 0;

		// 1文字ずつ処理(先頭文字は何もしないので1から)
		for (int i = 1; i < str.length(); i++) {
			char c = str.charAt(i);

			// 大文字の場合
			if (Character.isUpperCase(c)) {
				list.add(str.substring(upper, i));
				upper = i;
			}
		}
		list.add(str.substring(upper, str.length()));

		// 配列にして返す
		return list.toArray(new String[0]);
	}

	/**
	 * 文字列をアンダーバー(_)で区切る
	 * 
	 * @param 分割する文字列
	 * @return 分割した配列
	 * 
	 * */
	public static String[] splitUnderBar(String str) {
		if (StringUtils.isEmpty(str)) {
			return new String[0];
		}

		List<String> list = new ArrayList<String>();

		// 文字列を見るポジション
		int pos = 0;

		// 1文字ずつ処理(先頭文字は何もしないので1から)
		for (int i = 1; i < str.length(); i++) {
			char c = str.charAt(i);

			// アンダーバーが見つかった場合
			if (c == '_') {
				// ポジション番目からiまでを抜き取る
				list.add(str.substring(pos, i));
				// 次の文字列取得開始位置を設定
				pos = i + 1;
			}
		}
		// 最後の部分を取得
		list.add(str.substring(pos, str.length()));

		// 配列にして返す
		return list.toArray(new String[0]);
	}

	/**
	 * 頭文字を大文字に変換して返します
	 * 
	 * @param str
	 *            変換する文字列
	 * @param 頭文字を大文字に変換した文字列
	 * */
	public static String upperInitials(String str) {
		String s = str.substring(0, 1).toUpperCase().concat(str.substring(1));
		return s;
	}

	/**
	 * 文字列からXML名を取得する
	 * 
	 * @param strs
	 *            文字列
	 * @return XML名
	 */
	public static String getXmlName(String str) {
		// 大文字で分割
		String[] strs = splitUpper(str);

		// 配列数が0の場合は空文字を返す
		if (strs.length <= 0) {
			return "";
		}

		StringBuilder buf = new StringBuilder();

		// 配列末尾を小文字にして文字列先頭に追加
		buf.append(strs[strs.length - 1].toLowerCase());

		// 配列先頭から配列末尾を小文字にして文字列に追加
		for (int i = 0; i < strs.length - 1; i++) {
			buf.append("_").append(strs[i].toLowerCase());
		}

		return buf.toString();
	}

	/**
	 * 文字列がDouble型であるかどうかを判定する
	 * 
	 * @param str
	 *            文字列
	 * @return true:double型 false:double型ではない
	 * 
	 * */
	public static boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
