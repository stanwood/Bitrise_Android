package io.stanwood.bitrise.databinding;
import io.stanwood.bitrise.R;
import io.stanwood.bitrise.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentLogsBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnRefreshListener.Listener {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.support.v4.widget.SwipeRefreshLayout mboundView1;
    @NonNull
    private final android.widget.TextView mboundView2;
    // variables
    @Nullable
    private io.stanwood.bitrise.ui.logs.vm.LogsViewModel mVm;
    @Nullable
    private final android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener mCallback4;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentLogsBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 3);
        final Object[] bindings = mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.support.v4.widget.SwipeRefreshLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        setRootTag(root);
        // listeners
        mCallback4 = new android.databinding.generated.callback.OnRefreshListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.vm == variableId) {
            setVm((io.stanwood.bitrise.ui.logs.vm.LogsViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVm(@Nullable io.stanwood.bitrise.ui.logs.vm.LogsViewModel Vm) {
        updateRegistration(0, Vm);
        this.mVm = Vm;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }
    @Nullable
    public io.stanwood.bitrise.ui.logs.vm.LogsViewModel getVm() {
        return mVm;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeVm((io.stanwood.bitrise.ui.logs.vm.LogsViewModel) object, fieldId);
            case 1 :
                return onChangeVmLog((android.databinding.ObservableField<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeVmIsLoading((android.databinding.ObservableBoolean) object, fieldId);
        }
        return false;
    }
    private boolean onChangeVm(io.stanwood.bitrise.ui.logs.vm.LogsViewModel Vm, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmLog(android.databinding.ObservableField<java.lang.String> VmLog, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmIsLoading(android.databinding.ObservableBoolean VmIsLoading, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        io.stanwood.bitrise.ui.logs.vm.LogsViewModel vm = mVm;
        java.lang.String vmLogGet = null;
        boolean vmIsLoadingGet = false;
        android.databinding.ObservableField<java.lang.String> vmLog = null;
        android.databinding.ObservableBoolean vmIsLoading = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xbL) != 0) {

                    if (vm != null) {
                        // read vm.log
                        vmLog = vm.getLog();
                    }
                    updateRegistration(1, vmLog);


                    if (vmLog != null) {
                        // read vm.log.get()
                        vmLogGet = vmLog.get();
                    }
            }
            if ((dirtyFlags & 0xdL) != 0) {

                    if (vm != null) {
                        // read vm.isLoading
                        vmIsLoading = vm.isLoading();
                    }
                    updateRegistration(2, vmIsLoading);


                    if (vmIsLoading != null) {
                        // read vm.isLoading.get()
                        vmIsLoadingGet = vmIsLoading.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.mboundView1.setOnRefreshListener(mCallback4);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            this.mboundView1.setRefreshing(vmIsLoadingGet);
        }
        if ((dirtyFlags & 0xbL) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, vmLogGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnRefresh(int sourceId ) {
        // localize variables for thread safety
        // vm != null
        boolean vmJavaLangObjectNull = false;
        // vm
        io.stanwood.bitrise.ui.logs.vm.LogsViewModel vm = mVm;



        vmJavaLangObjectNull = (vm) != (null);
        if (vmJavaLangObjectNull) {


            vm.onRefresh();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static FragmentLogsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentLogsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FragmentLogsBinding>inflate(inflater, io.stanwood.bitrise.R.layout.fragment_logs, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FragmentLogsBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentLogsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(io.stanwood.bitrise.R.layout.fragment_logs, null, false), bindingComponent);
    }
    @NonNull
    public static FragmentLogsBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentLogsBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fragment_logs_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FragmentLogsBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): vm
        flag 1 (0x2L): vm.log
        flag 2 (0x3L): vm.isLoading
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}