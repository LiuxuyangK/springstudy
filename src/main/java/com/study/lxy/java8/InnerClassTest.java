package com.study.lxy.java8;

/**
 * Created by Harry on 17/9/17.
 */

interface Flag{

}

public class InnerClassTest {
    private Person person;


    private class Person implements Flag {
        private String name;
        private String user;

        private String getName() {

            return name;
        }

        private void setName(String name) {

            this.name = name;
        }

        private String getUser() {

            return user;
        }

        private void setUser(String user) {

            this.user = user;
        }

    }



    public void initPerson() {

        this.person = new Person();
    }

    public Person getPerson() {

        return new Person();
    }

    public String getPersonName() {

        return this.person.getName();
    }

    public void settPersonName(String name) {

        this.person.setName(name);
    }


}

class Client{
    private Flag flag;

    public Flag getFlag() {

        return flag;
    }

    public void setFlag(Flag flag) {

        this.flag = flag;
    }

    public static void main(String[] args) {

        InnerClassTest innerClassTest = new InnerClassTest();

        innerClassTest.initPerson();

        innerClassTest.settPersonName("name");

        System.out.println(innerClassTest.getPersonName());

        Flag flag1 = innerClassTest.getPerson();

        Client client = new Client();

        client.setFlag(flag1);
    }
}