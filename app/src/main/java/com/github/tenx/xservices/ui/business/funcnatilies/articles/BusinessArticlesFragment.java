package com.github.tenx.xservices.ui.business.funcnatilies.articles;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.tenx.xservices.R;
import com.github.tenx.xservices.ui.Function.articles.adapter.ArticlesAdapter;
import com.github.tenx.xservices.ui.Function.articles.adapter.ArticlesDataModel;
import com.github.tenx.xservices.ui.business.funcnatilies.singleArticle.BusSingleArticleFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class BusinessArticlesFragment extends Fragment {

    private static final String TAG = "BusinessArticlesFragmen";


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    Unbinder unbinder;


    @Inject
    ArticlesAdapter adapter;

    @Inject
    BusSingleArticleFragment busSingleArticleFragment;

    ArrayList<ArticlesDataModel> itemList;

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            Log.d(TAG, "onClick: POsition ::: " + position);

            //  goToNextActivity(position);

            initializeFragments(busSingleArticleFragment);
        }
    };


    public void initializeFragments( Fragment frag){
        String backStateName = frag.getClass().toString();
        //Log.d(TAG, "onBtnOtpLoginClicked: " + backStateName);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right,R.anim.enter_from_right,R.anim.exit_to_right);

        transaction.replace(R.id.frame_layout,frag);
        transaction.addToBackStack(backStateName);

        transaction.commit();
    }



    @Inject
    public BusinessArticlesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_business_articles, container, false);


        AndroidSupportInjection.inject(this);
        ButterKnife.bind(this,view);

        setUpRecycler(recyclerView,adapter);

        return view;
    }


    @Override
    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    private void setUpRecycler(RecyclerView recyclerView, ArticlesAdapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(onClickListener);
        adapter.updateListItems(loadItems());
    }

    private List<ArticlesDataModel> loadItems() {
        itemList = new ArrayList<>();
        itemList.add(new ArticlesDataModel(R.drawable.ic_launcher_foreground,"article 1"));
        itemList.add(new ArticlesDataModel(R.drawable.ic_launcher_foreground,"Article 2"));
        itemList.add(new ArticlesDataModel(R.drawable.ic_launcher_foreground,"Article 3"));
        itemList.add(new ArticlesDataModel(R.drawable.ic_launcher_foreground,"Article 4"));
        itemList.add(new ArticlesDataModel(R.drawable.ic_launcher_foreground,"Articvle 5"));
        itemList.add(new ArticlesDataModel(R.drawable.ic_launcher_foreground,"Articles"));
        return itemList;
    }


}
