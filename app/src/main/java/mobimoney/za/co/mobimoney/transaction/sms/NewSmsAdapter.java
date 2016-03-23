package mobimoney.za.co.mobimoney.transaction.sms;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import mobimoney.za.co.mobimoney.R;

/**
 * Created by MichaelJacobs on 3/22/2016.
 */
public class NewSmsAdapter extends RecyclerView.Adapter<NewSmsAdapter.NewSmsViewHolder>{

    private ArrayList<NewSmsDTO> newSmsData;

    public NewSmsAdapter(ArrayList<NewSmsDTO> newSmsData) {
        this.newSmsData = newSmsData;
    }

    public static class NewSmsViewHolder extends RecyclerView.ViewHolder {
        TextView txtDate;
        TextView txtContent;
        TextView txtAmount;
        TextView txtVendor;

        public NewSmsViewHolder(View itemView) {
            super(itemView);

            this.txtDate = (TextView) itemView.findViewById(R.id.new_sms_date);
            this.txtContent = (TextView) itemView.findViewById(R.id.new_sms_content);
            this.txtAmount = (TextView) itemView.findViewById(R.id.new_sms_amount);
            this.txtVendor = (TextView) itemView.findViewById(R.id.new_sms_vendor);
        }
    }



    @Override
    public NewSmsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_sms_transaction_card_view, parent, false);
        //TODO: Add on click listener
        return new NewSmsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewSmsViewHolder holder, int position) {
        TextView txtDate = holder.txtDate;
        TextView txtContent = holder.txtContent;
        TextView txtAmount = holder.txtAmount;
        TextView txtVendor = holder.txtVendor;

        txtDate.setText(newSmsData.get(position).getDate());
        txtContent.setText(newSmsData.get(position).getContent());
        txtAmount.setText(newSmsData.get(position).getAmount());
        txtVendor.setText(newSmsData.get(position).getVendor());
    }

    @Override
    public int getItemCount() {
        return newSmsData.size();
    }
}
