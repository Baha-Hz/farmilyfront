package esprit.tn.farmily.fields;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.layers.SymbolLayer;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import esprit.tn.farmily.Networking.APIclient;
import esprit.tn.farmily.R;
import esprit.tn.farmily.feed.feed;
import esprit.tn.farmily.models.Filedsmodel;
import esprit.tn.farmily.models.Location;
import esprit.tn.farmily.notification.notification;
import esprit.tn.farmily.utilities.CurrentSession;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconAllowOverlap;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconIgnorePlacement;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconImage;

public class AddFields extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener,OnMapReadyCallback {

    private static final String SOURCE_ID = "SOURCE_ID";
    private static final String ICON_ID = "ICON_ID";
    private static final String LAYER_ID = "LAYER_ID";
    private MapView mapView;
    private MapboxMap mapboxMap;

    LinearLayout layoutList, layoutListmat, layouttype;
    Button buttonAdd, buttonAddmat;
    Button buttonAddfield, searchnow,cancel;
    TextView langt, lati;
    EditText searchtext;

    List<String> teamList = new ArrayList<>();
    List<String> teamListmat = new ArrayList<>();
    List<String> typeList = new ArrayList<>();

    List<Worker> cricketersList = new ArrayList<>();
    List<Material> material = new ArrayList<>();
    // public static List<Location> locations ;
    List<List<Double>> coordinates = new ArrayList<List<Double>>();
    List<Double> cor;
    Double lat;
    Double lang;
    String type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, getString(R.string.mapbox_access_token));

        setContentView(R.layout.add_fields);

        langt = findViewById(R.id.lang);
        lati = findViewById(R.id.lat);
        buttonAddfield = findViewById(R.id.add_field);
        cancel = findViewById(R.id.cancel);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent notif= new Intent(getApplicationContext(),feed.class);
                startActivity(notif);
                overridePendingTransition(0, 0);
                notif.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
            }
        });

        buttonAddfield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkIfValidAndRead() && checkIfValidAndRead2()) {
                    int ready = 0;


                    switch (type) {
                        case "Potato":
                            ready = 70;
                            break;
                        case "Tomato":
                            ready = 50;
                            break;
                        case "Eggplant":
                            ready = 85;
                            break;
                    }


                    TextView surface = findViewById(R.id.edit_surface);
                    int dimensions = Integer.parseInt((surface.getText().toString()));

                    Filedsmodel filedsmodel = new Filedsmodel();
                    filedsmodel.setReadyTime(ready);
                    filedsmodel.setCreator(CurrentSession.CurrentUser.getUsername());
                    filedsmodel.setWorker(cricketersList);
                    filedsmodel.setMaterials(material);
                    filedsmodel.setDimensions(dimensions);
                    filedsmodel.setTypeName(type);


                    Call<Filedsmodel> add = APIclient.apIinterface().addFiled(filedsmodel);
                    add.enqueue(new Callback<Filedsmodel>() {
                        @Override
                        public void onResponse(Call<Filedsmodel> call, Response<Filedsmodel> response) {
                            if (response.isSuccessful()) {
                                Log.d("RegisterNet", String.valueOf(response.code()));
                                Toast.makeText(AddFields.this, "New post Added", Toast.LENGTH_LONG).show();
                                Intent addnew = new Intent(AddFields.this, feed.class);
                                startActivity(addnew);
                            } else {
                                Log.d("RegisterNet", "unsucc response");


                            }
                        }

                        @Override
                        public void onFailure(Call<Filedsmodel> call, Throwable t) {
                            Log.d("RegisterNet", t.toString());
                        }
                    });


                }
            }
        });


        // search
        searchnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String address = searchtext.getText().toString();





               /* Call<Location> add = APIclient.apIinterface().loacate(searchtext.getText().toString());
                add.enqueue(new Callback<Location>() {
                    @Override
                    public void onResponse(Call<Location> call, Response<Location> response) {
                        if (response.isSuccessful()) {

                            coordinates.add(response.body().getCoordinates());
                            cor = coordinates.get(0);
                            lang = cor.get(0);
                            lat= cor.get(1);



                        } else {
                            Log.d("RegisterNet", "unsucc response");


                        }
                    }

                    @Override
                    public void onFailure(Call<Location> call, Throwable t) {
                        Log.d("RegisterNet", t.toString());
                    }
                });*/

            }
        });


        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);


        layoutListmat = findViewById(R.id.layout_list2);
        buttonAddmat = findViewById(R.id.button_add_mat);
        // buttonSubmitList = findViewById(R.id.button_submit_list);

        buttonAddmat.setOnClickListener(this);
//        buttonSubmitList.setOnClickListener(this);

        teamListmat.add("Materials");
        teamListmat.add("Tractor");
        teamListmat.add("Truck");
        teamListmat.add("Harvester");


        layoutList = findViewById(R.id.layout_list);
        buttonAdd = findViewById(R.id.button_add);
        // buttonSubmitList = findViewById(R.id.button_submit_list);

        buttonAdd.setOnClickListener(this);
