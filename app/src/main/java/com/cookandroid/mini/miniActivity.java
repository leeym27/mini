package com.cookandroid.mini;

import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Dialog;
import android.view.Window;
import android.widget.CalendarView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.HashMap;

public class miniActivity extends Activity {

    RadioGroup sexGroup;
    RadioButton man, woman;
    EditText weightInput, heightInput, ageInput;
    Button bmiBtn, bmrBtn;
    TextView bmiResult, bmrResult;

    private DatePicker startDatePicker, endDatePicker;
    private Button calculateButton, btnAllResult;
    private TextView resultTextView;
    private ListView rstView;
    private ArrayList<String> resultList;
    private ArrayAdapter<String> adapter;

    private HashMap<String, String> memoMap = new HashMap<>();
    private String selectedDate;

    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.project);

        Button btnPrev, btnNext;
        final ViewFlipper vFlipper;

        btnPrev = (Button) findViewById(R.id.pvbutton);
        btnNext = (Button) findViewById(R.id.ntbutton);
        vFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);

        weightInput = (EditText) findViewById(R.id.weight);
        heightInput = (EditText) findViewById(R.id.height);
        ageInput = (EditText) findViewById(R.id.age);
        sexGroup = (RadioGroup) findViewById(R.id.sex);
        man = (RadioButton) findViewById(R.id.male);
        woman = (RadioButton) findViewById(R.id.female);

        bmiBtn = (Button) findViewById(R.id.bmiBtn);
        bmiResult = (TextView) findViewById(R.id.bmiRst);
        bmrResult = (TextView) findViewById(R.id.bmrRst);

        startDatePicker = findViewById(R.id.startDatePicker);
        endDatePicker = findViewById(R.id.endDatePicker);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);
        btnAllResult = findViewById(R.id.allresult);

        resultList = new ArrayList<>();
        rstView = (ListView) findViewById(R.id.rstView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, resultList);
        rstView.setAdapter(adapter);

        EditText searchEditText = findViewById(R.id.search);
        Button searchButton = findViewById(R.id.searchBtn);

        //뷰플리퍼 이전화면
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vFlipper.showPrevious();
            }
        });

        //뷰플리퍼 다음화면
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vFlipper.showNext();
            }
        });


        //bmi 계산 버튼
        bmiBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // 리스트 초기화
                resultList.clear();
                String weightStr = weightInput.getText().toString();
                String heightStr = heightInput.getText().toString();
                //bmi계산하기
                if (!weightStr.isEmpty() && !heightStr.isEmpty()) {
                    float weight = Float.parseFloat(weightStr);
                    float height = Float.parseFloat(heightStr) / 100;

                    float bmi = weight / (height * height);
                    String bmiStatus;

                    if (bmi < 18.5) {
                        bmiStatus = "저체중";
                    } else if (bmi >= 18.5 && bmi <= 22.9) {
                        bmiStatus = "정상";
                    } else if (bmi >= 23 && bmi <= 24.9) {
                        bmiStatus = "과체중";
                    } else {
                        bmiStatus = "비만";
                    }

                    String bmiResultText = "BMI : " + String.format("%.2f", bmi) + " (" + bmiStatus + ")";
                    bmiResult.setText(bmiResultText);
                    if (!resultList.contains(bmiResultText)) {
                        resultList.add(bmiResultText);
                        adapter.notifyDataSetChanged();
                    }
                }

                //기초대사량 계산하기
                int selectedId = sexGroup.getCheckedRadioButtonId();
                double weight = Double.parseDouble(weightInput.getText().toString());
                double height = Double.parseDouble(heightInput.getText().toString());
                int age = Integer.parseInt(ageInput.getText().toString());

                double bmr = 0.0;
                if (selectedId == R.id.male) {
                    bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
                } else if (selectedId == R.id.female) {
                    bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
                }

                String bmrResultText = "기초대사량 : " + String.format("%.2f", bmr);
                bmrResult.setText(bmrResultText);
                if (!resultList.contains(bmrResultText)) {
                    resultList.add(bmrResultText);
                    adapter.notifyDataSetChanged();
                }
                return false;
            }
        });

        //다이어트기간 계산버튼
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int startDay = startDatePicker.getDayOfMonth();
                int startMonth = startDatePicker.getMonth();
                int startYear = startDatePicker.getYear();


                int endDay = endDatePicker.getDayOfMonth();
                int endMonth = endDatePicker.getMonth();
                int endYear = endDatePicker.getYear();

                Calendar startDate = Calendar.getInstance();
                startDate.set(startYear, startMonth, startDay);

                Calendar endDate = Calendar.getInstance();
                endDate.set(endYear, endMonth, endDay);

                long diffInMillis = endDate.getTimeInMillis() - startDate.getTimeInMillis();
                long diffInDays = diffInMillis / (24 * 60 * 60 * 1000);

                String dietPeriodText = "다이어트 기간: " + diffInDays + "일";
                resultTextView.setText(dietPeriodText);
                if (!resultList.contains(dietPeriodText)) {
                    resultList.add(dietPeriodText);
                    adapter.notifyDataSetChanged();
                }
            }
        });


        //수치결과 계산 + 식단과 운동 추천하기
        btnAllResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bmiText = bmiResult.getText().toString();
                int layoutId = 0;

                if (bmiText.contains("저체중")) {
                    layoutId = R.layout.dialog_underweight;
                } else if (bmiText.contains("정상")) {
                    layoutId = R.layout.dialog_normal;
                } else if (bmiText.contains("과체중")) {
                    layoutId = R.layout.dialog_overweight;
                } else if (bmiText.contains("비만")) {
                    layoutId = R.layout.dialog_obese;
                }

                if (layoutId != 0) {
                    final Dialog dialog = new Dialog(v.getContext());
                    dialog.setContentView(layoutId);
                    dialog.show();
                }
            }
        });


        //검색 확인버튼
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = searchEditText.getText().toString().trim();
                if (!query.isEmpty()) {
                    searchOnYouTube(query);
                }
            }
        });

        //캘린더용 다이어로그 버튼
        ImageButton showDialogButton = findViewById(R.id.showDialogButton);
        showDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalendarDialog();
            }
        });

    }
    //유튜브 검색하기
    private void searchOnYouTube(String query) {
        Intent intent = new Intent(Intent.ACTION_SEARCH);
        intent.setPackage("com.google.android.youtube");
        intent.putExtra("query", query);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        try {
            startActivity(intent);
        } catch (Exception e) {
            // 유튜브 앱이 설치되어 있지 않은 경우 웹 브라우저로 유튜브 검색
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.youtube.com/results?search_query=" + query));
            startActivity(webIntent);
        }
    }

    //다이어로그에 캘린더 생성
    private void showCalendarDialog() {
        // 다이얼로그 생성
        final Dialog dialog = new Dialog(miniActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_calendar);

        // 다이얼로그 안의 뷰들 참조
        CalendarView calendarView = dialog.findViewById(R.id.calendarView);
        EditText memoEditText = dialog.findViewById(R.id.edtDiary);
        Button saveButton = dialog.findViewById(R.id.saveBtn);
        Button closeButton = dialog.findViewById(R.id.closeBtn);
        TextView memoTextView = dialog.findViewById(R.id.memoTextView);
        // 캘린더 날짜 선택 리스너
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                selectedDate = year + "-" + (month + 1) + "-" + dayOfMonth;
                TextView memoTextView = dialog.findViewById(R.id.memoTextView); // dialog_calendar.xml에 있는 TextView
                String memo = memoMap.get(selectedDate); // 날짜에 해당하는 메모 가져오기
                // 선택된 날짜에 저장된 메모가 있으면 불러오기
                if (memo != null) {
                    // 메모가 있으면 TextView에 메모 내용 표시
                    memoTextView.setText(memo);
                } else {
                    // 메모가 없으면 "메모 없음" 표시
                    memoTextView.setText("메모 없음");
                }
            }
        });

        // 저장 버튼 클릭 리스너
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String memo = memoEditText.getText().toString();
                if (selectedDate != null && !memo.isEmpty()) {
                    memoMap.put(selectedDate, memo); // 날짜별로 메모 저장
                }
            }
        });

        // 닫기 버튼 클릭 리스너
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        // 다이얼로그 표시
        dialog.show();
    }
}
