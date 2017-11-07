package lab2;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private int age;
    private MaritalStatus maritalStatus;

    @Override
    public String toString()
    {
        return String.format("%s, age:%d, %s", name, age, maritalStatus.toString());
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Person))
            return false;
        if (obj == this)
            return true;

        Person rhs = (Person) obj;
        return new EqualsBuilder().
                        append(name, rhs.name).
                        append(age, rhs.age).
                        append(maritalStatus, rhs.maritalStatus).
                        isEquals();
    }
}