//        buttonSubmitList.setOnClickListener(this);

        teamList.add("Workers");
        teamList.add("Transporter");
        teamList.add("Farmer");
        teamList.add("Worker");


        Spinner spinner = findViewById(R.id.spinner_type);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        type = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }


    private boolean checkIfValidAndRead() {
        cricketersList.clear();
        boolean result = true;

        for (int i = 0; i < layoutList.getChildCount(); i++) {

            View cricketerView = layoutList.getChildAt(i);

            EditText editTextName = (EditText) cricketerView.findViewById(R.id.edit_cricketer_name);
            AppCompatSpinner spinnerTeam = (AppCompatSpinner) cricketerView.findViewById(R.id.spinner_team);

            Worker worker = new Worker();

            if (!editTextName.getText().toString().equals("")) {
                worker.setFullname(editTextName.getText().toString());
            } else {
                result = false;
                break;
            }

            if (spinnerTeam.getSelectedItemPosition() != 0) {
                worker.setRole(teamList.get(spinnerTeam.getSelectedItemPosition()));
            } else {
                result = false;
                break;
            }

            cricketersList.add(worker);

        }

        if (cricketersList.size() == 0) {
            result = false;
            Toast.makeText(this, "Add Cricketers First!", Toast.LENGTH_SHORT).show();
        } else if (!result) {
            Toast.makeText(this, "Enter All Details Correctly!", Toast.LENGTH_SHORT).show();
        }


        return result;
    }

    private boolean checkIfValidAndRead2() {
        material.clear();

        boolean result = true;

        for (int i = 0; i < layoutListmat.getChildCount(); i++) {

            View cricketerView = layoutListmat.getChildAt(i);


            AppCompatSpinner spinnerTeam = (AppCompatSpinner) cricketerView.findViewById(R.id.spinner_team2);

            Material materials = new Material();


            if (spinnerTeam.getSelectedItemPosition() != 0) {
                materials.setType(teamListmat.get(spinnerTeam.getSelectedItemPosition()));

            } else {
                result = false;
                break;
            }

            material.add(materials);

        }

        if (material.size() == 0) {
            result = false;
            Toast.makeText(this, "Add Cricketers First!", Toast.LENGTH_SHORT).show();
        } else if (!result) {
            Toast.makeText(this, "Enter All Details Correctly!", Toast.LENGTH_SHORT).show();
        }


        return result;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button_add:

                addView();

                break;

            case R.id.button_add_mat:

                addViewm();

                break;


        }


    }


    private void addView() {

        final View cricketerView = getLayoutInflater().inflate(R.layout.row_add_cricketer, null, false);

        EditText editText = (EditText) cricketerView.findViewById(R.id.edit_cricketer_name);
        AppCompatSpinner spinnerTeam = (AppCompatSpinner) cricketerView.findViewById(R.id.spinner_team);
        ImageView imageClose = (ImageView) cricketerView.findViewById(R.id.image_remove);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, teamList);
        spinnerTeam.setAdapter(arrayAdapter);

        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeView(cricketerView);
            }
        });

        layoutList.addView(cricketerView);

    }

    private void removeView(View view) {

        layoutList.removeView(view);

    }

    private void addViewm() {

        final View cricketerView = getLayoutInflater().inflate(R.layout.row_add_material, null, false);


        AppCompatSpinner spinnerTeam = (AppCompatSpinner) cricketerView.findViewById(R.id.spinner_team2);
        ImageView imageClose = (ImageView) cricketerView.findViewById(R.id.image_remove2);

        ArrayAdapter arrayAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, teamListmat);
        spinnerTeam.setAdapter(arrayAdapter2);

        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeViewm(cricketerView);
            }
        });

        layoutListmat.addView(cricketerView);

    }

    private void removeViewm(View view) {

        layoutListmat.removeView(view);

    }

    @Override
    public void onMapReady(@NonNull final MapboxMap mapboxMap) {

        List<Feature> symbolLayerIconFeatureList = new ArrayList<>();
        symbolLayerIconFeatureList.add(Feature.fromGeometry(
                Point.fromLngLat(10.16897, 36.8509)));

        mapboxMap.setStyle(new Style.Builder().fromUri("mapbox://styles/mapbox/cjf4m44iw0uza2spb3q0a7s41")

// Add the SymbolLayer icon image to the map style
                .withImage(ICON_ID, BitmapFactory.decodeResource(
                        AddFields.this.getResources(), R.drawable.mapbox_marker_icon_default))

// Adding a GeoJson source for the SymbolLayer icons.
                .withSource(new GeoJsonSource(SOURCE_ID,
                        FeatureCollection.fromFeatures(symbolLayerIconFeatureList)))

// Adding the actual SymbolLayer to the map style. An offset is added that the bottom of the red
// marker icon gets fixed to the coordinate, rather than the middle of the icon being fixed to
// the coordinate point. This is offset is not always needed and is dependent on the image
// that you use for the SymbolLayer icon.
                .withLayer(new SymbolLayer(LAYER_ID, SOURCE_ID)
                        .withProperties(
                                iconImage(ICON_ID),
                                iconAllowOverlap(true),
                                iconIgnorePlacement(true)
                        )
                ), new Style.OnStyleLoaded() {
            @Override
            public void onStyleLoaded(@NonNull Style style) {

// Map is set up and the style has loaded. Now you can add additional data or make other map adjustments.


            }
        });


    }

    //search
    public boolean onMapClick(@NonNull LatLng point) {

// Toast instructing user to tap on the map


        CameraPosition position = new CameraPosition.Builder()
                .target(new LatLng(36.8509, 10.16897)) // Sets the new camera position
                .zoom(17) // Sets the zoom
                .bearing(180) // Rotate the camera
                .tilt(30) // Set the camera tilt
                .build(); // Creates a CameraPosition from the builder

        mapboxMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(position), 7000);

        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

}
