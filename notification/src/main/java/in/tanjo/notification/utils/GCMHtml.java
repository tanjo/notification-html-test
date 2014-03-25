package in.tanjo.notification.utils;

import android.text.Html;
import android.text.Spanned;

import java.util.regex.Pattern;

public class GCMHtml {

  public static Spanned fromHtml(String source) {
    String fix_source = replaceAll("<blockquote>|</blockquote>", "", source);
    return Html.fromHtml(fix_source);
  }

  /**
   * 大文字小文字を区別せずにreplaceAll
   * @param regex 検索対象文字列
   * @param reql 置換後文字列
   * @param text 置換対象文字列
   * @return
   */
  public static String replaceAll(String regex, String reql, String text) {
    String retStr = "";
    retStr = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(text).replaceAll(reql);
    return retStr;
  }
}
