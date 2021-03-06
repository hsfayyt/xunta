package com.cc.notes.PersonalCenter;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.notes.cc.notes.R;


public class EditInformationActivity extends AppCompatActivity {
    private Toolbar mEditToolbar;
    private RelativeLayout mEditPortraitlayout;
    private RelativeLayout mEditManifestolayout;
    private RelativeLayout mEditNamelayout;
    private TextView mEditNametext;
    private TextView mEditName;
    private RelativeLayout mEditSexlayout;
    private TextView mEditSextext;
    private TextView mEditSex;
    private RelativeLayout mEditBirthdaylayout;
    private TextView mEditBirthdaytext;
    private TextView mEditBirthday;
    private RelativeLayout mEditHeightlayout;
    private TextView mEditHeighttext;
    private TextView mEditHeight;
    private RelativeLayout mEditOccupationlayout;
    private TextView mEditOccupationtext;
    private TextView mEditOccupation;
    private RelativeLayout mEditSitelayout;
    private TextView mEditSitetext;
    private TextView mEditSite;
    private RelativeLayout mEditIntroducelayout;
    private TextView mEditIntroducetext;
    private Button mSaveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_information);
        mEditToolbar = (Toolbar) findViewById(R.id.edit_toolbar);
        mEditToolbar = (Toolbar) findViewById(R.id.edit_toolbar);
        mEditPortraitlayout = (RelativeLayout) findViewById(R.id.edit_portraitlayout);
        mEditManifestolayout = (RelativeLayout) findViewById(R.id.edit_manifestolayout);
        mEditNamelayout = (RelativeLayout) findViewById(R.id.edit_namelayout);
        mEditNametext = (TextView) findViewById(R.id.edit_nametext);
        mEditName = (TextView) findViewById(R.id.edit_name);
        mEditSexlayout = (RelativeLayout) findViewById(R.id.edit_sexlayout);
        mEditSextext = (TextView) findViewById(R.id.edit_sextext);
        mEditSex = (TextView) findViewById(R.id.edit_sex);
        mEditBirthdaylayout = (RelativeLayout) findViewById(R.id.edit_birthdaylayout);
        mEditBirthdaytext = (TextView) findViewById(R.id.edit_birthdaytext);
        mEditBirthday = (TextView) findViewById(R.id.edit_birthday);
        mEditHeightlayout = (RelativeLayout) findViewById(R.id.edit_heightlayout);
        mEditHeighttext = (TextView) findViewById(R.id.edit_heighttext);
        mEditHeight = (TextView) findViewById(R.id.edit_height);
        mEditOccupationlayout = (RelativeLayout) findViewById(R.id.edit_occupationlayout);
        mEditOccupationtext = (TextView) findViewById(R.id.edit_occupationtext);
        mEditOccupation = (TextView) findViewById(R.id.edit_occupation);
        mEditSitelayout = (RelativeLayout) findViewById(R.id.edit_sitelayout);
        mEditSitetext = (TextView) findViewById(R.id.edit_sitetext);
        mEditSite = (TextView) findViewById(R.id.edit_site);
        mEditIntroducelayout = (RelativeLayout) findViewById(R.id.edit_introducelayout);
        mEditIntroducetext = (TextView) findViewById(R.id.edit_introducetext);
        mSaveButton = (Button) findViewById(R.id.save_button);

        /*
         * 设置标题为空
         * */
        mEditToolbar.setTitle("");
        /*
         * 为toolbar设置返回
         * */
        setSupportActionBar(mEditToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mEditToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /*
        * 点击跳转更换头像界面
        * */
        mEditPortraitlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent =new Intent(EditInformationActivity.this,PersonalHomeActivity.class);
////                startActivity(intent);
            }
        });

        /*
         * 点击修改交友宣言
         * */
        mEditManifestolayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(EditInformationActivity.this,ChangeManifestoActivity.class);
                startActivity(intent);
            }
        });

        /*
        * 点击修改昵称
        * */
        mEditNamelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeName();
            }
        });

        /*
         * 点击修改性别
         * */
        mEditSexlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSex();
            }
        });

        /*
        * 点击修改出生日期
        * */
        mEditBirthdaylayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(EditInformationActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        mEditBirthday.setText(String.format("%d-%d-%d",year,monthOfYear+1,dayOfMonth));
                    }
                },2000,1,2).show();
            }
        });

        /*
         * 点击修改身高
         * */
        mEditHeightlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changHight();
            }
        });

        /*
         * 点击修改职业
         * */
        mEditOccupationlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changOccupation();
            }
        });

        /**
         * 点击修改城市
         * */
        mEditSitelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    /*
    * 修改昵称
    * */
    public void changeName(){
        final AlertDialog.Builder alertDialogname = new AlertDialog.Builder(this);
        final View view = View.inflate(this, R.layout.activity_alter_dialog, null);
        final EditText mDialogText;
        mDialogText = (EditText)view.findViewById(R.id.dialog_text);

        alertDialogname
                .setTitle("修改昵称")
                .setIcon(R.drawable.nicheng)
                .setView(view)
                /*
                 * 点击取确定按钮
                 * */
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加确定按钮
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(mDialogText.getText().toString().trim().equals("")||mDialogText.getText().toString().length() == 0){
                            Toast.makeText(EditInformationActivity.this, "昵称不能为空！请重新输入" , Toast.LENGTH_SHORT).show();
                        }else{
                            mEditName.setText(mDialogText.getText().toString());
                            Toast.makeText(EditInformationActivity.this, "昵称修改成功："  + mDialogText.getText().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {//添加取消
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(EditInformationActivity.this, "已取消", Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        alertDialogname.show();
    }

    /*
    * 修改性别
    * */
    public void changeSex(){
        final String[] sex = new String[]{"男", "女"};//创建item
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("修改您的性别")
                .setIcon(R.drawable.xingbie)
                .setItems(sex, new DialogInterface.OnClickListener() {//添加列表
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mEditSex.setText(sex[i]);
                        Toast.makeText(EditInformationActivity.this, "修改成功：" + sex[i], Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        alertDialog.show();
    }

    /*
    * 修改身高方法
    * */
    public void changHight(){
        final AlertDialog.Builder alertDialogname = new AlertDialog.Builder(this);
        final View view = View.inflate(this, R.layout.activity_alter_dialog, null);
        final EditText mDialogText;
        mDialogText = (EditText)view.findViewById(R.id.dialog_text);
        mDialogText.setInputType(InputType.TYPE_CLASS_NUMBER); //设置只能输入数字
        mDialogText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)}); //设置输入长度限制，为3
        alertDialogname
                .setTitle("修改您身高")
                .setIcon(R.drawable.shengao)
                .setView(view)
                /*
                 * 点击取确定按钮
                 * */
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加确定按钮
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                            mEditHeight.setText(mDialogText.getText().toString()+" cm");
                            Toast.makeText(EditInformationActivity.this, "身高修改成功："  + mDialogText.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {//添加取消
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(EditInformationActivity.this, "已取消", Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        alertDialogname.show();
    }


    /*
     * 修改职业方法
     * */
    public void changOccupation(){
        final String[] occupation = new String[]{"IT : 计算机/互联网/通信", "制造 ：生产/工艺/制造", "金融 ：金融/银行/投资/保险",
                "文化 ：文化/广告/传媒", "艺术 ：娱乐/艺术/表演", "法律 ：法律/法务", "教育 ：教育/培训", "行政 ：公务员/行政/事业单位",
                "模特", "空姐", "学生 ", "其他职业"};//创建item
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("修改您的职业")
                .setIcon(R.drawable.zhiye)
                .setItems(occupation, new DialogInterface.OnClickListener() {    //添加列表
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mEditOccupation.setText(occupation[i]);
                        Toast.makeText(EditInformationActivity.this, "职业修改成功：" + occupation[i], Toast.LENGTH_SHORT).show();
                    }
                })
                .create();
        alertDialog.show();
    }

    

}
