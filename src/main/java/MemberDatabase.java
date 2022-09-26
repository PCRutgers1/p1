public class MemberDatabase {
    private Member [] mlist;
    private int size;
    private int find(Member member) { }
    private void grow() { }
    // returns true if member successfully added and false if member is under 18
    public boolean add(Member member) {
        if (member.getdob().isValid() && member.getExpireDate().isValid() && member.getdob().isValid() && )
            if (this.mlist.length == 0) {
                this.mlist = new Member[4];
                this.size = 1;
                this.mlist[size - 1] = member;
            } else if (size == this.mlist.length) {
                Member[] temp = new Member[size + 4];
                for (int counter = 0; counter < size; counter++) {
                    temp[counter] = this.mlist[counter];
                }
                size++;
                this.mlist = temp;
                this.mlist[size - 1] = member;
            } else {
                size++;
                this.mlist[size - 1] = member;
            }

    }

    public boolean remove(Member member) { }
    public void print () { } //print the array contents as is
    public void printByCounty() { } //sort by county and then zipcode
    public void printByExpirationDate() { } //sort by the expiration date
    public void printByName() { } //sort by last name and then first name
}