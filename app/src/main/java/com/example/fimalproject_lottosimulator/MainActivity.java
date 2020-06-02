package com.example.fimalproject_lottosimulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.fimalproject_lottosimulator.databinding.ActivityMainBinding;

import java.util.Arrays;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;

    int[] winLottoNumArr = new int[6]; // 배열의 3번칸에 적힌 값은? 0이다
    int bonusNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        binding.buyOneLottoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeLottoWinNumbers();
            }
        });

    }
    @Override
    public void setValues() {

    }
    void makeLottoWinNumbers() {

        for (int i = 0; i < winLottoNumArr.length; i ++) {
            winLottoNumArr[i] = 0;
        }

        for (int i = 0; i  < winLottoNumArr.length; i ++) {
            while (true) {

                int randomNum = (int) (Math.random() * 45 + 1);

                boolean isDuplicateOk = true;

                for (int num : winLottoNumArr) {
                    if (num == randomNum) {
                        isDuplicateOk = false;
                        break;
                    }
                }
                if (isDuplicateOk) {
                    winLottoNumArr[i] = randomNum;
                    break;
                }
            }
        }
        Arrays.sort(winLottoNumArr);

        for (int winNum : winLottoNumArr) {
            Log.d("당첨번호", winNum+"");
        }
    }
}
