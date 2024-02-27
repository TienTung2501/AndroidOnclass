package com.example.simplecaculate;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    String input = "";
    TextView txtDisplay;
    TextInputEditText txtInput;
    Button btnCE, btnX, btnC, btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPlus, btnMinus, btnResult, btnDivide, btnMulti;
    char operator = ' ';
    double firstOperand = 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDisplay =(TextView) findViewById(R.id.textViewDisplay);
        txtInput =(TextInputEditText) findViewById(R.id.editText);
        btn0 =(Button) findViewById(R.id.buttonNum0);
        btn1 =(Button) findViewById(R.id.buttonNum1);
        btn2 =(Button) findViewById(R.id.buttonNum2);
        btn3 =(Button) findViewById(R.id.buttonNum3);
        btn4 =(Button) findViewById(R.id.buttonNum4);
        btn5 =(Button) findViewById(R.id.buttonNum5);
        btn6 =(Button) findViewById(R.id.buttonNum6);
        btn7 =(Button) findViewById(R.id.buttonNum7);
        btn8 =(Button) findViewById(R.id.buttonNum8);
        btn9 =(Button) findViewById(R.id.buttonNum9);
        btnCE =(Button) findViewById(R.id.buttonCE);
        btnX =(Button) findViewById(R.id.buttonX);
        btnC =(Button) findViewById(R.id.buttonC);
        btnPlus =(Button) findViewById(R.id.buttonPlus);
        btnMinus =(Button) findViewById(R.id.buttonMinus);
        btnDivide =(Button) findViewById(R.id.buttonDivide);
        btnMulti =(Button) findViewById(R.id.buttonMulti);
        btnResult =(Button) findViewById(R.id.buttonResult);



// Thiết lập sự kiện cho nút 0
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "0";
                updateDisplay();
            }
        });

        // Thiết lập sự kiện cho nút 1
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "1";
                updateDisplay();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "2";
                updateDisplay();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "3";
                updateDisplay();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "4";
                updateDisplay();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "5";
                updateDisplay();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "6";
                updateDisplay();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "7";
                updateDisplay();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "8";
                updateDisplay();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "9";
                updateDisplay();
            }
        });
        // ... (thêm sự kiện cho các nút khác tương tự)

        // Thiết lập sự kiện cho nút cộng
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOperator('+');
            }
        });

        // Thiết lập sự kiện cho nút trừ
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOperator('-');
            }
        });

        // Thiết lập sự kiện cho nút nhân
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOperator('*');
            }
        });

        // Thiết lập sự kiện cho nút chia
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOperator('/');
            }
        });

        // Thiết lập sự kiện cho nút kết quả
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearInput();
            }
        });

// Thiết lập sự kiện cho nút CE
        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearAll();
            }
        });

// Thiết lập sự kiện cho nút X (xóa một ký tự)
        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeLastCharacter();
            }
        });
        // ... (thêm sự kiện cho các nút khác tương tự)
    }
    // Thiết lập sự kiện cho nút C


    // Phương thức để xóa toàn bộ nội dung đang nhập
    private void clearAll() {
        input = "";
        operator = ' ';
        firstOperand = 0;
        updateDisplay();
    }

    // Phương thức để xóa một ký tự cuối cùng
    private void removeLastCharacter() {
        if (!input.isEmpty()) {
            input = input.substring(0, input.length() - 1);
            updateDisplay();
        }
    }

    // Phương thức để xóa toàn bộ nội dung đang nhập
    private void clearInput() {
        input = "";
        updateDisplay();
    }


    // Phương thức cập nhật hiển thị
    private void updateDisplay() {
        txtInput.setText(input);
    }

    // Phương thức xử lý toán tử
    private void handleOperator(char newOperator) {
        if (!input.isEmpty()) {
            if (operator == ' ') {
                // Nếu đây là toán tử đầu tiên
                firstOperand = Double.parseDouble(input);
                operator = newOperator;
                input = "";
                updateDisplay();
            } else {
                // Nếu đã có toán tử trước đó, tính kết quả và hiển thị
                calculateResult();
                operator = newOperator;
            }
        }
    }

    // Phương thức tính kết quả
    private void calculateResult() {
        if (!input.isEmpty()) {
            double secondOperand = Double.parseDouble(input);
            double result = 0;

            switch (operator) {
                case '+':
                    result = firstOperand + secondOperand;
                    break;
                case '-':
                    result = firstOperand - secondOperand;
                    break;
                case '*':
                    result = firstOperand * secondOperand;
                    break;
                case '/':
                    // Kiểm tra chia cho 0
                    if (secondOperand != 0) {
                        result = firstOperand / secondOperand;
                    } else {
                        Toast.makeText(getApplicationContext(), "Không thể chia cho 0", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    break;
            }

            // Hiển thị kết quả
            txtInput.setText(String.valueOf(result));

            // Reset các biến để chuẩn bị tính toán tiếp theo

            firstOperand = result;
        }
    }

}