package com.example.soundtest.Read;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.soundtest.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.util.ArrayList;
import java.util.List;

public class BookMarks extends Fragment {


    private ListView listView;

    private String[] paraNo = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17"};
    private String[] pageNo = {"32","45","54","67","87","87","98","09","43","98","76","54","75","84","47","74","74"};
    private String[] suraNo = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17"};
    private String[] ayatNo = {"10","34","43","43","65","87","98","12","22","55","65","76","78","98","53","64","76"};
    private String[] ayatNumber = {"03","02","05","04","05","06","07","08","09","10","11","07","06","09","03","04","05"};
    private String[] ayat = {"ان الله غفور الرحيم","ان الله غفور الرحيم","ان الله غفور الرحيم",
            "والله على كل شيئ قدير","والله على كل شيئ قدير",
            "والله ذوالفضل العظيم","واﻟﻠﻪ ذوالفضل العظيم","واﻟﻠﻪ ذوالفضل العظيم","واﻟﻠﻪ ذوالفضل العظيم","واﻟﻠﻪ ذوالفضل العظيم","وهوالعزيز الحكيم",
            "وهوالعزيز الحكيم", "وهو العزيز الحكيم","وهو العزيز الحكيم","وهو العزيز الحكيم","وهو العزيز الحكيم","وهو العزيز الحكيم"};

    List<ItemModel> listItem = new ArrayList<>();
    CustomAdapter customAdapter;

    PDFView quranPdf;




    public BookMarks() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book_marks, container, false);

        setHasOptionsMenu(true);
        listView =view. findViewById(R.id.listViewId);

        quranPdf = view.findViewById(R.id.readQuranPDF);


        for (int i = 0;i<paraNo.length;i++){

            ItemModel itemModel = new ItemModel(paraNo[i],pageNo[i],suraNo[i],ayatNo[i],ayatNumber[i],ayat[i]);
            listItem.add(itemModel);
        }

        customAdapter = new CustomAdapter(listItem, getContext());
        listView.setAdapter(customAdapter);

        return view;
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.menu, menu);




        MenuItem menuItem = menu.findItem(R.id.searchViewId);

        SearchView searchView = (SearchView) menuItem.getActionView();



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {



                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                listView.setVisibility(View.VISIBLE);

                customAdapter.getFilter().filter(newText);
                return true;
            }
        });

        super.onCreateOptionsMenu(menu,inflater);

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        int id= item.getItemId();
        if (id == R.id.searchViewId)
        {


            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class CustomAdapter extends BaseAdapter implements Filterable {
        private List<ItemModel> itemModelList;
        private List<ItemModel> itemModelListFiltered;
        private Context context;

        public CustomAdapter(List<ItemModel> itemModelList,Context context){

            this.itemModelList = itemModelList;
            this.itemModelListFiltered = itemModelList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return itemModelListFiltered.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = getLayoutInflater().inflate(R.layout.sample_view,null);

            final TextView paraNo = view.findViewById(R.id.paraNoId);
            final TextView pageNo = view.findViewById(R.id.pageNoId);
            final TextView suraNo = view.findViewById(R.id.suraNoId);
            final TextView ayatNo = view.findViewById(R.id.ayatNoId);
            final TextView ayatNumber = view.findViewById(R.id.numberId);
            final TextView ayat = view.findViewById(R.id.ayatID);

            paraNo.setText(itemModelListFiltered.get(position).getPara());
            pageNo.setText(itemModelListFiltered.get(position).getPage());
            suraNo.setText(itemModelListFiltered.get(position).getSura());
            ayatNo.setText(itemModelListFiltered.get(position).getAyatNumber());
            ayatNumber.setText(itemModelListFiltered.get(position).getNumber());
            ayat.setText(itemModelListFiltered.get(position).getAyat());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String text = ayat.getText().toString();
                    if (text.equals("ان الله غفور الرحيم")){
                        listView.setVisibility(View.GONE);

                        quranPdf.fromAsset("quranmusgabbah.pdf")
                                .pages(3,5,2,3,7)
                                .enableAnnotationRendering(true)
                                .enableSwipe(true)
                                .swipeHorizontal(true)
                                .enableDoubletap(true)
                                .pageFling(true)
                                .pageSnap(true)
                                .autoSpacing(true)
                                .nightMode(false)
                                .scrollHandle(new DefaultScrollHandle(getContext(),true))
                                .spacing(2).load();

                    }else {
                        Toast.makeText(context, ayat.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

            return view;
        }

        @Override
        public Filter getFilter() {

            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {

                    FilterResults filterResults = new FilterResults();
                    if (constraint == null || constraint.length() == 0){
                        filterResults.count = itemModelList.size();
                        filterResults.values = itemModelList;
                    }else {

                        String searchStr = constraint.toString();
                        List<ItemModel> resultData = new ArrayList<>();
                        for (ItemModel itemModel:itemModelList){
                            if (itemModel.getAyat().contains(searchStr)){
                                resultData.add(itemModel);
                            }

                            filterResults.count = resultData.size();
                            filterResults.values = resultData;
                        }


                    }



                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {

                    itemModelListFiltered = (List<ItemModel>) results.values;

                    notifyDataSetChanged();


                }
            };


            return filter;
        }
    }


}



