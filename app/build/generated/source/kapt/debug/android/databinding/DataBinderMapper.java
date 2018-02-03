
package android.databinding;
import io.stanwood.bitrise.BR;
class DataBinderMapper  {
    final static int TARGET_MIN_SDK = 21;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case io.stanwood.bitrise.R.layout.fragment_builds:
                    return io.stanwood.bitrise.databinding.FragmentBuildsBinding.bind(view, bindingComponent);
                case io.stanwood.bitrise.R.layout.fragment_dashboard:
                    return io.stanwood.bitrise.databinding.FragmentDashboardBinding.bind(view, bindingComponent);
                case io.stanwood.bitrise.R.layout.item_app:
                    return io.stanwood.bitrise.databinding.ItemAppBinding.bind(view, bindingComponent);
                case io.stanwood.bitrise.R.layout.layout_toolbar:
                    return io.stanwood.bitrise.databinding.LayoutToolbarBinding.bind(view, bindingComponent);
                case io.stanwood.bitrise.R.layout.fragment_build:
                    return io.stanwood.bitrise.databinding.FragmentBuildBinding.bind(view, bindingComponent);
                case io.stanwood.bitrise.R.layout.fragment_logs:
                    return io.stanwood.bitrise.databinding.FragmentLogsBinding.bind(view, bindingComponent);
                case io.stanwood.bitrise.R.layout.fragment_artifacts:
                    return io.stanwood.bitrise.databinding.FragmentArtifactsBinding.bind(view, bindingComponent);
                case io.stanwood.bitrise.R.layout.item_build:
                    return io.stanwood.bitrise.databinding.ItemBuildBinding.bind(view, bindingComponent);
                case io.stanwood.bitrise.R.layout.fragment_error:
                    return io.stanwood.bitrise.databinding.FragmentErrorBinding.bind(view, bindingComponent);
                case io.stanwood.bitrise.R.layout.fragment_login:
                    return io.stanwood.bitrise.databinding.FragmentLoginBinding.bind(view, bindingComponent);
                case io.stanwood.bitrise.R.layout.item_artifact:
                    return io.stanwood.bitrise.databinding.ItemArtifactBinding.bind(view, bindingComponent);
        }
        return null;
    }
    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case 326952864: {
                if(tag.equals("layout/fragment_builds_0")) {
                    return io.stanwood.bitrise.R.layout.fragment_builds;
                }
                break;
            }
            case -1558282341: {
                if(tag.equals("layout/fragment_dashboard_0")) {
                    return io.stanwood.bitrise.R.layout.fragment_dashboard;
                }
                break;
            }
            case 1188273515: {
                if(tag.equals("layout/item_app_0")) {
                    return io.stanwood.bitrise.R.layout.item_app;
                }
                break;
            }
            case 1978887644: {
                if(tag.equals("layout/layout_toolbar_0")) {
                    return io.stanwood.bitrise.R.layout.layout_toolbar;
                }
                break;
            }
            case -1097832459: {
                if(tag.equals("layout/fragment_build_0")) {
                    return io.stanwood.bitrise.R.layout.fragment_build;
                }
                break;
            }
            case -1001642614: {
                if(tag.equals("layout/fragment_logs_0")) {
                    return io.stanwood.bitrise.R.layout.fragment_logs;
                }
                break;
            }
            case -716641624: {
                if(tag.equals("layout/fragment_artifacts_0")) {
                    return io.stanwood.bitrise.R.layout.fragment_artifacts;
                }
                break;
            }
            case 494172216: {
                if(tag.equals("layout/item_build_0")) {
                    return io.stanwood.bitrise.R.layout.item_build;
                }
                break;
            }
            case 1487205647: {
                if(tag.equals("layout/fragment_error_0")) {
                    return io.stanwood.bitrise.R.layout.fragment_error;
                }
                break;
            }
            case -986431952: {
                if(tag.equals("layout/fragment_login_0")) {
                    return io.stanwood.bitrise.R.layout.fragment_login;
                }
                break;
            }
            case -550221622: {
                if(tag.equals("layout/item_artifact_0")) {
                    return io.stanwood.bitrise.R.layout.item_artifact;
                }
                break;
            }
        }
        return 0;
    }
    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"buildStatusColor"
            ,"buildStatusIcon"
            ,"downloading"
            ,"lastBuildTime"
            ,"size"
            ,"title"
            ,"token"
            ,"vm"};
    }
}