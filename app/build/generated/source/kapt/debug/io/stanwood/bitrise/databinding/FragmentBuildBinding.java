package io.stanwood.bitrise.databinding;
import io.stanwood.bitrise.R;
import io.stanwood.bitrise.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentBuildBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appbar, 3);
        sViewsWithIds.put(R.id.tabs, 4);
    }
    // views
    @NonNull
    public final android.support.design.widget.AppBarLayout appbar;
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.support.v7.widget.Toolbar mboundView1;
    @NonNull
    public final android.support.v4.view.ViewPager pager;
    @NonNull
    public final android.support.design.widget.TabLayout tabs;
    // variables
    @Nullable
    private io.stanwood.bitrise.ui.build.vm.BuildViewModel mVm;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentBuildBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds);
        this.appbar = (android.support.design.widget.AppBarLayout) bindings[3];
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.support.v7.widget.Toolbar) bindings[1];
        this.mboundView1.setTag(null);
        this.pager = (android.support.v4.view.ViewPager) bindings[2];
        this.pager.setTag(null);
        this.tabs = (android.support.design.widget.TabLayout) bindings[4];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
            setVm((io.stanwood.bitrise.ui.build.vm.BuildViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVm(@Nullable io.stanwood.bitrise.ui.build.vm.BuildViewModel Vm) {
        this.mVm = Vm;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }
    @Nullable
    public io.stanwood.bitrise.ui.build.vm.BuildViewModel getVm() {
        return mVm;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        io.stanwood.bitrise.ui.build.vm.BuildViewModel vm = mVm;
        io.stanwood.bitrise.ui.build.ui.FragmentAdapter vmAdapter = null;
        java.lang.String vmTitle = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (vm != null) {
                    // read vm.adapter
                    vmAdapter = vm.getAdapter();
                    // read vm.title
                    vmTitle = vm.getTitle();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            this.mboundView1.setTitle(vmTitle);
            io.stanwood.bitrise.util.databinding.ViewPagerDataBindingsKt.setAdapter(this.pager, vmAdapter);
        }
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            io.stanwood.bitrise.util.databinding.ViewPagerDataBindingsKt.setViewPager(this.pager, tabs);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static FragmentBuildBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentBuildBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FragmentBuildBinding>inflate(inflater, io.stanwood.bitrise.R.layout.fragment_build, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FragmentBuildBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentBuildBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(io.stanwood.bitrise.R.layout.fragment_build, null, false), bindingComponent);
    }
    @NonNull
    public static FragmentBuildBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FragmentBuildBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fragment_build_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FragmentBuildBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): vm
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}