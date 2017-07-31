package com.example.admin.mytourguide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 7/28/2017.
 */

public class gameReservesFragment extends Fragment {

    private ListView tourListview;

    private tourAdapter ttourAdapter;

    private DatabaseReference tTourDatabaseReference;

    private FirebaseDatabase firebaseDatabase;

    private ChildEventListener childEventListener;

    FirebaseStorage firebaseStorage;

    public gameReservesFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_list_item, container, false);

        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();

        tTourDatabaseReference = firebaseDatabase.getReference().child("watch");

        tourListview = (ListView)rootView.findViewById(R.id.List);
        final List<tour> tours = new ArrayList<>();
        ttourAdapter = new tourAdapter(getActivity(), R.layout.activity_list_view, tours);
        tourListview.setAdapter(ttourAdapter);

        childEventListener= new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                tour tour = dataSnapshot.getValue(tour.class);
                ttourAdapter.add(tour);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        };
        tTourDatabaseReference.addChildEventListener(childEventListener);
        return tourListview;
    }
}
