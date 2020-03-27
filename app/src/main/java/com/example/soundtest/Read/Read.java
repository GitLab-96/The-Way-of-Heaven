package com.example.soundtest.Read;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.soundtest.R;
import com.github.barteksc.pdfviewer.PDFView;

public class Read extends AppCompatActivity {
    PDFView quranPdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        init();

        PDFViewer();

    }

    private void init() {
        quranPdf = findViewById(R.id.readQuranPDF);
    }
    private void PDFViewer() {
        quranPdf.fromAsset("hifjquran.pdf").load();
    }


}
