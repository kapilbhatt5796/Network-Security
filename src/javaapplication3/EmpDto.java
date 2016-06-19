/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author kapil bhatt
 */
public class EmpDto {

  private int id;
  private String name, emailid, password;

    public void setId(int id){
        this.id = id;
    }
  
    public void setName(String name) {
        this.name = name;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EmpDto(String name, String emailid, String password) {
        this.name = name;
        this.emailid = emailid;
        this.password = password;
    }
  
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmailid() {
        return emailid;
    }

    public String getPassword() {
        return password;
    }
  
  

}
