package com.cbgh1.calculatorburakgithub;//varsayilan

import androidx.appcompat.app.AppCompatActivity;//varsayilan

import android.os.Bundle;//varsayilan

import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import java.text.DecimalFormat;

import android.media.MediaPlayer;//ses
import android.os.Build;
import android.media.AudioAttributes;

import android.content.res.Configuration; //ekran dondugunde


public class MainActivity extends AppCompatActivity implements View.OnClickListener{//varsayilan

    private TextView ekran;
    private Button buton_1, buton_2, buton_3, buton_4,
            buton_5, buton_6, buton_7, buton_8, buton_9, buton_0,
            buton_arti, buton_eksi, buton_carpi, buton_bolu,
            buton_esittir, buton_temizle, buton_nokta,
            buton_arti_eksi, buton_ondalik,
            buton_kare_al, buton_faktoriyel, buton_bir_bolu;
    private String mevcut_deger, son_deger, hesaplama;
    private double toplam_deger;
    private MediaPlayer mediaPlayer;//ses

    @Override//varsayilan
    protected void onCreate(Bundle savedInstanceState) {//varsayilan
        super.onCreate(savedInstanceState);//varsayilan
        setContentView(R.layout.activity_main);//varsayilan

        int orientation = getResources().getConfiguration().orientation; //ekranın duz ve yatay olunca calisacak xml
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_main_yatay);
        } else {
            setContentView(R.layout.activity_main);
        }

        ekran = (TextView) findViewById(R.id.sonuc); //butonlar kodda tanıtılıyor
        buton_1 = (Button) findViewById(R.id.bir);
        buton_2 = (Button) findViewById(R.id.iki);
        buton_3 = (Button) findViewById(R.id.uc);
        buton_4 = (Button) findViewById(R.id.dort);
        buton_5 = (Button) findViewById(R.id.bes);
        buton_6 = (Button) findViewById(R.id.alti);
        buton_7 = (Button) findViewById(R.id.yedi);
        buton_8 = (Button) findViewById(R.id.sekiz);
        buton_9 = (Button) findViewById(R.id.dokuz);
        buton_0 = (Button) findViewById(R.id.sifir);

        buton_arti = (Button) findViewById(R.id.arti);
        buton_eksi = (Button) findViewById(R.id.eksi);
        buton_carpi = (Button) findViewById(R.id.carpi);
        buton_bolu = (Button) findViewById(R.id.bolu);
        buton_esittir = (Button) findViewById(R.id.esittir);
        buton_temizle = (Button) findViewById(R.id.ac);
        buton_nokta = (Button) findViewById(R.id.nokta);

        buton_arti_eksi = (Button) findViewById(R.id.arti_eksi);
        buton_ondalik = (Button) findViewById(R.id.ondalik);

        buton_kare_al = (Button) findViewById(R.id.kare);
        buton_faktoriyel = (Button) findViewById(R.id.faktoriyel);
        buton_bir_bolu = (Button) findViewById(R.id.bir_bolu);

        buton_1.setOnClickListener(this); //Listenerlar tanıtılıyor
        buton_2.setOnClickListener(this);
        buton_3.setOnClickListener(this);
        buton_4.setOnClickListener(this);
        buton_5.setOnClickListener(this);
        buton_6.setOnClickListener(this);
        buton_7.setOnClickListener(this);
        buton_8.setOnClickListener(this);
        buton_9.setOnClickListener(this);
        buton_0.setOnClickListener(this);

        buton_arti.setOnClickListener(this);
        buton_eksi.setOnClickListener(this);
        buton_carpi.setOnClickListener(this);
        buton_bolu.setOnClickListener(this);
        buton_temizle.setOnClickListener(this);
        buton_esittir.setOnClickListener(this);
        buton_nokta.setOnClickListener(this);

        buton_arti_eksi.setOnClickListener(this);
        buton_ondalik.setOnClickListener(this);

        buton_kare_al.setOnClickListener(this);
        buton_faktoriyel.setOnClickListener(this);
        buton_bir_bolu.setOnClickListener(this);

        son_deger = ""; //hesap yapmak için gereken değişkenler
        mevcut_deger = "";
        hesaplama = "";
        toplam_deger = 0;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//ses
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();
            mediaPlayer = MediaPlayer.create(this, R.raw.tiklama_sesi, audioAttributes, 1);
        } else {
            mediaPlayer = MediaPlayer.create(this, R.raw.tiklama_sesi);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bir:
                mediaPlayer.start(); //ses
                f3_sayiEkle(1); //fonkisyon
                break;
            case R.id.iki:
                mediaPlayer.start();
                f3_sayiEkle(2);
                break;
            case R.id.uc:
                mediaPlayer.start();
                f3_sayiEkle(3);
                break;
            case R.id.dort:
                mediaPlayer.start();
                f3_sayiEkle(4);
                break;
            case R.id.bes:
                mediaPlayer.start();
                f3_sayiEkle(5);
                break;
            case R.id.alti:
                mediaPlayer.start();
                f3_sayiEkle(6);
                break;
            case R.id.yedi:
                mediaPlayer.start();
                f3_sayiEkle(7);
                break;
            case R.id.sekiz:
                mediaPlayer.start();
                f3_sayiEkle(8);
                break;
            case R.id.dokuz:
                mediaPlayer.start();
                f3_sayiEkle(9);
                break;
            case R.id.sifir:
                mediaPlayer.start();
                f3_sayiEkle(0);
                break;

            case R.id.arti:
                mediaPlayer.start();
                f6_hesapla("+");
                break;
            case R.id.eksi:
                mediaPlayer.start();
                f6_hesapla("-");
                break;
            case R.id.carpi:
                mediaPlayer.start();
                f6_hesapla("*");
                break;
            case R.id.bolu:
                mediaPlayer.start();
                f6_hesapla("/");
                break;
            case R.id.esittir:
                mediaPlayer.start();
                f7_sonucuHesapla();
                break;
            case R.id.ac:
                mediaPlayer.start();
                f5_ekraniTemizle();
                break;
            case R.id.nokta:
                mediaPlayer.start();
                f4_noktaEkle();
                break;

            case R.id.arti_eksi:
                mediaPlayer.start();
                f1_isaretDegistir();
                break;
            case R.id.ondalik:
                mediaPlayer.start();
                f2_ondalikEkle();
                break;

            case R.id.kare:
                mediaPlayer.start();
                fs1_kare_Al();
                break;
            case R.id.faktoriyel:
                mediaPlayer.start();
                fs2_faktoriyel_Al();
                break;
            case R.id.bir_bolu:
                mediaPlayer.start();
                fs3_bir_Bolu();
                break;
            default:
                System.out.println("Hatali Giris");
                break;
        }
    }
    private void f1_isaretDegistir() {
        if (mevcut_deger.equals("")) { //cokmesini engelliyor
            return;
        }

        mevcut_deger = virgul_silme(mevcut_deger);//decimal formatlanmış sayıdan sonra yapılan işlemde hesap makinesinin çökmemesi için gereken kod

        double x = Double.parseDouble(mevcut_deger);
        x = -x;
        mevcut_deger = String.valueOf(x);
        ekran.setText(mevcut_deger);
    }

    private void f2_ondalikEkle() {
        if (mevcut_deger.equals("")) { //cokmesini engelliyor
            return;
        }

        mevcut_deger = virgul_silme(mevcut_deger);//decimal formatlanmış sayıdan sonra yapılan işlemde hesap makinesinin çökmemesi için gereken kod

        double x = Double.parseDouble(mevcut_deger);
        x /= 10.00;
        mevcut_deger = String.valueOf(x);
        ekran.setText(mevcut_deger);
    }
    private void f3_sayiEkle(int sayi) {
        mevcut_deger += String.valueOf(sayi);
        ekran.setText(mevcut_deger);
    }
    private void f4_noktaEkle() {
        if (!mevcut_deger.contains(".")) {
            mevcut_deger += ".";
            ekran.setText(mevcut_deger);
        }
    }
    private void f5_ekraniTemizle() {
        mevcut_deger = "";
        son_deger = "";
        hesaplama = "";
        toplam_deger = 0;
        ekran.setText("0");
    }
    private void f6_hesapla(String operator) {
        if (mevcut_deger.isEmpty()) {
            return;
        }
        if (!son_deger.isEmpty()) {
            f7_sonucuHesapla();
        }
        hesaplama = operator;
        son_deger = mevcut_deger;
        mevcut_deger = "";
    }
    private void f7_sonucuHesapla() {
        if (son_deger.isEmpty() || mevcut_deger.isEmpty()) { //sayıdan sonra 2.sayı girilmezse çökmeyi önler
            System.out.println("HATALI GIRIS!");
        } else {

            mevcut_deger = virgul_silme(mevcut_deger);//decimal formatlanmış sayıdan sonra yapılan işlemde hesap makinesinin çökmemesi için gereken kod
            son_deger = virgul_silme(son_deger);//decimal formatlanmış sayıdan sonra yapılan işlemde hesap makinesinin çökmemesi için gereken kod

            double x_ilk = Double.parseDouble(mevcut_deger);
            double x_son = Double.parseDouble(son_deger);
            switch (hesaplama) {
                case "+":
                    toplam_deger = x_son + x_ilk;
                    break;
                case "-":
                    toplam_deger = x_son - x_ilk;
                    break;
                case "*":
                    toplam_deger = x_son * x_ilk;
                    break;
                case "/":
                    toplam_deger = x_son / x_ilk;
                    break;
                default:
                    System.out.println("Hatali Giris");
                    break;
            }
            DecimalFormat decimalFormat = new DecimalFormat("#,###.##########");
            String formattedResult = decimalFormat.format(toplam_deger);
            ekran.setText(formattedResult);
            mevcut_deger = formattedResult;
            son_deger = "";
        }
    }
    private void fs1_kare_Al() {
        if (mevcut_deger.equals("")) { //cokmesini engelliyor
            return;
        }

        mevcut_deger = virgul_silme(mevcut_deger);//decimal formatlanmış sayıdan sonra yapılan işlemde hesap makinesinin çökmemesi için gereken kod

        double x = Double.parseDouble(mevcut_deger);
        x = x * x;
        mevcut_deger = String.valueOf(x);
        ekran.setText(mevcut_deger);
    }
    private void fs2_faktoriyel_Al() {
        if (mevcut_deger.equals("")) { //cokmesini engelliyor
            return;
        }

        mevcut_deger = virgul_silme(mevcut_deger);//decimal formatlanmış sayıdan sonra yapılan işlemde hesap makinesinin çökmemesi için gereken kod

        double x = Double.parseDouble(mevcut_deger);
        int fact = 1;
        for (int i = 1; i <= x; i++) {
            fact *= i;
        }
        mevcut_deger = String.valueOf(fact);
        ekran.setText(mevcut_deger);
    }
    private void fs3_bir_Bolu() {
        if (mevcut_deger.equals("")) { //cokmesini engelliyor
            return;
        }

        mevcut_deger = virgul_silme(mevcut_deger);//decimal formatlanmış sayıdan sonra yapılan işlemde hesap makinesinin çökmemesi için gereken kod

        double x = Double.parseDouble(mevcut_deger);
        x = 1 / x;
        mevcut_deger = String.valueOf(x);
        ekran.setText(mevcut_deger);
    }

    @Override//ses
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        mediaPlayer = null;
    }

    private String virgul_silme(String sil) {
        if (sil.contains(",")) { //decimal formatlanmış sayıdan sonra yapılan işlemde hesap makinesinin çökmemesi için gereken kod
            sil = sil.replace(",", "");
        }
        return sil;
    }

}