package mobimoney.za.co.mobimoney.home.model;

/**
 * Created by MichaelJacobs on 3/23/2016.
 */
public class HomeSummaryDTO {
    String date;
    String income;
    String expense;
    String budget;
    String gain;

    public HomeSummaryDTO(String date, String income, String expense, String budget, String gain) {
        this.date = date;
        this.income = income;
        this.expense = expense;
        this.budget = budget;
        this.gain = gain;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getGain() {
        return gain;
    }

    public void setGain(String gain) {
        this.gain = gain;
    }
}

