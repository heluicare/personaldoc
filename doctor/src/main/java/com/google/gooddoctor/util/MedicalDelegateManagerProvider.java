package com.google.gooddoctor.util;

import android.support.v4.app.FragmentActivity;
import com.google.gooddoctor.adapter.BaseViewHolder;
import com.google.gooddoctor.interfaces.IItemInfo;
import com.google.gooddoctor.interfaces.IItemViewDelegate;
import com.google.gooddoctor.view.MedicalWenZhenDelegate;

public class MedicalDelegateManagerProvider {

    public static DelegateManager<IItemInfo, BaseViewHolder, IItemViewDelegate> a(FragmentActivity fragmentActivity) {
        DelegateManager<IItemInfo, BaseViewHolder, IItemViewDelegate> delegateManager = new DelegateManager<>();
        a((DelegateManager) delegateManager, fragmentActivity);
        return delegateManager;
    }

    private static void a(DelegateManager delegateManager, FragmentActivity fragmentActivity) {
//        a(delegateManager, 106, new UploadTipDelegate(fragmentActivity));
//        a(delegateManager, 3, new PDServiceDelegate(fragmentActivity));
//        a(delegateManager, 4, new PDNormalChatDelegate(fragmentActivity));
//        a(delegateManager, 5, new PDUnBindDocDelegate(fragmentActivity));
//        a(delegateManager, 104, new MedicalWenZhenDelegate(fragmentActivity));
//        a(delegateManager, 107, new FooterDelegate(fragmentActivity));
//        a(delegateManager, 103, new FurtherConsultionDelegate(fragmentActivity));
//        a(delegateManager, 100, new MPDynamicVTemplateDelegate(fragmentActivity));
//        a(delegateManager, 102, new MPPurchaseServicesDelegate(fragmentActivity));
//        a(delegateManager, 109, new HealthCheckDelegate(fragmentActivity, fragmentActivity));
//        a(delegateManager, 110, new MedicalO2OViewDelegate(fragmentActivity, fragmentActivity));
//        a(delegateManager, 111, new MpBannerDelegate(fragmentActivity));
//        a(delegateManager, 112, new MpOldEnterpriseAdBannerDelegate(fragmentActivity));
//        a(delegateManager, (Context) fragmentActivity);
        a(delegateManager, 0, new MedicalWenZhenDelegate(fragmentActivity));
    }

//    private static void a(DelegateManager<IItemInfo, BaseViewHolder, IItemViewDelegate> delegateManager, Context context) {
//        delegateManager.a(-1, new DefaultDelegate(context));
//    }

    public static DelegateManager<IItemInfo, BaseViewHolder, IItemViewDelegate> a(DelegateManager<IItemInfo, BaseViewHolder, IItemViewDelegate> delegateManager, int i, BaseDelegate<?, ?> baseDelegate) {
        delegateManager.a(i, baseDelegate);
        return delegateManager;
    }
}
