package com.kasungunathilaka.rentmanager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kasungunathilaka.rentmanager.R;
import com.kasungunathilaka.rentmanager.model.Tenant;

import java.util.List;

/**
 * Created by nirmal on 11/16/2016.
 */

public class TenantAdapter extends RecyclerView.Adapter<TenantAdapter.ViewHolder> {

    List<Tenant> mTenants;

    public TenantAdapter(List<Tenant> tenants) {
        this.mTenants = tenants;
    }

    @Override
    public TenantAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_row_tenant, parent, false);
        return (ViewHolder) new TenantAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TenantAdapter.ViewHolder holder, int position) {
//        Tenant tenant = mTenants.get(position);
//        holder.bind(tenant);
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvTelephone;
        TextView tvEmail;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvTelephone = (TextView) itemView.findViewById(R.id.tvTelephone);
            tvEmail = (TextView) itemView.findViewById(R.id.tvEmail);
        }

        void bind(Tenant tenant) {
            tvName.setText(tenant.name);
            tvTelephone.setText(tenant.telephone);
            tvEmail.setText(tenant.email);
        }
    }

}
