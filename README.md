Notification Html Tag Test
=================

Android Notification Service Test with Html Tag

## 概要
HTML タグがどのように表示されるのかを Android Notification で確認するプログラム

## GCMHtml.java

  - fromHtml
  
    命名をミスったが 文字列から ```Spanned``` を返すメソッド.
    あえて ```blockquote``` タグを避けているのは Galaxy S3α で通知が壊れる事象が発生したから.


## 試すタグ

  基本的に ```NotificationCompat.Builder``` の書くセッターに追加したときに処理されるタグのみ検証する
  これ以外のタグは基本的に処理されない

  > br, p, div, b, em, i, strong, cite, dfn, big, small, font, blockquote, 
    tt, a, u, sup, sub, h1, h2, h3, h4, h5, h6, img, code, pre, hr
  
