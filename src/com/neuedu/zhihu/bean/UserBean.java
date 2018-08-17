package com.neuedu.zhihu.bean;

public class UserBean {
    private Integer id;
    private String uname;
    private String password;
    private String password1;
    private String rename;
    private String province;
    private String city;
    private String Idcard;
    //定义两个sex一个用于获取前端的，一个是传入数据库的
    private String sex;
    private Integer age;
    private String birth;
    private String IDnumber;
    private Integer isRemove;
    private Integer sqlsex;
    private String phone;
    private String path;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRename() {
        return rename;
    }
    public void setRename(String rename) {
        this.rename = rename;
    }

    public String getSex() {
        return sex;
    }
    public void setWebSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public int getSqlsex() {
        return sqlsex;
    }

    public void setSqlsex(int sqlsex) {
        this.sqlsex = sqlsex;
    }

    public String getBirth() {
        return birth;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getIDnumber() {
        return IDnumber;
    }
    public void setId_card(String IDnumber) {
        this.IDnumber = IDnumber;
    }

    public int getIsRemove() {
        return isRemove;
    }

    public void setIsRemove(int isRemove) {
        this.isRemove = isRemove;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIdcard() {
        return Idcard;
    }

    public void setIdcard(String idcard) {
        Idcard = idcard;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setIDnumber(String IDnumber) {
        this.IDnumber = IDnumber;
    }

    public String getPassword1() { return password1;}

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
