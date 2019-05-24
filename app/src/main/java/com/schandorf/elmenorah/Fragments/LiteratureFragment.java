package com.schandorf.elmenorah.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.schandorf.elmenorah.Adapters.LiteratureAdapter;
import com.schandorf.elmenorah.Helpers.Constants;
import com.schandorf.elmenorah.Helpers.DbHelper;
import com.schandorf.elmenorah.Helpers.FontChangeCrawler;
import com.schandorf.elmenorah.POJO.LiteraturePOJO;
import com.schandorf.elmenorah.R;
import com.schandorf.elmenorah.RetrofitService;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiteratureFragment extends Fragment {

    RecyclerView recyclerViewLit;
    RealmResults<LiteraturePOJO> literaturePOJORealmResults;
    LiteratureAdapter literatureAdapter;
    Realm realm;
    TextView refresh;
    DbHelper dbHelper;
    SwipeRefreshLayout literatureSwipe;
    FontChangeCrawler fontChangeCrawler;
    public LiteratureFragment() {
        // Required empty public constructor
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(realm != null) {
            dbHelper.closeRealm(realm);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vw = inflater.inflate(R.layout.fragment_literature, container, false);
        fontChangeCrawler = new FontChangeCrawler(getActivity().getAssets(), Constants.FONT_NAME);
        recyclerViewLit = vw.findViewById(R.id.literatureRecycler);
        refresh = vw.findViewById(R.id.reloadtextliterature);
        literatureSwipe = vw.findViewById(R.id.literatureSwipe);
        literatureSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                literatureSwipe.setRefreshing(true);
                loadLiteratureFromOnline();
            }
        });
       dbHelper = new DbHelper("literature",getActivity());
        realm = dbHelper.startRealm();
        literaturePOJORealmResults = realm.where(LiteraturePOJO.class).findAll();
        if(literaturePOJORealmResults.size() > 0)
        {
            literatureAdapter = new LiteratureAdapter(getActivity(),literaturePOJORealmResults,fontChangeCrawler);
        }
        else
        {
            loadLiteratureFromOnline();
        }

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadLiteratureFromOnline();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        recyclerViewLit.setLayoutManager(linearLayoutManager);
        recyclerViewLit.setAdapter(literatureAdapter);
        return vw;
    }

    private void loadLiteratureFromOnline() {

        RetrofitInterface retrofitInterface = RetrofitService.getClient().create(RetrofitInterface.class);
        Call<List<LiteraturePOJO>> call = retrofitInterface.getLiterature();
        call.enqueue(new Callback<List<LiteraturePOJO>>() {
            @Override
            public void onResponse(@NonNull Call<List<LiteraturePOJO>> call, @NonNull final Response<List<LiteraturePOJO>> response) {
                if(literatureSwipe.isRefreshing())
                {
                    literatureSwipe.setRefreshing(false);
                }
                if(response.isSuccessful())
                {
                   // Toast.makeText(getActivity(), response.body().toString(), Toast.LENGTH_SHORT).show();
                   // Log.i("literature",response.body().toString());
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            realm.where(LiteraturePOJO.class).findAll().deleteAllFromRealm();
                            realm.copyToRealmOrUpdate((Iterable) response.body());
                            literaturePOJORealmResults = realm.where(LiteraturePOJO.class).findAll();
                            if(literaturePOJORealmResults.size() > 0) {
                                literatureAdapter = new LiteratureAdapter(getActivity(), literaturePOJORealmResults, fontChangeCrawler);
                                recyclerViewLit.setAdapter(literatureAdapter);
                            }
                            else
                            {
                                recyclerViewLit.setVisibility(View.GONE);
                                refresh.setVisibility(View.VISIBLE);
                                refresh.setText(R.string.notfoundTapSwap);
                            }

                        }
                    });
                }
                else
                {
                  //  Toast.makeText(getActivity(), "Malformed Response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<LiteraturePOJO>> call, @NonNull Throwable t) {
               // Toast.makeText(getActivity(), "Check Internet Connection.", Toast.LENGTH_SHORT).show();
                if(literatureSwipe.isRefreshing())
                {
                    literatureSwipe.setRefreshing(false);
                }
                if(literaturePOJORealmResults.size() == 0)
                {
                    recyclerViewLit.setVisibility(View.GONE);
                    refresh.setVisibility(View.VISIBLE);
                    refresh.setText(R.string.checkInternet);
                }

            }
        });
    }

}
