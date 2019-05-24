// Generated code from Butter Knife. Do not modify!
package com.schandorf.elmenorah.Activities;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class AboutActivity$$ViewInjector {
  public static void inject(Finder finder, final com.schandorf.elmenorah.Activities.AboutActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624085, "field 'aboutTextView'");
    target.aboutTextView = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131624086, "field 'shareApp' and method 'onClick'");
    target.shareApp = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick();
        }
      });
  }

  public static void reset(com.schandorf.elmenorah.Activities.AboutActivity target) {
    target.aboutTextView = null;
    target.shareApp = null;
  }
}
