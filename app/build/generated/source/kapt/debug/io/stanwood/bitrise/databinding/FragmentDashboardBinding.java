package io.stanwood.bitrise.databinding;
import io.stanwood.bitrise.R;
import io.stanwood.bitrise.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentDashboardBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnRefreshListener.Listener {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(4);
        sIncludes.setIncludes(0, 
            new String[] {"layout_toolbar"},
            new int[] {3},
            new int[] {R.layout.layout_toolbar});
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.support.v4.widget.SwipeRefreshLayout mboundView1;
    @NonNull
    private final android.support.v7.widget.RecyclerView mboundView2;
    @Nullable
    public final io.stanwood.bitrise.databinding.LayoutToolbarBinding toolbar;
    // variables
    @Nullable
    private io.stanwood.bitrise.ui.dashboard.vm.DashboardViewModel mVm;
    @Nullable
    private final android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener mCallback2;
    // values
    // listeners
    private EndOfListReachedListenerImpl mVmOnEndOfListReachedIoStanwoodBitriseUtilDatabindingEndOfListReachedListener;
    // Inverse Binding Event Handlers

    public FragmentDashboardBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 3);
        final Object[] bindings = mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.support.v4.widget.SwipeRefreshLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.support.v7.widget.RecyclerView) bindings[2];
        this.mboundView2.setTag(null);
        this.toolbar = (io.stanwood.bitrise.databinding.LayoutToolbarBinding) bindings[3];
        setContainedBinding(this.toolbar);
        setRootTag(root);
        // listeners
        mCallback2 = new android.databinding.generated.callback.OnRefreshListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        toolbar.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (toolbar.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.vm == variableId) {
            setVm((io.stanwood.bitrise.ui.dashboard.vm.DashboardViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVm(@Nullable io.stanwood.bitrise.ui.dashboard.vm.DashboardViewModel Vm) {
        this.mVm = Vm;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }
    @Nullable
    public io.stanwood.bitrise.ui.dashboard.vm.DashboardViewModel getVm() {
        return mVm;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeVmIsLoading((android.databinding.ObservableBoolean) object, fieldId);
            case 1 :
                return onChangeToolbar((io.stanwood.bitrise.databinding.LayoutToolbarBinding) object, fieldId);
            case 2 :
                return onChangeVmItems((android.databinding.ObservableArrayList<io.stanwood.bitrise.ui.dashboard.vm.AppViewModel>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeVmIsLoading(android.databinding.ObservableBoolean VmIsLoading, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeToolbar(io.stanwood.bitrise.databinding.LayoutToolbarBinding Toolbar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmItems(android.databinding.ObservableArrayList<io.stanwood.bitrise.ui.dashboard.vm.AppViewModel> VmItems, int fieldId) {
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
        io.stanwood.bitrise.ui.dashboard.vm.DashboardViewModel vm = mVm;
        boolean vmIsLoadingGet = false;
        io.stanwood.bitrise.util.databinding.EndOfListReachedListener vmOnEndOfListReachedIoStanwoodBitriseUtilDatabindingEndOfListReachedListener = null;
        android.databinding.ObservableBoolean vmIsLoading = null;
        android.databinding.ObservableArrayList<io.stanwood.bitrise.ui.dashboard.vm.AppViewModel> vmItems = null;

        if ((dirtyFlags & 0x1dL) != 0) {


            if ((dirtyFlags & 0x18L) != 0) {

                    if (vm != null) {
                        // read vm::onEndOfListReached
                        vmOnEndOfListReachedIoStanwoodBitriseUtilDatabindingEndOfListReachedListener = (((mVmOnEndOfListReachedIoStanwoodBitriseUtilDatabindingEndOfListReachedListener == null) ? (mVmOnEndOfListReachedIoStanwoodBitriseUtilDatabindingEndOfListReachedListener = new EndOfListReachedListenerImpl()) : mVmOnEndOfListReachedIoStanwoodBitriseUtilDatabindingEndOfListReachedListener).setValue(vm));
                    }
            }
            if ((dirtyFlags & 0x19L) != 0) {

                    if (vm != null) {
                        // read vm.isLoading
                        vmIsLoading = vm.isLoading();
                    }
                    updateRegistration(0, vmIsLoading);


                    if (vmIsLoading != null) {
                        // read vm.isLoading.get()
                        vmIsLoadingGet = vmIsLoading.get();
                    }
            }
            if ((dirtyFlags & 0x1cL) != 0) {

                    if (vm != null) {
                        // read vm.items
                        vmItems = vm.getItems();
                    }
                    updateRegistration(2, vmItems);
            }
        }
        // batch finished
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            this.mboundView1.setOnRefreshListener(mCallback2);
            io.stanwood.bitrise.util.databinding.RecyclerViewDataBindingsKt.setDivider(this.mboundView2, android.support.v7.widget.LinearLayoutManager.VERTICAL);
            io.stanwood.bitrise.util.databinding.RecyclerViewDataBindingsKt.setOrientation(this.mboundView2, android.support.v7.widget.LinearLayoutManager.VERTICAL);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            this.mboundView1.setRefreshing(vmIsLoadingGet);
        }
        if ((dirtyFlags & 0x18L) != 0) {
            // api target 1

            io.stanwood.bitrise.util.databinding.RecyclerViewDataBindingsKt.setEndOfListReachedLister(this.mboundView2, (io.stanwood.bitrise.util.databinding.EndOfListReachedListener)vmOnEndOfListReachedIoStanwoodBitriseUtilDatabindingEndOfListReachedListener, io.stanwood.bitrise.BuildConfig.PAGE_LOAD_THRESHOLD);
        }
        if ((dirtyFlags & 0x1cL) != 0) {
            // api target 1

            io.stanwood.bitrise.util.databinding.RecyclerViewDataBindingsKt.setItems(this.mboundView2, vmItems, R.layout.item_app);
        }
        executeBindingsOn(toolbar);
    }
    // Listener Stub Implementations
    public static class EndOfListReachedListenerImpl implements io.stanwood.bitrise.util.databinding.EndOfListReachedListener{
        private io.stanwood.bitrise.ui.dashboard.vm.DashboardViewModel value;
        public EndOfListReachedListenerImpl setValue(io.stanwood.bitrise.ui.dashboard.vm.DashboardViewModel value) {
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
        io.stanwood.bitrise.ui.dashboard.vm.DashboardViewModel vm = mVm;



        vmJavaLangObjectNull = (vm) != (null);
        if (vmJavaLangObjectNull) {


            vm.onRefresh();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static FragmentDashboardBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentDashboardBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FragmentDashboardBinding>inflate(inflater, io.stanwood.bitrise.R.layout.fragment_dashboard, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FragmentDashboardBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentDashboardBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(io.stanwood.bitrise.R.layout.fragment_dashboard, null, false), bindingComponent);
    }
    @NonNull
    public static FragmentDashboardBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentDashboardBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fragment_dashboard_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FragmentDashboardBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): vm.isLoading
        flag 1 (0x2L): toolbar
        flag 2 (0x3L): vm.items
        flag 3 (0x4L): vm
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}