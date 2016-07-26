package com.xpower.android5preview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.xpower.android5preview.R;

/**
 * Created by 4399-3040 on 2016/7/21.
 */
public class TextInputLayoutActivity extends AppCompatActivity {

    private TextInputLayout mTextInputAccount, mTextInputPw;
    private EditText mEtAccout, mEtPassword;
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_layout);

        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mTextInputAccount = (TextInputLayout) findViewById(R.id.text_input_layout_account);
        mTextInputPw = (TextInputLayout) findViewById(R.id.text_input_layout_pw);
        mEtAccout = (EditText) findViewById(R.id.text_input_et_account);
        mEtPassword = (EditText) findViewById(R.id.text_input_et_pw);

        mToolBar.setTitle(getResources().getStringArray(R.array.widget_list)[2]);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mEtAccout.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() < 4) {
                    mTextInputAccount.setError("账号长度不得小于4位");
                    mTextInputAccount.setErrorEnabled(true);
                } else {
                    mTextInputAccount.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mEtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() < 4) {
                    mTextInputPw.setError("账号长度不得小于4位");
                    mTextInputPw.setErrorEnabled(true);
                } else {
                    mTextInputPw.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
