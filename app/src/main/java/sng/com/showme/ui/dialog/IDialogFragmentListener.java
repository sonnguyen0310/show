package sng.com.showme.ui.dialog;

/**
 * Created by Yannick Gerard <yannick.gerard@tapptic.com> on 02/09/15.
 */
public interface IDialogFragmentListener {

    void onPositiveButtonClicked(int dialogId);

    void onCancel(int dialogId);
}
