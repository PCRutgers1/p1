public class MemberDatabase {
    private Member[] mlist;
    private int size;

    private int find(Member member) {
        for (int i = 0; i < mlist.length; i++) {
            if (mlist[i] == member) {
                return i;
            }
        }
        return -1;
    }

    private void grow() {
        Member[] newList = new Member[this.size + 4];
        for (int counter = 0; counter < this.size; counter++) {
            newList[counter] = this.mlist[counter];
        }

        this.mlist = newList;
    }

    private boolean checkLocationExists(Member member){
        Location[] allLocations = Location.values();

        for (Location l : allLocations)
        {
            if (l == member.getLocation())
                return true;
        }
        return false;
    }
    private boolean checkOver18(Member member){
        Date today = new Date();
        int ageYear = today.getYear() - member.getdob().getYear() ;
        int ageMonth = today.getMonth()- member.getdob().getMonth() ;
        int ageDay = today.getDay() - member.getdob().getDay() ;
        if ( ageYear > 18){
            return true;
        }else if (ageYear == 18){
            if (ageMonth < 0){
                return false;
            }
            else if (ageMonth == 0 && ageDay == 0){
                return true;
            }
        }

        return false;
    }

    // returns true if member successfully added and false if member is under 18
    public boolean add(Member member) {
        if (member.getdob().isValid() && member.getExpireDate().isValid() && checkLocationExists(member) && checkOver18(member))
            if (this.mlist.length == 0) {
                this.mlist = new Member[4];
                this.size = 1;
                this.mlist[size - 1] = member;
            } else if (size == this.mlist.length) {
                grow();
                this.size++;
                this.mlist[size - 1] = member;
            } else {
                size++;
                this.mlist[size - 1] = member;
            }
    }

    public boolean remove(Member member) {
        int memberIndex = find(member);
        Member[] newArray = new Member[mlist.length];
        if (memberIndex == -1) {
            return false;
        } else {
            for (int i = 0; i < this.size; i++) {
                if (i != memberIndex)
                    newArray[i] = this.mlist[i];
            }
        }
        size--;
        this.mlist = newArray;
        return true;
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(mlist[i].toString());
        }
    } //print the array contents as is

    public void printByCounty() {
        for (int ind = 0; ind < this.size; ind++) {
            System.out.println(this.mlist[ind]);
        }
    } //sort by county and then zipcode

    private void countySort() {
        for (int i = 0; i < this.size - 1; i++)
            for (int j = 0; j < this.size - i - 1; j++)
                if (this.mlist[j].getLocation().compareTo(this.mlist[j + 1].getLocation()) > 0) {
                    // swap arr[j+1] and arr[j]
                    Member temp = this.mlist[j];
                    this.mlist[j] = this.mlist[j + 1];
                    this.mlist[j + 1] = temp;
                }
    }

    public void printByExpirationDate() {
        for (int ind = 0; ind < this.size; ind++) {
            System.out.println(this.mlist[ind]);
        }
    } //sort by the expiration date

    private void dateSort() {
        for (int i = 0; i < this.size - 1; i++)
            for (int j = 0; j < this.size - i - 1; j++)
                if (this.mlist[j].getExpireDate().compareTo(this.mlist[j + 1].getExpireDate()) > 0) {
                    // swap arr[j+1] and arr[j]
                    Member temp = this.mlist[j];
                    this.mlist[j] = this.mlist[j + 1];
                    this.mlist[j + 1] = temp;
                }
    }

    public void printByName() {
        for (int ind = 0; ind < this.size; ind++) {
            System.out.println(this.mlist[ind]);
        }
    } //sort by last name and then first name

    private void nameSort() {
        for (int i = 0; i < this.size - 1; i++)
            for (int j = 0; j < this.size - i - 1; j++)
                if (this.mlist[j].compareTo(this.mlist[j + 1]) > 0) {
                    // swap arr[j+1] and arr[j]
                    Member temp = this.mlist[j];
                    this.mlist[j] = this.mlist[j + 1];
                    this.mlist[j + 1] = temp;
                }
    }
}