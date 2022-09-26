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
    public int compareTo(Member member) {
        if (member.lname != this.lname)
            return this.lname.compareTo(member.lname);
        else
            return this.fname.compareTo(member.fname);
    }
    public Date getdob(){
        return this.dob;
    }
    public String getfname(){
        return this.fname;
    }
    public String getlname(){
        return this.lname;
    }
    public Date getExpireDate(){
        return this.expire;
    }
    public Location getLocation(){
        return this.location;
    }

}