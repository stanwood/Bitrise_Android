package io.stanwood.bitrise.databinding;
import io.stanwood.bitrise.R;
import io.stanwood.bitrise.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemArtifactBinding extends android.databinding.ViewDataBinding implements android.databinding.generated.callback.OnClickListener.Listener {

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
    public final android.support.v7.widget.AppCompatTextView lastBuildTime;
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    @NonNull
    public final android.widget.ProgressBar progress;
    @NonNull
    public final android.support.v7.widget.AppCompatTextView status;
    @NonNull
    public final android.support.v7.widget.AppCompatImageView typeIcon;
    // variables
    @Nullable
    private io.stanwood.bitrise.ui.artifacts.vm.ArtifactItemViewModel mVm;
    @Nullable
    private final android.view.View.OnClickListener mCallback9;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemArtifactBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 3);
        final Object[] bindings = mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds);
        this.lastBuildTime = (android.support.v7.widget.AppCompatTextView) bindings[3];
        this.lastBuildTime.setTag(null);
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.progress = (android.widget.ProgressBar) bindings[4];
        this.progress.setTag(null);
        this.status = (android.support.v7.widget.AppCompatTextView) bindings[2];
        this.status.setTag(null);
        this.typeIcon = (android.support.v7.widget.AppCompatImageView) bindings[1];
        this.typeIcon.setTag(null);
        setRootTag(root);
        // listeners
        mCallback9 = new android.databinding.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
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
            setVm((io.stanwood.bitrise.ui.artifacts.vm.ArtifactItemViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setVm(@Nullable io.stanwood.bitrise.ui.artifacts.vm.ArtifactItemViewModel Vm) {
        updateRegistration(0, Vm);
        this.mVm = Vm;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }
    @Nullable
    public io.stanwood.bitrise.ui.artifacts.vm.ArtifactItemViewModel getVm() {
        return mVm;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeVm((io.stanwood.bitrise.ui.artifacts.vm.ArtifactItemViewModel) object, fieldId);
            case 1 :
                return onChangeVmDownloadedSize((android.databinding.ObservableInt) object, fieldId);
            case 2 :
                return onChangeVmTotalSize((android.databinding.ObservableInt) object, fieldId);
        }
        return false;
    }
    private boolean onChangeVm(io.stanwood.bitrise.ui.artifacts.vm.ArtifactItemViewModel Vm, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.size) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        else if (fieldId == BR.downloading) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmDownloadedSize(android.databinding.ObservableInt VmDownloadedSize, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1aL;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeVmTotalSize(android.databinding.ObservableInt VmTotalSize, int fieldId) {
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
        boolean vmIsDownloading = false;
        io.stanwood.bitrise.ui.artifacts.vm.ArtifactItemViewModel vm = mVm;
        java.lang.String vmTitle = null;
        int vmDownloadedSizeGet = 0;
        android.databinding.ObservableInt vmDownloadedSize = null;
        int vmTotalSizeGet = 0;
        java.lang.String vmSize = null;
        android.graphics.drawable.Drawable vmIcon = null;
        android.databinding.ObservableInt vmTotalSize = null;

        if ((dirtyFlags & 0x3fL) != 0) {


            if ((dirtyFlags & 0x31L) != 0) {

                    if (vm != null) {
                        // read vm.isDownloading
                        vmIsDownloading = vm.isDownloading();
                    }
            }
            if ((dirtyFlags & 0x21L) != 0) {

                    if (vm != null) {
                        // read vm.title
                        vmTitle = vm.getTitle();
                        // read vm.icon
                        vmIcon = vm.getIcon();
                    }
            }
            if ((dirtyFlags & 0x23L) != 0) {

                    if (vm != null) {
                        // read vm.downloadedSize
                        vmDownloadedSize = vm.getDownloadedSize();
                    }
                    updateRegistration(1, vmDownloadedSize);


                    if (vmDownloadedSize != null) {
                        // read vm.downloadedSize.get()
                        vmDownloadedSizeGet = vmDownloadedSize.get();
                    }
            }
            if ((dirtyFlags & 0x29L) != 0) {

                    if (vm != null) {
                        // read vm.size
                        vmSize = vm.getSize();
                    }
            }
            if ((dirtyFlags & 0x25L) != 0) {

                    if (vm != null) {
                        // read vm.totalSize
                        vmTotalSize = vm.getTotalSize();
                    }
                    updateRegistration(2, vmTotalSize);


                    if (vmTotalSize != null) {
                        // read vm.totalSize.get()
                        vmTotalSizeGet = vmTotalSize.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x29L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.lastBuildTime, vmSize);
        }
        if ((dirtyFlags & 0x20L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(mCallback9);
        }
        if ((dirtyFlags & 0x25L) != 0) {
            // api target 1

            this.progress.setMax(vmTotalSizeGet);
        }
        if ((dirtyFlags & 0x23L) != 0) {
            // api target 1

            this.progress.setProgress(vmDownloadedSizeGet);
        }
        if ((dirtyFlags & 0x31L) != 0) {
            // api target 1

            io.stanwood.bitrise.util.databinding.ViewDataBindingsKt.setVisibility(this.progress, vmIsDownloading);
        }
        if ((dirtyFlags & 0x21L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.status, vmTitle);
            android.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.typeIcon, vmIcon);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // vm != null
        boolean vmJavaLangObjectNull = false;
        // vm
        io.stanwood.bitrise.ui.artifacts.vm.ArtifactItemViewModel vm = mVm;



        vmJavaLangObjectNull = (vm) != (null);
        if (vmJavaLangObjectNull) {


            vm.onClick();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ItemArtifactBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemArtifactBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ItemArtifactBinding>inflate(inflater, io.stanwood.bitrise.R.layout.item_artifact, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ItemArtifactBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemArtifactBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(io.stanwood.bitrise.R.layout.item_artifact, null, false), bindingComponent);
    }
    @NonNull
    public static ItemArtifactBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ItemArtifactBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/item_artifact_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ItemArtifactBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): vm
        flag 1 (0x2L): vm.downloadedSize
        flag 2 (0x3L): vm.totalSize
        flag 3 (0x4L): vm.size
        flag 4 (0x5L): vm.isDownloading
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}