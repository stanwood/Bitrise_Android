package io.stanwood.bitrise.databinding;
import io.stanwood.bitrise.R;
import io.stanwood.bitrise.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemAppBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnClickListener.Listener {

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
    public final android.support.v7.widget.AppCompatImageView buildStatusIcon;
    @NonNull
    public final android.support.v7.widget.AppCompatImageView icon;
    @NonNull
    public final android.support.v7.widget.AppCompatTextView lastBuildTime;
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    @NonNull
    private final android.view.View mboundView1;
    @NonNull
    public final android.support.v7.widget.AppCompatTextView repoOwner;
    @NonNull
    public final android.support.v7.widget.AppCompatTextView title;
    // variables
    @Nullable
    private io.stanwood.bitrise.ui.dashboard.vm.AppViewModel mVm;
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemAppBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds);
        this.buildStatusIcon = (android.support.v7.widget.AppCompatImageView) bindings[6];
        this.buildStatusIcon.setTag(null);
        this.icon = (android.support.v7.widget.AppCompatImageView) bindings[2];
        this.icon.setTag(null);
        this.lastBuildTime = (android.support.v7.widget.AppCompatTextView) bindings[5];
        this.lastBuildTime.setTag(null);
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.view.View) bindings[1];
        this.mboundView1.setTag(null);
        this.repoOwner = (android.support.v7.widget.AppCompatTextView) bindings[3];
        this.repoOwner.setTag(null);
        this.title = (android.support.v7.widget.AppCompatTextView) bindings[4];
        this.title.setTag(null);
        setRootTag(root);
        // listeners
        mCallback3 = new android.databinding.generated.callback.OnClickListener(this, 1);
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
            setVm((io.stanwood.bitrise.ui.dashboard.vm.AppViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVm(@Nullable io.stanwood.bitrise.ui.dashboard.vm.AppViewModel Vm) {
        updateRegistration(0, Vm);
        this.mVm = Vm;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }
    @Nullable
    public io.stanwood.bitrise.ui.dashboard.vm.AppViewModel getVm() {
        return mVm;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeVm((io.stanwood.bitrise.ui.dashboard.vm.AppViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeVm(io.stanwood.bitrise.ui.dashboard.vm.AppViewModel Vm, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.lastBuildTime) {
            synchronized(this) {
                    mDirtyFlags |= 0xeL;
            }
            return true;
        }
        else if (fieldId == BR.buildStatusColor) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        else if (fieldId == BR.buildStatusIcon) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
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
        android.graphics.drawable.Drawable vmBuildStatusIcon = null;
        io.stanwood.bitrise.ui.dashboard.vm.AppViewModel vm = mVm;
        java.lang.String vmTitle = null;
        java.lang.String vmLastBuildTime = null;
        java.lang.String vmRepoOwner = null;
        android.graphics.drawable.Drawable vmIcon = null;
        int vmBuildStatusColor = 0;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (vm != null) {
                        // read vm.buildStatusIcon
                        vmBuildStatusIcon = vm.getBuildStatusIcon();
                    }
            }
            if ((dirtyFlags & 0x11L) != 0) {

                    if (vm != null) {
                        // read vm.title
                        vmTitle = vm.getTitle();
                        // read vm.repoOwner
                        vmRepoOwner = vm.getRepoOwner();
                        // read vm.icon
                        vmIcon = vm.getIcon();
                    }
            }
            if ((dirtyFlags & 0x15L) != 0) {

                    if (vm != null) {
                        // read vm.lastBuildTime
                        vmLastBuildTime = vm.getLastBuildTime();
                    }
            }
            if ((dirtyFlags & 0x13L) != 0) {

                    if (vm != null) {
                        // read vm.buildStatusColor
                        vmBuildStatusColor = vm.getBuildStatusColor();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            android.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.buildStatusIcon, vmBuildStatusIcon);
        }
        if ((dirtyFlags & 0x13L) != 0) {
            // api target 21
            if(getBuildSdkInt() >= 21) {

                this.buildStatusIcon.setImageTintList(android.databinding.adapters.Converters.convertColorToColorStateList(vmBuildStatusColor));
            }
            // api target 1

            this.lastBuildTime.setTextColor(vmBuildStatusColor);
            android.databinding.adapters.ViewBindingAdapter.setBackground(this.mboundView1, android.databinding.adapters.Converters.convertColorToDrawable(vmBuildStatusColor));
        }
        if ((dirtyFlags & 0x11L) != 0) {
            // api target 1

            android.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.icon, vmIcon);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.repoOwner, vmRepoOwner);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.title, vmTitle);
        }
        if ((dirtyFlags & 0x15L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.lastBuildTime, vmLastBuildTime);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(mCallback3);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // vm != null
        boolean vmJavaLangObjectNull = false;
        // vm
        io.stanwood.bitrise.ui.dashboard.vm.AppViewModel vm = mVm;



        vmJavaLangObjectNull = (vm) != (null);
        if (vmJavaLangObjectNull) {


            vm.onClick();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ItemAppBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemAppBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ItemAppBinding>inflate(inflater, io.stanwood.bitrise.R.layout.item_app, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ItemAppBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemAppBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(io.stanwood.bitrise.R.layout.item_app, null, false), bindingComponent);
    }
    @NonNull
    public static ItemAppBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemAppBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/item_app_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ItemAppBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): vm
        flag 1 (0x2L): vm.buildStatusColor
        flag 2 (0x3L): vm.lastBuildTime
        flag 3 (0x4L): vm.buildStatusIcon
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}