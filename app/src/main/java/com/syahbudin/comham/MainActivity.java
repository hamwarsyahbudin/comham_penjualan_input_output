/*
 * Copyright (c) 2021 Syahbudin Hamwar
 */

package com.syahbudin.comham;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNamaPelanggan, etNamaBarang, etJmlBarang, etHarga, etJmlUang;
    TextView tvNamaPembeli, tvNamaBarang, tvJmlBarang, tvHarga, tvUangBayar,
            tvTotal, tvKembalian, tvBonus, tvKeterangan;
    Button btnProses, btnHapus, btnKeluar;
    String namaPelanggan, namaBarang, jumlahBarang, hargaBarang, uangBayar;
    double jmlBarang, hrgBarang, uangByr, total, kembalian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("COMHAM");
        etNamaPelanggan = findViewById(R.id.etNamaPelanggan);
        etNamaBarang = findViewById(R.id.etNamaBarang);
        etJmlBarang = findViewById(R.id.etJmlBarang);
        etHarga = findViewById(R.id.etHarga);
        etJmlUang = findViewById(R.id.etJmlUang);
        tvNamaPembeli = findViewById(R.id.tvNamaPembeli);
        tvNamaBarang = findViewById(R.id.tvNamaBarang);
        tvJmlBarang = findViewById(R.id.tvJmlBarang);
        tvHarga = findViewById(R.id.tvHarga);
        tvUangBayar = findViewById(R.id.tvUangBayar);
        tvTotal = findViewById(R.id.tvTotal);
        tvKembalian = findViewById(R.id.tvKembalian);
        tvBonus = findViewById(R.id.tvBonus);
        tvKeterangan = findViewById(R.id.tvKeterangan);
        btnProses = findViewById(R.id.btnProses);
        btnHapus = findViewById(R.id.btnHapus);
        btnKeluar = findViewById(R.id.btnKeluar);

        btnProses.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                namaPelanggan = etNamaPelanggan.getText().toString().trim();
                namaBarang = etNamaBarang.getText().toString().trim();
                jumlahBarang = etJmlBarang.getText().toString().trim();
                hargaBarang = etHarga.getText().toString().trim();
                uangBayar = etJmlUang.getText().toString().trim();

                jmlBarang = Double.parseDouble(jumlahBarang);
                hrgBarang = Double.parseDouble(hargaBarang);
                uangByr = Double.parseDouble(uangBayar);
                total = (jmlBarang * hrgBarang);

                tvNamaPembeli.setText("Nama Pembeli    : " + namaPelanggan);
                tvNamaBarang.setText("Nama Barang      : " + namaBarang);
                tvJmlBarang.setText("Jumlah Barang   : Rp." + jumlahBarang);
                tvHarga.setText("Harga Barang      : Rp." + hargaBarang);
                tvUangBayar.setText("Uang Bayar          : Rp." + uangBayar);

                tvTotal.setText("Total Belanja       : Rp." + total);
                if (total >= 1000000) {
                    tvBonus.setText("Bonus Hadiah      : HardDisk 512Gb");
                } else if (total >= 500000) {
                    tvBonus.setText("Bonus Hadiah      : Keyboard");
                } else if (total >= 250000) {
                    tvBonus.setText("Bonus Hadiah      : Mouse");
                } else {
                    tvBonus.setText("Bonus Hadiah      : Tidak Dapat Bonus!");
                }

                kembalian = (uangByr - total);
                if (uangByr < total) {
                    tvKeterangan.setText("Keterangan : Uang bayar kurang Rp." + (-kembalian));
                    tvKembalian.setText("Uang Kembalian : Rp. 0");
                } else {
                    tvKeterangan.setText("Keterangan          : Harap Tunggu Kembalian");
                    tvKembalian.setText("Uang Kembalian : Rp." + kembalian);
                }

            }
        });

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvNamaPembeli.setText("");
                tvNamaBarang.setText("");
                tvJmlBarang.setText("");
                tvHarga.setText("");
                tvUangBayar.setText("");
                tvKembalian.setText("");
                tvKeterangan.setText("");
                tvBonus.setText("");
                tvTotal.setText("");

                Toast.makeText(getApplicationContext(), "Data sudah dihapus", Toast.LENGTH_SHORT).show();
            }
        });

        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
            }
        });

    }
}
