## FAT JAVA
---

다이어트를 도와주는 보조 어플리케이션
2171018 이용민

### **1.프로젝트 수행 목적**

#### 1.1 프로젝트 정의
  -건강하게 다이어트를 도와주는 보조 어플리케이션

#### 1.2 프로젝트 배경
  - 코로나 이후 배달을 많이 시켜먹게 되면서 많은 사람들이 살을 많이 찌게 되었고 그 이후로 많은 사람들이 다이어트에 관심이 많아졌다. 하지만 인터넷에 잘못된 정보나 너무나 많은 정보로 제대로 된 다이어트를 이루지 못하는 문제점이 있다.

  - 이러한 문제점을 해결하기 위해 나에게 맞는 다이어트 방법을 알고 스스로 극복하는 방법을 알아간다.

#### 1.3 프로젝트 목표
  - 나이, 체중, 신장을 통해 나의 건강상태를 확인한다.

  - 캘린더를 통해 자신이 언제까지 다이어트를 할지 정한다.

  - 유튜브로 검색하여 내가 추가적으로 필요한 운동이나 식당을 조사한다.

### **2.프로젝트 개요**
#### 2.1 프로젝트 설명
 - 나이, 체중, 신장과 성별을 적으면 자신의 BMI와 기초대사량 수치를 조사한다.
 - 뷰 플리퍼를 이용하여 다음 장으로 넘어간다.
 - 2개의 캘린더로 다이어트 시작 날짜와 끝나는 날짜를 얻어 다이어트 기간을 조사한다.
 - 리스트를 통해 자신의 BMI와 기초대사량 다이어트 기간을 보여주고 이 정보를 통해 Dialog   로 BMI수치에 맞는 식단과 운동방법 또는 다이어트 조언을 해준다.
 - 유튜브 api를 통해 검색란에 운동관련이나 식단같은 내용을 입력하고 검색 버튼을 누르면 유튜브와 연결되어 검색한 내용의 결과가 보여줘 자신이 원하는 영상을 골라서 본다.
 - 캘린더 사진을 누르고 원하는 날짜에 클릭하여 그날 자신이 어떤 운동을 할지 어떤 식당을 할지 등 원하는 메모를 할 수 있다.

#### 2.2 프로젝트 구조

  - 사용한 언어 : JAVA , XML
  - TOOL : Android Studio
  - API : YOUTUBE

#### 2.3 코드 설명
  - activity_main.xml
 <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="1">

        <ImageView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="20dp"
            android:layout_marginTop="20dp"
            android:layout_marginEnd="20dp"
            android:layout_marginBottom="20dp"
            android:src="@drawable/healthy" />
    </RelativeLayout>

    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="1">
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="10dp"
            android:layout_centerInParent="true"
            android:text="건강을 JAVA"
            android:textSize="70sp" />
    </RelativeLayout>
    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="1">
        <Button
            android:id="@+id/btnNewActivity"
            android:layout_width="200dp"
            android:layout_height="100dp"
            android:layout_centerInParent="true"
            android:background="@drawable/main_itme_button"
            android:text="시작하기"
            android:textSize="40sp"/>
    </RelativeLayout>
**렐러티브레이아웃을 통해 이미지랑 텍스트 버튼의 위치를 가운데로 조정**

- project.xml
<LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">

            <Button
                android:id="@+id/pvbutton"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_margin="5dp"
                android:layout_weight="1"
                android:background="@drawable/main_itme_button"
                android:text="이전 화면" />

            <Button
                android:id="@+id/ntbutton"
                android:layout_width="0dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:layout_margin="5dp"
                android:background="@drawable/main_itme_button"
                android:text="다음 화면" />
        </LinearLayout>


        <ViewFlipper
            android:id="@+id/viewFlipper"
            android:layout_width="match_parent"
            android:layout_height="wrap_content">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical">

                <RadioGroup
                    android:id="@+id/sex"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content">

                    <RadioButton
                        android:id="@+id/male"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:text="남성"
                        android:textSize="30dp" />

                    <RadioButton
                        android:id="@+id/female"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:text="여성"
                        android:textSize="30dp" />
                </RadioGroup>

                <EditText
                    android:id="@+id/age"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:hint="나이"
                    android:textSize="35dp" />

                <EditText
                    android:id="@+id/weight"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:hint="체중(KG)"
                    android:textSize="35dp" />

                <EditText
                    android:id="@+id/height"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:hint="신장(CM)"
                    android:textSize="35dp" />

                <Button
                    android:id="@+id/bmiBtn"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:background="@drawable/main_itme_button"
                    android:text="BMI 계산하기" />

                <TextView
                    android:id="@+id/bmiRst"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:text="BMI : "
                    android:textSize="35dp" />

                <TextView
                    android:id="@+id/bmrRst"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:text="기초대사량 : "
                    android:textSize="35dp" />
            </LinearLayout>


            <ScrollView
                android:layout_width="match_parent"
                android:layout_height="wrap_content">

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:gravity="center_horizontal"
                    android:orientation="vertical">

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:text="다이어트 시작 날짜"
                        android:textSize="30sp" />

                    <FrameLayout
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content">

                        <DatePicker
                            android:id="@+id/startDatePicker"
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_gravity="center" />
                    </FrameLayout>

                    <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_marginTop="16dp"
                        android:text="다이어트 끝나는 날짜"
                        android:textSize="30sp" />

                    <FrameLayout
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content">

                        <DatePicker
                            android:id="@+id/endDatePicker"
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_gravity="center" />
                    </FrameLayout>

                    <Button
                        android:id="@+id/calculateButton"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_gravity="center"
                        android:background="@drawable/main_itme_button"
                        android:text="완료" />

                    <TextView
                        android:id="@+id/resultTextView"
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:gravity="center_horizontal"
                        android:text="다이어트 기간: "
                        android:textSize="30dp" />

                </LinearLayout>
            </ScrollView>


            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical">

                <Button
                    android:id="@+id/allresult"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:background="@drawable/main_itme_button"
                    android:text="결과 측정하기" />

                <ListView
                    android:id="@+id/rstView"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content" />
            </LinearLayout>

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical">
                <ImageView
                    android:layout_width="200dp"
                    android:layout_height="150dp"
                    android:src="@drawable/youtube"
                    android:layout_gravity="center"
                    android:background="@android:color/transparent"/>
                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:orientation="horizontal"
                    android:gravity="center">
                    <EditText
                        android:id="@+id/search"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:hint="운동 종류를 입력하세요"
                        android:inputType="text"
                        android:maxWidth="250dp"/>
                    <Button
                        android:id="@+id/searchBtn"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:background="@drawable/button_green"
                        android:text="검색" />
                </LinearLayout>
                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="0dp"
                    android:layout_weight="1"
                    android:orientation="vertical"
                    android:gravity="center_horizontal">

                    <ImageButton
                        android:id="@+id/showDialogButton"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:src="@drawable/calendar"
                        android:background="@android:color/transparent"
                       android:layout_margin="20dp"/>
                </LinearLayout>
            </LinearLayout>
        </ViewFlipper>
    </LinearLayout>

