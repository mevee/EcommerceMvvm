package com.webkype.happiroo.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.webkype.happiroo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReferEarnActivity extends AppCompatActivity {

    private Context context;
    @BindView(R.id.referTxt_eT) EditText referTxt_eT;

    private ClipboardManager myClipboard;
    private ClipData myClip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refer_earn);
        context = ReferEarnActivity.this;
        ButterKnife.bind(this);

        myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);

        referTxt_eT.setText("CTAK11");
    }

    @OnClick({R.id.backReferEarn, R.id.whatsappicon, R.id.fbicon, R.id.twittericon,
            R.id.copy, R.id.instagramIcon, R.id.messengerIcon, R.id.skypeIcon, R.id.linkedInIcon,
            R.id.gmailIcon, R.id.messageIcon})
    void onClick(View view){
        switch (view.getId()){

            case R.id.backReferEarn:

                onBackPressed();

                break;

            case R.id.whatsappicon:

                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                whatsappIntent.setType("text/plain");
                whatsappIntent.setPackage("com.whatsapp");
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, referTxt_eT.getText().toString());
                try {
                    startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(this, "Whatsapp not installed", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.fbicon:

                Intent facebookintent = new Intent(Intent.ACTION_SEND);
                facebookintent.setType("text/plain");
                facebookintent.setPackage("com.facebook.katana");
                facebookintent.putExtra(Intent.EXTRA_TEXT, referTxt_eT.getText().toString());
                try {
                    startActivity(facebookintent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(this, "Facebook not installed", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.twittericon:

                Intent twittericon = new Intent(Intent.ACTION_SEND);
                twittericon.setType("text/plain");
                twittericon.setPackage("com.twitter.android");
                twittericon.putExtra(Intent.EXTRA_TEXT, referTxt_eT.getText().toString());
                try {
                    startActivity(twittericon);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(this, "Twitter not installed", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.copy:

                myClip = ClipData.newPlainText("text", referTxt_eT.getText().toString());
                myClipboard.setPrimaryClip(myClip);
                Toast.makeText(getApplicationContext(), "Copied to clipboard",
                        Toast.LENGTH_SHORT).show();

                break;

            case R.id.instagramIcon:

                Intent instaIntent = new Intent(Intent.ACTION_SEND);
                instaIntent.setType("text/plain");
                instaIntent.setPackage("com.instagram.android");
                instaIntent.putExtra(Intent.EXTRA_TEXT, referTxt_eT.getText().toString());
                try {
                    startActivity(instaIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(this, "Instagram not installed", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.messengerIcon:

                Intent messengerIntent = new Intent(Intent.ACTION_SEND);
                messengerIntent.setType("text/plain");
                messengerIntent.setPackage("com.facebook.orca");
                messengerIntent.putExtra(Intent.EXTRA_TEXT, referTxt_eT.getText().toString());
                try {
                    startActivity(messengerIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(this, "Facebook Messenger not installed", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.skypeIcon:

                Intent skypeIntent = new Intent(Intent.ACTION_SEND);
                skypeIntent.setType("text/plain");
                skypeIntent.setPackage("com.skype.raider");
                skypeIntent.putExtra(Intent.EXTRA_TEXT, referTxt_eT.getText().toString());
                try {
                    startActivity(skypeIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(this, "Skype not installed", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.linkedInIcon:

                Intent linkedInIntent = new Intent(Intent.ACTION_SEND);
                linkedInIntent.setType("text/plain");
                linkedInIntent.setPackage("com.linkedin.android");
                linkedInIntent.putExtra(Intent.EXTRA_TEXT, referTxt_eT.getText().toString());
                try {
                    startActivity(linkedInIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(this, "LinkedIn not installed", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.gmailIcon:

                Intent gmailIntent = new Intent(Intent.ACTION_SEND);
                gmailIntent.setType("text/plain");
                gmailIntent.setPackage("com.google.android.gm");
                gmailIntent.putExtra(Intent.EXTRA_TEXT, referTxt_eT.getText().toString());
                try {
                    startActivity(gmailIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(this, "Gmail not installed", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.messageIcon:

                Intent msgIntent = new Intent(Intent.ACTION_VIEW);
                msgIntent.setType("vnd.android-dir/mms-sms");
                msgIntent.putExtra("sms_body", referTxt_eT.getText().toString());
                try {
                    startActivity(msgIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(this, "Message App not found !", Toast.LENGTH_SHORT).show();
                }

                break;
        }

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
