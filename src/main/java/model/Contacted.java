
package model;


public class Contacted {
  String c_no;
  String name;
  String email;
  String msg;
  

    public String getc_no() {
        return c_no;
    }

    public String getname() {
        return name;
    }
   

    public String getemail() {
        return email;
    }
     public String getmsg() {
        return msg;
    }

    public void setc_no(String c_no) {
        this.c_no = c_no;
    }

    public void setname(String name) {
        this.name = name;
    }
   

    public void setemail(String email) {
        this.email= email;
    }
    public void setmsg(String msg) {
        this.msg= msg;
    }
  
}
