package mobimoney.za.co.mobimoney.home.controller;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import mobimoney.za.co.mobimoney.R;
import mobimoney.za.co.mobimoney.home.model.HomeSummaryDTO;

/**
 * Created by MichaelJacobs on 3/23/2016.
 */
public class HomeSummaryAdapter extends RecyclerView.Adapter<HomeSummaryAdapter.HomeSummaryViewHolder> {

    private ArrayList<HomeSummaryDTO> data;

    public HomeSummaryAdapter(ArrayList<HomeSummaryDTO> data) {
        this.data = data;
    }

    public static class HomeSummaryViewHolder extends RecyclerView.ViewHolder {
        TextView txtDate;
        TextView txtIncome;
        TextView txtExpense;
        TextView txtGainTitle;
        TextView txtGain;
        TextView txtBudget;

        public HomeSummaryViewHolder(View itemView) {
            super(itemView);
            txtDate = (TextView) itemView.findViewById(R.id.home_summary_card_view_date);
            txtIncome = (TextView) itemView.findViewById(R.id.home_summary_card_view_income);
            txtExpense = (TextView) itemView.findViewById(R.id.home_summary_card_view_expense);
            txtGainTitle = (TextView) itemView.findViewById(R.id.home_summary_card_view_title_gain_loss);
            txtGain = (TextView) itemView.findViewById(R.id.home_summary_card_view_gain_loss);
            txtBudget = (TextView) itemView.findViewById(R.id.home_summary_card_view_budget);
        }
    }

    @Override
    public HomeSummaryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_summary_card_view, parent, false);
        //TODO: Add on click listener
        return new HomeSummaryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeSummaryViewHolder holder, int position) {

        TextView txtDate = holder.txtDate;
        TextView txtIncome = holder.txtIncome;
        TextView txtExpense = holder.txtExpense;
        TextView txtGainTitle = holder.txtGainTitle;
        TextView txtGain = holder.txtGain;
        TextView txtBudget = holder.txtBudget;

        txtDate.setText(data.get(position).getDate());
        txtIncome.setText(data.get(position).getIncome());
        txtExpense.setText(data.get(position).getExpense());
        if (data.get(position).getGain() != null && !data.get(position).getGain().isEmpty()) {
            int gain = Integer.parseInt(data.get(position).getGain());
            txtGainTitle.setText(gain > 0 ? R.string.home_summary_title_surplus : R.string.home_summary_title_loss);
        } else {
            txtGainTitle.setText(R.string.home_summary_title_loss);
        }
        txtGain.setText(data.get(position).getGain());
        txtBudget.setText(data.get(position).getBudget());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
