package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zique_yuutaka.palindromeapp.R;

import woodferren.izak.palindrome.PalindromeChecker;
import woodferren.izak.palindrome.StringProcessor;

/**
 * Created by Zique Yuutaka on 2/26/2017.
 */

public class EntryFragment extends Fragment {

    private static final String DEBUG = "DEBUG";
    private static final String RESULT_DIALOG = "ResultDialog";

    private Button btSubmit;
    private Button btClear;
    private EditText etEntry;

    private String palindromeString;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup fragContainer,
                                Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.entry_fragment_layout, fragContainer, false);

        //grab EditText view object
        etEntry = (EditText)v.findViewById(R.id.etEntry);

        //wire buttons
        wireButtons(v);

        return v;

    }

    private void wireButtons(View view){
        btSubmit = (Button)view.findViewById(R.id.btSubmit);
        btSubmit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Log.d(DEBUG, "Submit button pressed");

                palindromeString = etEntry.getText().toString();

                Log.d(DEBUG, "Value of palindromeString: " + palindromeString);

                if(StringProcessor.isEmpty(palindromeString)){
                    toastMaker("Nothing to submit");
                }else{
                    if(StringProcessor.isValidString(palindromeString)){
                        Log.d(DEBUG, "Correctly formatted string");
                        PalindromeChecker checker = new PalindromeChecker(palindromeString);

                        FragmentManager manager = getFragmentManager();
                        ResultDialogFragment dialog = new ResultDialogFragment();
                        dialog.setMessage(messageBuilder(checker.isPalindrome()));
                        dialog.show(manager, RESULT_DIALOG);

                        clearText();
                    }else{
                        Log.d(DEBUG, "Incorrectly formatted string");
                        toastMaker("Incorrectly formatted string");
                    }
                }

            }
        });

        btClear = (Button)view.findViewById(R.id.btClear);
        btClear.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Log.d(DEBUG, "Clear button pressed");

                clearText();
            }
        });

    }//end wireButtons

    private void clearText(){
        if(etEntry.getText().toString().equals("")){
            toastMaker("Nothing to clear");

        }else{
            Log.d(DEBUG, "Clearing text");
            etEntry.setText("");
        }
    }

    private String messageBuilder(boolean result){
        if(result){
            return palindromeString + " is a palindrome!";
        }else{
            return palindromeString + " is NOT a palindrome!";
        }
    }

    private void toastMaker(String msg){
        Toast.makeText(getActivity(), msg,Toast.LENGTH_SHORT).show();
    }
}
