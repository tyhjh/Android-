package com.yorhp.getpermissions.view;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yorhp.getpermissions.R;
import com.yorhp.getpermissions.app.BaseActivity;

public class MainActivity extends BaseActivity {
    static final String[] PERMISSIONS={
            Manifest.permission.CAMERA,
            Manifest.permission.SEND_SMS
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button= (Button) findViewById(R.id.btn_1);
        setPermissions(PERMISSIONS);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermission();
            }
        });

    }


    @Override
    protected void requestPermissionFail() {
        Toast.makeText(this,"获取权限失败",Toast.LENGTH_SHORT).show();
    }
}
