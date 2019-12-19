package com.github.tenx.xservices.di.modules.function;

import com.github.tenx.xservices.ui.Function.appointments.FarmerAppointmentsFragment;
import com.github.tenx.xservices.ui.Function.bookEquipments.BookEquipmentsFragment;
import com.github.tenx.xservices.ui.Function.buyItemFragment.BuyItemFragment;
import com.github.tenx.xservices.ui.Function.cart.CartFragment;
import com.github.tenx.xservices.ui.Function.meetingTheExpert.ExpertMeetingFragment;
import com.github.tenx.xservices.ui.Function.notification.FarmerNotificationFragment;
import com.github.tenx.xservices.ui.Function.payments.FarmerPaymentsFragment;
import com.github.tenx.xservices.ui.Function.shop.ShopFragment;
import com.github.tenx.xservices.ui.Function.articles.ArticlesFragment;
import com.github.tenx.xservices.ui.Function.contactExperts.ContactExpertsFragment;
import com.github.tenx.xservices.ui.Function.prediction.PredictionFragment;
import com.github.tenx.xservices.ui.Function.questions.QuestionFragment;

import com.github.tenx.xservices.ui.Function.singleExpert.SingleExpertFragment;
import com.github.tenx.xservices.ui.Function.singleItemShop.SingleItemShopFragment;
import com.github.tenx.xservices.ui.Function.singleNotification.FarmerSingleNotificationFragment;
import com.github.tenx.xservices.ui.Function.singlearticle.SingleArticleFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FunctionFragmentBuilder {

    @ContributesAndroidInjector(modules = {})
    abstract ShopFragment bindAdvertisementsFragment();

    @ContributesAndroidInjector(modules = {})
    abstract ArticlesFragment bindArticlesFragment();

    @ContributesAndroidInjector(modules = {})
    abstract ContactExpertsFragment bindContactExpertsFragment();

    @ContributesAndroidInjector(modules = {})
    abstract QuestionFragment bindQuestionsFragment();

    @ContributesAndroidInjector(modules = {})
    abstract PredictionFragment bindPredictionFragment();

    @ContributesAndroidInjector
    abstract SingleArticleFragment bindSingleArticleFragment();

    @ContributesAndroidInjector
    abstract SingleItemShopFragment bindSingleItemShopFragment();

    @ContributesAndroidInjector
    abstract SingleExpertFragment bindSingleExpertFragment();

    @ContributesAndroidInjector
    abstract ExpertMeetingFragment bindExpertMeetingFragment();

    @ContributesAndroidInjector
    abstract CartFragment bindCartFragment();

    @ContributesAndroidInjector
    abstract FarmerSingleNotificationFragment bindFarmerSingleNotificationFrag();

    @ContributesAndroidInjector
    abstract FarmerNotificationFragment bindFarmerNotificationFrag();

    @ContributesAndroidInjector
    abstract FarmerAppointmentsFragment bindFarmerAppointmentsFrag();

    @ContributesAndroidInjector
    abstract BuyItemFragment bindBuyItemFragment();

    @ContributesAndroidInjector
    abstract BookEquipmentsFragment bindBookEquipmentsFragment();

    @ContributesAndroidInjector
    abstract FarmerPaymentsFragment bindFarmerPaymentsFragment();



}
