package net.prosetyle.telephonnayakniga.controller.entity;

import javax.persistence.*;

/*
Логин (только английские символы, не меньше 3х, без спецсимволов)
Пароль (минимум 5 символов)
ФИО (минимум 5 символов)
Хранимая информация (одна запись)
Фамилия (обязательный, минимум 4 символа)
Имя (обязательный, минимум 4 символа)
Отчество (обязательный, минимум 4 символа)
Телефон мобильный (обязательный)
Телефон домашний (не обязательный)
Адрес (не обязательный)
e-mail (не обязательный, общепринятая валидация)

 */
@Entity
@Table(name = "telephonnaya_kniga")
public class Telephonnaya_Kniga {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "login")
    private String login;
    @Column(name = "passwordd")
    private String passwordd;
    @Column(name = "FIO")
    private String FIO;
    @Column(name = "store_information")
    private String store_information;
    @Column(name = "surname")
    private String surname;
    @Column(name = "namee")
    private String namee;
    @Column(name = "third_name")
    private String third_name;
    @Column(name = "mobile_phone")
    private String mobile_phone;
    @Column(name = "home_phone")
    private String home_phone;
    @Column(name = "address")
    private String address;
    @Column(name = "e_mail")
    private String e_mail;

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordd() {
        return passwordd;
    }

    public void setPasswordd(String passwordd) {
        this.passwordd = passwordd;
    }

    public String getStore_information() {
        return store_information;
    }

    public void setStore_information(String store_information) {
        this.store_information = store_information;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNamee() {
        return namee;
    }

    public void setNamee(String namee) {
        this.namee = namee;
    }

    public String getThird_name() {
        return third_name;
    }

    public void setThird_name(String third_name) {
        this.third_name = third_name;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getHome_phone() {
        return home_phone;
    }

    public void setHome_phone(String home_phone) {
        this.home_phone = home_phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    @Override
    public String toString() {
        return "Telephonnaya_Kniga{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", passwordd='" + passwordd + '\'' +
                ", FIO='" + FIO + '\'' +
                ", store_information='" + store_information + '\'' +
                ", surname='" + surname + '\'' +
                ", namee='" + namee + '\'' +
                ", third_name='" + third_name + '\'' +
                ", mobile_phone='" + mobile_phone + '\'' +
                ", home_phone='" + home_phone + '\'' +
                ", address='" + address + '\'' +
                ", e_mail='" + e_mail + '\'' +
                '}';
    }
}
