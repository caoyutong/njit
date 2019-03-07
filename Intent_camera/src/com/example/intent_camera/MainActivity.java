package com.example.intent_camera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    final static int CAMERA_RESULT = 0;//����һ����������������
    private Button button;//����һ��Button����
    private ImageView imageView;//����һ��ImageView����

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//���ز����ļ�
        button = (Button) findViewById(R.id.button);//��ȡ�����ֹ�������Button�ؼ�
        imageView = (ImageView) findViewById(R.id.imageView);//��ȡ�����ֹ�������ImageView�ؼ�
        //��Ӱ�ť����¼�������
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//ʵ����Intent����,ʹ��MediaStore��ACTION_IMAGE_CAPTURE��������ϵͳ���
                startActivityForResult(intent, CAMERA_RESULT);//������������������Intent����
            }
        });

    }

    /**
     * ��onActivityResult()���մ��ص�ͼ�񣬵��û�������Ƭ������ȡ����ϵͳ��������������
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, intent);
        if(resultCode==RESULT_OK){
            Bundle extras=intent.getExtras();//��Intent�л�ȡ����ֵ
            Bitmap bitmap=(Bitmap) extras.get("data");//�Ӹ���ֵ�л�ȡ���ص�ͼ��
            imageView.setImageBitmap(bitmap);//��ʾͼ��
        }
    }
}

