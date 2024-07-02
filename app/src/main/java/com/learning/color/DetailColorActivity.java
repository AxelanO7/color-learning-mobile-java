package com.learning.color;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DetailColorActivity extends AppCompatActivity {
    View detailColorContainer;
    TextView detailColorName, shortDetailColorDesc, longDetailColorDesc, btnBack;
    String color;
    Map<String, String> colorTitle = new HashMap<String, String>() {{
        put("#FF0000", "Merah");
        put("#0500FF", "Biru");
        put("#00FF00", "Hijau");
        put("#00FFFF", "Cyan");
        put("#BF00FF", "Ungu");
        put("#FFFF00", "Kuning");
    }};

    Map<String, String> colorShortDesc = new HashMap<String, String>() {{
        put("#FF0000", "Merah adalah warna api dan darah, sehingga dikaitkan dengan energi, perang, bahaya, kekuatan, kekuasaan, tekad serta gairah, keinginan, dan cinta");
        put("#0500FF", "Biru adalah warna langit dan laut. Hal ini sering dikaitkan dengan kedalaman dan stabilitas. Melambangkan kepercayaan, kesetiaan, kebijaksanaan, keyakinan, kecerdasan, iman, kebenaran, dan surga");
        put("#00FF00", "Hijau adalah warna alam. Melambangkan pertumbuhan, harmoni, kesegaran, dan kesuburan. Hijau memiliki hubungan emosional yang kuat dengan keselamatan. Hijau tua juga sering diasosiasikan dengan uang");
        put("#00FFFF", "Cyan adalah warna antara biru dan hijau pada roda warna. Hal ini sering dikaitkan dengan air, langit, dan es. Melambangkan kepercayaan, kesetiaan, kebijaksanaan, keyakinan, kecerdasan, iman, kebenaran, dan surga");
        put("#BF00FF", "Ungu memadukan stabilitas biru dan energi merah. Ungu diasosiasikan dengan royalti. Ini melambangkan kekuatan, kemuliaan, kemewahan, dan ambisi. Ini menyampaikan kekayaan dan kemewahan");
        put("#FFFF00", "Kuning adalah warna sinar matahari. Ini terkait dengan kegembiraan, kebahagiaan, kecerdasan, dan energi. Warna kuning menghasilkan efek menghangatkan, membangkitkan keceriaan, merangsang aktivitas mental, dan membangkitkan energi otot");
    }};

    Map<String, String> colorLongDesc = new HashMap<String, String>() {{
        put("#FF0000", "Merah adalah warna api dan darah, sehingga dikaitkan dengan energi, perang, bahaya, kekuatan, kekuasaan, tekad serta gairah, keinginan, dan cinta. Merah adalah warna yang sangat intens secara emosional. Ini meningkatkan metabolisme manusia, meningkatkan laju pernapasan, dan meningkatkan tekanan darah. Jarak pandangnya sangat tinggi, itulah sebabnya rambu berhenti, lampu lalu lintas, dan peralatan pemadam kebakaran biasanya dicat merah. Dalam lambang, warna merah digunakan untuk menunjukkan keberanian. Ini adalah warna yang ditemukan di banyak bendera nasional");
        put("#0500FF", "Biru adalah warna langit dan laut. Hal ini sering dikaitkan dengan kedalaman dan stabilitas. Melambangkan kepercayaan, kesetiaan, kebijaksanaan, keyakinan, kecerdasan, iman, kebenaran, dan surga. Biru dianggap bermanfaat bagi pikiran dan tubuh. Ini memperlambat metabolisme manusia dan menghasilkan efek menenangkan. Biru sangat terkait dengan ketenangan dan ketenangan. Dalam lambang, warna biru digunakan untuk melambangkan kesalehan dan ketulusan");
        put("#00FF00", "Hijau adalah warna alam. Melambangkan pertumbuhan, harmoni, kesegaran, dan kesuburan. Hijau memiliki hubungan emosional yang kuat dengan keselamatan. Hijau tua juga sering diasosiasikan dengan uang. Hijau memiliki kekuatan penyembuhan yang luar biasa. Ini adalah warna yang paling menenangkan bagi mata manusia; itu dapat meningkatkan penglihatan. Hijau menunjukkan stabilitas dan daya tahan. Terkadang warna hijau menunjukkan kurangnya pengalaman; misalnya, 'greenhorn' adalah seorang pemula. Dalam lambang, hijau melambangkan pertumbuhan dan harapan");
        put("#00FFFF", "Cyan adalah warna antara biru dan hijau pada roda warna. Hal ini sering dikaitkan dengan air, langit, dan es. Melambangkan kepercayaan, kesetiaan, kebijaksanaan, keyakinan, kecerdasan, iman, kebenaran, dan surga. Cyan adalah warna yang sangat menenangkan. Cyan adalah warna tenang dan menenangkan yang melambangkan relaksasi. Ini adalah warna yang menawarkan rasa tenang dan tenteram. Cyan juga merupakan warna yang mewakili masa muda dan energi tinggi");
        put("#BF00FF", "Ungu memadukan stabilitas biru dan energi merah. Ungu diasosiasikan dengan royalti. Ini melambangkan kekuatan, kemuliaan, kemewahan, dan ambisi. Ini menyampaikan kekayaan dan kemewahan. Ungu diasosiasikan dengan kebijaksanaan, martabat, kemandirian, kreativitas, misteri, dan keajaiban. Menurut survei, hampir 75 persen anak-anak pra-remaja lebih menyukai warna ungu dibandingkan warna lainnya. Ungu adalah warna yang sangat langka di alam; beberapa orang menganggapnya buatan");
        put("#FFFF00", "Kuning adalah warna sinar matahari. Ini terkait dengan kegembiraan, kebahagiaan, kecerdasan, dan energi. Warna kuning menghasilkan efek menghangatkan, membangkitkan keceriaan, merangsang aktivitas mental, dan membangkitkan energi otot. Kuning sering dikaitkan dengan makanan. Kuning cerah dan murni menarik perhatian, itulah alasan taksi dicat dengan warna ini. Jika digunakan secara berlebihan, warna kuning mungkin menimbulkan efek yang mengganggu; diketahui bahwa bayi lebih banyak menangis di ruangan berwarna kuning. Kuning terlihat sebelum warna lain jika ditempatkan berlawanan dengan hitam; kombinasi ini sering digunakan untuk mengeluarkan peringatan");
    }};

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_color);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detail), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Objects.requireNonNull(getSupportActionBar()).hide();
        int colorStatusBar = Color.parseColor("#CADEDF");
        int colorNavigationBar = Color.parseColor("#04ECF0");
        getWindow().setStatusBarColor(colorStatusBar);
        getWindow().setNavigationBarColor(colorNavigationBar);

        detailColorContainer = findViewById(R.id.color_container_detail);
        detailColorName = findViewById(R.id.tvDetail2);
        shortDetailColorDesc = findViewById(R.id.tvDetail3);
        longDetailColorDesc = findViewById(R.id.tvDetail4);
        btnBack = findViewById(R.id.button_back_detail);

        color = getIntent().getStringExtra("color");
        detailColorContainer.setBackgroundColor(android.graphics.Color.parseColor(color));
        detailColorName.setText(colorTitle.get(color));

        btnBack.setOnClickListener(v -> onBackPressed());
        shortDetailColorDesc.setText(colorShortDesc.get(color));
        longDetailColorDesc.setText(colorLongDesc.get(color));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DetailColorActivity.this, PickColorActivity.class);
        startActivity(intent);
        finish();
    }
}