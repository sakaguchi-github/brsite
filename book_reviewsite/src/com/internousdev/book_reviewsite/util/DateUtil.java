package com.internousdev.book_reviewsite.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	//実行の日付を引数の部分で設定した形で表示するように設定
	public String getDate(){
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy/MM/dd HH:mm:ss");

		//設定したフォーマットで日付情報を返す
		return simpleDateFormat.format(date);
	}

}