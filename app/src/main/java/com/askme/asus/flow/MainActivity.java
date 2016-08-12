package com.askme.asus.flow;

import android.os.Build;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton main_button,phone,message,notes,settings;
    RelativeLayout main_layout;
    int temp_height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_button = (FloatingActionButton) findViewById(R.id.main_button);
        main_button = (FloatingActionButton) findViewById(R.id.main_button);
        phone = (FloatingActionButton) findViewById(R.id.phone);
        message = (FloatingActionButton) findViewById(R.id.message);
        notes = (FloatingActionButton) findViewById(R.id.notes);
        settings = (FloatingActionButton) findViewById(R.id.settings);

        main_layout = (RelativeLayout) findViewById(R.id.main_layout);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) main_button.getLayoutParams();
            params1.setMargins(0, 0, 20, 32);
            main_button.setLayoutParams(params1);

            RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) phone.getLayoutParams();
            params2.setMargins(0, 0, 20, 32);
            phone.setLayoutParams(params2);

            RelativeLayout.LayoutParams params3 = (RelativeLayout.LayoutParams) message.getLayoutParams();
            params3.setMargins(0, 0, 20, 32);
            message.setLayoutParams(params3);

            RelativeLayout.LayoutParams params4 = (RelativeLayout.LayoutParams) notes.getLayoutParams();
            params4.setMargins(0, 0, 20, 32);
            notes.setLayoutParams(params4);

            RelativeLayout.LayoutParams params5 = (RelativeLayout.LayoutParams) settings.getLayoutParams();
            params5.setMargins(0, 0, 20, 32);
            settings.setLayoutParams(params5);
        }


        main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp_height = main_button.getHeight();

                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if(settings.getAlpha()== 0.0)
                    {
                        main_button.animate().setDuration(300).y(5);
                        main_button.animate().setDuration(300).rotation(405);
                        phone.animate().setDuration(400).y(5).alpha((float) 1.0);
                        message.animate().setDuration(500).y(5).alpha((float) 1.0);
                        notes.animate().setDuration(600).y(5).alpha((float) 1.0);
                        settings.animate().setDuration(700).y(5).alpha((float) 1.0);

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                phone.animate().y((float) (temp_height*1.1)+3).setDuration(400);
                                message.animate().y((float) (temp_height*2.2)+3).setDuration(400);
                                notes.animate().y((float) (temp_height*3.3)+3).setDuration(400);
                                settings.animate().y((float) (temp_height*4.4)+3).setDuration(400);
                            }
                        }, 700);

                    }
                    else
                    {

                        close_animation();

                    }
                }

                else
                {
                    if(settings.getAlpha()== 0.0)
                    {
                        main_button.animate().setDuration(300).y(0);
                        main_button.animate().setDuration(300).rotation(405);
                        phone.animate().setDuration(400).y(0).alpha((float) 1.0);
                        message.animate().setDuration(500).y(0).alpha((float) 1.0);
                        notes.animate().setDuration(600).y(0).alpha((float) 1.0);
                        settings.animate().setDuration(700).y(0).alpha((float) 1.0);

                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                main_button.animate().setDuration(300).y(0);
                                phone.animate().y((float) (temp_height*.7)).setDuration(400);
                                message.animate().y((float) (temp_height*1.4)).setDuration(400);
                                notes.animate().y((float) (temp_height*2.1)).setDuration(400);
                                settings.animate().y((float) (temp_height*2.8)).setDuration(400);
                            }
                        }, 700);

                    }
                    else
                    {

                        close_animation();

                    }
                }


            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Phone",500).show();
                close_animation();
            }
        });

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Message",500).show();
                close_animation();
            }
        });

        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Notes",500).show();
                close_animation();
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Settings",500).show();
                close_animation();
            }
        });

    }

    private void close_animation() {

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    phone.animate().setDuration(500).y(5);
                }
            }, 90);
            final Handler handler1 = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    message.animate().setDuration(400).y(5);
                }
            }, 180);
            final Handler handler2 = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    notes.animate().setDuration(370).y(5);
                }
            }, 230);

            final Handler handler3 = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    settings.animate().setDuration(300).y(5).alpha((float) 0.0);
                }
            }, 320);


            final Handler handle4 = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    main_button.animate().setDuration(670).y((float) (main_layout.getHeight()-temp_height*1.3));
                    main_button.animate().setDuration(670).rotation(0);
                    phone.animate().setDuration(670).y((float) (main_layout.getHeight()-temp_height*1.3)).alpha((float) 0.0);
                    message.animate().setDuration(670).y((float) (main_layout.getHeight()-temp_height*1.3)).alpha((float) 0.0);
                    notes.animate().setDuration(670).y((float) (main_layout.getHeight()-temp_height*1.3)).alpha((float) 0.0);
                    settings.animate().setDuration(670).y((float) (main_layout.getHeight()-temp_height*1.3)).alpha((float) 0.0);
                }
            }, 700);
        }

        else
        {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    phone.animate().setDuration(500).y(0);
                }
            }, 90);
            final Handler handler1 = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    message.animate().setDuration(400).y(0);
                }
            }, 180);
            final Handler handler2 = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    notes.animate().setDuration(370).y(0);
                }
            }, 230);

            final Handler handler3 = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    settings.animate().setDuration(300).y(0).alpha((float) 0.0);
                }
            }, 320);


            final Handler handle4 = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    main_button.animate().setDuration(670).y((float) (main_layout.getHeight()-temp_height));
                    main_button.animate().setDuration(670).rotation(0);
                    phone.animate().setDuration(670).y((float) (main_layout.getHeight()-temp_height)).alpha((float) 0.0);
                    message.animate().setDuration(670).y((float) (main_layout.getHeight()-temp_height)).alpha((float) 0.0);
                    notes.animate().setDuration(670).y((float) (main_layout.getHeight()-temp_height)).alpha((float) 0.0);
                    settings.animate().setDuration(670).y((float) (main_layout.getHeight()-temp_height)).alpha((float) 0.0);
                }
            }, 700);
        }




    }
}
