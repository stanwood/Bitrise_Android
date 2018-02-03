package android.databinding.generated.callback;
public final class TextSubmissionListener implements io.stanwood.bitrise.util.databinding.TextSubmissionListener {
    final Listener mListener;
    final int mSourceId;
    public TextSubmissionListener(Listener listener, int sourceId) {
        mListener = listener;
        mSourceId = sourceId;
    }
    @Override
    public void invoke(java.lang.String callbackArg_0) {
        mListener._internalCallbackInvoke(mSourceId , callbackArg_0);
    }
    public interface Listener {
        void _internalCallbackInvoke(int sourceId , java.lang.String callbackArg_0);
    }
}