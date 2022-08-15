package com.example.stringpatternmatching;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.stringpatternmatching.databinding.ActivityMainBinding;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;


/* NOTE BY : Hardi Rachh,14/08/2022
 *  For String,
 *   (Used StringValidOrNOt class)
 *  (1) Only lowercase letter ([a-z]),
 *  (2) square bracket (opening and closing check) in a string.
 *
 * For pattern match where by,
 *  (Used PalindromeString class)
 *  (a) 2 string are followed by the reverse of that pair
 *     for example "rttr"
 *  (b) Also middle charcter should be different from first and
 *      last charcater e.g : "bbbb" not valid.
 *  (c) Only outside from the []/bracket strings are valid but
 *     with above (a) and (b) senario should be match.
 *
 *  For example,
 *  rttr[mnop]qrst : only "rttr" valid string
 *  ab[ba] : Invalid string for pattren occurance.
 * */

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<String> patternList = new ArrayList<String>();
    ValidStringPatternAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ButterKnife.bind(this);

        binding.edittextValue.setHint(R.string.hintText);

        binding.tvNoData.setVisibility(View.VISIBLE);
        binding.btnClear.setVisibility(View.GONE);
        binding.recyclerViewValidPattern.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        adapter = new ValidStringPatternAdapter(this, patternList);
        binding.recyclerViewValidPattern.setAdapter(adapter);
    }

    /*check your string with regex or valid/not for pattern occurance*/
    @SuppressLint("NonConstantResourceId")
    @OnClick(R.id.btn_click)
    public void checkYourString() {
     String input =binding.edittextValue.getText().toString();
        if (input.isEmpty()) {
            Toast.makeText(this, "Please Add Some String, Thank You!!!", Toast.LENGTH_LONG).show();
        } else {
            if(input.contains("\n")){
             input =  input.replaceAll("\n","");
            }
            if (StringValidOrNOt.isValidOrNotLowecase(input)) {
                doValidatePattern(input);
                Log.d("*********", input);
            } else if (StringValidOrNOt.isValidOrNotLowecaseSquareBracket(input)) {
                String updateInput = input.replaceFirst("\\[[^\\]]+\\]", "").trim();
                Log.d("---------", updateInput);
                doValidatePattern(updateInput);
            } else {
                Toast.makeText(this, input + ": Invalid String :", Toast.LENGTH_LONG).show();
            }
        }
    }

    //check your string have valid pattern or not.
    public void doValidatePattern(String updateInput) {
        if (updateInput.length() < 4) {
            Toast.makeText(this, updateInput + " : No occurrence of pattern :", Toast.LENGTH_LONG).show();
        } else {
            ArrayList<String> validPalindromeStr = PalindromeString.longestPalindromeString(updateInput);
            if (validPalindromeStr.size() > 0) {
                binding.recyclerViewValidPattern.setVisibility(View.VISIBLE);
                patternList.addAll(validPalindromeStr);
                adapter.notifyDataSetChanged();
                binding.btnClear.setVisibility(View.VISIBLE);
                binding.tvNoData.setVisibility(View.GONE);
                binding.tvCount.setText(patternList.size() + "");
                Toast.makeText(this, updateInput + " : String Added :", Toast.LENGTH_LONG).show();
            } else {
                if(patternList.size() >0){
                    binding.recyclerViewValidPattern.setVisibility(View.VISIBLE);
                    binding.btnClear.setVisibility(View.VISIBLE);
                    binding.tvNoData.setVisibility(View.GONE);
                    binding.tvCount.setText(patternList.size() + "");
                }else {
                    binding.tvCount.setText(0 + "");
                    binding.recyclerViewValidPattern.setVisibility(View.INVISIBLE);
                    binding.btnClear.setVisibility(View.GONE);
                    binding.tvNoData.setVisibility(View.VISIBLE);
                }
                Toast.makeText(this, updateInput + " : No occurrence of pattern :", Toast.LENGTH_LONG).show();
            }
            validPalindromeStr.clear();
        }
    }

    @OnClick({R.id.btn_clear})
    public void clearData() {
        if (patternList.size() > 0) {
            binding.tvCount.setText(0+ "");
            patternList.clear();
            binding.edittextValue.setText("");
            binding.edittextValue.setHint(R.string.hintText);
            binding.btnClear.setVisibility(View.GONE);
            binding.tvNoData.setVisibility(View.VISIBLE);
            binding.recyclerViewValidPattern.setVisibility(View.INVISIBLE);
        }else {
            Toast.makeText(this, "No Data Available", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        patternList.clear();
        binding.edittextValue.setText("");
        binding.tvCount.setText(0);
        super.onDestroy();
    }
}