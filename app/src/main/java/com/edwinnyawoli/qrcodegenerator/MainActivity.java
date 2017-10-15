package com.edwinnyawoli.qrcodegenerator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private QRCodeBitmapGenerator qrCodeBitmapGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText messageEditText = (EditText) findViewById(R.id.message_edit_text);
        final ImageView qrCodeImageView = (ImageView) findViewById(R.id.qr_code_image_view);
        Button generateQRCodeButton = (Button) findViewById(R.id.generate_qr_code_button);

        qrCodeBitmapGenerator = new QRCodeBitmapGenerator();

        generateQRCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageEditText.getText().toString();
                if (!TextUtils.isEmpty(message))
                    qrCodeImageView.setImageBitmap(qrCodeBitmapGenerator.encodeAsBitmap(message));
                else {
                    messageEditText.setError("Message is empty");
                }
            }
        });
    }


}
