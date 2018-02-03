package android.databinding.generated.callback;
public final class OnClickListener implements android.view.View.OnClickListener {
    final Listener mListener;
    final int mSourceId;
    public OnClickListener(Listener listener, int sourceId) {
        mListener = listener;
        mSourceId = sourceId;
    }
    @Override
    public void onClick(android.view.View callbackArg_0) {
        mListener._internalCallbackOnClick(mSourceId , callbackArg_0);
    }
    public interface Listener {
        void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0);
    }
}