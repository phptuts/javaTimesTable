package net.noahglaser.timetable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.timeTableListView);
        seekBar = findViewById(R.id.timeTableSeekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setTimesTable(progress + 1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        setTimesTable(1);
    }

    /**
     * Sets the times table app list view
     * @param timesBy
     */
    private void setTimesTable(int timesBy) {
        List<String> timesTable = new ArrayList<>();
        for (int i = 0; i < 20; i += 1) {
            timesTable.add(i, String.valueOf(timesBy * (i + 1)));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, timesTable);
        listView.setAdapter(arrayAdapter);
    }
}
