package com.example.kk.blanceaccount;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import base.BaseActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class CreateExcelActivity extends BaseActivity {
    @Bind(R.id.a1)
    EditText a1;
    @Bind(R.id.a2)
    EditText a2;

    @Bind(R.id.a3)
    EditText a3;
    @Bind(R.id.a4)
    EditText a4;
    @Bind(R.id.a5)
    EditText a5;
    @Bind(R.id.a6)
    EditText a6;
    @Bind(R.id.a7)
    EditText a7;
    @Bind(R.id.a8)
    EditText a8;
    @Bind(R.id.a9)
    EditText a9;
    @Bind(R.id.a10)
    EditText a10;
    @Bind(R.id.a11)
    EditText a11;
    @Bind(R.id.a12)
    EditText a12;
    @Bind(R.id.a13)
    EditText a13;
    @Bind(R.id.a14)
    EditText a14;
    @Bind(R.id.a15)
    EditText a15;
    @Bind(R.id.a16)
    EditText a16;
    @Bind(R.id.a17)
    EditText a17;
    @Bind(R.id.a18)
    EditText a18;
    @Bind(R.id.a19)
    EditText a19;
    @Bind(R.id.a20)
    EditText a20;
    @Bind(R.id.a21)
    EditText a21;
    @Bind(R.id.a22)
    EditText a22;
    @Bind(R.id.a23)
    EditText a23;
    @Bind(R.id.a24)
    EditText a24;
    @Bind(R.id.a25)
    EditText a25;
    @Bind(R.id.a26)
    EditText a26;
    @Bind(R.id.a27)
    EditText a27;
    @Bind(R.id.a28)
    EditText a28;
    @Bind(R.id.a29)
    EditText a29;
    @Bind(R.id.a30)
    EditText a30;
    @Bind(R.id.a31)
    EditText a31;
    @Bind(R.id.a32)
    EditText a32;
    @Bind(R.id.a33)
    EditText a33;
    @Bind(R.id.a34)
    EditText a34;
    @Bind(R.id.a35)
    EditText a35;
    @Bind(R.id.a36)
    EditText a36;
    @Bind(R.id.a37)
    EditText a37;
    @Bind(R.id.a38)
    EditText a38;
    @Bind(R.id.a39)
    EditText a39;
    @Bind(R.id.a40)
    EditText a40;

    @Bind(R.id.btn_execute)
    Button btnExecute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_excel);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_execute)
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_execute:
                printer();
                break;
        }
    }

    /**
     * 为了保证模板的可用，最好在现有的模板上复制后修改
     */
    private void printer() {
        try {
            saveFile("radiate1.xls", this, R.raw.radiate1);//文件目录res/raw
            //现场检查记录
            Log.e("ooo","aaa");
            String aafileurl = getExternalFilesDir(null).getPath() + "/inspection/radiate1.xls";
            String bbfileurl =getExternalFilesDir(null).getPath() + "/inspection/radiate1_printer.xls";
            Workbook rwb = Workbook.getWorkbook(new File(aafileurl));
            WritableWorkbook wwb = Workbook.createWorkbook(new File(bbfileurl), rwb);// copy
            WritableSheet wws = wwb.getSheet(0);

            /**
             * 按照单元格的（列，行 ）
             * */
            WritableCell wc1_2 = wws.getWritableCell(1, 2);
            WritableCell wc1_3 = wws.getWritableCell(1, 3);
            WritableCell wc1_4 = wws.getWritableCell(1, 4);
            WritableCell wc1_5 = wws.getWritableCell(1, 5);
            WritableCell wc1_6 = wws.getWritableCell(1, 6);
            WritableCell wc1_7 = wws.getWritableCell(1, 7);
            WritableCell wc1_8 = wws.getWritableCell(1, 8);
            WritableCell wc1_9 = wws.getWritableCell(1, 9);
            WritableCell wc1_10 = wws.getWritableCell(1, 10);
            WritableCell wc1_11 = wws.getWritableCell(1, 11);
            WritableCell wc1_12 = wws.getWritableCell(1, 12);
            WritableCell wc1_13 = wws.getWritableCell(1, 13);
            WritableCell wc1_14 = wws.getWritableCell(1, 14);
            WritableCell wc1_15 = wws.getWritableCell(1, 15);
            WritableCell wc1_16 = wws.getWritableCell(1, 16);


            WritableCell wc4_10 = wws.getWritableCell(4, 10);
            WritableCell wc4_11 = wws.getWritableCell(4, 11);
            WritableCell wc4_12 = wws.getWritableCell(4, 12);
            WritableCell wc5_5 = wws.getWritableCell(5, 5);
            WritableCell wc5_6 = wws.getWritableCell(5, 6);
            WritableCell wc6_13 = wws.getWritableCell(6, 13);
            WritableCell wc7_10 = wws.getWritableCell(7, 10);
            WritableCell wc7_11 = wws.getWritableCell(7, 11);

            WritableCell wc10_10 = wws.getWritableCell(10, 10);
            WritableCell wc10_11 = wws.getWritableCell(10, 11);
            WritableCell wc13_10 = wws.getWritableCell(13, 10);
            WritableCell wc16_10 = wws.getWritableCell(16, 10);

            WritableCell wc8_12 = wws.getWritableCell(8, 12);
            WritableCell wc16_12 = wws.getWritableCell(16, 12);

            WritableCell wc16_11 = wws.getWritableCell(16, 11);

            WritableCell wc13_13 = wws.getWritableCell(13, 13);
            WritableCell wc13_14 = wws.getWritableCell(13, 14);


            WritableCell wc14_8 = wws.getWritableCell(14, 8);
            WritableCell wc10_9 = wws.getWritableCell(10, 9);

            WritableCell wc11_5 = wws.getWritableCell(11, 5);

            WritableCell wc14_2 = wws.getWritableCell(14, 2);
            WritableCell wc14_3 = wws.getWritableCell(14, 3);
            WritableCell wc14_4 = wws.getWritableCell(14, 4);

            /**
             * 设置表单的值
             */

            Label label5_5 = (Label) wc5_5;
            label5_5.setString("非例行＿＿"+a9.getText().toString()+"＿＿");

            Label label5_6 = (Label) wc5_6;
            label5_6.setString(a12.getText().toString());

            Label label14_2 = (Label) wc14_2;
            label14_2.setString(a3.getText().toString());
            Label label14_3 = (Label) wc14_3;
            label14_3.setString(a5.getText().toString());
            Label label14_4 = (Label) wc14_4;
            label14_4.setString(a7.getText().toString());

            Label label11_5 = (Label) wc11_5;
            label11_5.setString("是否联合检查＿"+a10.getText().toString());

            Label label14_8 = (Label) wc14_8;
            label14_8.setString(a15.getText().toString());
            Label label10_9 = (Label) wc10_9;
            label10_9.setString("125I、131I、18F、99mTc、3H、32P、"+a17.getText().toString());
            Label label13_14 = (Label) wc13_14;
            label13_14.setString(a37.getText().toString());

            Label label13_13 = (Label) wc13_13;
            label13_13.setString(a35.getText().toString()+"  人");
            Label label16_11 = (Label) wc16_11;
            label16_11.setString(a32.getText().toString()+"  人");

            Label label8_12 = (Label) wc8_12;
            label8_12.setString("初级培训  "+a31.getText().toString()+"  人");
            Label label16_12 = (Label) wc16_12;
            label16_12.setString(a32.getText().toString()+"  人");

            Label label10_10 = (Label) wc10_10;
            label10_10.setString("Ⅲ类 "+a21.getText().toString()+"  枚");
            Label label10_11 = (Label) wc10_11;
            label10_11.setString("Ⅲ类 "+a27.getText().toString()+"   台");
            Label label13_10 = (Label) wc13_10;
            label13_10.setString("Ⅳ类 "+a22.getText().toString()+"  枚");
            Label label16_10 = (Label) wc16_10;
            label16_10.setString("Ⅴ类 "+a23.getText().toString()+"  枚");

            Label label7_10 = (Label) wc7_10;
            label7_10.setString("Ⅱ类 "+a20.getText().toString()+"  枚");
            Label label7_11 = (Label) wc7_11;
            label7_11.setString("Ⅱ类 "+a26.getText().toString()+"   台");

            Label label6_13 = (Label) wc6_13;
            label6_13.setString(a34.getText().toString()+"  人");

            Label label4_10 = (Label) wc4_10;
            label4_10.setString("Ⅰ类 "+a19.getText().toString()+"  枚");
            Label label4_11 = (Label) wc4_11;
            label4_11.setString("Ⅰ类 "+a25.getText().toString()+"   台");
            Label label4_12 = (Label) wc4_12;
            label4_12.setString("中级培训  "+a30.getText().toString()+"  人");



            Label label1_2 = (Label) wc1_2;
            label1_2.setString(a2.getText().toString());
            Label label1_3 = (Label) wc1_3;
            label1_3.setString(a4.getText().toString());
            Label label1_4 = (Label) wc1_4;
            label1_4.setString("环辐证[ "+a6.getText().toString()+"  ]");
            Label label1_5 = (Label) wc1_5;
            label1_5.setString("例行 年度第  "+a8.getText().toString()+" 次");
            Label label1_6 = (Label) wc1_6;
            label1_6.setString(a11.getText().toString()+" 处");
            Label label1_7 = (Label) wc1_7;
            label1_7.setString(a13.getText().toString());
            Label label1_8 = (Label) wc1_8;
            label1_8.setString(a14.getText().toString());
            Label label1_9 = (Label) wc1_9;
            label1_9.setString(a16.getText().toString());
            Label label1_10 = (Label) wc1_10;
            label1_10.setString("共  "+a18.getText().toString()+"  枚");
            Label label1_11 = (Label) wc1_11;
            label1_11.setString("共 "+a24.getText().toString()+"   台");
            Label label1_12 = (Label) wc1_12;
            label1_12.setString("共 "+a29.getText().toString()+"   人");
            Label label1_13 = (Label) wc1_13;
            label1_13.setString(a33.getText().toString());
            Label label1_14 = (Label) wc1_14;
            label1_14.setString(a36.getText().toString());
            Label label1_15 = (Label) wc1_15;
            label1_15.setString(a38.getText().toString());
            Label label1_16 = (Label) wc1_16;
            label1_16.setString("检查人员签字：    " +a39.getText().toString()+
                    "                    被检查单位签字：    "+a40.getText().toString());



            wwb.write();
            wwb.close();
            rwb.close();
            Intent intent=new Intent(this,OpenExcelActivity.class);


            intent.putExtra("path",bbfileurl);
            startActivity(intent);
            Toast.makeText(this,"保存成功", Toast.LENGTH_SHORT).show();

            //以下代码是连接打印机的，这边没有用到，所以可以忽略


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    /**
     * 将文件复制到SD卡，并返回该文件对应的数据库对象
     *
     * @return
     * @throws IOException
     */
    public void saveFile(String fileName, Context context, int rawid) throws IOException {

        // 首先判断该目录下的文件夹是否存在
        File dir = new File(context.getExternalFilesDir(null).getPath() + "/inspection/");
        if (!dir.exists()) {
            // 文件夹不存在 ， 则创建文件夹
            dir.mkdirs();
        }

        // 判断目标文件是否存在
        File file1 = new File(dir, fileName);

        if (!file1.exists()) {
            file1.createNewFile(); // 创建文件

        }
        // 开始进行文件的复制
        InputStream input = context.getResources().openRawResource(rawid); // 获取资源文件raw
        // 标号
        try {

            FileOutputStream out = new FileOutputStream(file1); // 文件输出流、用于将文件写到SD卡中
            // -- 从内存出去
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = (input.read(buffer))) != -1) { // 读取文件，-- 进到内存

                out.write(buffer, 0, len); // 写入数据 ，-- 从内存出
            }

            input.close();
            out.close(); // 关闭流
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    protected void findWidgets() {

    }

    @Override
    protected void initComponent() {

    }
}
