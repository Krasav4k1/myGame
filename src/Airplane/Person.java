package Airplane;

import java.io.Serializable;

public class Person implements Serializable{

    //Fields
    private String nikName;
    private int record;

    //Constructor
    public Person(String nikName, int record){
        super();
        this.nikName = nikName;
        this.record = record;
    }

    public String getNikName() {
        return nikName;
    }

    public void setNikName(String nikName) {
        this.nikName = nikName;
    }

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (record != person.record) return false;
        return nikName.equals(person.nikName);

    }

    @Override
    public int hashCode() {
        int result = nikName.hashCode();
        result = 31 * result + record;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "nikName='" + nikName + '\'' +
                ", record=" + record +
                '}';
    }
}
