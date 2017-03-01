package fragments;



import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

/**
 * Created by Zique Yuutaka on 2/28/2017.
 */

public class ResultDialogFragment extends DialogFragment {

    private String resultMsg;

    public void setMessage(String msg){
        resultMsg = msg;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        return new AlertDialog.Builder(getActivity())
                .setTitle(resultMsg)
                .setPositiveButton(android.R.string.ok,null)
                .create();
    }
}
