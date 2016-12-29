package com.example.jorch.dialogos;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ListaDialogosFragment extends Fragment {
    private String[] listaDialogos;
    private ListView listViewDialogos;
    private ArrayAdapter<String> adapter;


    public ListaDialogosFragment() {
        // Required empty public constructor
    }

    public static ListaDialogosFragment newInstance() {
        ListaDialogosFragment fragment = new ListaDialogosFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_dialogos,container,false);

        listViewDialogos = (ListView) view.findViewById(R.id.lv_diferentes_dialogos);
        listaDialogos = new String[]{
                "Diálogo Simple","Diálogo Con Lista Simple","Diálogo Con Lista De Radios","Diálogo Con Lista De Checkboxes","Diálogo Personalizado"};


        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,listaDialogos);

        listViewDialogos.setAdapter(adapter);

        listViewDialogos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        getFragmentManager().beginTransaction().add(DialogoSimple.newInstance(),"DIALOGO_SIMPLE").commit();
                        /*DialogoSimple dialogoSimple = new DialogoSimple();
                        getFragmentManager().beginTransaction().add(dialogoSimple,"SIMPLE").commit();*/
                        break;
                    case 1:
                        DialogoConListaSimple dialogoConListaSimple = new DialogoConListaSimple();
                        getFragmentManager().beginTransaction().add(dialogoConListaSimple,"DIALOGO_SIMPLE_LISTA_SIMPLE").commit();
                        break;
                    case 2:
                        DialogoConListaDeRadios dialogoConListaDeRadios = new DialogoConListaDeRadios();
                        getFragmentManager().beginTransaction().add(dialogoConListaDeRadios,"DIALOGO_SIMPLE_LISTA_CON_RADIOS").commit();
                        break;
                    case 3:
                        DialogoConListaDeCheckboxes dialogoConListaDeCheckboxes = new DialogoConListaDeCheckboxes();
                        getFragmentManager().beginTransaction().add(dialogoConListaDeCheckboxes,"DIALOGO_SIMPLE_LISTA_CON_CHECKBOXES").commit();
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                }
            }
        });

        return view;
    }

}