**뷰플리퍼로 화면전환을 하고 따로 한 리니어레이아웃을 수평으로 버튼 2개를 만들어 "이전 화면" "다음 화면"으로 뷰를 다음 뷰로 넘어가거나 이전으로 돌아감.
첫번째 뷰에는 라디오그룹으로 성별(남,여)를 정하고 EDITTEXT로 나이, 체중, 신장로 신체정보를 입력함. 이 정보를 LIST에 저장을 함. 그리고 버튼을 누르면 TEXTVIEW에 BMI랑 기초대사량을 출력함. 
두번째 뷰는 SCROLLVIEW로 캘린더 2개를 할당하여 나중 캘린더에서 원래캘린더를 빼서 다이어트 기간을 구함. 또 다시 이정보를 LIST에 저장함.
세번째 뷰에서는 LISTVIEW로 저장한 내용을 출력하고 버튼을 누르면 DIALOG로 BMI상태에 따라 dialog_underweight, dialog_normal, dialog_overweight, dialog_obese의 xml을 맞게 출력함.
네번째 뷰에는 EDITTEXT로 유튜브 검색을 함. 그 다음은 IMAGEBUTTON으로 캘린더 DIALOG(dialog_calendar.xml)를 연결함.**


- MainActivity.java
- public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), miniActivity.class);
                startActivity(intent);
            }
        });

    }
}

**처음 화면의 버튼으로 뷰플리퍼로 넘어가는 버튼**


  - miniActivity.java
  - public class miniActivity extends Activity {

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


**뷰플리퍼 이전화면, 뷰플리퍼 다음화면, BMI계산버튼(BMI계산, 기초대사량계산), 다이어트기간 계산버튼, 수치결과 계산+ 수치에 맞는 DIALOG추천, 유튜브검색버튼, IMAGEBUTTON 캘린더 DIALOG, 유튜브API연결, IMAGEBUTTON에 DIALOG에 캘린더 생성, 캘린더의 날짜선택 리스너, 메모 저장버튼, 캘린더 DIALOG 닫기버튼**

    

#### 2.4 결과물
  - 시작 화면
  - ![화면1](https://github.com/leeym27/mini/assets/172059199/3e379310-2644-4882-87f0-6d83880fec93)


  - 신체정보 작성하기
  -  ![화면2](https://github.com/leeym27/mini/assets/172059199/fc6d89e5-0813-42cb-aa9a-fa363564081c)  ![화면2-2](https://github.com/leeym27/mini/assets/172059199/fddc17e4-d9c5-4c97-967b-1527c41a955d)



  - 다이어트 날짜 정하기
  - ![화면3-1](https://github.com/leeym27/mini/assets/172059199/41b24465-0629-4bfc-bbe2-ad3173d50b23)   ![화면3-2](https://github.com/leeym27/mini/assets/172059199/b0b1f484-0892-4796-b250-e4a300e50285)



  - 결과 측정하기
  - ![화면4-1](https://github.com/leeym27/mini/assets/172059199/0450e047-7eb0-49fb-af0c-b0b7d6116b91)   ![화면4-2](https://github.com/leeym27/mini/assets/172059199/b9b479fa-10ea-42d4-9133-294edcf5c17a)



  - 유튜브 검색하기
  - ![화면5-1](https://github.com/leeym27/mini/assets/172059199/9ad4fa89-24f9-4c6e-b179-5960ea8694ff)   ![화면5-2](https://github.com/leeym27/mini/assets/172059199/7feceee6-fc0c-44b5-9e51-f1f848d65e10)



  - 캘린더 작성하기
  - ![화면5-3](https://github.com/leeym27/mini/assets/172059199/934d0141-689e-45b0-89f6-e48b3ea885ac)

#### 2.5 시연 영상
[유튜브 시연영상](https://youtu.be/bSnYqUteywE)





















