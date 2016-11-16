package com.kasungunathilaka.rentmanager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.kasungunathilaka.rentmanager.adapter.TenantAdapter;
import com.kasungunathilaka.rentmanager.model.Tenant;
import com.kasungunathilaka.rentmanager.view.SinglePropertyView;

import java.util.ArrayList;
import java.util.List;

public class SinglePropertyActivity extends BaseActivity {

    View.OnClickListener mFabAddTenantOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(SinglePropertyActivity.this);
            builder.setView(R.layout.dialog_add_tenant);
            builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog addTenantAddDialog = builder.create();
            addTenantAddDialog.show();
            Button postiveButton = addTenantAddDialog
                    .getButton(DialogInterface.BUTTON_POSITIVE);
            postiveButton.setTextColor(getResources().getColor(R.color.colorPrimary));
            postiveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });

        }
    };
    SinglePropertyView mSinglePropertyView;
    List<Tenant> mTenants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_property);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initialize();
    }

    private void initialize() {
        // UI initialize
        mSinglePropertyView = new SinglePropertyView();
        mSinglePropertyView.etAddress = (EditText) findViewById(R.id.etAddress);
        mSinglePropertyView.etRent = (EditText) findViewById(R.id.etRent);
        mSinglePropertyView.etUtilities = (EditText) findViewById(R.id.etUtilities);
        mSinglePropertyView.etServices = (EditText) findViewById(R.id.etServices);
        mSinglePropertyView.etLeaseStart = (EditText) findViewById(R.id.etLeaseStart);
        mSinglePropertyView.etLeaseEnd = (EditText) findViewById(R.id.etLeaseEnd);
        mSinglePropertyView.etMortgagePayment = (EditText) findViewById(R.id.etMortgagePayment);
        mSinglePropertyView.etSecurityDeposit = (EditText) findViewById(R.id.etSecurityDeposit);
        mSinglePropertyView.etPetDeposit = (EditText) findViewById(R.id.etPetDeposit);
        mSinglePropertyView.etPaymentPermitDate = (EditText) findViewById(R.id.etPaymentPermitDate);
        mSinglePropertyView.fabAddTenant = (FloatingActionButton) findViewById(R.id.fabAddTenant);
        mSinglePropertyView.rvTenant = (RecyclerView) findViewById(R.id.rvTenant);

        //Variable initialize
        mTenants = new ArrayList<>();

        //Onclick initialize
        mSinglePropertyView.fabAddTenant.setOnClickListener(mFabAddTenantOnClick);

        //RecyclerView initialize
        mSinglePropertyView.rvTenant.setHasFixedSize(true);
        mSinglePropertyView.rvTenant.setLayoutManager(new LinearLayoutManager(this));
        mSinglePropertyView.rvTenant.setAdapter(new TenantAdapter(mTenants));
    }
}
