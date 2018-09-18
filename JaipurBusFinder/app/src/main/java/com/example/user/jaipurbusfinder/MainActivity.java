package com.example.user.jaipurbusfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {
    private  final String TAG = "shrey";
    ArrayList<String> nameLowFloor = new ArrayList<>();
    ArrayList<String> nameMiniBus = new ArrayList<>();
    ArrayList<ArrayList<String>> bus_lowfloor = new ArrayList<>();
    ArrayList<ArrayList<String>> bus_mini = new ArrayList();
     AutoCompleteTextView source, destination;
      Button search;
       RecyclerView recyclerView;
 String start;
 String stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        source = findViewById(R.id.source);
        destination = findViewById(R.id.des);
        search = findViewById(R.id.search);
        recyclerView = findViewById(R.id.recy);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, getStops());
        source.setAdapter(adapter);
        destination.setAdapter(adapter);
        try {
            initialization();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }


           start = source.getText().toString();
          stop = destination.getText().toString();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(source.getText().toString().isEmpty()   &&  destination.getText().toString().isEmpty())){


                    recyclerView.setAdapter(new Rcadapter(Search_bus(source.getText().toString()
                            ,destination.getText().toString().toString()),MainActivity.this));




                }else
                {
                    source.setError("don't leave it blank");
                    destination.setError("don't leave it blank");
                }



            }
        });

        for (ArrayList<String> a : bus_lowfloor) {
            Log.d(TAG, String.valueOf(a));
        }
        for (ArrayList<String> a : bus_mini) {
            Log.d(TAG, String.valueOf(a));
        }


    }


    public List<String> getStops() {
        ArrayList<String> busL = new ArrayList<>();
        try {
            InputStream is = getAssets().open("buses_stops.xml");
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
            doc.getDocumentElement().normalize();
            NodeList newlist = doc.getElementsByTagName("stops");
            if (newlist != null) {
                newlist = ((Element) newlist.item(0)).getElementsByTagName("item");
                for (int k = 0; k < newlist.getLength(); k++) {
                    busL.add(newlist.item(k).getChildNodes().item(0).getNodeValue());
                }
                return busL;
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void initialization() throws IOException, ParserConfigurationException, SAXException {
        int i, j;
        Element element2;
        Element element3;
        NodeList newList;
        ArrayList<String> busL;
        InputStream Lf = getAssets().open("buses_lowfloor.xml");
        InputStream Mb = getAssets().open("buses_minibus.xml");

        Document ldoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(Lf);
        ldoc.getDocumentElement().normalize();
        Document mdoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(Mb);
        mdoc.getDocumentElement().normalize();


        NodeList nList = ldoc.getElementsByTagName("bus");

        for(i=0;i<nList.getLength();i++){
            busL = new ArrayList();

            element2 =(Element) nList.item(i);
            newList = element2.getElementsByTagName("item");
            nameLowFloor.add(element2.getAttribute("name"));
            for(j=0;j<newList.getLength();j++){
                busL.add(newList.item(j).getChildNodes().item(0).getNodeValue());
            }
        bus_lowfloor.add(busL);
        }


        NodeList nList2 = mdoc.getElementsByTagName("bus");

        for(i=0;i<nList2.getLength();i++){
            busL = new ArrayList();

            element3 =(Element) nList2.item(i);
            newList = element3.getElementsByTagName("item");
            nameMiniBus.add(element3.getAttribute("name"));
            for(j=0;j<newList.getLength();j++){
                busL.add(newList.item(j).getChildNodes().item(0).getNodeValue());
            }
            bus_mini.add(busL);
        }




    }
    public String[] getArray(ArrayList<ArrayList<String>> array, int pos) {
        String[] result = new String[((ArrayList) array.get(pos)).size()];
        ((ArrayList) array.get(pos)).toArray(result);
        return result;
    }

    public List<String> Search_bus(String start, String stop){
        String[] res;
        ArrayList<String> bus_detail = new ArrayList();
        bus_detail.clear();
        for(int k=0;k<bus_lowfloor.size();k++){
            res=getArray(bus_lowfloor,k);
            if(Search_inArray(res,start)  && Search_inArray(res,stop)){
                bus_detail.add(nameLowFloor.get(k)+":L");
            }
        }
        for(int k=0;k<bus_mini.size();k++){
            res=getArray(bus_mini,k);
            if(Search_inArray(res,start)  && Search_inArray(res,stop)){
                bus_detail.add(nameMiniBus.get(k)+":M");
            }

        }


        return bus_detail;

    }


    public boolean Search_inArray(String[] obj,String find){

        for(String s : obj){
            if(s.equals(find)){
                return true;
            }
        }  return  false;
    }

}

//ANOTHER METHOD OF THIS..!
       /* ArrayList<String> busL = new ArrayList<>();
        ArrayList<String> minB = new ArrayList<>();
        try{
            InputStream lf = getAssets().open("buses_lowfloor.xml");
            Document lf_doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(lf);
            lf_doc.getDocumentElement().normalize();
            NodeList lf_list = lf_doc.getElementsByTagName("bus");

            InputStream min = getAssets().open("buses_minibus.xml");
            Document min_doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(min);
            min_doc.getDocumentElement().normalize();
            NodeList min_list = min_doc.getElementsByTagName("bus");

            if(lf_list != null){
                for(int i=0; i < lf_list.getLength(); i++){

                    Element element = (Element)lf_list.item(i);
                    nameLowFloor.add(element.getAttribute("name"));
                    NodeList lf_list_item = element.getElementsByTagName("item");
                    for(int j = 0; j < lf_list_item.getLength(); j++){
                        busL.add(lf_list_item.item(j).getChildNodes().item(0).getNodeValue());
                    }

                    bus_lowfloor.add(busL);
                }
            }

            if(min_list != null){
                for(int k = 0; k < min_list.getLength(); k++){
                    Element element2 = (Element)min_list.item(k);
                    nameMiniBus.add(element2.getAttribute("name"));

                    NodeList min_list_item = element2.getElementsByTagName("item");
                    for(int l = 0; l < min_list_item.getLength(); l++){
                        minB.add(min_list_item.item(l).getChildNodes().item(0).getNodeValue());
                    }
                    bus_mini.add(minB);
                }
            }


        } catch (Exception e){

        }
    }*/




