package com.m520it.www.two;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by xmg on 2017/3/3.
 */

public class TextInputLayoutActivity extends AppCompatActivity {
    EditText mEditText;

    TextInputLayout input;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textinputlayout);
        input = (TextInputLayout) findViewById(R.id.text_input);
        input.setError("aaaaaaaaaaaaaaaaaaaaaa");
//        mEditText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//               String content = editable.toString();
//            }
//        });
    }
}
