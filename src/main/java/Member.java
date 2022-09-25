import javax.xml.stream.Location;
import java.io.InvalidObjectException;
import java.util.Date;

public class Member implements Comparable<Member>{
    private String fname;
    private String lname;
    private Date dob;
    private Date expire;
    private Location location;

    @Override
    public String toString() { return String.format("%s %s, DOB: %s, Membership expires %s, Location: location", fname, lname, dob.toString(), expire, location);}
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member){
            return (((Member)obj).fname == this.fname) && (((Member)obj).lname == this.lname) && (((Member)obj).dob == this.dob);
        }
        else{
            return false;
        }
    }
    @Override
    public int compareTo(Member member) { return 1;}

}