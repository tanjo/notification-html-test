package in.tanjo.notification.activity;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;
import java.util.List;

import in.tanjo.notification.utils.GCMHtml;
import in.tanjo.notification_test.notification.R;

public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_activity);
    bind();
  }

  @Override
  public void finish() {
    if (!isFinishing()) {
      super.finish();
    }
  }

  private void bind() {
    List<View.OnClickListener> listeners = Arrays.asList(
        mBrTag, mPTag, mDivTag, mBTag, mEmTag, mITag, mStrongTag, mCiteTag, mDfnTag, mBigTag, mSmallTag, mFontTag, mBlockquoteTag,
        mTtTag, mATag, mUTag, mSupTag, mSubTag, mH1Tag, mH2Tag, mH3Tag, mH4Tag, mH5Tag, mH6Tag, mImgTag, mCodeTag, mPreTag, mHrTag);
    List<Integer> viewIds;
    viewIds = Arrays.asList(
        R.id.tag_br, R.id.tag_p, R.id.tag_div, R.id.tag_b, R.id.tag_em, R.id.tag_i, R.id.tag_strong, R.id.tag_cite, R.id.tag_dfn, R.id.tag_big, R.id.tag_small, R.id.tag_font, R.id.tag_blockquote,
        R.id.tag_tt, R.id.tag_a, R.id.tag_u, R.id.tag_sup, R.id.tag_sub, R.id.tag_h1, R.id.tag_h2, R.id.tag_h3, R.id.tag_h4, R.id.tag_h5, R.id.tag_h6, R.id.tag_img, R.id.tag_code, R.id.tag_pre, R.id.tag_hr);

    for (int i = 0; i < listeners.size(); i++) {
      Button button = (Button) findViewById(viewIds.get(i));
      button.setOnClickListener(listeners.get(i));
    }

  }

  private void showNotification(String text) {
    NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
    NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
    builder.setSmallIcon(R.drawable.ic_launcher);
    builder.setContentTitle(GCMHtml.fromHtml(text));
    builder.setContentText(GCMHtml.fromHtml(text));
    builder.setTicker(GCMHtml.fromHtml(text));
    bigTextStyle.setBigContentTitle(GCMHtml.fromHtml(text));
    bigTextStyle.setSummaryText(GCMHtml.fromHtml(text));
    bigTextStyle.bigText(GCMHtml.fromHtml(text));
    builder.setStyle(bigTextStyle);
    builder.setAutoCancel(true);
    Intent intent = new Intent(this, MainActivity.class);
    PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
    builder.setContentIntent(pendingIntent);
    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    try {
      notificationManager.notify("NOTIFICATION_TEST", 1, builder.build());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private View.OnClickListener mBrTag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("aaa<br>aaa");
    }
  };

  private View.OnClickListener mPTag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("<p>aaaa\naaa\naaaa</p>");
    }
  };

  private View.OnClickListener mDivTag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("div<div>div</div>");
    }
  };

  private View.OnClickListener mBTag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("<b>B</b>");
    }
  };

  private View.OnClickListener mEmTag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("<em>em</em>");
    }
  };

  private View.OnClickListener mITag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("<i>i</i>");
    }
  };

  private View.OnClickListener mStrongTag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("<strong>strong</strong>");
    }
  };

  private View.OnClickListener mCiteTag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("<cite>cite</cite>");
    }
  };

  private View.OnClickListener mDfnTag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("<dfn>dfn</dfn>");
    }
  };

  private View.OnClickListener mBigTag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("<big>big</big>");
    }
  };

  private View.OnClickListener mSmallTag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("<small>small</small>");
    }
  };

  private View.OnClickListener mFontTag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("<font color=\"Yellow\" face=\"Impact\">font</font>");
    }
  };

  private View.OnClickListener mBlockquoteTag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("<blockquote>blockquote</blockquote>");
    }
  };

  private View.OnClickListener mTtTag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("<tt>tt</tt>");
    }
  };

  private View.OnClickListener mATag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("<a href=\"https://www.google.com/\">Google</a>");
    }
  };

  private View.OnClickListener mUTag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("<u>u</u>");
    }
  };

  private View.OnClickListener mSupTag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("sup<sup>sup</sup>");
    }
  };

  private View.OnClickListener mSubTag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("sub<sub>sub</sub>");
    }
  };

  private View.OnClickListener mH1Tag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("<h1>h1</h1>");
    }
  };

  private View.OnClickListener mH2Tag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("<h2>h2</h2>");
    }
  };

  private View.OnClickListener mH3Tag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("<h3>h3</h3>");
    }
  };

  private View.OnClickListener mH4Tag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("<h4>h4</h4>");
    }
  };

  private View.OnClickListener mH5Tag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("<h5>h5</h5>");
    }
  };

  private View.OnClickListener mH6Tag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("<h6>h6</h6>");
    }
  };

  private View.OnClickListener mImgTag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      // cannot show image
      showNotification("<img src=\"http://www.messentools.com/images/emoticones/android/www.MessenTools.com-Android-03.png\" >");
    }
  };

  private View.OnClickListener mCodeTag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("<code>code</code>");
    }
  };

  private View.OnClickListener mPreTag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("<pre>pre</pre>");
    }
  };

  private View.OnClickListener mHrTag = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      showNotification("hr<hr>hr");
    }
  };

}
