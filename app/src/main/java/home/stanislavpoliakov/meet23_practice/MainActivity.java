package home.stanislavpoliakov.meet23_practice;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        Button aDButton = findViewById(R.id.aDButton);
        aDButton.setOnClickListener((v) -> {
            //FragmentManager fragmentManager = getSupportFragmentManager();
            ADFragment fragment = ADFragment.newInstance();
            fragmentManager.beginTransaction()
                    .add(fragment, "animation drawable")
                    .commitNow();
        });

        Button bXMLButton = findViewById(R.id.BXMLButtom);
        bXMLButton.setOnClickListener((v -> {
            BXMLFragment fragment = BXMLFragment.newInstance();
            fragmentManager.beginTransaction()
                    .add(fragment, "base XML animation")
                    .commitNow();
        }));

        Button bCButton = findViewById(R.id.bCButton);
        bCButton.setOnClickListener((v) -> {
            AXMLFragment fragment = AXMLFragment.newInstance();
            fragmentManager.beginTransaction()
                    .add(fragment, "animator XML animation")
                    .commitNow();
        });
    }
}
