package com.example.control;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Random;

import model.Dato;

public class MainActivity extends AppCompatActivity {


    private Button upBtn;
    private Button downBtn;
    private Button rightBtn;
    private Button leftBtn;
    private Button colorBtn;
    private String json;

    BufferedReader bfr;
    BufferedWriter bfw;

    Dato datos;
    Gson gson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        upBtn = findViewById(R.id.upBtn);
        downBtn = findViewById(R.id.downBtn);
        leftBtn = findViewById(R.id.leftBtn);
        rightBtn = findViewById(R.id.rightBtn);
        colorBtn = findViewById(R.id.colorBtn);

        datos =  new Dato();
        gson = new Gson();

        new Thread(
                ()->{
                    try {
                        Socket socket = new Socket("10.0.2.2",9000);

                        InputStream is = socket.getInputStream();
                        InputStreamReader isr =  new InputStreamReader(is);
                         bfr = new BufferedReader(isr);

                        OutputStream os = socket.getOutputStream();
                        OutputStreamWriter osw =  new OutputStreamWriter(os);
                         bfw= new BufferedWriter(osw);


                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
        ).start();


        upBtn.setOnClickListener(
                (v) -> {
                    datos.setMovimiento("up");
                    datos.setMov(20);
                    json = gson.toJson(datos);
                    enviarMensaje(json);
                }
        );

        rightBtn.setOnClickListener(
                (v) -> {
                    datos.setMovimiento("right");
                    datos.setMov(20);
                    json = gson.toJson(datos);
                    enviarMensaje(json);
                }
        );

        leftBtn.setOnClickListener(
                (v) -> {
                    datos.setMovimiento("left");
                    datos.setMov(20);
                    json = gson.toJson(datos);
                    enviarMensaje(json);
                }
        );

        downBtn.setOnClickListener(
                (v) -> {
                    datos.setMovimiento("down");
                    datos.setMov(20);
                    json = gson.toJson(datos);
                    enviarMensaje(json);
                }
        );

        colorBtn.setOnClickListener(
                (v) -> {
                    datos.setMovimiento("color");
                    datos.setR(new Random().nextInt(256)+0);
                    datos.setG(new Random().nextInt(256)+0);
                    datos.setB(new Random().nextInt(256)+0);
                    json = gson.toJson(datos);
                    enviarMensaje(json);
                }
        );

    }

    public void enviarMensaje (String mns) {

        new Thread(()->{
            try {
                bfw.write(mns + "\n");
                bfw.flush();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();


    }



}