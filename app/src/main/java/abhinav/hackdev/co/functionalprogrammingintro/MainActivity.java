package abhinav.hackdev.co.functionalprogrammingintro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import rx.Observer;

public class MainActivity extends AppCompatActivity {

    private List<RVData> rvDataList ;
    private RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setData() ;
        init() ;
    }

    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewMain) ;

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);


        final RVAdapter adapter = new RVAdapter();
        recyclerView.setAdapter(adapter);

        rx.Observable<List<RVData>> listObservable = rx.Observable.just(setData()) ;


        listObservable.subscribe(new Observer<List<RVData>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<RVData> rvDatas) {
                adapter.setStrings(rvDataList);
            }
        }) ;

    }

    private List<RVData> setData() {
        rvDataList = new ArrayList<>() ;
        rvDataList.add(new RVData("Hello")) ;
        rvDataList.add(new RVData("World")) ;
        rvDataList.add(new RVData("Three")) ;
        rvDataList.add(new RVData("Four")) ;
        rvDataList.add(new RVData("Five")) ;
        rvDataList.add(new RVData("Six")) ;
        rvDataList.add(new RVData("Seven")) ;
        rvDataList.add(new RVData("Eight")) ;
        return rvDataList ;
    }
}
