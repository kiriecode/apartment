package Po;

public class dorm {
    private String dorm_id;
    private int bed_num, people_num, deposit;

    @Override
    public String toString() {
        return "dorm{" +
                "dorm_id='" + dorm_id + '\'' +
                ", bed_num=" + bed_num +
                ", people_num=" + people_num +
                ", deposit=" + deposit +
                '}';
    }

    public String getDorm_id() {
        return dorm_id;
    }

    public void setDorm_id(String dorm_id) {
        this.dorm_id = dorm_id;
    }

    public int getBed_num() {
        return bed_num;
    }

    public void setBed_num(int bed_num) {
        this.bed_num = bed_num;
    }

    public int getPeople_num() {
        return people_num;
    }

    public void setPeople_num(int people_num) {
        this.people_num = people_num;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }
}
