package com.github.tenx.xservices.ui.Function.articles;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.tenx.xservices.R;
import com.github.tenx.xservices.ui.Function.FunctionViewModel;
import com.github.tenx.xservices.ui.Function.articles.adapter.ArticlesAdapter;
import com.github.tenx.xservices.ui.Function.articles.adapter.ArticlesDataModel;
import com.github.tenx.xservices.ui.Function.singlearticle.SingleArticleFragment;

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
public class ArticlesFragment extends Fragment {


    private static final String TAG = "ArticlesFragment";

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    Unbinder unbinder;

    @Inject
    FunctionViewModel functionViewModel;

    @Inject
    ArticlesAdapter adapter;

    @Inject
    SingleArticleFragment singleArticleFragment;

    ArrayList<ArticlesDataModel> itemList;


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
            int position = viewHolder.getAdapterPosition();
            Log.d(TAG, "onClick: POsition ::: " + position);

          //  goToNextActivity(position);

            initializeFragments(singleArticleFragment);
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
    public ArticlesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_articles, container, false);

        unbinder =  ButterKnife.bind(this,view);
        AndroidSupportInjection.inject(this);


        setUpRecycler(recyclerView,adapter);


        if (functionViewModel==null)
            Log.d(TAG, "onClick: VIEWMODEL IS EMPTY");
        else
            Log.d(TAG, "onClick: VIEWMODEL IS NOT EMPTY");



        return view;
    }


    @Override
    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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
