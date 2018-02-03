package io.stanwood.bitrise.databinding;
import io.stanwood.bitrise.R;
import io.stanwood.bitrise.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentArtifactsBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnRefreshListener.Listener {

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
    private final android.widget.FrameLayout mboundView0;
    @NonNull
    private final android.support.v4.widget.SwipeRefreshLayout mboundView1;
    @NonNull
    private final android.support.v7.widget.RecyclerView mboundView2;
    // variables
    @Nullable
    private io.stanwood.bitrise.ui.artifacts.vm.ArtifactsViewModel mVm;
    @Nullable
    private final android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener mCallback5;
    // values
    // listeners
    private EndOfListReachedListenerImpl mVmOnEndOfListReachedIoStanwoodBitriseUtilDatabindingEndOfListReachedListener;
    // Inverse Binding Event Handlers

    public FragmentArtifactsBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 3);
        final Object[] bindings = mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.widget.FrameLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.support.v4.widget.SwipeRefreshLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.support.v7.widget.RecyclerView) bindings[2];
        this.mboundView2.setTag(null);
        setRootTag(root);
        // listeners
        mCallback5 = new android.databinding.generated.callback.OnRefreshListener(this, 1);
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
            setVm((io.stanwood.bitrise.ui.artifacts.vm.ArtifactsViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVm(@Nullable io.stanwood.bitrise.ui.artifacts.vm.ArtifactsViewModel Vm) {
        updateRegistration(0, Vm);
        this.mVm = Vm;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }
    @Nullable
    public io.stanwood.bitrise.ui.artifacts.vm.ArtifactsViewModel getVm() {
        return mVm;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeVm((io.stanwood.bitrise.ui.artifacts.vm.ArtifactsViewModel) object, fieldId);
            case 1 :
                return onChangeVmIsLoading((android.databinding.ObservableBoolean) object, fieldId);
            case 2 :
                return onChangeVmItems((android.databinding.ObservableArrayList<io.stanwood.bitrise.ui.artifacts.vm.ArtifactItemViewModel>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeVm(io.stanwood.bitrise.ui.artifacts.vm.ArtifactsViewModel Vm, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
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
    private boolean onChangeVmItems(android.databinding.ObservableArrayList<io.stanwood.bitrise.ui.artifacts.vm.ArtifactItemViewModel> VmItems, int fieldId) {
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
        io.stanwood.bitrise.ui.artifacts.vm.ArtifactsViewModel vm = mVm;
        boolean vmIsLoadingGet = false;
        io.stanwood.bitrise.util.databinding.EndOfListReachedListener vmOnEndOfListReachedIoStanwoodBitriseUtilDatabindingEndOfListReachedListener = null;
        android.databinding.ObservableBoolean vmIsLoading = null;
        android.databinding.ObservableArrayList<io.stanwood.bitrise.ui.artifacts.vm.ArtifactItemViewModel> vmItems = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0x9L) != 0) {

                    if (vm != null) {
                        // read vm::onEndOfListReached
                        vmOnEndOfListReachedIoStanwoodBitriseUtilDatabindingEndOfListReachedListener = (((mVmOnEndOfListReachedIoStanwoodBitriseUtilDatabindingEndOfListReachedListener == null) ? (mVmOnEndOfListReachedIoStanwoodBitriseUtilDatabindingEndOfListReachedListener = new EndOfListReachedListenerImpl()) : mVmOnEndOfListReachedIoStanwoodBitriseUtilDatabindingEndOfListReachedListener).setValue(vm));
                    }
            }
            if ((dirtyFlags & 0xbL) != 0) {

                    if (vm != null) {
                        // read vm.isLoading
                        vmIsLoading = vm.isLoading();
                    }
                    updateRegistration(1, vmIsLoading);


                    if (vmIsLoading != null) {
                        // read vm.isLoading.get()
                        vmIsLoadingGet = vmIsLoading.get();
                    }
            }
            if ((dirtyFlags & 0xdL) != 0) {

                    if (vm != null) {
                        // read vm.items
                        vmItems = vm.getItems();
                    }
                    updateRegistration(2, vmItems);
            }
        }
        // batch finished
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.mboundView1.setOnRefreshListener(mCallback5);
            io.stanwood.bitrise.util.databinding.RecyclerViewDataBindingsKt.setDivider(this.mboundView2, android.support.v7.widget.LinearLayoutManager.VERTICAL);
            io.stanwood.bitrise.util.databinding.RecyclerViewDataBindingsKt.setOrientation(this.mboundView2, android.support.v7.widget.LinearLayoutManager.VERTICAL);
        }
        if ((dirtyFlags & 0xbL) != 0) {
            // api target 1

            this.mboundView1.setRefreshing(vmIsLoadingGet);
        }
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            io.stanwood.bitrise.util.databinding.RecyclerViewDataBindingsKt.setEndOfListReachedLister(this.mboundView2, (io.stanwood.bitrise.util.databinding.EndOfListReachedListener)vmOnEndOfListReachedIoStanwoodBitriseUtilDatabindingEndOfListReachedListener, io.stanwood.bitrise.BuildConfig.PAGE_LOAD_THRESHOLD);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            io.stanwood.bitrise.util.databinding.RecyclerViewDataBindingsKt.setItems(this.mboundView2, vmItems, R.layout.item_artifact);
        }
    }
    // Listener Stub Implementations
    public static class EndOfListReachedListenerImpl implements io.stanwood.bitrise.util.databinding.EndOfListReachedListener{
        private io.stanwood.bitrise.ui.artifacts.vm.ArtifactsViewModel value;
        public EndOfListReachedListenerImpl setValue(io.stanwood.bitrise.ui.artifacts.vm.ArtifactsViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void invoke(int arg0) {
            this.value.onEndOfListReached(arg0);
        }
    }
    // callback impls
    public final void _internalCallbackOnRefresh(int sourceId ) {
        // localize variables for thread safety
        // vm != null
        boolean vmJavaLangObjectNull = false;
        // vm
        io.stanwood.bitrise.ui.artifacts.vm.ArtifactsViewModel vm = mVm;



        vmJavaLangObjectNull = (vm) != (null);
        if (vmJavaLangObjectNull) {


            vm.onRefresh();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static FragmentArtifactsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentArtifactsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FragmentArtifactsBinding>inflate(inflater, io.stanwood.bitrise.R.layout.fragment_artifacts, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FragmentArtifactsBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentArtifactsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(io.stanwood.bitrise.R.layout.fragment_artifacts, null, false), bindingComponent);
    }
    @NonNull
    public static FragmentArtifactsBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentArtifactsBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fragment_artifacts_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FragmentArtifactsBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): vm
        flag 1 (0x2L): vm.isLoading
        flag 2 (0x3L): vm.items
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}