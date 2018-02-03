package io.stanwood.bitrise.databinding;
import io.stanwood.bitrise.R;
import io.stanwood.bitrise.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemBuildBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.ic_duration, 8);
    }
    // views
    @NonNull
    public final android.support.v7.widget.AppCompatTextView branch;
    @NonNull
    public final android.support.v7.widget.AppCompatTextView buildDuration;
    @NonNull
    public final android.support.v7.widget.AppCompatTextView buildNumber;
    @NonNull
    public final android.support.v7.widget.AppCompatImageView icDuration;
    @NonNull
    public final android.support.v7.widget.AppCompatTextView lastBuildTime;
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    @NonNull
    private final android.view.View mboundView1;
    @NonNull
    public final android.support.v7.widget.AppCompatTextView status;
    @NonNull
    public final android.support.v7.widget.AppCompatImageView typeIcon;
    // variables
    @Nullable
    private io.stanwood.bitrise.ui.builds.vm.BuildItemViewModel mVm;
    @Nullable
    private final android.view.View.OnClickListener mCallback6;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemBuildBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds);
        this.branch = (android.support.v7.widget.AppCompatTextView) bindings[7];
        this.branch.setTag(null);
        this.buildDuration = (android.support.v7.widget.AppCompatTextView) bindings[5];
        this.buildDuration.setTag(null);
        this.buildNumber = (android.support.v7.widget.AppCompatTextView) bindings[6];
        this.buildNumber.setTag(null);
        this.icDuration = (android.support.v7.widget.AppCompatImageView) bindings[8];
        this.lastBuildTime = (android.support.v7.widget.AppCompatTextView) bindings[4];
        this.lastBuildTime.setTag(null);
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.view.View) bindings[1];
        this.mboundView1.setTag(null);
        this.status = (android.support.v7.widget.AppCompatTextView) bindings[3];
        this.status.setTag(null);
        this.typeIcon = (android.support.v7.widget.AppCompatImageView) bindings[2];
        this.typeIcon.setTag(null);
        setRootTag(root);
        // listeners
        mCallback6 = new android.databinding.generated.callback.OnClickListener(this, 1);
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
            setVm((io.stanwood.bitrise.ui.builds.vm.BuildItemViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVm(@Nullable io.stanwood.bitrise.ui.builds.vm.BuildItemViewModel Vm) {
        this.mVm = Vm;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }
    @Nullable
    public io.stanwood.bitrise.ui.builds.vm.BuildItemViewModel getVm() {
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
        io.stanwood.bitrise.ui.builds.vm.BuildItemViewModel vm = mVm;
        java.lang.String vmStatus = null;
        java.lang.String vmBranch = null;
        java.lang.String vmTriggeredAt = null;
        android.graphics.drawable.Drawable vmIcon = null;
        int vmColor = 0;
        java.lang.String vmNumber = null;
        java.lang.String vmDuration = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (vm != null) {
                    // read vm.status
                    vmStatus = vm.getStatus();
                    // read vm.branch
                    vmBranch = vm.getBranch();
                    // read vm.triggeredAt
                    vmTriggeredAt = vm.getTriggeredAt();
                    // read vm.icon
                    vmIcon = vm.getIcon();
                    // read vm.color
                    vmColor = vm.getColor();
                    // read vm.number
                    vmNumber = vm.getNumber();
                    // read vm.duration
                    vmDuration = vm.getDuration();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.branch, vmBranch);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.buildDuration, vmDuration);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.buildNumber, vmNumber);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.lastBuildTime, vmTriggeredAt);
            android.databinding.adapters.ViewBindingAdapter.setBackground(this.mboundView1, android.databinding.adapters.Converters.convertColorToDrawable(vmColor));
            android.databinding.adapters.TextViewBindingAdapter.setText(this.status, vmStatus);
            this.status.setTextColor(vmColor);
            android.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.typeIcon, vmIcon);
            // api target 21
            if(getBuildSdkInt() >= 21) {

                this.typeIcon.setImageTintList(android.databinding.adapters.Converters.convertColorToColorStateList(vmColor));
            }
        }
        if ((dirtyFlags & 0x2L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(mCallback6);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // vm != null
        boolean vmJavaLangObjectNull = false;
        // vm
        io.stanwood.bitrise.ui.builds.vm.BuildItemViewModel vm = mVm;



        vmJavaLangObjectNull = (vm) != (null);
        if (vmJavaLangObjectNull) {


            vm.onClick();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ItemBuildBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemBuildBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ItemBuildBinding>inflate(inflater, io.stanwood.bitrise.R.layout.item_build, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ItemBuildBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemBuildBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(io.stanwood.bitrise.R.layout.item_build, null, false), bindingComponent);
    }
    @NonNull
    public static ItemBuildBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemBuildBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/item_build_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ItemBuildBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): vm
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}