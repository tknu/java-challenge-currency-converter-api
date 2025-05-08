package src.br.com.alura.main;

public class Moeda {
    private String result; // "success" or "error"
    private String documentation;
    private String terms_of_use;
    // private long time_last_update_unix;
    // private String time_last_update_utc;
    // private long time_next_update_unix;
    // private String time_next_update_utc;
    private String base_code;
    private String target_code;
    private double conversion_rate;
    private double conversion_result;

    public String getResult() {
        return result;
    }

    public String getDocumentation() {
        return documentation;
    }

    public String getTerms_of_use() {
        return terms_of_use;
    }

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }

    public double getConversion_result() {
        return conversion_result;
    }

}
