package mobimoney.za.co.mobimoney.transaction.sms;

/**
 * Created by MichaelJacobs on 3/22/2016.
 */
public class NewSmsDTO {

    String date;
    String content;
    String vendor;
    String amount;

    public NewSmsDTO() {
        this.date = "";
        this.content = "";
        this.vendor = "";
        this.amount = "";
    }
    public NewSmsDTO(String date,String content, String vendor, String amount) {
        this.date = date;
        this.content = content;
        this.vendor = vendor;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
