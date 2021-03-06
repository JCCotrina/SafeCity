package com.example.safecity.ui.incident_report;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.safecity.R;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReportFeatureFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReportFeatureFragment extends Fragment {

    private ProgressBar progressBar;
    private String how;
    // URl image

    public static final String BASE_URL = "https://images.unsplash.com/";

    public static final String agresion_URL = BASE_URL + "photo-1602058176018-7915d6bd37ae?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80";
    public static final String desaparecido_URL = BASE_URL + "photo-1497514440240-3b870f7341f0?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=562&q=80";
    public static final String incendio_URL = BASE_URL +"photo-1516567832553-66232148f74c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1189&q=80";
    public static final String maltrato_URL = BASE_URL + "photo-1516585142943-4341daf22d5f?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80";
    public static final String robo_URL = BASE_URL + "photo-1605806616949-1e87b487fc2f?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80";
    public static final String otroCasos_URL = BASE_URL +"photo-1497005367839-6e852de72767?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=1047&q=80";

    public ReportFeatureFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReportFeatureFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ReportFeatureFragment newInstance(String param1, String param2) {
        ReportFeatureFragment fragment = new ReportFeatureFragment();

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("id", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
                how = bundle.getString("id");

                Log.i(getTag(), "El incidente le sucede: "+how);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_report_feature, container, false);
    }

    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);

        Button agresionButton = view.findViewById(R.id.agresionButton);
        Button desaparecidoButton = view.findViewById(R.id.desaparecidoButton);
        Button incendioButton = view.findViewById(R.id.incendioButton);
        Button maltratoButton = view.findViewById(R.id.maltratoButton);
        Button roboButton = view.findViewById(R.id.roboButton);
        Button otrosCasosButton = view.findViewById(R.id.otrosCasosButton);

        ImageView agresionImage = view.findViewById(R.id.agresionImage);
        ImageView desaparecidoImage = view.findViewById(R.id.desaparecidoImage);
        ImageView incendioImage = view.findViewById(R.id.incendioImage);
        ImageView maltratoImage = view.findViewById(R.id.maltratoImage);
        ImageView roboImage = view.findViewById(R.id.roboImage);
        ImageView otroCasosImage = view.findViewById(R.id.otroCasosImage);


        Glide.with(this)
                .load(agresion_URL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(agresionImage);


        Glide.with(this)
                .load(desaparecido_URL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(desaparecidoImage);


        Glide.with(this)
                .load(incendio_URL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(incendioImage);


        Glide.with(this)
                .load(maltrato_URL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(maltratoImage);


        Glide.with(this)
                .load(robo_URL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(roboImage);


        Glide.with(this)
                .load(otroCasos_URL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(otroCasosImage);

        agresionButton.setOnClickListener(v -> onReportForm(navController, how+",Agresion"));
        desaparecidoButton.setOnClickListener(v -> onReportForm(navController, how+",Persona Perdida"));
        incendioButton.setOnClickListener(v -> onReportForm(navController, how+",Incendio"));
        maltratoButton.setOnClickListener(v -> onReportForm(navController, how+",Maltrato Familiar"));
        roboButton.setOnClickListener(v -> onReportForm(navController, how+",Robo"));
        otrosCasosButton.setOnClickListener(v -> onReportForm(navController, how+",Otros Casos"));

    }


    private void onReportForm(NavController navController, String feature) {

        Bundle bundle = new Bundle();
        bundle.putString("key", feature);
        getParentFragmentManager().setFragmentResult("key",bundle);

        navController.navigate(R.id.nav_report_form);
    }
}