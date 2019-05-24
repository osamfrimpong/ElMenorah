// Generated code from Butter Knife. Do not modify!
package com.schandorf.elmenorah.Activities;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class LoginActivity$$ViewInjector {
  public static void inject(Finder finder, final com.schandorf.elmenorah.Activities.LoginActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624104, "field 'message'");
    target.message = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131624105, "field 'username'");
    target.username = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131624106, "field 'loginpassword'");
    target.loginpassword = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131624107, "field 'login' and method 'onClick'");
    target.login = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624108, "field 'clickToSignup' and method 'onClick'");
    target.clickToSignup = (android.widget.TextView) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
  }

  public static void reset(com.schandorf.elmenorah.Activities.LoginActivity target) {
    target.message = null;
    target.username = null;
    target.loginpassword = null;
    target.login = null;
    target.clickToSignup = null;
  }
}
