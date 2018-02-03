package io.stanwood.bitrise.databinding;
import io.stanwood.bitrise.R;
import io.stanwood.bitrise.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentBuildsBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnRefreshListener.Listener {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(5);
        sIncludes.setIncludes(1, 
            new String[] {"layout_toolbar"},
            new int[] {4},
            new int[] {R.layout.layout_toolbar});
        sViewsWithIds = null;
    }
    // views
    @NonNull
    public final android.support.design.widget.CoordinatorLayout mainContent;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    @Nullable
    private final io.stanwood.bitrise.databinding.LayoutToolbarBinding mboundView11;
    @NonNull
    private final android.support.v4.widget.SwipeRefreshLayout mboundView2;
    @NonNull
    private final android.support.v7.widget.RecyclerView mboundView3;
    // variables
    @Nullable
    private io.stanwood.bitrise.ui.builds.vm.BuildsViewModel mVm;
    @Nullable
    private final android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener mCallback1;
    // values
    // listeners
    private EndOfListReachedListenerImpl mVmOnEndOfListReachedIoStanwoodBitriseUtilDatabindingEndOfListReachedListener;
    // Inverse Binding Event Handlers

    public FragmentBuildsBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 2);
        final Object[] bindings = mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds);
        this.mainContent = (android.support.design.widget.CoordinatorLayout) bindings[0];
        this.mainContent.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView11 = (io.stanwood.bitrise.databinding.LayoutToolbarBinding) bindings[4];
        setContainedBinding(this.mboundView11);
        this.mboundView2 = (android.support.v4.widget.SwipeRefreshLayout) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.support.v7.widget.RecyclerView) bindings[3];
        this.mboundView3.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new android.databinding.generated.callback.OnRefreshListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        mboundView11.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (mboundView11.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.vm == variableId) {
            setVm((io.stanwood.bitrise.ui.builds.vm.BuildsViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVm(@Nullable io.stanwood.bitrise.ui.builds.vm.BuildsViewModel Vm) {
        this.mVm = Vm;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }
    @Nullable
    public io.stanwood.bitrise.ui.builds.vm.BuildsViewModel getVm() {
        return mVm;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeVmIsLoading((android.databinding.ObservableBoolean) object, fieldId);
            case 1 :
                return onChangeVmItems((android.databinding.ObservableArrayList<io.stanwood.bitrise.ui.builds.vm.BuildItemViewModel>) object, fieldId);
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
    private boolean onChangeVmItems(android.databinding.ObservableArrayList<io.stanwood.bitrise.ui.builds.vm.BuildItemViewModel> VmItems, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
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
        io.stanwood.bitrise.ui.builds.vm.BuildsViewModel vm = mVm;
        java.lang.String vmTitle = null;
        boolean vmIsLoadingGet = false;
        io.stanwood.bitrise.util.databinding.EndOfListReachedListener vmOnEndOfListReachedIoStanwoodBitriseUtilDatabindingEndOfListReachedListener = null;
        android.databinding.ObservableBoolean vmIsLoading = null;
        android.databinding.ObservableArrayList<io.stanwood.bitrise.ui.builds.vm.BuildItemViewModel> vmItems = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xcL) != 0) {

                    if (vm != null) {
                        // read vm.title
                        vmTitle = vm.getTitle();
                        // read vm::onEndOfListReached
                        vmOnEndOfListReachedIoStanwoodBitriseUtilDatabindingEndOfListReachedListener = (((mVmOnEndOfListReachedIoStanwoodBitriseUtilDatabindingEndOfListReachedListener == null) ? (mVmOnEndOfListReachedIoStanwoodBitriseUtilDatabindingEndOfListReachedListener = new EndOfListReachedListenerImpl()) : mVmOnEndOfListReachedIoStanwoodBitriseUtilDatabindingEndOfListReachedListener).setValue(vm));
                    }
            }
            if ((dirtyFlags & 0xdL) != 0) {

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
            if ((dirtyFlags & 0xeL) != 0) {

                    if (vm != null) {
                        // read vm.items
                        vmItems = vm.getItems();
                    }
                    updateRegistration(1, vmItems);
            }
        }
        // batch finished
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            this.mboundView11.setTitle(vmTitle);
            io.stanwood.bitrise.util.databinding.RecyclerViewDataBindingsKt.setEndOfListReachedLister(this.mboundView3, (io.stanwood.bitrise.util.databinding.EndOfListReachedListener)vmOnEndOfListReachedIoStanwoodBitriseUtilDatabindingEndOfListReachedListener, io.stanwood.bitrise.BuildConfig.PAGE_LOAD_THRESHOLD);
        }
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.mboundView2.setOnRefreshListener(mCallback1);
            io.stanwood.bitrise.util.databinding.RecyclerViewDataBindingsKt.setDivider(this.mboundView3, android.support.v7.widget.LinearLayoutManager.VERTICAL);
            io.stanwood.bitrise.util.databinding.RecyclerViewDataBindingsKt.setOrientation(this.mboundView3, android.support.v7.widget.LinearLayoutManager.VERTICAL);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            this.mboundView2.setRefreshing(vmIsLoadingGet);
        }
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            io.stanwood.bitrise.util.databinding.RecyclerViewDataBindingsKt.setItems(this.mboundView3, vmItems, R.layout.item_build);
        }
        executeBindingsOn(mboundView11);
    }
    // Listener Stub Implementations
    public static class EndOfListReachedListenerImpl implements io.stanwood.bitrise.util.databinding.EndOfListReachedListener{
        private io.stanwood.bitrise.ui.builds.vm.BuildsViewModel value;
        public EndOfListReachedListenerImpl setValue(io.stanwood.bitrise.ui.builds.vm.BuildsViewModel value) {
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
        io.stanwood.bitrise.ui.builds.vm.BuildsViewModel vm = mVm;



        vmJavaLangObjectNull = (vm) != (null);
        if (vmJavaLangObjectNull) {


            vm.onRefresh();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static FragmentBuildsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentBuildsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FragmentBuildsBinding>inflate(inflater, io.stanwood.bitrise.R.layout.fragment_builds, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FragmentBuildsBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentBuildsBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(io.stanwood.bitrise.R.layout.fragment_builds, null, false), bindingComponent);
    }
    @NonNull
    public static FragmentBuildsBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentBuildsBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fragment_builds_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FragmentBuildsBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): vm.isLoading
        flag 1 (0x2L): vm.items
        flag 2 (0x3L): vm
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}