package io.stanwood.bitrise.databinding;
import io.stanwood.bitrise.R;
import io.stanwood.bitrise.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentLoginBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.TextSubmissionListener.Listener {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.guideline, 5);
        sViewsWithIds.put(R.id.logo, 6);
        sViewsWithIds.put(R.id.app_info, 7);
    }
    // views
    @NonNull
    public final android.support.v7.widget.AppCompatTextView appInfo;
    @NonNull
    public final android.support.constraint.Guideline guideline;
    @NonNull
    public final android.support.design.widget.TextInputLayout input;
    @NonNull
    public final android.support.v7.widget.AppCompatImageView logo;
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    @NonNull
    private final android.support.v7.widget.AppCompatEditText mboundView2;
    @NonNull
    public final android.widget.ProgressBar progress;
    @NonNull
    public final android.support.v7.widget.AppCompatTextView tokenInstructions;
    // variables
    @Nullable
    private io.stanwood.bitrise.ui.login.vm.LoginViewModel mVm;
    @Nullable
    private final io.stanwood.bitrise.util.databinding.TextSubmissionListener mCallback8;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private android.databinding.InverseBindingListener mboundView2androidTextAttrChanged = new android.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of vm.token
            //         is vm.setToken((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = android.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView2);
            // localize variables for thread safety
            // vm != null
            boolean vmJavaLangObjectNull = false;
            // vm
            io.stanwood.bitrise.ui.login.vm.LoginViewModel vm = mVm;
            // vm.token
            java.lang.String vmToken = null;



            vmJavaLangObjectNull = (vm) != (null);
            if (vmJavaLangObjectNull) {




                vm.setToken(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public FragmentLoginBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 3);
        final Object[] bindings = mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds);
        this.appInfo = (android.support.v7.widget.AppCompatTextView) bindings[7];
        this.guideline = (android.support.constraint.Guideline) bindings[5];
        this.input = (android.support.design.widget.TextInputLayout) bindings[1];
        this.input.setTag(null);
        this.logo = (android.support.v7.widget.AppCompatImageView) bindings[6];
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.support.v7.widget.AppCompatEditText) bindings[2];
        this.mboundView2.setTag(null);
        this.progress = (android.widget.ProgressBar) bindings[4];
        this.progress.setTag(null);
        this.tokenInstructions = (android.support.v7.widget.AppCompatTextView) bindings[3];
        this.tokenInstructions.setTag(null);
        setRootTag(root);
        // listeners
        mCallback8 = new android.databinding.generated.callback.TextSubmissionListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
            setVm((io.stanwood.bitrise.ui.login.vm.LoginViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVm(@Nullable io.stanwood.bitrise.ui.login.vm.LoginViewModel Vm) {
        updateRegistration(0, Vm);
        this.mVm = Vm;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }
    @Nullable
    public io.stanwood.bitrise.ui.login.vm.LoginViewModel getVm() {
        return mVm;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeVm((io.stanwood.bitrise.ui.login.vm.LoginViewModel) object, fieldId);
            case 1 :
                return onChangeVmIsLoading((android.databinding.ObservableBoolean) object, fieldId);
            case 2 :
                return onChangeVmIsError((android.databinding.ObservableBoolean) object, fieldId);
        }
        return false;
    }
    private boolean onChangeVm(io.stanwood.bitrise.ui.login.vm.LoginViewModel Vm, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.token) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmIsLoading(android.databinding.ObservableBoolean VmIsLoading, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmIsError(android.databinding.ObservableBoolean VmIsError, int fieldId) {
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
        io.stanwood.bitrise.ui.login.vm.LoginViewModel vm = mVm;
        int vmIsLoadingViewINVISIBLEViewVISIBLE = 0;
        java.lang.String vmToken = null;
        boolean vmIsLoadingGet = false;
        java.lang.String vmIsErrorInputAndroidStringInvalidTokenJavaLangObjectNull = null;
        android.databinding.ObservableBoolean vmIsLoading = null;
        android.databinding.ObservableBoolean vmIsError = null;
        boolean vmIsErrorGet = false;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (vm != null) {
                        // read vm.token
                        vmToken = vm.getToken();
                    }
            }
            if ((dirtyFlags & 0x13L) != 0) {

                    if (vm != null) {
                        // read vm.isLoading
                        vmIsLoading = vm.isLoading();
                    }
                    updateRegistration(1, vmIsLoading);


                    if (vmIsLoading != null) {
                        // read vm.isLoading.get()
                        vmIsLoadingGet = vmIsLoading.get();
                    }
                if((dirtyFlags & 0x13L) != 0) {
                    if(vmIsLoadingGet) {
                            dirtyFlags |= 0x40L;
                    }
                    else {
                            dirtyFlags |= 0x20L;
                    }
                }


                    // read vm.isLoading.get() ? View.INVISIBLE : View.VISIBLE
                    vmIsLoadingViewINVISIBLEViewVISIBLE = ((vmIsLoadingGet) ? (android.view.View.INVISIBLE) : (android.view.View.VISIBLE));
            }
            if ((dirtyFlags & 0x15L) != 0) {

                    if (vm != null) {
                        // read vm.isError
                        vmIsError = vm.isError();
                    }
                    updateRegistration(2, vmIsError);


                    if (vmIsError != null) {
                        // read vm.isError.get()
                        vmIsErrorGet = vmIsError.get();
                    }
                if((dirtyFlags & 0x15L) != 0) {
                    if(vmIsErrorGet) {
                            dirtyFlags |= 0x100L;
                    }
                    else {
                            dirtyFlags |= 0x80L;
                    }
                }


                    // read vm.isError.get() ? @android:string/invalid_token : null
                    vmIsErrorInputAndroidStringInvalidTokenJavaLangObjectNull = ((vmIsErrorGet) ? (input.getResources().getString(R.string.invalid_token)) : (null));
            }
        }
        // batch finished
        if ((dirtyFlags & 0x15L) != 0) {
            // api target 1

            this.input.setError(vmIsErrorInputAndroidStringInvalidTokenJavaLangObjectNull);
        }
        if ((dirtyFlags & 0x13L) != 0) {
            // api target 1

            this.input.setVisibility(vmIsLoadingViewINVISIBLEViewVISIBLE);
            io.stanwood.bitrise.util.databinding.ViewDataBindingsKt.setVisibility(this.progress, vmIsLoadingGet);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            io.stanwood.bitrise.util.databinding.EditTextDataBindingsKt.test(this.mboundView2, mCallback8);
            android.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView2, (android.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (android.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView2androidTextAttrChanged);
            io.stanwood.bitrise.util.databinding.TextViewDataBindingsKt.setHtml(this.tokenInstructions, true);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, vmToken);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackInvoke(int sourceId , java.lang.String callbackArg_0) {
        // localize variables for thread safety
        // vm != null
        boolean vmJavaLangObjectNull = false;
        // vm
        io.stanwood.bitrise.ui.login.vm.LoginViewModel vm = mVm;



        vmJavaLangObjectNull = (vm) != (null);
        if (vmJavaLangObjectNull) {



            vm.onTokenEntered(callbackArg_0);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static FragmentLoginBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentLoginBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FragmentLoginBinding>inflate(inflater, io.stanwood.bitrise.R.layout.fragment_login, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FragmentLoginBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentLoginBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(io.stanwood.bitrise.R.layout.fragment_login, null, false), bindingComponent);
    }
    @NonNull
    public static FragmentLoginBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentLoginBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fragment_login_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FragmentLoginBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): vm
        flag 1 (0x2L): vm.isLoading
        flag 2 (0x3L): vm.isError
        flag 3 (0x4L): vm.token
        flag 4 (0x5L): null
        flag 5 (0x6L): vm.isLoading.get() ? View.INVISIBLE : View.VISIBLE
        flag 6 (0x7L): vm.isLoading.get() ? View.INVISIBLE : View.VISIBLE
        flag 7 (0x8L): vm.isError.get() ? @android:string/invalid_token : null
        flag 8 (0x9L): vm.isError.get() ? @android:string/invalid_token : null
    flag mapping end*/
    //end
}